package net.scalax.simple
package codec

import net.scalax.simple.adt.nat.support.SimpleProductContextX
import net.scalax.simple.adt.nat.support.v5.AppenderSupport4
import net.scalax.simple.codec.to_list_generic.{BasedInstalledLabelled, BasedInstalledSimpleProduct, PojoInstance}
import net.scalax.simple.codec.utils.ByNameImplicit
import play.api.libs.json._

object PlayJsonGeneric {

  object F {
    implicit def encodeModelF[F[_[_]]](implicit
      g: ByNameImplicit[F[Writes]],
      g1: BasedInstalledSimpleProduct[F],
      lb: BasedInstalledLabelled[F],
      sjn: SimpleJsonLabelled[F]
    ): Writes[F[({ type IDF[T] = T })#IDF]] = {
      val bsInsatnall: SimpleProductContextX[F] = g1.basedInstalled
      val simpleRunner: AppenderSupport4[F]     = g1.simpleRunner

      val labelledIns: F[({ type Str1[_] = String })#Str1] = sjn.labelledValueFunc(lb.labelled.stringLabelled)

      Writes(PlayJsonGeneric2.encodeImpl[F](sp3 = simpleRunner.simpleRunner3, labelledIns, () => g.value))
    }

    implicit def getCirceDecoderF[F[_[_]]](implicit
      g: ByNameImplicit[F[Reads]],
      g1: BasedInstalledSimpleProduct[F],
      lb: BasedInstalledLabelled[F],
      sg: SimpleJsonLabelled[F]
    ): Reads[F[({ type IDF[T] = T })#IDF]] = {
      val bsInsatnall: SimpleProductContextX[F] = g1.basedInstalled
      val simpleRunner: AppenderSupport4[F]     = g1.simpleRunner

      val labelledIns: F[({ type Str1[_] = String })#Str1] = sg.labelledValueFunc(lb.labelled.stringLabelled)

      val func =
        PlayJsonGeneric2.decodeImpl[F](simpleRunner.simpleRelease2, simpleRunner.simpleRunner4, labelledIns, () => g.value, sg.defaultValue)

      implicitly[Reads[JsObject]].flatMapResult(func)
    }

  }

  object Pojo {
    implicit def playJsonEncodeModelPojo[Model](implicit
      g1: ModelGet[({ type F[X[_]] = PojoInstance[X, Model] })#F, Model],
      basedInstalled: BasedInstalledSimpleProduct[({ type F[X[_]] = PojoInstance[X, Model] })#F],
      lb: BasedInstalledLabelled[({ type F[X[_]] = PojoInstance[X, Model] })#F],
      g: ByNameImplicit[PojoInstance[Writes, Model]],
      sjn: SimpleJsonLabelled[({ type F[X[_]] = PojoInstance[X, Model] })#F]
    ): Writes[Model] = {
      val w1: Writes[PojoInstance[({ type IDF[T] = T })#IDF, Model]] = F.encodeModelF[({ type F[X[_]] = PojoInstance[X, Model] })#F]
      w1.contramap[Model](g1.toIdentity)
    }

    implicit def playJsonDecodeModelPojo[Model](implicit
      g1: ModelSet[({ type F[X[_]] = PojoInstance[X, Model] })#F, Model],
      basedInstalled: BasedInstalledSimpleProduct[({ type F[X[_]] = PojoInstance[X, Model] })#F],
      lb: BasedInstalledLabelled[({ type F[X[_]] = PojoInstance[X, Model] })#F],
      g3: ByNameImplicit[PojoInstance[Reads, Model]],
      sg: SimpleJsonLabelled[({ type F[X[_]] = PojoInstance[X, Model] })#F]
    ): Reads[Model] = {
      val de1: Reads[PojoInstance[({ type IDF[T] = T })#IDF, Model]] = F.getCirceDecoderF[({ type F[X[_]] = PojoInstance[X, Model] })#F]
      for (model <- de1) yield g1.fromIdentity(model)
    }
  }

}
