package net.scalax.simple
package codec

import net.scalax.simple.codec.to_list_generic.{BasedInstalledLabelled, BasedInstalledSimpleProduct}
import net.scalax.simple.codec.utils.ByNameImplicit
import play.api.libs.json._
import net.scalax.simple.codec.product.core.PojoProjection

trait PlayJsonPoly
object PlayJsonGeneric {

  implicit def simplePlayJsonOWritesFImplicit[F[_[_]]](implicit
    g: ByNameImplicit[F[Writes]],
    g1: BasedInstalledSimpleProduct[F],
    lb: BasedInstalledLabelled[F],
    sjn: ConfigGeneric[F, PlayJsonPoly] = ConfigGeneric.F[F, PlayJsonPoly].derived
  ): OWrites[F[({ type IDF[T] = T })#IDF]] = {
    val labelledIns: F[({ type Str1[_] = String })#Str1] = sjn.labelledValueFunc(lb.labelled.stringLabelled)

    OWrites(PlayJsonGenericUtils.writes[F, Writes](g1.simpleRunner.simpleRelease3, labelledIns, () => g.value))
  }

  implicit def simplePlayJsonReadsFImplicit[F[_[_]]](implicit
    g: ByNameImplicit[F[Reads]],
    g1: BasedInstalledSimpleProduct[F],
    lb: BasedInstalledLabelled[F],
    sg: ConfigGeneric[F, PlayJsonPoly] = ConfigGeneric.F[F, PlayJsonPoly].derived
  ): Reads[F[({ type IDF[T] = T })#IDF]] = {
    val labelledIns: F[({ type Str1[_] = String })#Str1] = sg.labelledValueFunc(lb.labelled.stringLabelled)
    val defaultValueOpt                                  = sg.defaultValue

    val func: JsObject => JsResult[F[({ type IDF[T] = T })#IDF]] = defaultValueOpt.fold(
      PlayJsonGenericUtils.reads[F, Reads](
        g1.simpleRunner.simpleRelease3,
        labelledIns,
        () => g.value
      )
    )(defValue =>
      PlayJsonGenericUtils.readsWithDefaultValue[F, Reads](
        g1.simpleRunner.simpleRelease2,
        g1.simpleRunner.simpleRelease4,
        labelledIns,
        () => g.value,
        defValue
      )
    )

    implicitly[Reads[JsObject]].flatMapResult(func)
  }

  implicit def simplePlayJsonOFormatFImplicit[F[_[_]]](implicit
    g: ByNameImplicit[F[Format]],
    g1: BasedInstalledSimpleProduct[F],
    lb: BasedInstalledLabelled[F],
    sg: ConfigGeneric[F, PlayJsonPoly] = ConfigGeneric.F[F, PlayJsonPoly].derived
  ): OFormat[F[({ type IDF[T] = T })#IDF]] = {
    val labelledIns: F[({ type Str1[_] = String })#Str1] = sg.labelledValueFunc(lb.labelled.stringLabelled)
    val defaultValueOpt                                  = sg.defaultValue

    val func: JsObject => JsResult[F[({ type IDF[T] = T })#IDF]] = defaultValueOpt.fold(
      PlayJsonGenericUtils.reads[F, Format](
        g1.simpleRunner.simpleRelease3,
        labelledIns,
        () => g.value
      )
    )(defValue =>
      PlayJsonGenericUtils.readsWithDefaultValue[F, Format](
        g1.simpleRunner.simpleRelease2,
        g1.simpleRunner.simpleRelease4,
        labelledIns,
        () => g.value,
        defValue
      )
    )

    val reads: Reads[F[({ type IDF[T] = T })#IDF]] = implicitly[Reads[JsObject]].flatMapResult(func)

    val writes: OWrites[F[({ type IDF[T] = T })#IDF]] = OWrites(
      PlayJsonGenericUtils.writes[F, Format](g1.simpleRunner.simpleRelease3, labelledIns, () => g.value)
    )

    OFormat(reads, writes)
  }

  implicit def simplePlayJsonOWritesPojoImplicit[Model](implicit
    g1: ModelGet[({ type F[X[_]] = PojoProjection[X, Model] })#F, Model],
    basedInstalled: BasedInstalledSimpleProduct[({ type F[X[_]] = PojoProjection[X, Model] })#F],
    lb: BasedInstalledLabelled[({ type F[X[_]] = PojoProjection[X, Model] })#F],
    g: ByNameImplicit[PojoProjection[Writes, Model]],
    sjn: ConfigGeneric.Pojo[Model, PlayJsonPoly] = ConfigGeneric.Pojo[Model, PlayJsonPoly].derived
  ): OWrites[Model] = {
    val w1: OWrites[PojoProjection[({ type IDF[T] = T })#IDF, Model]] =
      simplePlayJsonOWritesFImplicit[({ type F[X[_]] = PojoProjection[X, Model] })#F]
    w1.contramap[Model](g1.toIdentity)
  }

  implicit def simplePlayJsonReadsPojoImplicit[Model](implicit
    g1: ModelSet[({ type F[X[_]] = PojoProjection[X, Model] })#F, Model],
    basedInstalled: BasedInstalledSimpleProduct[({ type F[X[_]] = PojoProjection[X, Model] })#F],
    lb: BasedInstalledLabelled[({ type F[X[_]] = PojoProjection[X, Model] })#F],
    g3: ByNameImplicit[PojoProjection[Reads, Model]],
    sg: ConfigGeneric.Pojo[Model, PlayJsonPoly] = ConfigGeneric.Pojo[Model, PlayJsonPoly].derived
  ): Reads[Model] = {
    val de1: Reads[PojoProjection[({ type IDF[T] = T })#IDF, Model]] =
      simplePlayJsonReadsFImplicit[({ type F[X[_]] = PojoProjection[X, Model] })#F]
    for (model <- de1) yield g1.fromIdentity(model)
  }

  implicit def simplePlayJsonOFormatPojoImplicit[Model](implicit
    g1: ModelGet[({ type F[X[_]] = PojoProjection[X, Model] })#F, Model],
    g2: ModelSet[({ type F[X[_]] = PojoProjection[X, Model] })#F, Model],
    basedInstalled: BasedInstalledSimpleProduct[({ type F[X[_]] = PojoProjection[X, Model] })#F],
    lb: BasedInstalledLabelled[({ type F[X[_]] = PojoProjection[X, Model] })#F],
    g: ByNameImplicit[PojoProjection[Format, Model]],
    sjn: ConfigGeneric.Pojo[Model, PlayJsonPoly] = ConfigGeneric.Pojo[Model, PlayJsonPoly].derived
  ): OFormat[Model] = {
    val w1: OFormat[PojoProjection[({ type IDF[T] = T })#IDF, Model]] =
      simplePlayJsonOFormatFImplicit[({ type F[X[_]] = PojoProjection[X, Model] })#F]
    w1.bimap[Model](g2.fromIdentity, g1.toIdentity)
  }

}
