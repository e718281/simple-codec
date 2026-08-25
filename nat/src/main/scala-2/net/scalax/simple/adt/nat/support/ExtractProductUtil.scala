package net.scalax.simple.adt
package nat
package support

import net.scalax.simple.adt.nat.support.v5.{Append2Impl, AppenderSupport2, AppenderSupport3, AppenderSupport4}
import shapeless.{HList, HNil}

object ExtractProductUtil extends NatNext5[shapeless.HList, shapeless.::, shapeless.HNil] {

  override object extraAbstraction extends NatNext4[shapeless.HList, shapeless.::, shapeless.HNil] {
    extraAbstractionSelf =>

    override lazy val zeroInstance: shapeless.HNil = shapeless.HNil

    override object natNext2Helper extends NatNext2Helper[shapeless.HList, shapeless.::] {
      override object hlistFunc extends HListFunc[shapeless.HList, shapeless.::] {
        override def takeHead[Head, Tail <: shapeless.HList](m: shapeless.::[Head, Tail]): Head        = m.head
        override def takeTail[Head, Tail <: shapeless.HList](m: shapeless.::[Head, Tail]): Tail        = m.tail
        override def append[Head, Tail <: shapeless.HList](h: Head, t: Tail): shapeless.::[Head, Tail] = shapeless.::[Head, Tail](h, t)

        private lazy val anyToABCFunc: ABCFunc[Any, HList, shapeless.::[Any, HList]] = super.toABCFunc[Any, HList]
        override def toABCFunc[Head, HCollecio <: HList]: ABCFunc[Head, HCollecio, shapeless.::[Head, HCollecio]] =
          anyToABCFunc.asInstanceOf[ABCFunc[Head, HCollecio, shapeless.::[Head, HCollecio]]]
      }
    }

  }

}

trait Append3Impl1 extends AppenderSupport3[shapeless.HList, shapeless.::, shapeless.HNil] {
  Append3Impl1Self =>
  override lazy val appSupport2: AppenderSupport2[shapeless.HList, shapeless.::] = Append2Impl
  override lazy val hZero: shapeless.HNil                                        = shapeless.HNil
  override def fromToFunc[X1]: FromToFunc[X1, shapeless.::[X1, shapeless.HNil]]  =
    appSupport2.abcGen.fromTo[X1, shapeless.HNil](Append3Impl1Self.hZero)
}

object Append3Impl extends Append3Impl1 {
  Append3ImplSelf =>
  private lazy val fromToFuncAny: FromToFunc[Any, shapeless.::[Any, shapeless.HNil]] = super.fromToFunc[Any]
  override def fromToFunc[X1]: FromToFunc[X1, shapeless.::[X1, shapeless.HNil]]      =
    fromToFuncAny.asInstanceOf[FromToFunc[X1, shapeless.::[X1, shapeless.HNil]]]
}
