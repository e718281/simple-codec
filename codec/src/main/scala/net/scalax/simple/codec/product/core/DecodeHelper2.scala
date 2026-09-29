package net.scalax.simple.codec.product.core

import net.scalax.simple.adt.nat.support.v5.AppenderSupport1
import net.scalax.simple.adt.nat.support.{ABCFunc, FromToFunc}

trait DecodeHelper2[F[_[_]]] {
  def map[U1[_], U2[_], S[_], T[_]](f1: F[U1], f2: F[U2], input: DecodeHelper2.Helper[U1, U2, S, T]): S[F[T]]
}

object DecodeHelper2 {

  trait Helper[U1[_], U2[_], S[_], T[_]] {
    def func[X1](in: U1[X1], in2: U2[X1]): S[T[X1]]
    def map1[A, B](t: A => B): S[A] => S[B]
    def map2[A, B, C](t: (A, B) => C): (S[A], S[B]) => S[C]
  }

  class Builder[F[_[_]]] {
    def derived(generic3: AppenderSupport1.Simple3.Release[F]): DecodeHelper2[F] = new DecodeHelper2[F] {
      override def map[U1[_], U2[_], S[_], T[_]](f1: F[U1], f2: F[U2], input: DecodeHelper2.Helper[U1, U2, S, T]): S[F[T]] = {
        type MA[H1, H2, H3] = (H1, H2) => S[H3]
        val appender: AppenderSupport1.Simple3.Appender[MA, U1, U2, T] = new AppenderSupport1.Simple3.Appender[MA, U1, U2, T] {
          override def append[X1, B1, B2, B3, C1, C2, C3](
            abc1: ABCFunc[U1[X1], B1, C1],
            abc2: ABCFunc[U2[X1], B2, C2],
            abc3: ABCFunc[T[X1], B3, C3],
            ma: (B1, B2) => S[B3]
          ): (C1, C2) => S[C3] = (c1, c2) => {
            val sm1: U1[X1]   = abc1.takeHead(c1)
            val b1: B1        = abc1.takeTail(c1)
            val sm2: U2[X1]   = abc2.takeHead(c2)
            val b2: B2        = abc2.takeTail(c2)
            val sb3: S[B3]    = ma(b1, b2)
            val stx: S[T[X1]] = input.func[X1](sm1, sm2)
            input.map2[T[X1], B3, C3](abc3.append)(stx, sb3)
          }
        }
        val one: AppenderSupport1.Simple3.One[MA, U1, U2, T] = new AppenderSupport1.Simple3.One[MA, U1, U2, T] {
          override def one[X1, B1, B2, B3](
            abc1: FromToFunc[U1[X1], B1],
            abc2: FromToFunc[U2[X1], B2],
            abc3: FromToFunc[T[X1], B3]
          ): (B1, B2) => S[B3] = (b1, b2) => {
            val u1x1: U1[X1]  = abc1.to(b1)
            val u2x1: U2[X1]  = abc2.to(b2)
            val stx: S[T[X1]] = input.func[X1](u1x1, u2x1)
            input.map1[T[X1], B3](abc3.from)(stx)
          }
        }

        val func: (F[U1], F[U2]) => S[F[T]] = generic3.append[MA, U1, U2, T](appender = appender, zero = one)

        func(f1, f2)
      }
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
