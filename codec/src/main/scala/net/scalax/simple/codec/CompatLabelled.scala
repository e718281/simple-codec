package net.scalax.simple.codec

import net.scalax.simple.codec.product.core.Map1Generic

trait CompatLabelled[F[_[_]]] {
  def stringLabelled: F[({ type T1[_] = String })#T1]
  def symbolLabelled: F[({ type T1[_] = Symbol })#T1]
}

object CompatLabelled extends CompatLabelledCompatHelper

object CompatLabelledImplHelper {

  private val map1: Map1Generic.MapFunction[({ type T1[_] = String })#T1, ({ type T1[_] = Symbol })#T1] =
    new Map1Generic.MapFunction[({ type T1[_] = String })#T1, ({ type T1[_] = Symbol })#T1] {
      override def func[X1](in: String): Symbol = Symbol(in)
    }

  private val map2: Map1Generic.MapFunction[({ type T1[_] = Symbol })#T1, ({ type T1[_] = String })#T1] =
    new Map1Generic.MapFunction[({ type T1[_] = Symbol })#T1, ({ type T1[_] = String })#T1] {
      override def func[X1](in: Symbol): String = in.name
    }

  trait Impl[F[_[_]]] extends CompatLabelled[F] { ImplSelf =>
    override def stringLabelled: F[({ type T1[_] = String })#T1] =
      mapGeneric.map[({ type T1[_] = Symbol })#T1, ({ type T1[_] = String })#T1](map2)(ImplSelf.symbolLabelled)
    override def symbolLabelled: F[({ type T1[_] = Symbol })#T1] =
      mapGeneric.map[({ type T1[_] = String })#T1, ({ type T1[_] = Symbol })#T1](map1)(ImplSelf.stringLabelled)

    def mapGeneric: Map1Generic[F]
  }

}
