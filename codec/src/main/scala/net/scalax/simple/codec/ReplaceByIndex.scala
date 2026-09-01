package net.scalax.simple.codec

import net.scalax.simple.adt.nat.support.v5.AppenderSupport1
import net.scalax.simple.adt.nat.support.{ABCFunc, FromToFunc}

trait ReplaceByIndex[F[_[_]]] {
  def replaceImpl[UX](index: Int, proValue: UX): F[({ type X1[_] = UX })#X1] => F[({ type X1[_] = UX })#X1]
  def replace[T[_]](index: Int, proValue: Any): F[T] => F[T] = {
    val func: F[({ type X1[_] = Any })#X1] => F[({ type X1[_] = Any })#X1] = replaceImpl[Any](index = index, proValue = proValue)
    func.asInstanceOf[F[T] => F[T]]
  }
}

object ReplaceByIndex {

  private class Helper1[ProType] {
    type MA[H] = (Int, ProType, H) => H
  }
  private def appendMonad[ProType]: AppenderSupport1.Simple1.Appender[Helper1[ProType]#MA, ({ type X1[_] = ProType })#X1] =
    new AppenderSupport1.Simple1.Appender[Helper1[ProType]#MA, ({ type X1[_] = ProType })#X1] {
      override def append[T, B1, C1](abc1: ABCFunc[ProType, B1, C1], ma: (Int, ProType, B1) => B1): (Int, ProType, C1) => C1 =
        (index, pro, c1) => {
          val b1: B1 = abc1.takeTail(c1)

          if (index == 0) {
            abc1.append(pro, b1)
          } else {
            val currentPro: ProType = abc1.takeHead(c1)
            abc1.append(currentPro, ma(index - 1, pro, b1))
          }
        }
    }

  private def funcImpl[ProType]: AppenderSupport1.Simple1.One[Helper1[ProType]#MA, ({ type X1[_] = ProType })#X1] =
    new AppenderSupport1.Simple1.One[Helper1[ProType]#MA, ({ type X1[_] = ProType })#X1] {
      override def one[V, B1](abc1: FromToFunc[ProType, B1]): (Int, ProType, B1) => B1 = (index, anyModel, x1) =>
        if (index == 0) abc1.from(anyModel) else x1
    }

  class Builder[F[_[_]]] {
    def derived(fromList: AppenderSupport1.Simple1.Release[F]): ReplaceByIndex[F] = new ReplaceByIndex[F] {
      override def replaceImpl[ProType](
        index: Int,
        proValue: ProType
      ): F[({ type X1[_] = ProType })#X1] => F[({ type X1[_] = ProType })#X1] = {
        val fromInt = fromList.append[Helper1[ProType]#MA, ({ type X1[_] = ProType })#X1](appendMonad[ProType], funcImpl[ProType])
        (t: F[({ type X1[_] = ProType })#X1]) => fromInt(index, proValue, t)
      }
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
