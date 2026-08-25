package net.scalax.simple.codec

import play.api.libs.json._
import net.scalax.simple.codec.to_list_generic.{FillIdentity, ModelLink, ModelLinkPojo}

case class CatNameTest5(
  id5: Int,
  str5: Option[String],
  uClass5: Option[Long],
  name115: String,
  friends: List[CatNameTest5]
)

object CatNameTest5 {

  implicit val modelLinkPojo: ModelLink.Pojo[CatNameTest5] = ModelLink.Pojo[CatNameTest5].derived

  implicit val jsonLabelled: SimpleJsonLabelled.Pojo[CatNameTest5] = SimpleJsonLabelled.pojo[CatNameTest5]

  import PlayJsonGeneric.Pojo._
  implicit val modelWrites: FillIdentity.Pojo[Writes, CatNameTest5] = FillIdentity.Pojo[Writes, CatNameTest5].derived

  implicit def optionWithNull[T](implicit rds: Reads[T]): Reads[Option[T]] = Reads.optionWithNull[T]
  implicit val modelReads: FillIdentity.Pojo[Reads, CatNameTest5]          = FillIdentity.Pojo[Reads, CatNameTest5].derived

}

object PlayJsonTest1234 {

  import PlayJsonGeneric.Pojo._

  val friend2: CatNameTest5 = CatNameTest5(
    id5 = 8594,
    str5 = Option("aaTest3"),
    uClass5 = Option.empty,
    name115 = "xxiwerwjkl",
    friends = List.empty
  )
  val friend1: CatNameTest5 = CatNameTest5(
    id5 = 8594,
    str5 = Option("aaTest3"),
    uClass5 = Option.empty,
    name115 = "xxiwerwjkl",
    friends = List(friend2)
  )
  val modelInstance: CatNameTest5 = CatNameTest5(
    id5 = 8594,
    str5 = Option("aaTest3"),
    uClass5 = Option.empty,
    name115 = "xxiwerwjkl",
    friends = List(friend1, friend2)
  )

  final def main(args: Array[String]): Unit = {
    locally {
      println(Json.toJson(modelInstance))
    }

    locally {
      val jsonStr: String = Json.toJson(modelInstance).toString()
      val jsVal: JsValue  = Json.parse(jsonStr)
      println(Json.fromJson[CatNameTest5](jsVal))
    }

    locally {
      val aa =
        """{"id5":8594,"str5":"aaTest3","uClass5":null,"name115":"xxiwerwjkl","friends":[{"id5":8594,"str5":"aaTest3","uClass5":null,"name115":"xxiwerwjkl","friends":[{"id5":8594,"str5":"aaTest3","uClass5":null,"name1156":"xxiwerwjkl","friends":[]}]},{"id5":8594,"str5":"aaTest3","uClass5":null,"name115":"xxiwerwjkl","friends":[]}]}"""
      val bb = Json.parse(aa)
      val cc = bb.validate[CatNameTest5]
      println(cc)
    }
  }

}
