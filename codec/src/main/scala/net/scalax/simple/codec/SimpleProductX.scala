package net.scalax.simple.codec
package to_list_generic

import net.scalax.simple.adt.nat.support.v5.AppenderSupport4
import net.scalax.simple.adt.nat.support.{Append3Impl, ExtractProductUtil, SimpleProductContextX}

object SimpleProductX {
  private def toU[U](x: Any): U = x.asInstanceOf[U]

  class Builder[F[_[_]]] {
    def derived(from: GenericAuxFrom[F], to: GenericAuxTo[F], modelSize: ModelSize[F]): SimpleProductContextX[F] =
      ExtractProductUtil.genSimpleProduct[F](
        length = modelSize.modelSize,
        toModel = toU(from.fromModel: Any => F[({ type ToAny[_] = Any })#ToAny]),
        fromModel = toU(to.toModel: F[({ type ToAny[_] = Any })#ToAny] => Any)
      )

    def derivedRunner(from: GenericAuxFrom[F], to: GenericAuxTo[F], modelSize: ModelSize[F]): AppenderSupport4[F] =
      Append3Impl.genSimpleProduct[F](
        length = modelSize.modelSize,
        toModel = toU(from.fromModel: Any => F[({ type ToAny[_] = Any })#ToAny]),
        fromModel = toU(to.toModel: F[({ type ToAny[_] = Any })#ToAny] => Any)
      )
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]
}
