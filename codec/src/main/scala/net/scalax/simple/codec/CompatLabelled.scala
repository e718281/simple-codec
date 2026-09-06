package net.scalax.simple.codec

trait CompatLabelled[F[_[_]]] {
  def stringLabelled: F[({ type T1[_] = String })#T1]
  def symbolLabelled: F[({ type T1[_] = Symbol })#T1]
}

object CompatLabelled extends CompatLabelledCompatHelper

object CompatLabelledImplHelper {

  private val map1: MapGeneric.MapFunction[({ type T1[_] = String })#T1, ({ type T1[_] = Symbol })#T1] =
    new MapGeneric.MapFunction[({ type T1[_] = String })#T1, ({ type T1[_] = Symbol })#T1] {
      override def map[X1](in: String): Symbol = Symbol(in)
    }

  private val map2: MapGeneric.MapFunction[({ type T1[_] = Symbol })#T1, ({ type T1[_] = String })#T1] =
    new MapGeneric.MapFunction[({ type T1[_] = Symbol })#T1, ({ type T1[_] = String })#T1] {
      override def map[X1](in: Symbol): String = in.name
    }

  trait Impl[F[_[_]]] extends CompatLabelled[F] { ImplSelf =>
    override def stringLabelled: F[({ type T1[_] = String })#T1] =
      mapGeneric.map[({ type T1[_] = Symbol })#T1, ({ type T1[_] = String })#T1](map2)(ImplSelf.symbolLabelled)
    override def symbolLabelled: F[({ type T1[_] = Symbol })#T1] =
      mapGeneric.map[({ type T1[_] = String })#T1, ({ type T1[_] = Symbol })#T1](map1)(ImplSelf.stringLabelled)

    def mapGeneric: MapGeneric[F]
  }

}
