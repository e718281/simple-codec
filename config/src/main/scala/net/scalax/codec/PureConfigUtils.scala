package net.scalax.simple.codec.pureconfig

import com.typesafe.config.ConfigValue
import net.scalax.simple.adt.nat.support.v5.AppenderSupport4
import net.scalax.simple.codec.product.core.Map1Generic
import net.scalax.simple.codec.{ConfigGeneric, ModelGet, ModelSet}
import net.scalax.simple.codec.to_list_generic.{BasedInstalledLabelled, BasedInstalledSimpleProduct, PojoInstance}
import net.scalax.simple.codec.utils.ByNameImplicit
import pureconfig.ConfigReader.Result
import pureconfig._

trait PureConfigPoly
object PureConfigUtils {
  type Str1[_]   = String
  type IdType[T] = T

  def getCirceDecoderF[F[_[_]]](implicit
    modelLabelled: BasedInstalledLabelled[F],
    basedInstalled: BasedInstalledSimpleProduct[F],
    g3: ByNameImplicit[F[ConfigReader]],
    sg: ConfigGeneric.F[F, PureConfigPoly] = ConfigGeneric.F[F, PureConfigPoly].derived
  ): ConfigReader[F[IdType]] = {
    val simpleRunner: AppenderSupport4[F] = basedInstalled.simpleRunner

    val labelledIns: F[Str1]                         = sg.labelledValueFunc(modelLabelled.labelled.stringLabelled)
    val de1: ConfigObjectCursor => Result[F[IdType]] =
      DecodeHelperUtils.decodeImpl[F](
        simpleRunner.simpleRelease2,
        simpleRunner.simpleRelease3,
        simpleRunner.simpleRelease4,
        labelledIns,
        () => g3.value,
        sg.defaultValue
      )

    ConfigReader.fromCursor[F[IdType]](configs =>
      for {
        v1 <- configs.asObjectCursor
        v2 <- de1(v1)
      } yield v2
    )
  }

  def getPureConfigWriterF[F[_[_]]](implicit
    modelLabelled: BasedInstalledLabelled[F],
    basedInstalled: BasedInstalledSimpleProduct[F],
    g3: ByNameImplicit[F[ConfigWriter]],
    sg: ConfigGeneric.F[F, PureConfigPoly] = ConfigGeneric.F[F, PureConfigPoly].derived
  ): ConfigWriter[F[IdType]] = {
    val simpleRunner: AppenderSupport4[F] = basedInstalled.simpleRunner
    val labelledIns: F[Str1]              = sg.labelledValueFunc(modelLabelled.labelled.stringLabelled)
    val func: F[IdType] => ConfigValue    = EncodeHelperUtils.encodeImpl[F](simpleRunner.simpleRelease3, labelledIns, () => g3.value)

    ConfigWriter.fromFunction[F[IdType]](func)
  }

  implicit def getCirceDecoderPojo[Model](implicit
    g1: ModelSet[({ type F[X[_]] = PojoInstance[X, Model] })#F, Model],
    modelLabelled: BasedInstalledLabelled[({ type F[X[_]] = PojoInstance[X, Model] })#F],
    basedInstalled: BasedInstalledSimpleProduct[({ type F[X[_]] = PojoInstance[X, Model] })#F],
    g3: ByNameImplicit[PojoInstance[ConfigReader, Model]],
    sg: ConfigGeneric.Pojo[Model, PureConfigPoly] = ConfigGeneric.Pojo[Model, PureConfigPoly].derived
  ): ConfigReader[Model] = {
    val reader = getCirceDecoderF[({ type F[X[_]] = PojoInstance[X, Model] })#F]
    for (r1 <- reader) yield g1.fromIdentity(r1)
  }

  implicit def getPureConfigWriterPojo[Model](implicit
    g1: ModelGet[({ type F[X[_]] = PojoInstance[X, Model] })#F, Model],
    modelLabelled: BasedInstalledLabelled[({ type F[X[_]] = PojoInstance[X, Model] })#F],
    basedInstalled: BasedInstalledSimpleProduct[({ type F[X[_]] = PojoInstance[X, Model] })#F],
    g3: ByNameImplicit[PojoInstance[ConfigWriter, Model]],
    sg: ConfigGeneric.Pojo[Model, PureConfigPoly] = ConfigGeneric.Pojo[Model, PureConfigPoly].derived
  ): ConfigWriter[Model] = {
    val writer = getPureConfigWriterF[({ type F[X[_]] = PojoInstance[X, Model] })#F]
    writer.contramap[Model](g1.toIdentity)
  }

  def configFieldMappingApply[F[_[_]]](c: ConfigFieldMapping)(implicit bs: BasedInstalledSimpleProduct[F]): F[Str1] => F[Str1] = {
    val map1Generic: Map1Generic[F] = Map1Generic[F].derived(bs.simpleRunner.simpleRelease2)
    val mapping                     = new Map1Generic.MapFunction[Str1, Str1] {
      override def func[X1](in: String): String = c(in)
    }
    map1Generic.map[Str1, Str1](mapping)
  }

  def configFieldMappingApplyPojo[Model](c: ConfigFieldMapping)(implicit
    bs: BasedInstalledSimpleProduct[({ type U1[U2[_]] = PojoInstance[U2, Model] })#U1]
  ): PojoInstance[Str1, Model] => PojoInstance[Str1, Model] = configFieldMappingApply[({ type U1[U2[_]] = PojoInstance[U2, Model] })#U1](c)

}
