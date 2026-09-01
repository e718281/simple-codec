package net.scalax.simple.adt
package nat
package support

import net.scalax.simple.adt.nat.support.v5.{AppenderSupport2, AppenderSupport3}

/*object ExtractProductUtil extends NatNext5[Tuple, *:, EmptyTuple] {

  override object extraAbstraction extends NatNext4[Tuple, *:, EmptyTuple] {
    extraAbstractionSelf =>

    override lazy val zeroInstance: EmptyTuple = EmptyTuple

    override object natNext2Helper extends NatNext2Helper[Tuple, *:] {
      override object hlistFunc extends HListFunc[Tuple, *:] {
        override def takeHead[Head, Tail <: Tuple](m: Head *: Tail): Head        = m.head
        override def takeTail[Head, Tail <: Tuple](m: Head *: Tail): Tail        = m.tail
        override def append[Head, Tail <: Tuple](h: Head, t: Tail): Head *: Tail = h *: t

        private lazy val anyToABCFunc: ABCFunc[Any, Tuple, Any *: Tuple]                              = super.toABCFunc[Any, Tuple]
        override def toABCFunc[Head, HCollecio <: Tuple]: ABCFunc[Head, HCollecio, Head *: HCollecio] =
          anyToABCFunc.asInstanceOf[ABCFunc[Head, HCollecio, Head *: HCollecio]]
      }
    }

  }

}*/

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
