package net.scalax.simple.codec
package to_list_generic

import net.scalax.simple.codec.product.core.Map1Generic

trait ModelLink[F[_[_]], Model]
    extends BasedInstalledSimpleProduct[F]
    with BasedInstalledLabelled[F]
    with BasedInstalledModelSized[F]
    with ModelGet[F, Model]
    with ModelSet[F, Model]
    with FModelGet[F]
    with FModelSet[F]

object ModelLink {

  import scala.deriving.Mirror

  def buildUtilImplCommonF[FMM[_[_]]](cNamed: Any, fromTuple: Any => FMM[[_] =>> Any]): ModelLinkCommonF[FMM] = new ModelLinkCommonF[FMM] {
    ModelLinkCommonFSelf =>
    override def FToHList[T[_]](x: FMM[T]): Any   = Tuple.fromProduct(x.asInstanceOf)
    override def FFromHList[T[_]](x: Any): FMM[T] = fromTuple(x).asInstanceOf[FMM[T]]
    override def size: ModelSize[FMM]             = ModelSize[FMM].derived(cNamed)
    override def labelled: CompatLabelled[FMM]    = new CompatLabelledImplHelper.Impl[FMM] {
      override def stringLabelled: FMM[({ type T1[_] = String })#T1] = ModelLinkCommonFSelf.FFromHList[({ type T1[_] = String })#T1](cNamed)
      override def mapGeneric: Map1Generic[FMM] = Map1Generic[FMM].derived(ModelLinkCommonFSelf.simpleRunner.simpleRelease2)
    }
  }

  class BuilderCommonF[FMM[_[_]]] {
    inline def implicitly(using x: ModelLink[FMM, FMM[({ type IDF[T] = T })#IDF]]): ModelLink[FMM, FMM[({ type IDF[T] = T })#IDF]] = x

    inline def derived(using g: Mirror.ProductOf[FMM[({ type U1[_] = Any })#U1]]): ModelLink.F[FMM] = {
      val namedModel = scala.compiletime.constValueTuple[g.MirroredElemLabels]
      buildUtilImplCommonF(namedModel, g.fromTuple.asInstanceOf[Any => FMM[[_] =>> Any]])
    }
  }

  class BuilderPojo[Model] {
    def buildUtilImplPojo[Model <: Product](cNamed: Any, fromTuple: Any => Model): ModelLinkPojo[Model] = new ModelLinkPojo[Model] {
      ModelLinkPojoSelf =>
      override def genericTo(x: Model): Any                         = Tuple.fromProduct(x.asInstanceOf)
      override def genericFrom(x: Any): Model                       = fromTuple(x.asInstanceOf[Tuple]).asInstanceOf[Model]
      override def FFromHList[U[_]](t: Any): PojoInstance[U, Model] = new PojoInstance[U, Model] {
        override def instance: Any = t
      }
      override def FToHList[U[_]](t: PojoInstance[U, Model]): Any                     = t.instance
      override def size: ModelSize[({ type FX[U1[_]] = PojoInstance[U1, Model] })#FX] =
        ModelSize[({ type FX[U1[_]] = PojoInstance[U1, Model] })#FX].derived(cNamed)

      override def labelled: CompatLabelled[({ type FX[U1[_]] = PojoInstance[U1, Model] })#FX] =
        new CompatLabelledImplHelper.Impl[({ type FX[U1[_]] = PojoInstance[U1, Model] })#FX] {
          override def stringLabelled: PojoInstance[({ type T1[_] = String })#T1, Model] =
            ModelLinkPojoSelf.FFromHList[({ type T1[_] = String })#T1](cNamed)
          override def mapGeneric: Map1Generic[({ type FX[U1[_]] = PojoInstance[U1, Model] })#FX] =
            Map1Generic[({ type FX[U1[_]] = PojoInstance[U1, Model] })#FX].derived(ModelLinkPojoSelf.simpleRunner.simpleRelease2)
        }
    }

    inline def derived[Model <: Product](using g: scala.deriving.Mirror.ProductOf[Model]): ModelLinkPojo[Model] = {
      val namedModel = scala.compiletime.constValueTuple[g.MirroredElemLabels]
      buildUtilImplPojo(namedModel, g.fromTuple.asInstanceOf[Any => Model])
    }
  }

  object F {
    def apply[FMM[_[_]]]: BuilderCommonF[FMM] = new BuilderCommonF[FMM]
  }
  type F[FModel[_[_]]] = ModelLink[FModel, FModel[({ type IDF[T] = T })#IDF]]

  object Pojo {
    def apply[Model]: BuilderPojo[Model] = new BuilderPojo[Model]
  }
  type Pojo[Model] = ModelLink[({ type T1[U1[_]] = PojoInstance[U1, Model] })#T1, Model]

}
