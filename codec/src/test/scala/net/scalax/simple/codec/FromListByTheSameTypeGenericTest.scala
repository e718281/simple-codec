package net.scalax.simple
package codec

import net.scalax.simple.codec.to_list_generic.ModelLink

import org.scalatest._
import org.scalatest.flatspec._
import org.scalatest.matchers._

class FromListByTheSameTypeGenericTest extends AnyFlatSpec with should.Matchers {

  "FromListByTheSameTypeGeneric" should "get model from List." in {
    val modelLike: ModelLink.F[CatName]      = implicitly[ModelLink.F[CatName]]
    val nameLabelled: CatName[CatName.Named] = modelLike.labelled.stringLabelled
    nameLabelled should be(CatName[CatName.Named]("id1", "str1", "uClass1", "name1", "namexu1"))

    val list: List[String]                                           = List("id1", "str1", "uClass1", "name1", "namexu1")
    val fromListByTheSameType: FromListByTheSameTypeGeneric[CatName] =
      FromListByTheSameTypeGeneric[CatName].derived(modelLike.simpleRunner.simpleRelease1)
    val namePro: CatName[CatName.Named] = fromListByTheSameType.fromListByTheSameType[String, List[String]](_.head, _.tail)(list)
    namePro should be(nameLabelled)
  }

}
