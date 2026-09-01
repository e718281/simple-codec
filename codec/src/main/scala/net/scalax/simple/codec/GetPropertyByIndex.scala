package net.scalax.simple.codec

import net.scalax.simple.adt.nat.support.v5.AppenderSupport1
import net.scalax.simple.adt.nat.support.{ABCFunc, FromToFunc}

trait GetPropertyByIndex[F[_[_]]] {
  def byIndexImpl[UX](index: Int): F[({ type X1[_] = UX })#X1] => UX
  def byIndex[T[_]](index: Int): F[T] => Any = {
    val func1: F[({ type X1[_] = Any })#X1] => Any = byIndexImpl[Any](index)
    func1.asInstanceOf[F[T] => Any]
  }
}

object GetPropertyByIndex {

  def appendMonad[ProType]
    : AppenderSupport1.Simple1.Appender[({ type X[T0] = (Int, T0) => Either[Int, ProType] })#X, ({ type T1[_] = ProType })#T1] =
    new AppenderSupport1.Simple1.Appender[({ type X[T0] = (Int, T0) => Either[Int, ProType] })#X, ({ type T1[_] = ProType })#T1] {
      override def append[V, B1, C1](
        abc1: ABCFunc[ProType, B1, C1],
        ma: (Int, B1) => Either[Int, ProType]
      ): (Int, C1) => Either[Int, ProType] = (index, c1) => {
        val pro: ProType = abc1.takeHead(c1)
        val b1: B1       = abc1.takeTail(c1)
        if (index == 0) Right(pro)
        else ma(index - 1, b1)
      }
    }

  def toNamed[ProType]
    : AppenderSupport1.Simple1.One[({ type X[T0] = (Int, T0) => Either[Int, ProType] })#X, ({ type T1[_] = ProType })#T1] =
    new AppenderSupport1.Simple1.One[({ type X[T0] = (Int, T0) => Either[Int, ProType] })#X, ({ type T1[_] = ProType })#T1] {
      override def one[V, B1](abc1: FromToFunc[ProType, B1]): (Int, B1) => Either[Int, ProType] = (index, b1) =>
        if (index == 0) Left(index - 1) else Right(abc1.to(b1))
    }

  class Builder[F[_[_]]] {
    def derived(appender1: AppenderSupport1.Simple1.Release[F]): GetPropertyByIndex[F] = new GetPropertyByIndex[F] {
      override def byIndexImpl[UX](index: Int): F[({ type X1[_] = UX })#X1] => UX = (fM: F[({ type X1[_] = UX })#X1]) => {
        val containFunc =
          appender1.append[({ type X[T0] = (Int, T0) => Either[Int, UX] })#X, ({ type T1[_] = UX })#T1](appendMonad[UX], toNamed[UX])
        containFunc(index, fM).getOrElse(throw new Exception("Out of Index."))
      }
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
