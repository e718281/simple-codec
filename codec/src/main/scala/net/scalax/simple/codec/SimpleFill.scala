package net.scalax.simple.codec

import net.scalax.simple.adt.nat.support.{ABCFunc, FromToFunc}
import net.scalax.simple.adt.nat.support.v5.AppenderSupport1

trait SimpleFill[F[_[_]]] {
  def fill[S[_]](t: SimpleFill.FillI[S]): F[S]
}

object SimpleFill {
  trait FillI[S[_]] {
    def fill[T]: S[T]
  }

  class Builder[F[_[_]]] {
    type Id[T] = T
    def derived(basedInstalled: AppenderSupport1.Simple1.Release[F]): SimpleFill[F] = new SimpleFill[F] {
      override def fill[S[_]](t: SimpleFill.FillI[S]): F[S] = {
        val appender = new AppenderSupport1.Simple1.Appender[Id, S] {
          override def append[T, B1, C1](abc1: ABCFunc[S[T], B1, C1], ma: B1): C1 = abc1.append(t.fill[T], ma)
        }
        val one = new AppenderSupport1.Simple1.One[Id, S] {
          override def one[T, B1](abc1: FromToFunc[S[T], B1]): B1 = abc1.from(t.fill[T])
        }

        basedInstalled.append[Id, S](appender, one)
      }
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]
}
