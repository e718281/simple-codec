package net.scalax.simple.codec

import io.circe._
import io.circe.generic.extras.JsonKey
import net.scalax.simple.adt.nat.support.v5.AppenderSupport4
import net.scalax.simple.codec.circe.EncodeHelperUtils
import net.scalax.simple.codec.product.core.Map2Generic
import net.scalax.simple.codec.to_list_generic.{BasedInstalledLabelled, BasedInstalledSimpleProduct, PojoInstance, SingletonMap}
import net.scalax.simple.codec.utils.ByNameImplicit

trait CircePoly
object CirceGen {
  type Named[T] = String
  type Id[T]    = T

  object F {

    implicit def getCirceEncoderF[F[_[_]]](implicit
      g: ByNameImplicit[F[Encoder]],
      g1: BasedInstalledSimpleProduct[F],
      lb: BasedInstalledLabelled[F],
      sg: ConfigGeneric[F, CircePoly] = ConfigGeneric.F[F, CircePoly].derived
    ): Encoder[F[Id]] = {
      val labelledIns: F[Named] = sg.labelledValueFunc(lb.labelled.stringLabelled)

      Encoder.instance[F[Id]](
        EncodeHelperUtils.encodeImpl[F](g1.simpleRunner.simpleRelease3, labelledIns, () => g.value).andThen(Json.fromJsonObject)
      )
    }

    implicit def getCirceDecoderF[F[_[_]]](implicit
      g: ByNameImplicit[F[Decoder]],
      g1: BasedInstalledSimpleProduct[F],
      lb: BasedInstalledLabelled[F],
      sg: ConfigGeneric[F, CircePoly] = ConfigGeneric.F[F, CircePoly].derived
    ): Decoder[F[Id]] = {
      val simpleRunner: AppenderSupport4[F] = g1.simpleRunner

      val labelledIns: F[Named] = sg.labelledValueFunc(lb.labelled.stringLabelled)

      Decoder.instance[F[Id]](
        EncodeHelperUtils.decodeImpl[F](
          simpleRunner.simpleRelease2,
          simpleRunner.simpleRelease3,
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
      sg: ConfigGeneric.Pojo[Model, CircePoly] = ConfigGeneric.Pojo[Model, CircePoly].derived
    ): Encoder[Model] = {
      val en1: Encoder[PojoInstance[({ type IDF[T] = T })#IDF, Model]] = F.getCirceEncoderF[({ type F[X[_]] = PojoInstance[X, Model] })#F]
      en1.contramap[Model](g1.toIdentity)
    }

    implicit def getCirceDecoderPojo[Model](implicit
      g1: ModelSet[({ type F[X[_]] = PojoInstance[X, Model] })#F, Model],
      basedInstalled: BasedInstalledSimpleProduct[({ type F[X[_]] = PojoInstance[X, Model] })#F],
      lb: BasedInstalledLabelled[({ type F[X[_]] = PojoInstance[X, Model] })#F],
      g3: ByNameImplicit[PojoInstance[Decoder, Model]],
      sg: ConfigGeneric.Pojo[Model, CircePoly] = ConfigGeneric.Pojo[Model, CircePoly].derived
    ): Decoder[Model] = {
      val de1: Decoder[PojoInstance[({ type IDF[T] = T })#IDF, Model]] = F.getCirceDecoderF[({ type F[X[_]] = PojoInstance[X, Model] })#F]
      for (model <- de1) yield g1.fromIdentity(model)
    }

    implicit def objectEncoder[Model](implicit mapper: SingletonMap[Model]): Encoder[Model] =
      Encoder.encodeJsonObject.contramapObject(_ => JsonObject.empty)

    def annotationsLabelled[Model](implicit
      bs: BasedInstalledSimpleProduct[({ type F[X[_]] = PojoInstance[X, Model] })#F],
      ann: ModelAnnotationsPojo[Model, JsonKey]
    ): PojoInstance[Named, Model] => PojoInstance[Named, Model] = {
      type PojoPro[U[_]] = PojoInstance[U, Model]
      type JsonKeyPro[_] = Option[JsonKey]
      val map2Generc = Map2Generic[PojoPro].derived(bs.simpleRunner.simpleRelease3)
      val mapper2    = new Map2Generic.MapFunction[Named, JsonKeyPro, Named] {
        override def func[X1](in: String, in2: Option[JsonKey]): String = in2.fold(in)(ann => ann.value)
      }

      val func: (PojoInstance[Named, Model], PojoInstance[JsonKeyPro, Model]) => PojoInstance[Named, Model] =
        map2Generc.map[Named, JsonKeyPro, Named](mapper2)

      (labelled: PojoInstance[Named, Model]) => func(labelled, ann.annInstance)
    }

  }

}
