package net.scalax.simple.codec.product.core

import net.scalax.simple.adt.nat.support.{ABCFunc, FromToFunc}
import net.scalax.simple.adt.nat.support.v5.AppenderSupport1

trait Map0Generic[F[_[_]]] {
  def map[S[_]](t: Map0Generic.MapFunction[S]): F[S]
}

object Map0Generic {
  trait MapFunction[S[_]] {
    def func[T]: S[T]
  }

  class Builder[F[_[_]]] {
    type Id[T] = T
    def derived(basedInstalled: AppenderSupport1.Simple1.Release[F]): Map0Generic[F] = new Map0Generic[F] {
      override def map[S[_]](t: Map0Generic.MapFunction[S]): F[S] = {
        val appender = new AppenderSupport1.Simple1.Appender[Id, S] {
          override def append[T, B1, C1](abc1: ABCFunc[S[T], B1, C1], ma: B1): C1 = abc1.append(t.func[T], ma)
        }
        val one = new AppenderSupport1.Simple1.One[Id, S] {
          override def one[T, B1](abc1: FromToFunc[S[T], B1]): B1 = abc1.from(t.func[T])
        }

        basedInstalled.append[Id, S](appender, one)
      }
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]
}
