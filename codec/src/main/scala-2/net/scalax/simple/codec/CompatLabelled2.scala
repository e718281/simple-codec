package net.scalax.simple.codec

trait CompatLabelledCompatHelper {

  class Builder[F[_[_]]] {
    /*def toLabelledWithScalaVersion(
      fromListGeneric: FromListByTheSameTypeGeneric[F],
      mapGenerc: MapGenerc[F],
      compatModel: Any
    ): CompatLabelled[F] = {
      val mapGeneric1: MapGenerc[F] = mapGenerc

      new CompatLabelledImplHelper.Impl[F] {
        override def symbolLabelled: F[({ type T1[_] = Symbol })#T1] = {
          val fromList: shapeless.HList => F[({ type T1[_] = Symbol })#T1] = fromListGeneric.fromListByTheSameType[Symbol, shapeless.HList](
            takeHead = h => h.asInstanceOf[shapeless.::[Symbol, shapeless.HList]].head,
            takeTail = h => h.asInstanceOf[shapeless.::[Any, shapeless.HList]].tail
          )

          fromList(compatModel.asInstanceOf[shapeless.HList])
        }

        override def mapGenerc: MapGenerc[F] = mapGeneric1
      }
    }*/

    def toLobelledSizeWithScalaVersion(compat: Any): Int = compat.asInstanceOf[shapeless.HList].runtimeLength
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
