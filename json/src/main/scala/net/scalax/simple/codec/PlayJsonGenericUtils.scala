package net.scalax.simple
package codec

import net.scalax.simple.adt.nat.support.v5.AppenderSupport1
import play.api.libs.json._
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._
import net.scalax.simple.adt.nat.support.{ABCFunc, FromToFunc}
import net.scalax.simple.codec.product.core.{DecodeHelper2, DecodeHelper3, Fold3Generic, GetFieldGeneric}

object PlayJsonGenericUtils {
  type Named[_]  = String
  type IdType[T] = T

  def writes[F[_[_]], En[_]](sp3: AppenderSupport1.Simple3.Release[F], namedIns: F[Named], encIns: () => F[En])(implicit
    formatHelper: FormatHelper[En, Writes]
  ): F[IdType] => JsObject = {
    val folderGeneric: Fold3Generic[F] = Fold3Generic[F].derived(sp3)

    val folderFunc = new Fold3Generic.Folder[Named, En, IdType, JsObject] {
      override def fold[T](n1: String, n2: En[T], n3: T, col: JsObject): JsObject = col.+(n1 -> formatHelper.to(n2).writes(n3))
      override def zero: JsObject                                                 = JsObject.empty
    }

    (model: F[IdType]) => folderGeneric.foldLeft(namedIns, encIns(), model, folderFunc)
  }

  def readsWithDefaultValue[F[_[_]], De[_]](
    sp2: AppenderSupport1.Simple2.Release[F],
    sp4: AppenderSupport1.Simple4.Release[F],
    named: F[Named],
    g: () => F[De],
    defaultValue: F[({ type OptF[TU] = Option[() => TU] })#OptF]
  )(implicit formatHelper: FormatHelper[De, Reads]): JsObject => JsResult[F[IdType]] = (hCursor: JsObject) => {
    type OptF[TU]    = Option[() => TU]
    type OptFGet[TU] = F[OptF] => OptF[TU]

    val getField: GetFieldGeneric[F]                                       = GetFieldGeneric[F].derived(sp2)
    val decoderHelper: DecodeHelper3[F]                                    = DecodeHelper3[F].derived(sp4)
    val helper: DecodeHelper3.Helper[Named, De, OptFGet, JsResult, IdType] =
      new DecodeHelper3.Helper[Named, De, OptFGet, JsResult, IdType] {
        override def func[X1](nameStr: String, decoderT: De[X1], in3: F[OptF] => Option[() => X1]): JsResult[X1] = {
          val jsPath: JsPath        = JsPath() \ nameStr
          val read1: Reads[X1]      = Reads.at[X1](jsPath)(formatHelper.to(decoderT))
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

    decoderHelper.map[Named, De, OptFGet, JsResult, IdType](named, g(), getField.getField[OptF], helper)
  }

  def reads[F[_[_]], De[_]](
    sp3: AppenderSupport1.Simple3.Release[F],
    named: F[Named],
    g: () => F[De]
  )(implicit formatHelper: FormatHelper[De, Reads]): JsObject => JsResult[F[IdType]] = (hCursor: JsObject) => {
    val decoderHelper: DecodeHelper2[F]                           = DecodeHelper2[F].derived(sp3)
    val helper: DecodeHelper2.Helper[Named, De, JsResult, IdType] =
      new DecodeHelper2.Helper[Named, De, JsResult, IdType] {
        override def func[X1](nameStr: String, decoderT: De[X1]): JsResult[X1] = {
          val jsPath: JsPath   = JsPath() \ nameStr
          val read1: Reads[X1] = Reads.at[X1](jsPath)(formatHelper.to(decoderT))
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
