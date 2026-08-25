package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.{BasedInstalledSimpleProduct, PojoInstance}
import shapeless.HList

trait ModelAnnotations[F[_[_]], Ann] {
  def annInstance: F[({ type U11[_] = Option[Ann] })#U11]
}

trait ModelAnnotationsPojo[Model, Ann] extends ModelAnnotations[({ type UA[X1[_]] = PojoInstance[X1, Model] })#UA, Ann]

object ModelAnnotationsPojo {

  trait ModelBuilder[Model, Ann] {
    def derived(implicit
      sa: shapeless.Annotations[Ann, Model],
      fModelGet: FModelGet[({ type F1[U[_]] = PojoInstance[U, Model] })#F1]
    ): ModelAnnotationsPojo[Model, Ann] = {
      def annIns: shapeless.HList = sa.apply()

      def toModel: PojoInstance[({ type U11[_] = Option[Ann] })#U11, Model] =
        fModelGet.FFromHList[({ type U11[_] = Option[Ann] })#U11](annIns)

      new ModelAnnotationsPojo[Model, Ann] {
        override def annInstance: PojoInstance[({ type U11[_] = Option[Ann] })#U11, Model] = toModel
      }
    }
  }

  def apply[Model, Ann]: ModelBuilder[Model, Ann] = new ModelBuilder[Model, Ann] {
    //
  }

}
