package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.PojoInstance

trait DefaultValue[F[_[_]]] {
  def defaultValueFunction1: F[({ type UA[T1] = Option[() => T1] })#UA]
}

trait DefaultValuePojo[Model] extends DefaultValue[({ type T1[U2[_]] = PojoInstance[U2, Model] })#T1]

object DefaultValuePojo { DefaultValuePojoSelf =>

  type ListType = List[(String, Option[() => Any])]

  class Builder[ModelType] {
    inline def derives(using fModelGet: FModelGet[({ type F1[U[_]] = PojoInstance[U, ModelType] })#F1]): DefaultValuePojo[ModelType] = {
      val defaultV: ListType                 = magnolia1.Macro.defaultValue[ModelType]
      val defaultV2: List[Option[() => Any]] = for (n1 <- defaultV) yield n1._2

      val namedTuple: Tuple = Tuple.fromArray(defaultV2.to(Array))

      val ins1: PojoInstance[({ type UA[T1] = Option[() => T1] })#UA, ModelType] =
        fModelGet.FFromHList[({ type UA[T1] = Option[() => T1] })#UA](namedTuple)

      new DefaultValuePojo[ModelType] {
        override def defaultValueFunction1: PojoInstance[({ type UA[T1] = Option[() => T1] })#UA, ModelType] = ins1
      }
    }
  }

  def apply[ModelType]: Builder[ModelType] = new Builder[ModelType]

}
