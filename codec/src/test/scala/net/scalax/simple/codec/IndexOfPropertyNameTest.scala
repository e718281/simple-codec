package net.scalax.simple
package codec

import net.scalax.simple.codec.to_list_generic.ModelLink

import org.scalatest._
import org.scalatest.flatspec._
import org.scalatest.matchers._

class IndexOfPropertyNameTest extends AnyFlatSpec with should.Matchers {

  "IndexOfPropertyName" should "get index by propertyName." in {
    val modelLike: ModelLink.F[CatName]      = implicitly[ModelLink.F[CatName]]
    val nameLabelled: CatName[CatName.Named] = modelLike.labelled.stringLabelled
    nameLabelled should be(CatName[CatName.Named]("id1", "str1", "uClass1", "name1", "namexu1"))

    val indexOfPropertyName: IndexOfPropertyName[CatName] = IndexOfPropertyName[CatName].derived(modelLike.simpleRunner.simpleRelease1)
    def getIndex(name: String): Int                       = indexOfPropertyName.ofName(name, nameLabelled)
    getIndex("id1") should be(0)
    getIndex("str1") should be(1)
    getIndex("uClass1") should be(2)
    getIndex("name1") should be(3)
    getIndex("namexu1") should be(4)
  }

}
