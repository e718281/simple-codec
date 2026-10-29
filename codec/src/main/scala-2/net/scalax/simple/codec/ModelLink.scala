package net.scalax.simple.codec
package to_list_generic

import net.scalax.simple.codec.product.core.Map1Generic
import shapeless.DefaultSymbolicLabelling
import net.scalax.simple.codec.product.core.PojoProjection

trait ModelLink[F[_[_]], Model]
    extends BasedInstalledSimpleProduct[F]
    with BasedInstalledLabelled[F]
    with BasedInstalledModelSized[F]
    with ModelGet[F, Model]
    with ModelSet[F, Model]
    with GenericAuxFrom[F]

object ModelLink {
  Self =>

  class BuilderCommonF[FMM[_[_]]] {
    def derived(implicit
      compatNamed1: DefaultSymbolicLabelling.Aux[FMM[({ type U1[X] = X })#U1], _ <: shapeless.HList],
      g: shapeless.Generic.Aux[FMM[({ type U1[_] = Any })#U1], _ <: shapeless.HList]
    ): Self.F[FMM] = {
      val namedModel = compatNamed1.apply()

      new ModelLinkCommonF[FMM] { ModelLinkCommonFSelf =>
        override def labelled: CompatLabelled[FMM] = new CompatLabelledImplHelper.Impl[FMM] {
          override def symbolLabelled: FMM[({ type T1[_] = Symbol })#T1] =
            ModelLinkCommonFSelf.fromHListToF[({ type T1[_] = Symbol })#T1](namedModel)
          override def mapGeneric: Map1Generic[FMM] = Map1Generic[FMM].derived(ModelLinkCommonFSelf.simpleRunner.simpleRelease2)
        }
        override def fromFToHList[T[_]](x: FMM[T]): Any = g.to(x.asInstanceOf[FMM[({ type U1[_] = Any })#U1]])
        override def fromHListToF[T[_]](x: Any): FMM[T] = g.from(x.asInstanceOf[g.Repr]).asInstanceOf[FMM[T]]
        override def size: ModelSize[FMM]               = ModelSize[FMM].derived(namedModel)
      }
    }
  }

  class BuilderPojo[Model] {
    import shapeless.DefaultSymbolicLabelling

    def derived(implicit g: shapeless.Generic[Model], c: DefaultSymbolicLabelling[Model]): ModelLinkPojo[Model] = {
      val namedModel = c.apply()
      new ModelLinkPojo[Model] { ModelLinkPojoSelf =>
        override def labelled: CompatLabelled[({ type FX[U1[_]] = PojoProjection[U1, Model] })#FX] =
          new CompatLabelledImplHelper.Impl[({ type FX[U1[_]] = PojoProjection[U1, Model] })#FX] {
            override def symbolLabelled: PojoProjection[({ type T1[_] = Symbol })#T1, Model] =
              ModelLinkPojoSelf.fromHListToF[({ type T1[_] = Symbol })#T1](namedModel)
            override def mapGeneric: Map1Generic[({ type FX[U1[_]] = PojoProjection[U1, Model] })#FX] =
              Map1Generic[({ type FX[U1[_]] = PojoProjection[U1, Model] })#FX].derived(ModelLinkPojoSelf.simpleRunner.simpleRelease2)
          }
        override def genericFrom(x: Any): Model                           = g.from(x.asInstanceOf[g.Repr])
        override def genericTo(x: Model): Any                             = g.to(x)
        override def fromHListToF[U[_]](t: Any): PojoProjection[U, Model] = new PojoProjection[U, Model] {
          override def instance: Any = t
        }
        override def fromFToHList[U[_]](t: PojoProjection[U, Model]): Any                 = t.instance
        override def size: ModelSize[({ type FX[U1[_]] = PojoProjection[U1, Model] })#FX] =
          ModelSize[({ type FX[U1[_]] = PojoProjection[U1, Model] })#FX].derived(namedModel)
      }
    }
  }

  object F {
    def apply[F[_[_]]]: BuilderCommonF[F] = new BuilderCommonF[F]
  }
  type F[FModel[_[_]]] = ModelLink[FModel, FModel[({ type IDF[T] = T })#IDF]]

  object Pojo {
    def apply[Model]: BuilderPojo[Model] = new BuilderPojo[Model]
  }
  type Pojo[Model] = ModelLink[({ type T1[U1[_]] = PojoProjection[U1, Model] })#T1, Model]

}
