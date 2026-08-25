package net.scalax.simple.codec
package to_list_generic

trait SingletonMap[T] {
  def instance: T
}

object SingletonMap {
  trait Builder[T] {
    def derived(implicit g: shapeless.Generic.Aux[T, shapeless.HNil]): SingletonMap[T] =
      new SingletonMap[T] {
        override def instance: T = g.from(shapeless.HNil)
      }
  }

  def apply[T]: Builder[T] = new Builder[T] {
    //
  }
}
