package net.scalax.simple.codec
package to_list_generic

import net.scalax.simple.codec.utils.ByNameImplicit
import shapeless.{::, Generic, HList, HNil}

trait FillIdentity[T] {
  def value: T
}

object FillIdentity {

  implicit def hlistImplicit1[T, Tail <: HList](implicit u: ByNameImplicit[T], t1: FillIdentity[Tail]): FillIdentity[T :: Tail] =
    new FillIdentity[T :: Tail] {
      override def value: T :: Tail = u.value :: t1.value
    }

  implicit val hlistHNilImplicit2: FillIdentity[HNil] = new FillIdentity[HNil] {
    override val value: HNil = HNil
  }

  class ModelFBuilder[T] {
    def derived[H <: HList](implicit generic: Generic.Aux[T, H], filler: FillIdentity[H]): T = generic.from(filler.value)
  }
  class ModelPojoBuilder[E[_], Model] {
    def derived[H <: shapeless.HList, HCol <: shapeless.HList](implicit
      x: shapeless.Generic.Aux[Model, H],
      n: FillIdentityHelper.U1Content.Aux[E, H, HCol]
    ): PojoInstance[E, Model] = new PojoInstance[E, Model] {
      override def instance: Any = n.insAny
    }
  }

  object F {
    def apply[U[_], FMM[_[_]]]: ModelFBuilder[FMM[U]] = new ModelFBuilder[FMM[U]]
  }
  type F[U[_], FMM[_[_]]] = FMM[U]

  object Pojo {
    def apply[U[_], Model]: ModelPojoBuilder[U, Model] = new ModelPojoBuilder[U, Model]
  }
  type Pojo[U[_], Model] = PojoInstance[U, Model]

}

object FillIdentityHelper {
  trait U1Content[U[_], XModel <: shapeless.HList] {
    type XHList <: shapeless.HList
    def insAny: XHList
  }
  object U1Content {
    type Aux[U[_], XModel <: shapeless.HList, XH <: shapeless.HList] = U1Content[U, XModel] {
      type XHList = XH
    }

    implicit def hlistAppendFetch[U[_], T, Tail1 <: shapeless.HList, Tail2 <: shapeless.HList](implicit
      h: U[T],
      tailInstance: U1Content.Aux[U, Tail1, Tail2]
    ): U1Content.Aux[U, T :: Tail1, U[T] :: Tail2] = new U1Content[U, T :: Tail1] {
      override type XHList = U[T] :: Tail2
      override def insAny: U[T] :: Tail2 = h :: tailInstance.insAny
    }
    implicit def hlistZeroFetch[U[_]]: U1Content.Aux[U, shapeless.HNil, shapeless.HNil] = new U1Content[U, shapeless.HNil] {
      override type XHList = shapeless.HNil
      override val insAny: shapeless.HNil = shapeless.HNil
    }
  }
}
