package net.scalax.simple.codec

import io.circe._
import net.scalax.simple.adt.nat.support.v5.AppenderSupport4
import net.scalax.simple.codec.circe.EncodeHelperUtils
import net.scalax.simple.codec.to_list_generic.{BasedInstalledLabelled, BasedInstalledSimpleProduct, PojoInstance, SingletonMap}
import net.scalax.simple.codec.utils.ByNameImplicit

object CirceGen {

  object F {

    implicit def getCirceEncoderF[F[_[_]]](implicit
      g: ByNameImplicit[F[Encoder]],
      g1: BasedInstalledSimpleProduct[F],
      lb: BasedInstalledLabelled[F],
      sg: SimpleJsonLabelled[F]
    ): Encoder[F[({ type IDF[T] = T })#IDF]] = {
      val labelledIns: F[({ type Str1[_] = String })#Str1] = sg.labelledValueFunc(lb.labelled.stringLabelled)

      Encoder.instance[F[({ type IDF[T] = T })#IDF]](
        EncodeHelperUtils.encodeImpl[F](g1.simpleRunner.simpleRelease3, labelledIns, () => g.value).andThen(Json.fromJsonObject)
      )
    }

    implicit def getCirceDecoderF[F[_[_]]](implicit
      g: ByNameImplicit[F[Decoder]],
      g1: BasedInstalledSimpleProduct[F],
      lb: BasedInstalledLabelled[F],
      sg: SimpleJsonLabelled[F]
    ): Decoder[F[({ type IDF[T] = T })#IDF]] = {
      val simpleRunner: AppenderSupport4[F] = g1.simpleRunner

      val labelledIns: F[({ type Str1[_] = String })#Str1] = sg.labelledValueFunc(lb.labelled.stringLabelled)

      Decoder.instance[F[({ type IDF[T] = T })#IDF]](
        EncodeHelperUtils.decodeImpl[F](
          simpleRunner.simpleRelease2,
          simpleRunner.simpleRelease4,
          labelledIns,
          () => g.value,
          sg.defaultValue
        )
      )
    }

  }

  object Pojo {

    implicit def getCirceEncoderPojo[Model](implicit
      g1: ModelGet[({ type F[X[_]] = PojoInstance[X, Model] })#F, Model],
      basedInstalled: BasedInstalledSimpleProduct[({ type F[X[_]] = PojoInstance[X, Model] })#F],
      lb: BasedInstalledLabelled[({ type F[X[_]] = PojoInstance[X, Model] })#F],
      g3: ByNameImplicit[PojoInstance[Encoder, Model]],
      sg: SimpleJsonLabelled[({ type F[X[_]] = PojoInstance[X, Model] })#F]
    ): Encoder[Model] = {
      val en1: Encoder[PojoInstance[({ type IDF[T] = T })#IDF, Model]] = F.getCirceEncoderF[({ type F[X[_]] = PojoInstance[X, Model] })#F]
      en1.contramap[Model](g1.toIdentity)
    }

    implicit def getCirceDecoderPojo[Model](implicit
      g1: ModelSet[({ type F[X[_]] = PojoInstance[X, Model] })#F, Model],
      basedInstalled: BasedInstalledSimpleProduct[({ type F[X[_]] = PojoInstance[X, Model] })#F],
      lb: BasedInstalledLabelled[({ type F[X[_]] = PojoInstance[X, Model] })#F],
      g3: ByNameImplicit[PojoInstance[Decoder, Model]],
      sg: SimpleJsonLabelled[({ type F[X[_]] = PojoInstance[X, Model] })#F]
    ): Decoder[Model] = {
      val de1: Decoder[PojoInstance[({ type IDF[T] = T })#IDF, Model]] = F.getCirceDecoderF[({ type F[X[_]] = PojoInstance[X, Model] })#F]
      for (model <- de1) yield g1.fromIdentity(model)
    }

    implicit def objectEncoder[Model](implicit mapper: SingletonMap[Model]): Encoder[Model] =
      Encoder.encodeJsonObject.contramapObject(_ => JsonObject.empty)

  }

}
