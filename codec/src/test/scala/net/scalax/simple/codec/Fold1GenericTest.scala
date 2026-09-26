package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.{Fold1FGenerc, ModelLink}
import org.scalatest._
import org.scalatest.flatspec._
import org.scalatest.matchers._
import scala.collection.compat._

class Fold1GenericTest extends AnyFlatSpec with should.Matchers {

  "Fold1GenericTest" should "fold pojo to a Vector." in {
    val modelLike: ModelLink.F[CatName]      = implicitly[ModelLink.F[CatName]]
    val nameLabelled: CatName[CatName.Named] = modelLike.labelled.stringLabelled
    nameLabelled should be(CatName[CatName.Named]("id1", "str1", "uClass1", "name1", "namexu1"))

    val fold1FGenerc: Fold1FGenerc[CatName]                      = Fold1FGenerc[CatName].derived(modelLike.simpleRunner.simpleRelease1)
    val foldF: Fold1FGenerc.FoldF[CatName.Named, Vector[String]] = new Fold1FGenerc.FoldF[CatName.Named, Vector[String]] {
      override def fold[T](n: String, col: Vector[String]): Vector[String] = col :+ n
    }

    val nameSeq: Vector[String]       = Vector("id1", "str1", "uClass1", "name1", "namexu1")
    val foldLeftNamed: Vector[String] = fold1FGenerc.foldLeft[CatName.Named, Vector[String]](foldF)(nameLabelled, Vector.empty)
    foldLeftNamed should be(nameSeq)

    val foldRightNamed: Vector[String] = fold1FGenerc.foldRight[CatName.Named, Vector[String]](foldF)(nameLabelled, Vector.empty)
    foldRightNamed should be(nameSeq.reverse)
  }

}
