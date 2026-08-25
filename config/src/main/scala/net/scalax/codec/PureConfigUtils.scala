package net.scalax.simple.codec.pureconfig

import com.typesafe.config.ConfigValue
import net.scalax.simple.adt.nat.support.SimpleProductContextX
import net.scalax.simple.adt.nat.support.v5.AppenderSupport4
import net.scalax.simple.codec.{ModelGet, ModelSet}
import net.scalax.simple.codec.to_list_generic.{BasedInstalledLabelled, BasedInstalledSimpleProduct, PojoInstance}
import net.scalax.simple.codec.utils.ByNameImplicit
import pureconfig.ConfigReader.Result
import pureconfig._

object PureConfigUtils {
  type Str1[_]   = String
  type IdType[T] = T

  def getCirceDecoderF[F[_[_]]](implicit
    modelLabelled: BasedInstalledLabelled[F],
    basedInstalled: BasedInstalledSimpleProduct[F],
    g3: ByNameImplicit[F[ConfigReader]],
    sg: PureConfigLabelled[F]
  ): ConfigReader[F[IdType]] = {
    val simpleRunner: AppenderSupport4[F] = basedInstalled.simpleRunner

    val labelledIns: F[Str1]                         = sg.labelledValueFunc(modelLabelled.labelled.stringLabelled)
    val de1: ConfigObjectCursor => Result[F[IdType]] =
      DecodeHelperUtils
        .decodeImpl[F](simpleRunner.simpleRelease2, simpleRunner.simpleRelease4, labelledIns, () => g3.value, sg.defaultValue)

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
    sg: PureConfigLabelled[F]
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
    sg: PureConfigLabelled[({ type F[X[_]] = PojoInstance[X, Model] })#F]
  ): ConfigReader[Model] = {
    val reader = getCirceDecoderF[({ type F[X[_]] = PojoInstance[X, Model] })#F]
    for (r1 <- reader) yield g1.fromIdentity(r1)
  }

  implicit def getPureConfigWriterPojo[Model](implicit
    g1: ModelGet[({ type F[X[_]] = PojoInstance[X, Model] })#F, Model],
    modelLabelled: BasedInstalledLabelled[({ type F[X[_]] = PojoInstance[X, Model] })#F],
    basedInstalled: BasedInstalledSimpleProduct[({ type F[X[_]] = PojoInstance[X, Model] })#F],
    g3: ByNameImplicit[PojoInstance[ConfigWriter, Model]],
    sg: PureConfigLabelled[({ type F[X[_]] = PojoInstance[X, Model] })#F]
  ): ConfigWriter[Model] = {
    val writer = getPureConfigWriterF[({ type F[X[_]] = PojoInstance[X, Model] })#F]
    writer.contramap[Model](g1.toIdentity)
  }

}
