package net.scalax.simple.codec
package to_list_generic

import net.scalax.simple.adt.nat.support.v5.AppenderSupport4

trait ModelLinkPojo[Model] extends ModelLink[({ type F[X[_]] = PojoInstance[X, Model] })#F, Model] { Self =>

  override def toIdentity(t: Model): PojoInstance[({ type U1[X] = X })#U1, Model] =
    Self.fromHListToF[({ type U1[X] = X })#U1](Self.genericTo(t))
  override def fromIdentity(t: PojoInstance[({ type U1[X] = X })#U1, Model]): Model =
    Self.genericFrom(Self.fromFToHList[({ type U1[X] = X })#U1](t))
  override def simpleRunner: AppenderSupport4[({ type F[X[_]] = PojoInstance[X, Model] })#F] = {
    /*val fromFunc: GenericAuxFrom[({ type F[X[_]] = PojoInstance[X, Model] })#F] =
      new GenericAuxFrom[({ type F[X[_]] = PojoInstance[X, Model] })#F] {
        override def fromModel[X[_]](collection: Any): PojoInstance[X, Model] = new PojoInstance[X, Model] {
          override def instance: Any = collection
        }
      }

    val toFunc: GenericAuxTo[({ type F[X[_]] = PojoInstance[X, Model] })#F] =
      new GenericAuxTo[({ type F[X[_]] = PojoInstance[X, Model] })#F] {
        override def toModel[X[_]](model: PojoInstance[X, Model]): Any = model.instance
      }*/

    SimpleProductX[({ type F[X[_]] = PojoInstance[X, Model] })#F].derivedRunner(Self, Self, Self.size)
  }

  protected def genericFrom(t: Any): Model
  protected def genericTo(t: Model): Any
}
