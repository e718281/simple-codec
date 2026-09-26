package net.scalax.simple
package codec

import io.circe.generic.extras.JsonKey
import net.scalax.simple.adt.nat.support.v5.AppenderSupport1
import net.scalax.simple.codec.product.core.Map2Generic
import net.scalax.simple.codec.to_list_generic.BasedInstalledSimpleProduct

trait ConfigPojo[F[_[_]]] { Self =>

  type StrF[_]    = String
  type OptVal[U1] = Option[() => U1]

  def labelledValueFunc: F[StrF] => F[StrF]
  def defaultValue: Option[F[OptVal]]

  def mapLabelled(func: F[StrF] => F[StrF]): ConfigPojo[F] = new ConfigPojo[F] {
    InnerSelf =>
    override def labelledValueFunc: F[StrF] => F[StrF] =
      Self.labelledValueFunc.andThen(func)
    override def defaultValue: Option[F[OptVal]] = Self.defaultValue
  }

  def fillDefaultValue(func: F[OptVal]): ConfigPojo[F] = new ConfigPojo[F] { InnerSelf =>
    override def labelledValueFunc: F[StrF] => F[StrF] = Self.labelledValueFunc
    override def defaultValue: Option[F[OptVal]]       = Some(func)
  }

  def map(m: ConfigPojo[F] => ConfigPojo[F]): ConfigPojo[F] = m(Self)

}

object ConfigPojo {
  type StrF[_]  = String
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
  }

}
