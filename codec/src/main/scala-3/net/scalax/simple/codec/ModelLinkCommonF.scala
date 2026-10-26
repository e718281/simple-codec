package net.scalax.simple.codec
package to_list_generic

import net.scalax.simple.adt.nat.support.v5.AppenderSupport4

trait ModelLinkCommonF[F[_[_]]] extends ModelLink[F, F[({ type U1[X] = X })#U1]] { Self =>
  override def toIdentity(t: F[({ type U1[X] = X })#U1]): F[({ type U1[X] = X })#U1]   = t
  override def fromIdentity(t: F[({ type U1[X] = X })#U1]): F[({ type U1[X] = X })#U1] = t
  override def simpleRunner: AppenderSupport4[F]                                       = SimpleProductX[F].derivedRunner(Self, Self.size)
}
