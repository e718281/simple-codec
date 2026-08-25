package net.scalax.simple
package codec

import net.scalax.simple.adt.nat.support.v5.AppenderSupport1
import play.api.libs.json._
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._
import net.scalax.simple.adt.nat.support.ABCFunc

object PlayJsonGeneric2 {
  type Named[_]  = String
  type IdType[T] = T

  type EncodeAction[Name, Enc, Model] = (Name, Enc, Model) => List[(String, JsValue)]

  def encodeImpl[F[_[_]]](sp3: AppenderSupport1.Simple3.Runner[F], namedIns: F[Named], encIns: () => F[Writes]): F[IdType] => JsValue = {
    val appender: AppenderSupport1.Simple3.Appender[EncodeAction, Named, Writes, IdType] =
      new AppenderSupport1.Simple3.Appender[EncodeAction, Named, Writes, IdType] {
        override def append[T, B1, B2, B3, C1, C2, C3](
          abc1: ABCFunc[String, B1, C1],
          abc2: ABCFunc[Writes[T], B2, C2],
          abc3: ABCFunc[T, B3, C3],
          ma: (B1, B2, B3) => List[(String, JsValue)]
        ): (C1, C2, C3) => List[(String, JsValue)] = (c1: C1, c2: C2, c3: C3) => {
          val nameStr: String = abc1.takeHead(c1)
          val b1: B1          = abc1.takeTail(c1)
          val wt2: Writes[T]  = abc2.takeHead(c2)
          val b2: B2          = abc2.takeTail(c2)
          val t1: T           = abc3.takeHead(c3)
          val b3: B3          = abc3.takeTail(c3)
          (nameStr, wt2.writes(t1)) :: ma(b1, b2, b3)
        }
      }

    val zero: AppenderSupport1.Simple3.Zero[EncodeAction] = new AppenderSupport1.Simple3.Zero[EncodeAction] {
      override def zero[B1, B2, B3](b1: B1, b2: B2, b3: B3): (B1, B2, B3) => List[(String, JsValue)] = (b1: B1, b2: B2, b3: B3) =>
        List.empty[(String, JsValue)]
    }

    val action: (F[Named], F[Writes], F[IdType]) => List[(String, JsValue)] =
      sp3.append[EncodeAction, Named, Writes, IdType](appender = appender, zero = zero)

    (model: F[IdType]) => {
      val list: List[(String, JsValue)] = action(namedIns, encIns(), model)
      JsObject(list)
    }
  }

  type DecodeJson[Name, Dec, Model, DefaultValue] = (Name, Dec, DefaultValue) => JsResult[Model]

  def decodeImpl[F[_[_]]](
    sp2: AppenderSupport1.Simple2.Release[F],
    sp4: AppenderSupport1.Simple4.Runner[F],
    named: F[Named],
    g: () => F[Reads],
    defaultValue: Option[F[({ type OptF[TU] = Option[() => TU] })#OptF]]
  ): JsObject => JsResult[F[IdType]] = (hCursor: JsObject) => {
    type OptF[TU]    = Option[() => TU]
    type OptFGet[TU] = F[OptF] => OptF[TU]

    val getField: GetFieldModel[F] = GetFieldModel[F].derived(sp2)

    val appender: AppenderSupport1.Simple4.Appender[DecodeJson, Named, Reads, IdType, OptFGet] =
      new AppenderSupport1.Simple4.Appender[DecodeJson, Named, Reads, IdType, OptFGet] {
        override def append[T, B1, B2, B3, B4, C1, C2, C3, C4](
          abc1: ABCFunc[String, B1, C1],
          abc2: ABCFunc[Reads[T], B2, C2],
          abc3: ABCFunc[T, B3, C3],
          abc4: ABCFunc[F[OptF] => Option[() => T], B4, C4],
          ma: DecodeJson[B1, B2, B3, B4]
        ): DecodeJson[C1, C2, C3, C4] = (c1: C1, c2: C2, c4: C4) => {
          val nameStr: String                  = abc1.takeHead(c1)
          val b1: B1                           = abc1.takeTail(c1)
          val readT: Reads[T]                  = abc2.takeHead(c2)
          val b2: B2                           = abc2.takeTail(c2)
          val get1: F[OptF] => Option[() => T] = abc4.takeHead(c4)
          val b4: B4                           = abc4.takeTail(c4)
          val r1: JsResult[B3]                 = ma(b1, b2, b4)

          val jsPath: JsPath      = JsPath() \ nameStr
          val read1: Reads[T]     = Reads.at[T](jsPath)(readT)
          val value2: JsResult[T] = read1.reads(hCursor)

          val value3: JsResult[T] = value2.recoverWith[T] { error =>
            val optIns = defaultValue.flatMap(get1)
            optIns.fold[JsResult[T]](error)(dInstance => JsSuccess(dInstance()))
          }

          for {
            m1 <- r1
            m2 <- value3
          } yield abc3.append(m2, m1)
        }
      }

    val zero: AppenderSupport1.Simple4.Zero[DecodeJson] = new AppenderSupport1.Simple4.Zero[DecodeJson] {
      override def zero[B1, B2, B3, B4](b1: B1, b2: B2, b3: B3, b4: B4): DecodeJson[B1, B2, B3, B4] = (b1: B1, b2: B2, b4: B4) =>
        JsSuccess(b3)
    }

    val decoderFunc: DecodeJson[F[Named], F[Reads], F[IdType], F[OptFGet]] =
      sp4.append[DecodeJson, Named, Reads, IdType, OptFGet](appender = appender, zero = zero)

    decoderFunc(named, g(), getField.getFieldModel[OptF])
  }

}
