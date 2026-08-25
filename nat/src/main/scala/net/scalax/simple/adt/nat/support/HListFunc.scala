package net.scalax.simple.adt
package nat
package support

trait ABCFunc[A, B, C] {
  def takeHead(m: C): A
  def takeTail(m: C): B
  def append(h: A, t: B): C
}

trait FromToFunc[A, B] {
  def from(m: A): B
  def to(m: B): A
}

trait HListFuncAbs[HLLike, Ap[_, _ <: HLLike] <: HLLike] {
  def takeHead[Head, Tail <: HLLike](m: Ap[Head, Tail]): Head
  def takeTail[Head, Tail <: HLLike](m: Ap[Head, Tail]): Tail
  def append[Head, Tail <: HLLike](h: Head, t: Tail): Ap[Head, Tail]
}

trait HListFunc[HLLike, Ap[_, _ <: HLLike] <: HLLike] {
  HListFuncSelf =>

  def takeHead[Head, Tail <: HLLike](m: Ap[Head, Tail]): Head
  def takeTail[Head, Tail <: HLLike](m: Ap[Head, Tail]): Tail
  def append[Head, Tail <: HLLike](h: Head, t: Tail): Ap[Head, Tail]

  def toABCFunc[Head, HCollecio <: HLLike]: ABCFunc[Head, HCollecio, Ap[Head, HCollecio]] =
    new ABCFunc[Head, HCollecio, Ap[Head, HCollecio]] {
      override def takeHead(m: Ap[Head, HCollecio]): Head             = HListFuncSelf.takeHead(m)
      override def takeTail(m: Ap[Head, HCollecio]): HCollecio        = HListFuncSelf.takeTail(m)
      override def append(h: Head, t: HCollecio): Ap[Head, HCollecio] = HListFuncSelf.append(h, t)
    }

  def fromTo[Head, HCollecio <: HLLike](hCol: HCollecio): FromToFunc[Head, Ap[Head, HCollecio]] =
    new FromToFunc[Head, Ap[Head, HCollecio]] {
      override def from(m: Head): Ap[Head, HCollecio] = HListFuncSelf.append(m, hCol)
      override def to(m: Ap[Head, HCollecio]): Head   = HListFuncSelf.takeHead(m)
    }

}
