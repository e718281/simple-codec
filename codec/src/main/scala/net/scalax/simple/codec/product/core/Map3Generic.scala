package net.scalax.simple.codec.product.core

import net.scalax.simple.adt.nat.support.v5.AppenderSupport1
import net.scalax.simple.adt.nat.support.{ABCFunc, FromToFunc}

trait Map3Generic[F[_[_]]] {
  def map[S1[_], S2[_], S3[_], T[_]](input: Map3Generic.MapFunction[S1, S2, S3, T]): (F[S1], F[S2], F[S3]) => F[T]
}

object Map3Generic {

  trait MapFunction[S1[_], S2[_], S3[_], T[_]] {
    def func[X1](in: S1[X1], in2: S2[X1], in3: S3[X1]): T[X1]
  }

  class Builder[F[_[_]]] {
    def derived(generic3: AppenderSupport1.Simple4.Release[F]): Map3Generic[F] = new Map3Generic[F] {
      override def map[S1[_], S2[_], S3[_], T[_]](input: MapFunction[S1, S2, S3, T]): (F[S1], F[S2], F[S3]) => F[T] = {
        type MA[H1, H2, H3, HH] = (H1, H2, H3) => HH
        val appender: AppenderSupport1.Simple4.Appender[MA, S1, S2, S3, T] = new AppenderSupport1.Simple4.Appender[MA, S1, S2, S3, T] {
          override def append[MX1, B1, B2, B3, B4, C1, C2, C3, C4](
            abc1: ABCFunc[S1[MX1], B1, C1],
            abc2: ABCFunc[S2[MX1], B2, C2],
            abc3: ABCFunc[S3[MX1], B3, C3],
            abc4: ABCFunc[T[MX1], B4, C4],
            ma: (B1, B2, B3) => B4
          ): (C1, C2, C3) => C4 =
            (c1: C1, c2: C2, c3: C3) => {
              val sm1: S1[MX1] = abc1.takeHead(c1)
              val b1: B1       = abc1.takeTail(c1)
              val sm2: S2[MX1] = abc2.takeHead(c2)
              val b2: B2       = abc2.takeTail(c2)
              val sm3: S3[MX1] = abc3.takeHead(c3)
              val b3: B3       = abc3.takeTail(c3)
              abc4.append(input.func[MX1](sm1, sm2, sm3), ma(b1, b2, b3))
            }
        }
        val one: AppenderSupport1.Simple4.One[MA, S1, S2, S3, T] = new AppenderSupport1.Simple4.One[MA, S1, S2, S3, T] {
          override def one[U, B1, B2, B3, B4](
            func1: FromToFunc[S1[U], B1],
            func2: FromToFunc[S2[U], B2],
            func3: FromToFunc[S3[U], B3],
            func4: FromToFunc[T[U], B4]
          ): (B1, B2, B3) => B4 = { (b1: B1, b2: B2, b3: B3) =>
            func4.from(input.func[U](func1.to(b1), func2.to(b2), func3.to(b3)))
          }
        }
        generic3.append[MA, S1, S2, S3, T](appender = appender, zero = one)
      }
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
