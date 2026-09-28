package net.scalax.simple.codec.product.core

import net.scalax.simple.adt.nat.support.ABCFunc
import net.scalax.simple.adt.nat.support.FromToFunc
import net.scalax.simple.adt.nat.support.v5.AppenderSupport1

trait Fold2Generic[F[_[_]]] {
  def foldLeft[N1[_], N2[_], SeqType](fn1: F[N1], fn2: F[N2], folder: Fold2Generic.Folder[N1, N2, SeqType]): SeqType
  def foldRight[N1[_], N2[_], SeqType](fn1: F[N1], fn2: F[N2], folder: Fold2Generic.Folder[N1, N2, SeqType]): SeqType
}

object Fold2Generic {

  trait Folder[N1[_], N2[_], ColType] {
    def fold[T](n1: N1[T], n2: N2[T], col: ColType): ColType
    def zero: ColType
  }

  private def toNamed[N1[_], N2[_], SeqType](
    folderF: Folder[N1, N2, SeqType]
  ): AppenderSupport1.Simple2.One[({ type T1[U1, U2] = (U1, U2, SeqType) => SeqType })#T1, N1, N2] = {
    type Func2[A, B] = (A, B, SeqType) => SeqType

    new AppenderSupport1.Simple2.One[Func2, N1, N2] {
      override def one[T, B1, B2](abc1: FromToFunc[N1[T], B1], abc2: FromToFunc[N2[T], B2]): (B1, B2, SeqType) => SeqType =
        (b1, b2, seq) => {
          folderF.fold[T](abc1.to(b1), abc2.to(b2), seq)
        }
    }
  }

  private def monadAddRight[N1[_], N2[_], SeqType](
    folderF: Folder[N1, N2, SeqType]
  ): AppenderSupport1.Simple2.Appender[({ type T1[U1, U2] = (U1, U2, SeqType) => SeqType })#T1, N1, N2] = {
    type Func2[A, B] = (A, B, SeqType) => SeqType
    new AppenderSupport1.Simple2.Appender[Func2, N1, N2] {
      override def append[T, B1, B2, C1, C2](
        abc1: ABCFunc[N1[T], B1, C1],
        abc2: ABCFunc[N2[T], B2, C2],
        ma: (B1, B2, SeqType) => SeqType
      ): (C1, C2, SeqType) => SeqType = (c1, c2, seq) => {
        val nt1: N1[T]     = abc1.takeHead(c1)
        val b1: B1         = abc1.takeTail(c1)
        val nt2: N2[T]     = abc2.takeHead(c2)
        val b2: B2         = abc2.takeTail(c2)
        val maSeq: SeqType = ma(b1, b2, seq)
        folderF.fold[T](nt1, nt2, maSeq)
      }
    }
  }

  private def monadAddLeft[N1[_], N2[_], SeqType](
    folderF: Folder[N1, N2, SeqType]
  ): AppenderSupport1.Simple2.Appender[({ type T1[U1, U2] = (U1, U2, SeqType) => SeqType })#T1, N1, N2] = {
    type Func2[A, B] = (A, B, SeqType) => SeqType
    new AppenderSupport1.Simple2.Appender[Func2, N1, N2] {
      override def append[T, B1, B2, C1, C2](
        abc1: ABCFunc[N1[T], B1, C1],
        abc2: ABCFunc[N2[T], B2, C2],
        ma: (B1, B2, SeqType) => SeqType
      ): (C1, C2, SeqType) => SeqType = (c1, c2, seq) => {
        val nt1: N1[T]     = abc1.takeHead(c1)
        val b1: B1         = abc1.takeTail(c1)
        val nt2: N2[T]     = abc2.takeHead(c2)
        val b2: B2         = abc2.takeTail(c2)
        val ntSeq: SeqType = folderF.fold[T](nt1, nt2, seq)
        ma(b1, b2, ntSeq)
      }
    }
  }

  class Builder[F[_[_]]] {
    def derived(o1: AppenderSupport1.Simple2.Release[F]): Fold2Generic[F] = new Fold2Generic[F] {
      override def foldLeft[N1[_], N2[_], SeqType](fn1: F[N1], fn2: F[N2], folder: Fold2Generic.Folder[N1, N2, SeqType]): SeqType = {
        type Func2[A, B] = (A, B, SeqType) => SeqType
        val func = o1.append[Func2, N1, N2](
          monadAddLeft[N1, N2, SeqType](folder),
          toNamed[N1, N2, SeqType](folder)
        )

        func(fn1, fn2, folder.zero)
      }

      override def foldRight[N1[_], N2[_], SeqType](fn1: F[N1], fn2: F[N2], folder: Fold2Generic.Folder[N1, N2, SeqType]): SeqType = {
        type Func2[A, B] = (A, B, SeqType) => SeqType
        val func = o1.append[Func2, N1, N2](
          monadAddRight[N1, N2, SeqType](folder),
          toNamed[N1, N2, SeqType](folder)
        )

        func(fn1, fn2, folder.zero)
      }
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
