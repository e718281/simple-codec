package net.scalax.simple.adt
package nat
package support

object Append2Impl extends v5.AppenderSupport2[Tuple, *:] {
  override object abcGen extends HListFunc[Tuple, *:] {
    override def takeHead[Head, Tail <: Tuple](m: Head *: Tail): Head        = m.head
    override def takeTail[Head, Tail <: Tuple](m: Head *: Tail): Tail        = m.tail
    override def append[Head, Tail <: Tuple](h: Head, t: Tail): Head *: Tail = h *: t

    private lazy val anyToABCFunc: ABCFunc[Any, Tuple, Any *: Tuple]                              = super.toABCFunc[Any, Tuple]
    override def toABCFunc[Head, HCollecio <: Tuple]: ABCFunc[Head, HCollecio, Head *: HCollecio] =
      anyToABCFunc.asInstanceOf[ABCFunc[Head, HCollecio, Head *: HCollecio]]
  }
}
