package net.scalax.simple.codec

import io.circe._
import io.circe.syntax._
import io.circe.generic.extras._
import net.scalax.simple.codec.to_list_generic.ModelLink

case class AnnTestCatName(
  id4: Int,
  str4: Option[String],
  @JsonKey("circeNamed1") uClass4: Option[Long],
  name114: String,
  namexu4: String
)

object AnnTestCatName {

  implicit def modelLink: ModelLink.Pojo[AnnTestCatName]         = ModelLink.Pojo[AnnTestCatName].derived
  def annInstance: ModelAnnotationsPojo[AnnTestCatName, JsonKey] = ModelAnnotationsPojo[AnnTestCatName, JsonKey].derived

}

object AnnCirceTest1 {

  import CirceGen.Pojo._

  final def main1(args: Array[String]): Unit = {
    println(AnnTestCatName.annInstance.annInstance(_.name114))
    println(AnnTestCatName.annInstance.annInstance(_.uClass4))
    println(for (ann <- AnnTestCatName.annInstance.annInstance(_.uClass4)) yield ann.value)
  }

}
