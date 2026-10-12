package net.scalax.simple.codec

import net.scalax.simple.codec.product.core.{Fold1Generic, FromListByTheSameTypeGeneric, IndexModelGeneric}
import net.scalax.simple.codec.to_list_generic.ModelLink
import org.scalatest._
import org.scalatest.flatspec._
import org.scalatest.matchers._

class IndexModelGenericTest extends AnyFlatSpec with should.Matchers {

  "IndexModelGeneric" should "gen index model." in {
    val modelLike: ModelLink.F[CatName]      = implicitly[ModelLink.F[CatName]]
    val nameLabelled: CatName[CatName.Named] = modelLike.labelled.stringLabelled
    nameLabelled should be(CatName[CatName.Named]("id1", "str1", "uClass1", "name1", "namexu1"))

    type IndexF[_] = Int
    val indexModelGeneric: IndexModelGeneric[CatName] =
      IndexModelGeneric[CatName].derived(FromListByTheSameTypeGeneric[CatName].derived(modelLike.simpleRunner.simpleRelease1))

    val indexModel: CatName[IndexF] = indexModelGeneric.model
    indexModel should be(CatName[IndexF](0, 1, 2, 3, 4))
  }

}
