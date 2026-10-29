package net.scalax.simple.codec.product.core

trait IndexModelGeneric[F[_[_]]] {
  def model: F[({ type Id[_] = Int })#Id]
}

object IndexModelGeneric {

  class Builder[F[_[_]]] {
    def derived(fromList: FromListGeneric[F]): IndexModelGeneric[F] = {
      val fromInt = fromList.fromListByTheSameType[Int, Int](takeHead = identity, takeTail = t => t + 1)
      val modelInt: F[({ type IntId[_] = Int })#IntId] = fromInt(0)

      new IndexModelGeneric[F] {
        override val model: F[({ type Id[_] = Int })#Id] = modelInt
      }
    }

    @inline def implicitly(implicit modelSize: IndexModelGeneric[F]): IndexModelGeneric[F] = modelSize
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
