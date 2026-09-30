package net.scalax.simple
package codec

import net.scalax.simple.adt.nat.support.v5.AppenderSupport1
import play.api.libs.json._
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._
import net.scalax.simple.adt.nat.support.{ABCFunc, FromToFunc}
import net.scalax.simple.codec.product.core.{DecodeHelper2, DecodeHelper3, Fold3Generic}

object PlayJsonGeneric2 {
  type Named[_]  = String
  type IdType[T] = T

  def encodeImpl[F[_[_]]](sp3: AppenderSupport1.Simple3.Release[F], namedIns: F[Named], encIns: () => F[Writes]): F[IdType] => JsValue = {
    val folderGeneric: Fold3Generic[F] = Fold3Generic[F].derived(sp3)

    val folderFunc = new Fold3Generic.Folder[Named, Writes, IdType, JsObject] {
      override def fold[T](n1: String, n2: Writes[T], n3: T, col: JsObject): JsObject = col.+(n1 -> n2.writes(n3))
      override def zero: JsObject                                                     = JsObject.empty
    }

    (model: F[IdType]) => folderGeneric.foldLeft(namedIns, encIns(), model, folderFunc)
  }

  type DecodeJson[Name, Dec, Model, DefaultValue] = (Name, Dec, DefaultValue) => JsResult[Model]

  def decodeImpl[F[_[_]]](
    sp2: AppenderSupport1.Simple2.Release[F],
    sp3: AppenderSupport1.Simple3.Release[F],
    sp4: AppenderSupport1.Simple4.Release[F],
    named: F[Named],
    g: () => F[Reads],
    defaultValue: Option[F[({ type OptF[TU] = Option[() => TU] })#OptF]]
  ): JsObject => JsResult[F[IdType]] = {
    defaultValue.fold(decodeImpl2[F](sp3, named, g))(dv => decodeImpl1[F](sp2, sp4, named, g, dv))

    /*type OptF[TU]    = Option[() => TU]
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

    val one: AppenderSupport1.Simple4.One[DecodeJson, Named, Reads, IdType, OptFGet] =
      new AppenderSupport1.Simple4.One[DecodeJson, Named, Reads, IdType, OptFGet] {
        override def one[T, B1, B2, B3, B4](
          func1: FromToFunc[String, B1],
          func2: FromToFunc[Reads[T], B2],
          func3: FromToFunc[T, B3],
          func4: FromToFunc[OptFGet[T], B4]
        ): (B1, B2, B4) => JsResult[B3] = (b1: B1, b2: B2, b4: B4) => {
          val nameStr: String                  = func1.to(b1)
          val readT: Reads[T]                  = func2.to(b2)
          val get1: F[OptF] => Option[() => T] = func4.to(b4)

          val jsPath: JsPath      = JsPath() \ nameStr
          val read1: Reads[T]     = Reads.at[T](jsPath)(readT)
          val value2: JsResult[T] = read1.reads(hCursor)

          val value3: JsResult[T] = value2.recoverWith[T] { error =>
            val optIns = defaultValue.flatMap(get1)
            optIns.fold[JsResult[T]](error)(dInstance => JsSuccess(dInstance()))
          }

          for (m2 <- value3) yield func3.from(m2)
        }
      }

    val decoderFunc: DecodeJson[F[Named], F[Reads], F[IdType], F[OptFGet]] =
      sp4.append[DecodeJson, Named, Reads, IdType, OptFGet](appender = appender, zero = one)

    decoderFunc(named, g(), getField.getFieldModel[OptF])*/
  }

  def decodeImpl1[F[_[_]]](
    sp2: AppenderSupport1.Simple2.Release[F],
    sp4: AppenderSupport1.Simple4.Release[F],
    named: F[Named],
    g: () => F[Reads],
    defaultValue: F[({ type OptF[TU] = Option[() => TU] })#OptF]
  ): JsObject => JsResult[F[IdType]] = (hCursor: JsObject) => {
    type OptF[TU]    = Option[() => TU]
    type OptFGet[TU] = F[OptF] => OptF[TU]

    val getField: GetFieldModel[F]                                            = GetFieldModel[F].derived(sp2)
    val decoderHelper: DecodeHelper3[F]                                       = DecodeHelper3[F].derived(sp4)
    val helper: DecodeHelper3.Helper[Named, Reads, OptFGet, JsResult, IdType] =
      new DecodeHelper3.Helper[Named, Reads, OptFGet, JsResult, IdType] {
        override def func[X1](nameStr: String, decoderT: Reads[X1], in3: F[OptF] => Option[() => X1]): JsResult[X1] = {
          val jsPath: JsPath        = JsPath() \ nameStr
          val read1: Reads[X1]      = Reads.at[X1](jsPath)(decoderT)
          val result1: JsResult[X1] = read1.reads(hCursor)
          result1.recoverWith[X1](_ => in3(defaultValue).fold(result1)(v1 => JsSuccess(v1())))
        }
        override def map1[A, B](t: A => B): JsResult[A] => JsResult[B]                        = a => for (a1 <- a) yield t(a1)
        override def map2[A, B, C](t: (A, B) => C): (JsResult[A], JsResult[B]) => JsResult[C] = (a, b) =>
          for {
            a1 <- a
            b1 <- b
          } yield t(a1, b1)
      }

    decoderHelper.map(named, g(), getField.getFieldModel[OptF], helper)
  }

  def decodeImpl2[F[_[_]]](
    sp3: AppenderSupport1.Simple3.Release[F],
    named: F[Named],
    g: () => F[Reads]
  ): JsObject => JsResult[F[IdType]] = (hCursor: JsObject) => {
    type OptF[TU]    = Option[() => TU]
    type OptFGet[TU] = F[OptF] => OptF[TU]

    val decoderHelper: DecodeHelper2[F]                              = DecodeHelper2[F].derived(sp3)
    val helper: DecodeHelper2.Helper[Named, Reads, JsResult, IdType] =
      new DecodeHelper2.Helper[Named, Reads, JsResult, IdType] {
        override def func[X1](nameStr: String, decoderT: Reads[X1]): JsResult[X1] = {
          val jsPath: JsPath   = JsPath() \ nameStr
          val read1: Reads[X1] = Reads.at[X1](jsPath)(decoderT)
          read1.reads(hCursor)
        }
        override def map1[A, B](t: A => B): JsResult[A] => JsResult[B]                        = a => for (a1 <- a) yield t(a1)
        override def map2[A, B, C](t: (A, B) => C): (JsResult[A], JsResult[B]) => JsResult[C] = (a, b) =>
          for {
            a1 <- a
            b1 <- b
          } yield t(a1, b1)
      }

    decoderHelper.map(named, g(), helper)
  }

}
