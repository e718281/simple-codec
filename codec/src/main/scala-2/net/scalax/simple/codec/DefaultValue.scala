package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.PojoInstance
import shapeless.HList
import scala.collection.compat._

trait DefaultValue[F[_[_]]] {
  def defaultValueFunction1: F[({ type UA[T1] = Option[() => T1] })#UA]
}

trait DefaultValuePojo[Model] extends DefaultValue[({ type T1[U2[_]] = PojoInstance[U2, Model] })#T1]

object DefaultValuePojo { DefaultValuePojoSelf =>

  class Builder[ModelType] {

    def derives(implicit
      fModelGet: FModelGet[({ type F1[U[_]] = PojoInstance[U, ModelType] })#F1],
      compatModel: SModelFill[ModelType]
    ): DefaultValuePojo[ModelType] = {
      def appendLImpl(n: List[Option[() => Any]]): shapeless.HList = n match {
        case head :: tail => shapeless.HList.ListCompat.#:(head, appendLImpl(tail))
        case Nil          => shapeless.HNil
      }

      val defaultV: List[Option[() => Any]] = compatModel.list
      val defaultVHList: HList              = appendLImpl(defaultV)

      val ins1: PojoInstance[({ type UA[T1] = Option[() => T1] })#UA, ModelType] =
        fModelGet.FFromHList[({ type UA[T1] = Option[() => T1] })#UA](defaultVHList)

      new DefaultValuePojo[ModelType] {
        override def defaultValueFunction1: PojoInstance[({ type UA[T1] = Option[() => T1] })#UA, ModelType] = ins1
      }
    }
  }

  def apply[ModelType]: Builder[ModelType] = new Builder[ModelType]

}

trait SModelFill[Model] {
  def list: List[Option[() => Any]]
}

object SModelFill {
  import language.experimental.macros, magnolia1._

  type Typeclass[T] = InnerHelper.EmptyFill[T]

  def join[T](ctx: CaseClass[InnerHelper.EmptyFill, T]): SModelFill[T] = new SModelFill[T] {
    override def list: List[Option[() => Any]] = ctx.parameters.map(_.evaluateDefault).to(List)
  }

  implicit def gen[T]: SModelFill[T] = macro Magnolia.gen[T]

  object InnerHelper {
    trait EmptyFill[Model]
    object EmptyFill {
      private def em1[M]: EmptyFill[M] = new EmptyFill[M] {
        //
      }
      private val em2: EmptyFill[Any]               = em1[Any]
      def empty[T]: EmptyFill[T]                    = em2.asInstanceOf[EmptyFill[T]]
      implicit def fillInsImplicit[T]: EmptyFill[T] = empty[T]
    }
  }

}
