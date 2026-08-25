package net.scalax.simple.codec

import net.scalax.simple.adt.nat.support.v5.AppenderSupport1
import net.scalax.simple.adt.nat.support.{ABCFunc, FromToFunc}

trait Map2Generc[F[_[_]]] {
  def map[S1[_], S2[_], T[_]](input: Map2Generc.Map2Function[S1, S2, T]): (F[S1], F[S2]) => F[T]
}

object Map2Generc {

  trait Map2Function[S1[_], S2[_], T[_]] {
    def map[X1](in: S1[X1], in2: S2[X1]): T[X1]
  }

  class Builder[F[_[_]]] {
    def derived(generic3: AppenderSupport1.Simple3.Release[F]): Map2Generc[F] = new Map2Generc[F] {
      override def map[S1[_], S2[_], T[_]](input: Map2Function[S1, S2, T]): (F[S1], F[S2]) => F[T] = {
        type MA[H1, H2, HH] = (H1, H2) => HH
        val appender: AppenderSupport1.Simple3.Appender[MA, S1, S2, T] = new AppenderSupport1.Simple3.Appender[MA, S1, S2, T] {
          override def append[MX1, B1, B2, B3, C1, C2, C3](
            abc1: ABCFunc[S1[MX1], B1, C1],
            abc12: ABCFunc[S2[MX1], B2, C2],
            abc2: ABCFunc[T[MX1], B3, C3],
            ma: (B1, B2) => B3
          ): (C1, C2) => C3 =
            (c1: C1, c2: C2) => {
              val sm1: S1[MX1] = abc1.takeHead(c1)
              val b1: B1       = abc1.takeTail(c1)
              val sm2: S2[MX1] = abc12.takeHead(c2)
              val b2: B2       = abc12.takeTail(c2)
              abc2.append(input.map[MX1](sm1, sm2), ma(b1, b2))
            }
        }
        val one: AppenderSupport1.Simple3.One[MA, S1, S2, T] = new AppenderSupport1.Simple3.One[MA, S1, S2, T] {
          override def one[U, B1, B2, B3](
            func1: FromToFunc[S1[U], B1],
            func12: FromToFunc[S2[U], B2],
            func2: FromToFunc[T[U], B3]
          ): (B1, B2) => B3 = { (b1: B1, b2: B2) =>
            func2.from(input.map[U](func1.to(b1), func12.to(b2)))
          }
        }
        generic3.append[MA, S1, S2, T](appender = appender, zero = one)
      }
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
