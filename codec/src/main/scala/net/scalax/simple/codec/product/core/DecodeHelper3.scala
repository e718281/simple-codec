package net.scalax.simple.codec.product.core

import net.scalax.simple.adt.nat.support.v5.AppenderSupport1
import net.scalax.simple.adt.nat.support.{ABCFunc, FromToFunc}

trait DecodeHelper3[F[_[_]]] {
  def map[U1[_], U2[_], U3[_], S[_], T[_]](f1: F[U1], f2: F[U2], f3: F[U3], input: DecodeHelper3.Helper[U1, U2, U3, S, T]): S[F[T]]
}

object DecodeHelper3 {

  trait Helper[U1[_], U2[_], U3[_], S[_], T[_]] {
    def func[X1](in: U1[X1], in2: U2[X1], in3: U3[X1]): S[T[X1]]
    def map1[A, B](t: A => B): S[A] => S[B]
    def map2[A, B, C](t: (A, B) => C): (S[A], S[B]) => S[C]
  }

  class Builder[F[_[_]]] {
    def derived(generic3: AppenderSupport1.Simple4.Release[F]): DecodeHelper3[F] = new DecodeHelper3[F] {
      override def map[U1[_], U2[_], U3[_], S[_], T[_]](
        f1: F[U1],
        f2: F[U2],
        f3: F[U3],
        input: DecodeHelper3.Helper[U1, U2, U3, S, T]
      ): S[F[T]] = {
        type MA[H1, H2, H3, H4] = (H1, H2, H3) => S[H4]
        val appender: AppenderSupport1.Simple4.Appender[MA, U1, U2, U3, T] = new AppenderSupport1.Simple4.Appender[MA, U1, U2, U3, T] {
          override def append[X1, B1, B2, B3, B4, C1, C2, C3, C4](
            abc1: ABCFunc[U1[X1], B1, C1],
            abc2: ABCFunc[U2[X1], B2, C2],
            abc3: ABCFunc[U3[X1], B3, C3],
            abc4: ABCFunc[T[X1], B4, C4],
            ma: (B1, B2, B3) => S[B4]
          ): (C1, C2, C3) => S[C4] = (c1, c2, c3) => {
            val sm1: U1[X1]   = abc1.takeHead(c1)
            val b1: B1        = abc1.takeTail(c1)
            val sm2: U2[X1]   = abc2.takeHead(c2)
            val b2: B2        = abc2.takeTail(c2)
            val sm3: U3[X1]   = abc3.takeHead(c3)
            val b3: B3        = abc3.takeTail(c3)
            val sb3: S[B4]    = ma(b1, b2, b3)
            val stx: S[T[X1]] = input.func[X1](sm1, sm2, sm3)
            input.map2[T[X1], B4, C4](abc4.append)(stx, sb3)
          }
        }
        val one: AppenderSupport1.Simple4.One[MA, U1, U2, U3, T] = new AppenderSupport1.Simple4.One[MA, U1, U2, U3, T] {
          override def one[X1, B1, B2, B3, B4](
            abc1: FromToFunc[U1[X1], B1],
            abc2: FromToFunc[U2[X1], B2],
            abc3: FromToFunc[U3[X1], B3],
            abc4: FromToFunc[T[X1], B4]
          ): MA[B1, B2, B3, B4] = (b1, b2, b3) => {
            val u1x: U1[X1]   = abc1.to(b1)
            val u2x: U2[X1]   = abc2.to(b2)
            val u3x: U3[X1]   = abc3.to(b3)
            val stx: S[T[X1]] = input.func[X1](u1x, u2x, u3x)
            input.map1[T[X1], B4](abc4.from)(stx)
          }
        }

        val func: (F[U1], F[U2], F[U3]) => S[F[T]] = generic3.append[MA, U1, U2, U3, T](appender = appender, zero = one)

        func(f1, f2, f3)
      }
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
