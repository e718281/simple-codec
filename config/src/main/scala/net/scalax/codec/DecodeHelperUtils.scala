package net.scalax.simple.codec.pureconfig

import net.scalax.simple.adt.nat.support.v5.AppenderSupport1
import pureconfig._
import net.scalax.simple.adt.nat.support.{ABCFunc, FromToFunc}
import net.scalax.simple.codec.GetFieldModel

object DecodeHelperUtils {

  type Named[_]                                   = String
  type IdType[T]                                  = T
  type DecodeJson[Name, Dec, Model, DefaultValue] = (Name, Dec, DefaultValue) => ConfigReader.Result[Model]

  def decodeImpl[F[_[_]]](
    sp2: AppenderSupport1.Simple2.Release[F],
    sp4: AppenderSupport1.Simple4.Release[F],
    named: F[Named],
    g: () => F[ConfigReader],
    defaultValue: Option[F[({ type OptF[TU] = Option[() => TU] })#OptF]]
  ): ConfigObjectCursor => ConfigReader.Result[F[IdType]] = (hCursor: ConfigObjectCursor) => {
    type OptF[TU]    = Option[() => TU]
    type OptFGet[TU] = F[OptF] => OptF[TU]

    val getField: GetFieldModel[F] = GetFieldModel[F].derived(sp2)

    val appender: AppenderSupport1.Simple4.Appender[DecodeJson, Named, ConfigReader, IdType, OptFGet] =
      new AppenderSupport1.Simple4.Appender[DecodeJson, Named, ConfigReader, IdType, OptFGet] {
        override def append[T, B1, B2, B3, B4, C1, C2, C3, C4](
          abc1: ABCFunc[String, B1, C1],
          abc2: ABCFunc[ConfigReader[T], B2, C2],
          abc3: ABCFunc[T, B3, C3],
          abc4: ABCFunc[OptFGet[T], B4, C4],
          ma: DecodeJson[B1, B2, B3, B4]
        ): (C1, C2, C4) => ConfigReader.Result[C3] = (c1: C1, c2: C2, c4: C4) => {
          val name1: String                 = abc1.takeHead(c1)
          val b1: B1                        = abc1.takeTail(c1)
          val configReader: ConfigReader[T] = abc2.takeHead(c2)
          val b2: B2                        = abc2.takeTail(c2)
          val optGet: OptFGet[T]            = abc4.takeHead(c4)
          val b4: B4                        = abc4.takeTail(c4)

          val value1: ConfigReader.Result[T] = for {
            v1 <- hCursor.atKey(name1)
            v2 <- configReader.from(v1)
          } yield v2

          val value2: ConfigReader.Result[T] = if (value1.isLeft) {
            val optIns = defaultValue.flatMap(optGet)
            optIns.fold[ConfigReader.Result[T]](value1)(r => Right(r()))
          } else value1

          for {
            t1 <- ma(b1, b2, b4)
            t2 <- value2
          } yield abc3.append(t2, t1)
        }
      }

    val one: AppenderSupport1.Simple4.One[DecodeJson, Named, ConfigReader, IdType, OptFGet] =
      new AppenderSupport1.Simple4.One[DecodeJson, Named, ConfigReader, IdType, OptFGet] {
        override def one[T, B1, B2, B3, B4](
          func1: FromToFunc[String, B1],
          func2: FromToFunc[ConfigReader[T], B2],
          func3: FromToFunc[T, B3],
          func4: FromToFunc[OptFGet[T], B4]
        ): (B1, B2, B4) => ConfigReader.Result[B3] = (b1: B1, b2: B2, b3: B4) => {
          val nameStr: String         = func1.to(b1)
          val reader: ConfigReader[T] = func2.to(b2)
          val optGet: OptFGet[T]      = func4.to(b3)

          val value1: ConfigReader.Result[T] = for {
            v1 <- hCursor.atKey(nameStr)
            v2 <- reader.from(v1)
          } yield v2

          val value2: ConfigReader.Result[T] = if (value1.isLeft) {
            val optIns = defaultValue.flatMap(optGet)
            optIns.fold[ConfigReader.Result[T]](value1)(r => Right(r()))
          } else value1

          for (v2 <- value2) yield func3.from(v2)
        }
      }

    val decoderFunc: DecodeJson[F[Named], F[ConfigReader], F[IdType], F[OptFGet]] =
      sp4.append[DecodeJson, Named, ConfigReader, IdType, OptFGet](appender = appender, zero = one)

    decoderFunc(named, g(), getField.getFieldModel[OptF])
  }

}
