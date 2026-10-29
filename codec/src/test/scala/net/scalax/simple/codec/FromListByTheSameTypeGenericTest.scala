package net.scalax.simple
package codec

import net.scalax.simple.codec.product.core.FromListGeneric
import net.scalax.simple.codec.to_list_generic.ModelLink
import org.scalatest._
import org.scalatest.flatspec._
import org.scalatest.matchers._

class FromListByTheSameTypeGenericTest extends AnyFlatSpec with should.Matchers {

  "FromListByTheSameTypeGeneric" should "get model from List." in {
    val modelLike: ModelLink.F[CatName]      = implicitly[ModelLink.F[CatName]]
    val nameLabelled: CatName[CatName.Named] = modelLike.labelled.stringLabelled

    val list: List[String]                              = List("foo1", "foo2", "foo3", "bar1", "bar2")
    val fromListByTheSameType: FromListGeneric[CatName] =
      FromListGeneric[CatName].derived(modelLike.simpleRunner.simpleRelease1)
    val namePro: CatName[CatName.Named] = fromListByTheSameType.fromListByTheSameType[String, List[String]](_.head, _.tail)(list)
    namePro should be(nameLabelled)
  }

}
