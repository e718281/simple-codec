package net.scalax.simple.adt
package nat
package support

import net.scalax.simple.adt.nat.support.v5.{Append2Impl, AppenderSupport2, AppenderSupport3}

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
