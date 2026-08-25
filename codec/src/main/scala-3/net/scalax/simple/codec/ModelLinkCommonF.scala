package net.scalax.simple.codec
package to_list_generic

import net.scalax.simple.adt.nat.support.SimpleProductContextX
import net.scalax.simple.adt.nat.support.v5.AppenderSupport4

trait ModelLinkCommonF[F[_[_]]] extends ModelLink[F, F[({ type U1[X] = X })#U1]] {
  modelLinkCommonFSelf =>

  override def toIdentity(t: F[({ type U1[X] = X })#U1]): F[({ type U1[X] = X })#U1]   = t
  override def fromIdentity(t: F[({ type U1[X] = X })#U1]): F[({ type U1[X] = X })#U1] = t

  override def basedInstalled: SimpleProductContextX[F] = {
    val fromFunc: GenericAuxFrom[F] = new GenericAuxFrom[F] {
      override def fromModel[X[_]](collection: Any): F[X] = modelLinkCommonFSelf.FFromHList(collection)
    }

    val toFunc: GenericAuxTo[F] = new GenericAuxTo[F] {
      override def toModel[X[_]](model: F[X]): Any = modelLinkCommonFSelf.FToHList(model)
    }

    SimpleProductX[F].derived(fromFunc, toFunc, modelLinkCommonFSelf.size)
  }
  override def simpleRunner: AppenderSupport4[F] = {
    val fromFunc: GenericAuxFrom[F] = new GenericAuxFrom[F] {
      override def fromModel[X[_]](collection: Any): F[X] = modelLinkCommonFSelf.FFromHList(collection)
    }

    val toFunc: GenericAuxTo[F] = new GenericAuxTo[F] {
      override def toModel[X[_]](model: F[X]): Any = modelLinkCommonFSelf.FToHList(model)
    }

    SimpleProductX[F].derivedRunner(fromFunc, toFunc, modelLinkCommonFSelf.size)
  }
}
