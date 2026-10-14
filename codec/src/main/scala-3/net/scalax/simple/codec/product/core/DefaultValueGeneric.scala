package net.scalax.simple.codec.product.core

import net.scalax.simple.codec.to_list_generic.PojoInstance
import net.scalax.simple.codec.FModelGet

trait DefaultValueGeneric[F[_[_]]] {
  def defaultValueFunction1: F[({ type UA[T1] = Option[() => T1] })#UA]
}

object DefaultValueGeneric { DefaultValuePojoSelf =>

  type ListType = List[(String, Option[() => Any])]

  class Builder[ModelType] {
    inline def derived(using
      fModelGet: FModelGet[({ type F1[U[_]] = PojoInstance[U, ModelType] })#F1]
    ): DefaultValueGeneric.Pojo[ModelType] = {
      val defaultV: ListType                 = magnolia1.Macro.defaultValue[ModelType]
      val defaultV2: List[Option[() => Any]] = for (n1 <- defaultV) yield n1._2

      val namedTuple: Tuple = Tuple.fromArray(defaultV2.to(Array))

      val ins1: PojoInstance[({ type UA[T1] = Option[() => T1] })#UA, ModelType] =
        fModelGet.FFromHList[({ type UA[T1] = Option[() => T1] })#UA](namedTuple)

      new DefaultValueGeneric[({ type T1[U2[_]] = PojoInstance[U2, ModelType] })#T1] {
        override def defaultValueFunction1: PojoInstance[({ type UA[T1] = Option[() => T1] })#UA, ModelType] = ins1
      }
    }
  }

  type Pojo[ModelType] = DefaultValueGeneric[({ type T1[U2[_]] = PojoInstance[U2, ModelType] })#T1]
  def Pojo[ModelType]: Builder[ModelType] = new Builder[ModelType]

}
