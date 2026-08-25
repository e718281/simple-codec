package net.scalax.simple
package codec

import net.scalax.simple.adt.nat.support.v5.AppenderSupport1
import net.scalax.simple.adt.nat.support.ABCFunc
import net.scalax.simple.codec.to_list_generic.{BasedInstalledLabelled, BasedInstalledSimpleProduct, PojoInstance}
import net.scalax.simple.codec.utils.ByNameImplicit

trait Builder[En[_]] { Builder1Self =>
  type TC1[T]                                  = String
  type TC2[T]                                  = FieldsContent[En, T]
  type TC3[T]                                  = FieldsInfo
  type ToCol[StrName, Col, TCOpt, NameBoolean] = (StrName, Col) => (TCOpt, NameBoolean, List[FieldsInfo])

  case class EncoderGetter[T](value: Option[() => En[T]])

  object EncoderGetter extends EncoderGetterPoly {
    implicit def implicitImpl1[T](implicit nn: ByNameImplicit[En[T]]): EncoderGetter[T] = EncoderGetter(Some(() => nn.value))
  }

  trait EncoderGetterPoly {
    implicit def implicitImpl2[T]: EncoderGetter[T] = EncoderGetter(None)
  }

  def Pojo[Model]: Builder1Self.Builder[({ type X1[U1[_]] = PojoInstance[U1, Model] })#X1] =
    new Builder1Self.Builder[({ type X1[U1[_]] = PojoInstance[U1, Model] })#X1] {
      //
    }

  def F[UX[_[_]]]: Builder1Self.Builder[UX] = new Builder1Self.Builder[UX] {
    //
  }
  type Pojo[Model] = TypeClassContent[({ type X1[U1[_]] = PojoInstance[U1, Model] })#X1, En]
  type F[UX[_[_]]] = TypeClassContent[UX, En]

  trait Builder[F[_[_]]] { Builder2Self =>
    def derived(implicit
      ins: F[EncoderGetter],
      labelled: BasedInstalledLabelled[F],
      simpleProduct: BasedInstalledSimpleProduct[F]
    ): TypeClassContent[F, En] = {
      val sp4 = simpleProduct.simpleRunner.simpleRunner4

      val appender: AppenderSupport1.Simple4.Appender[ToCol, TC1, EncoderGetter, TC2, TC3] =
        new AppenderSupport1.Simple4.Appender[ToCol, TC1, EncoderGetter, TC2, TC3] {
          override def append[T, B1, B2, B3, B4, C1, C2, C3, C4](
            abc1: ABCFunc[String, B1, C1],
            abc2: ABCFunc[EncoderGetter[T], B2, C2],
            abc3: ABCFunc[FieldsContent[En, T], B3, C3],
            abc4: ABCFunc[FieldsInfo, B4, C4],
            ma: (B1, B2) => (B3, B4, List[FieldsInfo])
          ): (C1, C2) => (C3, C4, List[FieldsInfo]) = (c1: C1, c2: C2) => {
            val nameStr: String                    = abc1.takeHead(c1)
            val b1: B1                             = abc1.takeTail(c1)
            val enGet: EncoderGetter[T]            = abc2.takeHead(c2)
            val b2: B2                             = abc2.takeTail(c2)
            val maFunc: (B3, B4, List[FieldsInfo]) = ma(b1, b2)

            val typeClassOpt: Option[() => En[T]] = enGet.value
            val enValueOpt: FieldsContent[En, T]  = FieldsContent[En, T](nameStr, typeClassOpt)
            val c3: C3                            = abc3.append(enValueOpt, maFunc._1)

            val nameTuple2: FieldsInfo   = FieldsInfo(nameStr, typeClassOpt.isDefined)
            val c4: C4                   = abc4.append(nameTuple2, maFunc._2)
            val listEn: List[FieldsInfo] = nameTuple2 :: maFunc._3

            (c3, c4, listEn)
          }
        }

      val zero: AppenderSupport1.Simple4.Zero[ToCol] = new AppenderSupport1.Simple4.Zero[ToCol] {
        override def zero[B1, B2, B3, B4](b1: B1, b2: B2, b3: B3, b4: B4): ToCol[B1, B2, B3, B4] = (b1: B1, b2: B2) =>
          (b3, b4, List.empty[FieldsInfo])
      }

      val func: (F[TC1], F[EncoderGetter]) => (F[TC2], F[TC3], List[FieldsInfo]) =
        sp4.append[ToCol, TC1, EncoderGetter, TC2, TC3](appender = appender, zero = zero)

      val result: (F[TC2], F[TC3], List[FieldsInfo]) = func(labelled.labelled.stringLabelled, ins)

      new TypeClassContent[F, En] {
        override def content: F[({ type StrT[U1] = FieldsContent[En, U1] })#StrT] = result._1
        override def simpleContent: F[({ type StrT[U1] = FieldsInfo })#StrT]      = result._2
        override def infoCollection: List[FieldsInfo]                             = result._3
      }
    }
  }

}

case class FieldsContent[U[_], T](fieldName: String, typeClassContent: Option[() => U[T]])
case class FieldsInfo(fieldName: String, isDefined: Boolean)
object FieldsInfo {
  implicit def codecJson: io.circe.Codec[FieldsInfo] = io.circe.generic.semiauto.deriveCodec
}

trait TypeClassContent[F[_[_]], TyClas[_]] {
  def content: F[({ type StrT[U1] = FieldsContent[TyClas, U1] })#StrT]
  def simpleContent: F[({ type StrT[U1] = FieldsInfo })#StrT]
  def infoCollection: List[FieldsInfo]
}

object TypeClassContent {
  def apply[Encoder[_]]: Builder[Encoder] = new Builder[Encoder] {
    //
  }

}
