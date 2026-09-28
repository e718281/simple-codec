package net.scalax.simple.codec.product.core

import net.scalax.simple.adt.nat.support.ABCFunc
import net.scalax.simple.adt.nat.support.FromToFunc
import net.scalax.simple.adt.nat.support.v5.AppenderSupport1

trait Fold3Generic[F[_[_]]] {
  def foldLeft[N1[_], N2[_], N3[_], SeqType](fn1: F[N1], fn2: F[N2], fn3: F[N3], folder: Fold3Generic.Folder[N1, N2, N3, SeqType]): SeqType
  def foldRight[N1[_], N2[_], N3[_], SeqType](fn1: F[N1], fn2: F[N2], fn3: F[N3], folder: Fold3Generic.Folder[N1, N2, N3, SeqType]): SeqType
}

object Fold3Generic {

  trait Folder[N1[_], N2[_], N3[_], ColType] {
    def fold[T](n1: N1[T], n2: N2[T], n3: N3[T], col: ColType): ColType
    def zero: ColType
  }

  private def toNamed[N1[_], N2[_], N3[_], SeqType](
    folderF: Folder[N1, N2, N3, SeqType]
  ): AppenderSupport1.Simple3.One[({ type T1[U1, U2, U3] = (U1, U2, U3, SeqType) => SeqType })#T1, N1, N2, N3] = {
    type Func2[A, B, C] = (A, B, C, SeqType) => SeqType

    new AppenderSupport1.Simple3.One[Func2, N1, N2, N3] {
      override def one[T, B1, B2, B3](
        abc1: FromToFunc[N1[T], B1],
        abc2: FromToFunc[N2[T], B2],
        abc3: FromToFunc[N3[T], B3]
      ): (B1, B2, B3, SeqType) => SeqType =
        (b1, b2, b3, seq) => {
          folderF.fold[T](abc1.to(b1), abc2.to(b2), abc3.to(b3), seq)
        }
    }
  }

  private def monadAddRight[N1[_], N2[_], N3[_], SeqType](
    folderF: Folder[N1, N2, N3, SeqType]
  ): AppenderSupport1.Simple3.Appender[({ type T1[U1, U2, U3] = (U1, U2, U3, SeqType) => SeqType })#T1, N1, N2, N3] = {
    type Func2[A, B, C] = (A, B, C, SeqType) => SeqType

    new AppenderSupport1.Simple3.Appender[Func2, N1, N2, N3] {
      override def append[T, B1, B2, B3, C1, C2, C3](
        abc1: ABCFunc[N1[T], B1, C1],
        abc2: ABCFunc[N2[T], B2, C2],
        abc3: ABCFunc[N3[T], B3, C3],
        ma: (B1, B2, B3, SeqType) => SeqType
      ): (C1, C2, C3, SeqType) => SeqType = (c1, c2, c3, seq) => {
        val nt1: N1[T]     = abc1.takeHead(c1)
        val nt2: N2[T]     = abc2.takeHead(c2)
        val nt3: N3[T]     = abc3.takeHead(c3)
        val b1: B1         = abc1.takeTail(c1)
        val b2: B2         = abc2.takeTail(c2)
        val b3: B3         = abc3.takeTail(c3)
        val maSeq: SeqType = ma(b1, b2, b3, seq)
        folderF.fold[T](nt1, nt2, nt3, maSeq)
      }
    }
  }

  private def monadAddLeft[N1[_], N2[_], N3[_], SeqType](
    folderF: Folder[N1, N2, N3, SeqType]
  ): AppenderSupport1.Simple3.Appender[({ type T1[U1, U2, U3] = (U1, U2, U3, SeqType) => SeqType })#T1, N1, N2, N3] = {
    type Func2[A, B, C] = (A, B, C, SeqType) => SeqType

    new AppenderSupport1.Simple3.Appender[Func2, N1, N2, N3] {
      override def append[T, B1, B2, B3, C1, C2, C3](
        abc1: ABCFunc[N1[T], B1, C1],
        abc2: ABCFunc[N2[T], B2, C2],
        abc3: ABCFunc[N3[T], B3, C3],
        ma: (B1, B2, B3, SeqType) => SeqType
      ): (C1, C2, C3, SeqType) => SeqType = (c1, c2, c3, seq) => {
        val nt1: N1[T]     = abc1.takeHead(c1)
        val nt2: N2[T]     = abc2.takeHead(c2)
        val nt3: N3[T]     = abc3.takeHead(c3)
        val b1: B1         = abc1.takeTail(c1)
        val b2: B2         = abc2.takeTail(c2)
        val b3: B3         = abc3.takeTail(c3)
        val ntSeq: SeqType = folderF.fold[T](nt1, nt2, nt3, seq)
        ma(b1, b2, b3, ntSeq)
      }
    }
  }

  class Builder[F[_[_]]] {
    def derived(o1: AppenderSupport1.Simple3.Release[F]): Fold3Generic[F] = new Fold3Generic[F] {
      override def foldLeft[N1[_], N2[_], N3[_], SeqType](
        fn1: F[N1],
        fn2: F[N2],
        fn3: F[N3],
        folder: Fold3Generic.Folder[N1, N2, N3, SeqType]
      ): SeqType = {
        type Func2[A, B, C] = (A, B, C, SeqType) => SeqType
        val func = o1.append[Func2, N1, N2, N3](
          monadAddLeft[N1, N2, N3, SeqType](folder),
          toNamed[N1, N2, N3, SeqType](folder)
        )

        func(fn1, fn2, fn3, folder.zero)
      }

      override def foldRight[N1[_], N2[_], N3[_], SeqType](
        fn1: F[N1],
        fn2: F[N2],
        fn3: F[N3],
        folder: Fold3Generic.Folder[N1, N2, N3, SeqType]
      ): SeqType = {
        type Func2[A, B, C] = (A, B, C, SeqType) => SeqType
        val func = o1.append[Func2, N1, N2, N3](
          monadAddRight[N1, N2, N3, SeqType](folder),
          toNamed[N1, N2, N3, SeqType](folder)
        )

        func(fn1, fn2, fn3, folder.zero)
      }
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
