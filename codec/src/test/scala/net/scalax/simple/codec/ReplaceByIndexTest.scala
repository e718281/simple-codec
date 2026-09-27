package net.scalax.simple
package codec

import net.scalax.simple.codec.to_list_generic.ModelLink

import org.scalatest._
import org.scalatest.flatspec._
import org.scalatest.matchers._

class ReplaceByIndexTest extends AnyFlatSpec with should.Matchers {

  "ReplaceByIndex" should "replay property by index." in {
    type Id[T] = T
    val modelLike: ModelLink.F[CatName] = implicitly[ModelLink.F[CatName]]
    val model: CatName[Id]              = CatName[Id](23, Some("foo"), Some(56), "bar", "bar2")

    val replaceByIndex: ReplaceByIndex[CatName] = ReplaceByIndex[CatName].derived(modelLike.simpleRunner.simpleRelease1)
    val model1: CatName[Id]                     = replaceByIndex.replace[Id](0, 56)(model)
    model1 should be(CatName[Id](56, Some("foo"), Some(56), "bar", "bar2"))
    val model2: CatName[Id] = replaceByIndex.replace[Id](1, Some("bar3"))(model)
    model2 should be(CatName[Id](23, Some("bar3"), Some(56), "bar", "bar2"))
    val model3: CatName[Id] = replaceByIndex.replace[Id](3, "foo3")(model)
    model3 should be(CatName[Id](23, Some("foo"), Some(56), "foo3", "bar2"))
  }

}
