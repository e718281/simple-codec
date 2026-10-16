package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.{BasedInstalledSimpleProduct, PojoInstance}
import shapeless.HList

trait ModelAnnotations[F[_[_]], Ann] {
  def annInstance: F[({ type U11[_] = Option[Ann] })#U11]
}

object ModelAnnotations {

  class ModelBuilder[Model, Ann] {
    def derived(implicit
      sa: shapeless.Annotations[Ann, Model],
      fModelGet: FModelGet[({ type F1[U[_]] = PojoInstance[U, Model] })#F1]
    ): ModelAnnotations.Pojo[Model, Ann] = {
      def annIns: shapeless.HList = sa.apply()

      def toModel: PojoInstance[({ type U11[_] = Option[Ann] })#U11, Model] =
        fModelGet.FFromHList[({ type U11[_] = Option[Ann] })#U11](annIns)

      new ModelAnnotations.Pojo[Model, Ann] {
        override def annInstance: PojoInstance[({ type U11[_] = Option[Ann] })#U11, Model] = toModel
      }
    }
  }

  type F[U1[_[_]], Ann] = ModelAnnotations[U1, Ann]
  type Pojo[Model, Ann] = ModelAnnotations[({ type U1[U2[_]] = PojoInstance[U2, Model] })#U1, Ann]
  def Pojo[Model, Ann]: ModelBuilder[Model, Ann] = new ModelBuilder[Model, Ann]

}
