package net.scalax.simple.codec

import io.circe._
import io.circe.generic.extras.JsonKey
import net.scalax.simple.adt.nat.support.v5.AppenderSupport4
import net.scalax.simple.codec.circe.EncodeHelperUtils
import net.scalax.simple.codec.product.core.Map2Generic
import net.scalax.simple.codec.to_list_generic.{BasedInstalledLabelled, BasedInstalledSimpleProduct, PojoInstance, SingletonMap}
import net.scalax.simple.codec.utils.ByNameImplicit

trait CircePoly
object Circe {
  type Named[T] = String
  type Id[T]    = T

  implicit def simpleCirceEncoderFImplicit[F[_[_]]](implicit
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

  implicit def simpleCirceDecoderFImplicit[F[_[_]]](implicit
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

  implicit def simpleCirceEncoderPojoImplicit[Model](implicit
    g1: ModelGet[({ type F[X[_]] = PojoInstance[X, Model] })#F, Model],
    basedInstalled: BasedInstalledSimpleProduct[({ type F[X[_]] = PojoInstance[X, Model] })#F],
    lb: BasedInstalledLabelled[({ type F[X[_]] = PojoInstance[X, Model] })#F],
    g3: ByNameImplicit[PojoInstance[Encoder, Model]],
    sg: ConfigGeneric.Pojo[Model, CircePoly] = ConfigGeneric.Pojo[Model, CircePoly].derived
  ): Encoder[Model] = {
    val en1: Encoder[PojoInstance[({ type IDF[T] = T })#IDF, Model]] =
      simpleCirceEncoderFImplicit[({ type F[X[_]] = PojoInstance[X, Model] })#F]
    en1.contramap[Model](g1.toIdentity)
  }

  implicit def simpleCirceDecoderPojoImplicit[Model](implicit
    g1: ModelSet[({ type F[X[_]] = PojoInstance[X, Model] })#F, Model],
    basedInstalled: BasedInstalledSimpleProduct[({ type F[X[_]] = PojoInstance[X, Model] })#F],
    lb: BasedInstalledLabelled[({ type F[X[_]] = PojoInstance[X, Model] })#F],
    g3: ByNameImplicit[PojoInstance[Decoder, Model]],
    sg: ConfigGeneric.Pojo[Model, CircePoly] = ConfigGeneric.Pojo[Model, CircePoly].derived
  ): Decoder[Model] = {
    val de1: Decoder[PojoInstance[({ type IDF[T] = T })#IDF, Model]] =
      simpleCirceDecoderFImplicit[({ type F[X[_]] = PojoInstance[X, Model] })#F]
    for (model <- de1) yield g1.fromIdentity(model)
  }

  implicit def objectEncoder[Model](implicit mapper: SingletonMap[Model]): Encoder[Model] =
    Encoder.encodeJsonObject.contramapObject(_ => JsonObject.empty)

  object CirceHepler {
    def jsonKeyF[F[_[_]]](implicit
      bs: BasedInstalledSimpleProduct[F],
      ann: ModelAnnotations.F[F, JsonKey]
    ): F[Named] => F[Named] = {
      type JsonKeyPro[_] = Option[JsonKey]
      val map2Generc = Map2Generic[F].derived(bs.simpleRunner.simpleRelease3)
      val mapper2    = new Map2Generic.MapFunction[Named, JsonKeyPro, Named] {
        override def func[X1](in: String, in2: Option[JsonKey]): String = in2.fold(in)(ann => ann.value)
      }

      val func: (F[Named], F[JsonKeyPro]) => F[Named] =
        map2Generc.map[Named, JsonKeyPro, Named](mapper2)

      (labelled: F[Named]) => func(labelled, ann.annInstance)
    }

    def jsonKeyPojo[Model](implicit
      bs: BasedInstalledSimpleProduct[({ type F[X[_]] = PojoInstance[X, Model] })#F],
      ann: ModelAnnotations.Pojo[Model, JsonKey]
    ): PojoInstance[Named, Model] => PojoInstance[Named, Model] = jsonKeyF[({ type F[X[_]] = PojoInstance[X, Model] })#F]

  }

}
