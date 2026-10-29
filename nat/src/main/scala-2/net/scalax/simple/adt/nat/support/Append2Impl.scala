package net.scalax.simple.adt.nat.support
package v5

import shapeless._
import shapeless.HList.ListCompat.#:

object Append2Impl extends v5.AppenderSupport2[shapeless.HList, ::] {
  override object abcGen extends HListFunc[HList, ::] {
    override def takeHead[Head, Tail <: shapeless.HList](m: Head :: Tail): Head        = m.head
    override def takeTail[Head, Tail <: shapeless.HList](m: Head :: Tail): Tail        = m.tail
    override def append[Head, Tail <: shapeless.HList](h: Head, t: Tail): Head :: Tail = #:(h, t)

    private lazy val anyToABCFunc: ABCFunc[Any, HList, Any :: shapeless.HList] = super.toABCFunc[Any, shapeless.HList]
    override def toABCFunc[Head, HCollecio <: HList]: ABCFunc[Head, HCollecio, shapeless.::[Head, HCollecio]] =
      anyToABCFunc.asInstanceOf[ABCFunc[Head, HCollecio, shapeless.::[Head, HCollecio]]]
  }
}

object CoProductFunc extends CoProductFunc[Coproduct, :+:] {
  override def liftHead[Head, Tail <: Coproduct](m: Head): Head :+: Tail                                   = Inl(m)
  override def liftTail[Head, Tail <: Coproduct](m: Tail): Head :+: Tail                                   = Inr(m)
  override def append[T, Head, Tail <: Coproduct](h: Head => T, t: Tail => T): Head :+: Tail => T          = ht => ht.eliminate(h, t)
  override def fromTo[Head, HCollecio <: Coproduct](hCol: HCollecio): FromToFunc[Head, Head :+: HCollecio] =
    new FromToFunc[Head, Head :+: HCollecio] {
      override def from(m: Head): Head :+: HCollecio = Inl(m)
      override def to(m: Head :+: HCollecio): Head   = {
        val Inl(head) = m // Unsafe get but not throw exception.
        head
      }
    }
}
