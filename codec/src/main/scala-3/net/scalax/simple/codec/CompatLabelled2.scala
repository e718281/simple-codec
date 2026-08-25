package net.scalax.simple.codec

trait CompatLabelledCompatHelper {

  class Builder[F[_[_]]] {
    def toLobelledSizeWithScalaVersion(compat: Any): Int = compat.asInstanceOf[Product].productArity
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
