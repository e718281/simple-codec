package net.scalax.simple.codec
package to_list_generic

trait SingletonMap[T] {
  def instance: T
}

object SingletonMap {
  trait Builder[T] {
    def derived(using g: scala.deriving.Mirror.ProductOf[T])(using t1: EmptyTuple <:< g.MirroredElemTypes): SingletonMap[T] =
      new SingletonMap[T] {
        override def instance: T = g.fromTuple(EmptyTuple)
      }
  }

  def apply[T]: Builder[T] = new Builder[T] {
    //
  }
}
