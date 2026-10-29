package net.scalax.simple.codec

import io.circe._
import io.circe.syntax._
import net.scalax.simple.codec.to_list_generic.{ModelLink, ModelLinkPojo, Packager}

case class S3CatName(id4: Int, str4: Option[String], uClass4: Option[Long], name114: String, namexu4: String)

object S3CatName {

  given modelLike: ModelLink.Pojo[S3CatName]                   = ModelLink.Pojo[S3CatName].derived
  given circeEncoder: Packager.Pojo[Encoder, S3CatName]        = Packager.Pojo[Encoder, S3CatName].derived
  given circeDecoder: Packager.Pojo[Decoder, S3CatName]        = Packager.Pojo[Decoder, S3CatName].derived
  given jsonLabelled: ConfigGeneric.Pojo[S3CatName, CircePoly] = ConfigGeneric.Pojo[S3CatName, CircePoly].derived

}

object S3CirceTest1 {

  import Circe._

  val modelInstance: S3CatName = S3CatName(
    id4 = 8594,
    str4 = Option("aaTest3"),
    uClass4 = Option.empty,
    name114 = "xxiwerwjkl",
    namexu4 = "jerokwjoe收代理Test3"
  )

  final def main(args: Array[String]): Unit = {
    println(modelInstance.asJson.spaces2)
    println(parser.parse(modelInstance.asJson.spaces2).right.flatMap(_.as[S3CatName]))
  }

}
