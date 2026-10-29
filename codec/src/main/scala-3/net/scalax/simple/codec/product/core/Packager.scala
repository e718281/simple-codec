package net.scalax.simple.codec
package to_list_generic

import net.scalax.simple.codec.product.core.PojoProjection

trait Packager[T] {
  def value: T
}

object Packager {
  import shapeless3.deriving.*

  given [A1](using a: => A1): Packager[A1] with {
    override def value: A1 = a
  }

  given monoidGen[A2](using inst: K0.ProductInstances[Packager, A2]): Packager[A2] with {
    override def value: A2 = inst.construct([t] => (ma: Packager[t]) => ma.value)
  }

  class ModelFBuilder[T] {
    inline def derived(using generic: K0.ProductGeneric[T]): T = {
      val fillIdentity: Packager[T] = Packager.monoidGen[T]
      fillIdentity.value
    }
  }

  class ModelPojoBuilder[E[_], Model] {
    inline def derived(using
      g: scala.deriving.Mirror.ProductOf[Model],
      inst: K0.ProductInstances[Packager, Tuple.Map[g.MirroredElemTypes, E]]
    ): PojoProjection[E, Model] = {
      val fillIdentity: Packager[Tuple.Map[g.MirroredElemTypes, E]] = Packager.monoidGen[Tuple.Map[g.MirroredElemTypes, E]]

      new PojoProjection[E, Model] {
        override def instance: Any = fillIdentity.value
      }
    }
  }

  object F {
    def apply[U[_], FMM[_[_]]]: ModelFBuilder[FMM[U]] = new ModelFBuilder[FMM[U]]
  }
  type F[U[_], FMM[_[_]]] = FMM[U]

  object Pojo {
    def apply[U[_], Model]: ModelPojoBuilder[U, Model] = new ModelPojoBuilder[U, Model]
  }
  type Pojo[U[_], Model] = PojoProjection[U, Model]

}
