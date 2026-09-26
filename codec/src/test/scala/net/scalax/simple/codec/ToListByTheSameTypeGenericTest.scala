package net.scalax.simple
package codec

import org.scalatest._
import flatspec._
import matchers._
import net.scalax.simple.codec.to_list_generic.{Fold1FGenerc, ModelLink, ToListByTheSameTypeGeneric}

class ToListByTheSameTypeGenericTest extends AnyFlatSpec with should.Matchers {

  "ToListByTheSameTypeGeneric" should "make property as a list." in {
    val modelLike: ModelLink.F[CatName]      = implicitly[ModelLink.F[CatName]]
    val nameLabelled: CatName[CatName.Named] = modelLike.labelled.stringLabelled
    nameLabelled should be(CatName[CatName.Named]("id1", "str1", "uClass1", "name1", "namexu1"))

    val fold1FGenerc: Fold1FGenerc[CatName] = Fold1FGenerc[CatName].derived(modelLike.simpleRunner.simpleRelease1)
    val toListByTheSameTypeGeneric: ToListByTheSameTypeGeneric[CatName] = ToListByTheSameTypeGeneric[CatName].derived(fold1FGenerc)
    def nameList: List[String]                                          =
      toListByTheSameTypeGeneric.toListByTheSameType[String, List[String]](List.empty, (l, h) => h :: l)(nameLabelled)
    nameList should be(List("id1", "str1", "uClass1", "name1", "namexu1"))
  }

}
