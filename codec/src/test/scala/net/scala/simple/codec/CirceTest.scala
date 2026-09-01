package net.scalax.simple
package codec

import org.scalatest._
import flatspec._
import matchers._

import net.scalax.simple.codec.to_list_generic.ModelLink

case class CatName[F[_]](id1: F[Int], str1: F[Option[String]], uClass1: F[Option[Long]], name1: F[String], namexu1: F[String])
object CatName {
  type Named[_] = String
  implicit val deco2_1: ModelLink.F[CatName] = ModelLink.F[CatName].derived
}

class MapGenericTest extends AnyFlatSpec with should.Matchers {

  "MapGeneric" should "map string data to int." in {
    type Len[_] = Int

    val modelLike: ModelLink.F[CatName]      = implicitly[ModelLink.F[CatName]]
    val nameLabelled: CatName[CatName.Named] = modelLike.labelled.stringLabelled
    nameLabelled should be(CatName[CatName.Named]("id1", "str1", "uClass1", "name1", "namexu1"))

    val mapGeneric: MapGenerc[CatName] = MapGenerc[CatName].derived(modelLike.simpleRunner.simpleRelease2)
    val mapper                         = new MapGenerc.MapFunction[CatName.Named, Len] {
      override def map[X1](in: String): Int = in.length
    }
    val nameSize: CatName[Len] = mapGeneric.map[CatName.Named, Len](mapper)(nameLabelled)
    nameSize should be(CatName[Len](3, 4, 7, 5, 7))
  }

}
