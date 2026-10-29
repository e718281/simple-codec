package net.scalax.simple.adt
package nat
package support

import net.scalax.simple.adt.nat.support.v5.{AppenderSupport2, AppenderSupport3}

trait Append3Impl1 extends AppenderSupport3[Tuple, *:, EmptyTuple] {
  Append3Impl1Self =>
  override lazy val appSupport2: AppenderSupport2[Tuple, *:]    = Append2Impl
  override lazy val hZero: EmptyTuple                           = EmptyTuple
  override def fromToFunc[X1]: FromToFunc[X1, X1 *: EmptyTuple] = appSupport2.abcGen.fromTo[X1, EmptyTuple](Append3Impl1Self.hZero)
}

object Append3Impl extends Append3Impl1 {
  Append3ImplSelf =>
  private lazy val fromToFuncAny: FromToFunc[Any, Any *: EmptyTuple] = super.fromToFunc[Any]
  override def fromToFunc[X1]: FromToFunc[X1, X1 *: EmptyTuple]      = fromToFuncAny.asInstanceOf[FromToFunc[X1, X1 *: EmptyTuple]]
}
