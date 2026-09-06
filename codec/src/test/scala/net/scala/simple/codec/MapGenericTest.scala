package net.scalax.simple
package codec

import org.scalatest._
import flatspec._
import matchers._

import net.scalax.simple.codec.to_list_generic.ModelLink

class MapGenericTest extends AnyFlatSpec with should.Matchers {

  "MapGeneric" should "map string data to int." in {
    type Len[_] = Int

    val modelLike: ModelLink.F[CatName]      = implicitly[ModelLink.F[CatName]]
    val nameLabelled: CatName[CatName.Named] = modelLike.labelled.stringLabelled
    nameLabelled should be(CatName[CatName.Named]("id1", "str1", "uClass1", "name1", "namexu1"))

    val mapGeneric: MapGeneric[CatName] = MapGeneric[CatName].derived(modelLike.simpleRunner.simpleRelease2)
    val mapper                          = new MapGeneric.MapFunction[CatName.Named, Len] {
      override def map[X1](in: String): Int = in.length
    }
    val nameSize: CatName[Len] = mapGeneric.map[CatName.Named, Len](mapper)(nameLabelled)
    nameSize should be(CatName[Len](3, 4, 7, 5, 7))
  }

}
