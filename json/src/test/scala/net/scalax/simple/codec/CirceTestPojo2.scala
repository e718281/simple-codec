package net.scalax.simple.codec

import io.circe._
import io.circe.syntax._
import net.scalax.simple.codec.to_list_generic.{FillIdentity, ModelLink, PojoProjection}

trait CusType
case class CatNameTest6(id3: Int, str3: Option[String], uClass3: Option[CusType], name113: String, friends: List[CusType])

object CatNameTest6 {

  import Circe._

  implicit val modelLinkPojo: ModelLink.Pojo[CatNameTest6] = ModelLink.Pojo[CatNameTest6].derived

  val compileCtx                                                                       = TypeClassContent[Encoder]
  implicit def encoderInstance: PojoProjection[compileCtx.EncoderGetter, CatNameTest6] =
    FillIdentity.Pojo[compileCtx.EncoderGetter, CatNameTest6].derived

  def typeClassOpt: compileCtx.Pojo[CatNameTest6] = compileCtx.Pojo[CatNameTest6].derived

  // implicit def codec1: Codec[CatNameTest6] = ???

}

object CatNameTes6EncoderInstance {

  final def main(args: Array[String]): Unit = {
    println(CatNameTest6.typeClassOpt)
    println(CatNameTest6.typeClassOpt.infoCollection.filter(_.isDefined).map(_.fieldName))
    println(CatNameTest6.typeClassOpt.infoCollection.filter(!_.isDefined).map(_.fieldName))
  }

}
