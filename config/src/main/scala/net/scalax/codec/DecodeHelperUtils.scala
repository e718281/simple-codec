package net.scalax.simple.codec.pureconfig

import net.scalax.simple.adt.nat.support.v5.AppenderSupport1
import pureconfig._
import net.scalax.simple.codec.product.core.GetFieldGeneric
import net.scalax.simple.codec.product.core.{DecodeHelper2, DecodeHelper3}

object DecodeHelperUtils {

  type Named[_]  = String
  type IdType[T] = T

  def decodeImpl[F[_[_]]](
    sp2: AppenderSupport1.Simple2.Release[F],
    sp3: AppenderSupport1.Simple3.Release[F],
    sp4: AppenderSupport1.Simple4.Release[F],
    named: F[Named],
    g: () => F[ConfigReader],
    defaultValue: Option[F[({ type OptF[TU] = Option[() => TU] })#OptF]]
  ): ConfigObjectCursor => ConfigReader.Result[F[IdType]] =
    defaultValue.fold(decodeImpl2[F](sp3, named, g))(dv => decodeImpl1[F](sp2, sp4, named, g, dv))

  def decodeImpl1[F[_[_]]](
    sp2: AppenderSupport1.Simple2.Release[F],
    sp4: AppenderSupport1.Simple4.Release[F],
    named: F[Named],
    g: () => F[ConfigReader],
    defaultValue: F[({ type OptF[TU] = Option[() => TU] })#OptF]
  ): ConfigObjectCursor => ConfigReader.Result[F[IdType]] = (hCursor: ConfigObjectCursor) => {
    type OptF[TU]    = Option[() => TU]
    type OptFGet[TU] = F[OptF] => OptF[TU]

    val getField: GetFieldGeneric[F]                                                            = GetFieldGeneric[F].derived(sp2)
    val decoderHelper: DecodeHelper3[F]                                                         = DecodeHelper3[F].derived(sp4)
    val helper: DecodeHelper3.Helper[Named, ConfigReader, OptFGet, ConfigReader.Result, IdType] =
      new DecodeHelper3.Helper[Named, ConfigReader, OptFGet, ConfigReader.Result, IdType] {
        override def func[X1](nameStr: String, decoderT: ConfigReader[X1], in3: F[OptF] => Option[() => X1]): ConfigReader.Result[X1] = {
          val result1: ConfigReader.Result[X1] = for {
            v1 <- hCursor.atKey(nameStr)
            v2 <- decoderT.from(v1)
          } yield v2

          result1.left.flatMap(_ => in3(defaultValue).fold(result1)(v => Right(v())))
        }
        override def map1[A, B](t: A => B): ConfigReader.Result[A] => ConfigReader.Result[B] = a => for (a1 <- a) yield t(a1)
        override def map2[A, B, C](t: (A, B) => C): (ConfigReader.Result[A], ConfigReader.Result[B]) => ConfigReader.Result[C] = (a, b) =>
          for {
            a1 <- a
            b1 <- b
          } yield t(a1, b1)
      }

    decoderHelper.map(named, g(), getField.getField[OptF], helper)
  }

  def decodeImpl2[F[_[_]]](
    sp3: AppenderSupport1.Simple3.Release[F],
    named: F[Named],
    g: () => F[ConfigReader]
  ): ConfigObjectCursor => ConfigReader.Result[F[IdType]] = (hCursor: ConfigObjectCursor) => {
    type OptF[TU]    = Option[() => TU]
    type OptFGet[TU] = F[OptF] => OptF[TU]

    val decoderHelper: DecodeHelper2[F]                                                = DecodeHelper2[F].derived(sp3)
    val helper: DecodeHelper2.Helper[Named, ConfigReader, ConfigReader.Result, IdType] =
      new DecodeHelper2.Helper[Named, ConfigReader, ConfigReader.Result, IdType] {
        override def func[X1](nameStr: String, decoderT: ConfigReader[X1]): ConfigReader.Result[X1] = for {
          v1 <- hCursor.atKey(nameStr)
          v2 <- decoderT.from(v1)
        } yield v2
        override def map1[A, B](t: A => B): ConfigReader.Result[A] => ConfigReader.Result[B] = a => for (a1 <- a) yield t(a1)
        override def map2[A, B, C](t: (A, B) => C): (ConfigReader.Result[A], ConfigReader.Result[B]) => ConfigReader.Result[C] = (a, b) =>
          for {
            a1 <- a
            b1 <- b
          } yield t(a1, b1)
      }

    decoderHelper.map(named, g(), helper)
  }

}
