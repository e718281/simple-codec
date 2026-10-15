package net.scalax.simple.codec

import net.scalax.simple.codec.product.core.IndexOfPropertyName
import net.scalax.simple.codec.to_list_generic.ModelLink
import org.scalatest._
import org.scalatest.flatspec._
import org.scalatest.matchers._

class IndexOfPropertyNameTest extends AnyFlatSpec with should.Matchers {

  "IndexOfPropertyName" should "get index by propertyName." in {
    val modelLike: ModelLink.F[CatName]      = implicitly[ModelLink.F[CatName]]
    val nameLabelled: CatName[CatName.Named] = modelLike.labelled.stringLabelled

    val indexOfPropertyName: IndexOfPropertyName[CatName] = IndexOfPropertyName[CatName].derived(modelLike.simpleRunner.simpleRelease1)
    def getIndex(name: String): Int                       = indexOfPropertyName.ofName(name, nameLabelled)
    getIndex("foo1") should be(0)
    getIndex("foo2") should be(1)
    getIndex("foo3") should be(2)
    getIndex("bar1") should be(3)
    getIndex("bar2") should be(4)
  }

}
