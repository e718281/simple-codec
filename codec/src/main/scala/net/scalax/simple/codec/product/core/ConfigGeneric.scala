package net.scalax.simple
package codec

import net.scalax.simple.codec.product.core.DefaultValueGeneric
import net.scalax.simple.codec.product.core.PojoProjection

trait ConfigGeneric[F[_[_]], Poly] { Self =>

  type StrF[_]    = String
  type OptVal[U1] = Option[() => U1]

  def labelledValueFunc: F[StrF] => F[StrF]
  def defaultValue: Option[F[OptVal]]

  def mapLabelled(func: F[StrF] => F[StrF]): ConfigGeneric[F, Poly] = new ConfigGeneric[F, Poly] {
    InnerSelf =>
    override def labelledValueFunc: F[StrF] => F[StrF] =
      Self.labelledValueFunc.andThen(func)
    override def defaultValue: Option[F[OptVal]] = Self.defaultValue
  }

  def useDefaultValue(implicit func: DefaultValueGeneric[F]): ConfigGeneric[F, Poly] = new ConfigGeneric[F, Poly] { InnerSelf =>
    override def labelledValueFunc: F[StrF] => F[StrF] = Self.labelledValueFunc
    override def defaultValue: Option[F[OptVal]]       = Some(func.defaultValueFunction1)
  }

}

object ConfigGeneric {
  /*type StrF[_]  = String
  type Type2[T] = Option[JsonKey]

  def fromAnnotationImpl[F[_[_]]](ann: ModelAnnotations[F, JsonKey], sp3: AppenderSupport1.Simple3.Release[F]): F[StrF] => F[StrF] = {
    val map2Generc = Map2Generic[F].derived(sp3)
    val mapper2    = new Map2Generic.MapFunction[StrF, Type2, StrF] {
      override def func[X1](in: String, in2: Option[JsonKey]): String = in2.fold(in)(ann => ann.value)
    }

    val func: (F[StrF], F[Type2]) => F[StrF] = map2Generc.map[StrF, Type2, StrF](mapper2)

    (labelled: F[StrF]) => func(labelled, ann.annInstance)
  }

  def fromAnnotation[F[_[_]]](implicit
    ann: ModelAnnotations[F, JsonKey],
    bs: BasedInstalledSimpleProduct[F]
  ): ConfigPojo[F] => ConfigPojo[F] = {
    val mapLabelled = fromAnnotationImpl[F](ann, bs.simpleRunner.simpleRelease3)
    (conf: ConfigPojo[F]) => conf.mapLabelled(mapLabelled)
  }*/

  class Builder[F[_[_]], Poly] {
    def derived: ConfigGeneric[F, Poly] = new ConfigGeneric[F, Poly] {
      override def labelledValueFunc: F[StrF] => F[StrF] = identity
      override def defaultValue: Option[F[OptVal]]       = Option.empty
    }
  }

  type F[U1[_[_]], Poly] = ConfigGeneric[U1, Poly]
  type Pojo[Model, Poly] = ConfigGeneric[({ type U1[U2[_]] = PojoProjection[U2, Model] })#U1, Poly]

  def F[U1[_[_]], Poly]: Builder[U1, Poly]                                                  = new Builder[U1, Poly]
  def Pojo[Model, Poly]: Builder[({ type U1[U2[_]] = PojoProjection[U2, Model] })#U1, Poly] =
    new Builder[({ type U1[U2[_]] = PojoProjection[U2, Model] })#U1, Poly]

}
