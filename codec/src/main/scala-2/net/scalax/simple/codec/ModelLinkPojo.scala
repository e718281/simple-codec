package net.scalax.simple.codec
package to_list_generic

import net.scalax.simple.adt.nat.support.v5.AppenderSupport4
import net.scalax.simple.codec.product.core.PojoProjection

trait ModelLinkPojo[Model] extends ModelLink[({ type F[X[_]] = PojoProjection[X, Model] })#F, Model] { Self =>

  override def toIdentity(t: Model): PojoProjection[({ type U1[X] = X })#U1, Model] =
    Self.fromHListToF[({ type U1[X] = X })#U1](Self.genericTo(t))
  override def fromIdentity(t: PojoProjection[({ type U1[X] = X })#U1, Model]): Model =
    Self.genericFrom(Self.fromFToHList[({ type U1[X] = X })#U1](t))
  override def simpleRunner: AppenderSupport4[({ type F[X[_]] = PojoProjection[X, Model] })#F] =
    SimpleProductX[({ type F[X[_]] = PojoProjection[X, Model] })#F].derivedRunner(Self, Self.size)

  protected def genericFrom(t: Any): Model
  protected def genericTo(t: Model): Any
}
