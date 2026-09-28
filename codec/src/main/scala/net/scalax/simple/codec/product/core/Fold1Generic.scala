package net.scalax.simple.codec.product.core

import net.scalax.simple.adt.nat.support.ABCFunc
import net.scalax.simple.adt.nat.support.FromToFunc
import net.scalax.simple.adt.nat.support.v5.AppenderSupport1

trait Fold1Generic[F[_[_]]] {
  def foldLeft[N[_], SeqType](fn: F[N], folder: Fold1Generic.Folder[N, SeqType]): SeqType
  def foldRight[N[_], SeqType](fn: F[N], folder: Fold1Generic.Folder[N, SeqType]): SeqType
}

object Fold1Generic {

  trait Folder[N[_], ColType] {
    def fold[T](n: N[T], col: ColType): ColType
    def zero: ColType
  }

  private def toNamed[N[_], SeqType](
    folderF: Folder[N, SeqType]
  ): AppenderSupport1.Simple1.One[({ type T1[U] = (U, SeqType) => SeqType })#T1, N] =
    new AppenderSupport1.Simple1.One[({ type T1[U] = (U, SeqType) => SeqType })#T1, N] {
      override def one[T, B1](abc1: FromToFunc[N[T], B1]): (B1, SeqType) => SeqType =
        (b1, seq) => {
          folderF.fold[T](abc1.to(b1), seq)
        }
    }

  private def monadAddRight[N[_], SeqType](
    folderF: Folder[N, SeqType]
  ): AppenderSupport1.Simple1.Appender[({ type T1[U] = (U, SeqType) => SeqType })#T1, N] =
    new AppenderSupport1.Simple1.Appender[({ type T1[U] = (U, SeqType) => SeqType })#T1, N] {
      override def append[T, B1, C1](abc1: ABCFunc[N[T], B1, C1], ma: (B1, SeqType) => SeqType): (C1, SeqType) => SeqType = (c1, seq) => {
        val nt: N[T]       = abc1.takeHead(c1)
        val b1: B1         = abc1.takeTail(c1)
        val maSeq: SeqType = ma(b1, seq)
        folderF.fold[T](nt, maSeq)
      }
    }

  private def monadAddLeft[N[_], SeqType](
    folderF: Folder[N, SeqType]
  ): AppenderSupport1.Simple1.Appender[({ type T1[U] = (U, SeqType) => SeqType })#T1, N] =
    new AppenderSupport1.Simple1.Appender[({ type T1[U] = (U, SeqType) => SeqType })#T1, N] {
      override def append[T, B1, C1](abc1: ABCFunc[N[T], B1, C1], ma: (B1, SeqType) => SeqType): (C1, SeqType) => SeqType = (c1, seq) => {
        val nt: N[T]       = abc1.takeHead(c1)
        val b1: B1         = abc1.takeTail(c1)
        val ntSeq: SeqType = folderF.fold[T](nt, seq)
        ma(b1, ntSeq)
      }
    }

  class Builder[F[_[_]]] {
    def derived(o1: AppenderSupport1.Simple1.Release[F]): Fold1Generic[F] = new Fold1Generic[F] {
      override def foldLeft[N[_], SeqType](fn: F[N], folder: Fold1Generic.Folder[N, SeqType]): SeqType = {
        val func: (F[N], SeqType) => SeqType =
          o1.append[({ type T1[U] = (U, SeqType) => SeqType })#T1, N](monadAddLeft[N, SeqType](folder), toNamed[N, SeqType](folder))

        func(fn, folder.zero)
      }

      override def foldRight[N[_], SeqType](fn: F[N], folder: Fold1Generic.Folder[N, SeqType]): SeqType = {
        val func: (F[N], SeqType) => SeqType =
          o1.append[({ type T1[U] = (U, SeqType) => SeqType })#T1, N](monadAddRight[N, SeqType](folder), toNamed[N, SeqType](folder))

        func(fn, folder.zero)
      }
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
