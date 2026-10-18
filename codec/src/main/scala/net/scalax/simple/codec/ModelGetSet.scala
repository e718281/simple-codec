package net.scalax.simple.codec

@FunctionalInterface
trait ModelGet[F[_[_]], Model] {
  def toIdentity(t: Model): F[({ type U1[X] = X })#U1]
}

@FunctionalInterface
trait ModelSet[F[_[_]], Model] {
  def fromIdentity(t: F[({ type U1[X] = X })#U1]): Model
}

/*@FunctionalInterface
trait FModelGet[F[_[_]]] {
  def FFromHList[U[_]](t: Any): F[U]
}

@FunctionalInterface
trait FModelSet[F[_[_]]] {
  def FToHList[U[_]](t: F[U]): Any
}*/

package to_list_generic {
  trait GenericAuxFrom[F[_[_]]] {
    def fromHListToF[X[_]](collection: Any): F[X]
  }
  trait GenericAuxTo[F[_[_]]] {
    def fromFToHList[X[_]](model: F[X]): Any
  }
}
