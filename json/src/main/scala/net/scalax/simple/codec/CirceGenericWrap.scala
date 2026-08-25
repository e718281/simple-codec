package net.scalax.simple.codec.circe

import io.circe._
import net.scalax.simple.adt.nat.support.v5.AppenderSupport1
import net.scalax.simple.adt.nat.support.{ABCFunc, FromToFunc, SimpleProduct2 => SP2}
import net.scalax.simple.codec.GetFieldModel

object EncodeHelperUtils {
  type Named[_]  = String
  type IdType[T] = T

  type EncodeAction[Name, Enc, Model] = (Name, Enc, Model) => JsonObject
  val emptyJsonObj: JsonObject = JsonObject.empty

  def encodeImpl[F[_[_]]](
    sp3: AppenderSupport1.Simple3.Release[F],
    namedIns: F[Named],
    encIns: () => F[Encoder]
  ): F[IdType] => JsonObject = {
    val one3: AppenderSupport1.Simple3.One[EncodeAction, Named, Encoder, IdType] =
      new AppenderSupport1.Simple3.One[EncodeAction, Named, Encoder, IdType] {
        override def one[T, B1, B2, B3](
          func1: FromToFunc[String, B1],
          func2: FromToFunc[Encoder[T], B2],
          func3: FromToFunc[T, B3]
        ): (B1, B2, B3) => JsonObject = (b1: B1, b2: B2, b3: B3) => {
          val nameStr: String = func1.to(b1)
          val en: Encoder[T]  = func2.to(b2)
          val t: T            = func3.to(b3)

          emptyJsonObj.add(nameStr, en(t))
        }
      }

    val appender3: AppenderSupport1.Simple3.Appender[EncodeAction, Named, Encoder, IdType] =
      new AppenderSupport1.Simple3.Appender[EncodeAction, Named, Encoder, IdType] {
        override def append[T, B1, B2, B3, C1, C2, C3](
          abc1: ABCFunc[String, B1, C1],
          abc2: ABCFunc[Encoder[T], B2, C2],
          abc3: ABCFunc[T, B3, C3],
          ma: (B1, B2, B3) => JsonObject
        ): (C1, C2, C3) => JsonObject = (n: C1, enc: C2, id: C3) => {
          val str: String          = abc1.takeHead(n)
          val b1: B1               = abc1.takeTail(n)
          val encoderT: Encoder[T] = abc2.takeHead(enc)
          val b2: B2               = abc2.takeTail(enc)
          val t: T                 = abc3.takeHead(id)
          val b3: B3               = abc3.takeTail(id)
          val maJson: JsonObject   = ma(b1, b2, b3)
          val jPro: Json           = encoderT(t)

          maJson.add(str, jPro)
        }

      }

    val action = sp3.append[EncodeAction, Named, Encoder, IdType](appender3, one3)

    (model: F[IdType]) => action(namedIns, encIns(), model)
  }

  type DecodeJson[Name, Dec, Model, DefaultValue] = (Name, Dec, DefaultValue) => Decoder.Result[Model]

  def decodeImpl[F[_[_]]](
    sp2: AppenderSupport1.Simple2.Release[F],
    sp4: AppenderSupport1.Simple4.Release[F],
    named: F[Named],
    g: () => F[Decoder],
    defaultValue: Option[F[({ type OptF[TU] = Option[() => TU] })#OptF]]
  ): HCursor => Decoder.Result[F[IdType]] = (hCursor: HCursor) => {
    type OptF[TU]    = Option[() => TU]
    type OptFGet[TU] = F[OptF] => OptF[TU]

    val getField: GetFieldModel[F] = GetFieldModel[F].derived(sp2)

    val one4: AppenderSupport1.Simple4.One[DecodeJson, Named, Decoder, IdType, OptFGet] =
      new AppenderSupport1.Simple4.One[DecodeJson, Named, Decoder, IdType, OptFGet] {
        override def one[T, B1, B2, B3, B4](
          func1: FromToFunc[String, B1],
          func2: FromToFunc[Decoder[T], B2],
          func3: FromToFunc[T, B3],
          func4: FromToFunc[OptFGet[T], B4]
        ): (B1, B2, B4) => Decoder.Result[B3] = (b1: B1, b2: B2, b4: B4) => {
          val nameStr: String                    = func1.to(b1)
          val decoderT: Decoder[T]               = func2.to(b2)
          val optGet: F[OptF] => Option[() => T] = func4.to(b4)

          val value1: Decoder.Result[T] = hCursor.downField(nameStr).as(decoderT)
          val value2: Decoder.Result[T] = if (value1.isLeft) {
            val optIns = defaultValue.flatMap(optGet)
            optIns.fold[Decoder.Result[T]](value1)(rValue1 => Right(rValue1()))
          } else value1

          for (v1 <- value2) yield func3.from(v1)
        }
      }

    val appender4: AppenderSupport1.Simple4.Appender[DecodeJson, Named, Decoder, IdType, OptFGet] =
      new AppenderSupport1.Simple4.Appender[DecodeJson, Named, Decoder, IdType, OptFGet] {
        override def append[T, B1, B2, B3, B4, C1, C2, C3, C4](
          abc1: ABCFunc[String, B1, C1],
          abc2: ABCFunc[Decoder[T], B2, C2],
          abc3: ABCFunc[T, B3, C3],
          abc4: ABCFunc[F[OptF] => Option[() => T], B4, C4],
          ma: DecodeJson[B1, B2, B3, B4]
        ): DecodeJson[C1, C2, C3, C4] = (n: C1, dec: C2, defVal: C4) => {
          val nameStr: String                    = abc1.takeHead(n)
          val b1: B1                             = abc1.takeTail(n)
          val decoderT: Decoder[T]               = abc2.takeHead(dec)
          val b2: B2                             = abc2.takeTail(dec)
          val optGet: F[OptF] => Option[() => T] = abc4.takeHead(defVal)
          val b4: B4                             = abc4.takeTail(defVal)
          val b3Result: Decoder.Result[B3]       = ma(b1, b2, b4)
          val value1: Decoder.Result[T]          = hCursor.downField(nameStr).as(decoderT)
          val value2: Decoder.Result[T]          = if (value1.isLeft) {
            val optIns = defaultValue.flatMap(optGet)
            optIns.fold[Decoder.Result[T]](value1)(rValue1 => Right(rValue1()))
          } else value1

          for {
            v1 <- value2
            v2 <- b3Result
          } yield abc3.append(v1, v2)
        }
      }

    val decoderFunc: DecodeJson[F[Named], F[Decoder], F[IdType], F[OptFGet]] =
      sp4.append[DecodeJson, Named, Decoder, IdType, OptFGet](appender4, one4)

    decoderFunc(named, g(), getField.getFieldModel[OptF])
  }

}
