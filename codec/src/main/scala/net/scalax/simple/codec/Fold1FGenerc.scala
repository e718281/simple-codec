package net.scalax.simple.codec
package to_list_generic

import net.scalax.simple.adt.nat.support.ABCFunc
import net.scalax.simple.adt.nat.support.FromToFunc
import net.scalax.simple.adt.nat.support.v5.AppenderSupport1

trait Fold1FGenerc[F[_[_]]] {
  def foldLeft[N[_], SeqType](folder: Fold1FGenerc.FoldF[N, SeqType], model: F[N], zero: SeqType): SeqType
  def foldRight[N[_], SeqType](folder: Fold1FGenerc.FoldF[N, SeqType], model: F[N], zero: SeqType): SeqType
}

object Fold1FGenerc {

  trait FoldF[N[_], ColType] {
    def fold[T](n: N[T], col: ColType): ColType
  }

  private def toNamed[N[_], SeqType](
    folderF: FoldF[N, SeqType]
  ): AppenderSupport1.Simple1.One[({ type T1[U] = (U, SeqType) => SeqType })#T1, N] =
    new AppenderSupport1.Simple1.One[({ type T1[U] = (U, SeqType) => SeqType })#T1, N] {
      override def one[T, B1](abc1: FromToFunc[N[T], B1]): (B1, SeqType) => SeqType =
        (b1, seq) => {
          folderF.fold[T](abc1.to(b1), seq)
        }
    }

  private def monadAddLeft[N[_], SeqType](
    folderF: FoldF[N, SeqType]
  ): AppenderSupport1.Simple1.Appender[({ type T1[U] = (U, SeqType) => SeqType })#T1, N] =
    new AppenderSupport1.Simple1.Appender[({ type T1[U] = (U, SeqType) => SeqType })#T1, N] {
      override def append[T, B1, C1](abc1: ABCFunc[N[T], B1, C1], ma: (B1, SeqType) => SeqType): (C1, SeqType) => SeqType = (c1, seq) => {
        val nt: N[T]       = abc1.takeHead(c1)
        val b1: B1         = abc1.takeTail(c1)
        val maSeq: SeqType = ma(b1, seq)
        folderF.fold[T](nt, maSeq)
      }
    }

  private def monadAddRight[N[_], SeqType](
    folderF: FoldF[N, SeqType]
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
    def derived(o1: AppenderSupport1.Simple1.Release[F]): Fold1FGenerc[F] = new Fold1FGenerc[F] {
      override def foldLeft[N[_], SeqType](
        folderF: Fold1FGenerc.FoldF[N, SeqType],
        model: F[N],
        zero: SeqType
      ): SeqType = {
        val u: (F[N], SeqType) => SeqType =
          o1.append[({ type T1[U] = (U, SeqType) => SeqType })#T1, N](monadAddLeft[N, SeqType](folderF), toNamed[N, SeqType](folderF))
        u(model, zero)
      }

      override def foldRight[N[_], SeqType](
        folderF: Fold1FGenerc.FoldF[N, SeqType],
        model: F[N],
        zero: SeqType
      ): SeqType = {
        val u: (F[N], SeqType) => SeqType =
          o1.append[({ type T1[U] = (U, SeqType) => SeqType })#T1, N](monadAddRight[N, SeqType](folderF), toNamed[N, SeqType](folderF))
        u(model, zero)
      }
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
