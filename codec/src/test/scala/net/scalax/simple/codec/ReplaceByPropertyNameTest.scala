package net.scalax.simple.codec

import net.scalax.simple.codec.product.core.Fold1Generic
import net.scalax.simple.codec.to_list_generic.{ModelLink, ToListByTheSameTypeGeneric}
import org.scalatest._
import org.scalatest.flatspec._
import org.scalatest.matchers._

class ReplaceByPropertyNameTest extends AnyFlatSpec with should.Matchers {
  type IntF[_] = Int

  "ReplaceByPropertyName" should "replace property value by property name." in {
    val modelLike: ModelLink.F[CatName]      = implicitly[ModelLink.F[CatName]]
    val nameLabelled: CatName[CatName.Named] = modelLike.labelled.stringLabelled
    nameLabelled should be(CatName[CatName.Named]("id1", "str1", "uClass1", "name1", "namexu1"))

    val indexF: CatName[IntF] = CatName[IntF](0, 1, 2, 3, 4)

    val replaceByPropertyName: ReplaceByPropertyName[CatName] =
      ReplaceByPropertyName[CatName].derived(modelLike.simpleRunner.simpleRelease2)

    val replaceModel1: CatName[IntF] = replaceByPropertyName.replace[IntF]("id1", 25, nameLabelled, indexF)
    replaceModel1 should be(CatName[IntF](25, 1, 2, 3, 4))
    val replaceModel2: CatName[IntF] = replaceByPropertyName.replace[IntF]("str1", 26, nameLabelled, indexF)
    replaceModel2 should be(CatName[IntF](0, 26, 2, 3, 4))
    val replaceModel3: CatName[IntF] = replaceByPropertyName.replace[IntF]("uClass1", 27, nameLabelled, indexF)
    replaceModel3 should be(CatName[IntF](0, 1, 27, 3, 4))
    val replaceModel4: CatName[IntF] = replaceByPropertyName.replace[IntF]("name1", 28, nameLabelled, indexF)
    replaceModel4 should be(CatName[IntF](0, 1, 2, 28, 4))
    val replaceModel5: CatName[IntF] = replaceByPropertyName.replace[IntF]("namexu1", 29, nameLabelled, indexF)
    replaceModel5 should be(CatName[IntF](0, 1, 2, 3, 29))
  }

}
