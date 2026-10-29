package net.scalax.simple.codec

import io.circe._
import io.circe.generic.extras.JsonKey
import io.circe.syntax._
import net.scalax.simple.codec.product.core.{DefaultValueGeneric, Fold1Generic, ToListByTheSameTypeGeneric}
import net.scalax.simple.codec.to_list_generic.{ModelLink, ModelLinkPojo, Packager}
import net.scalax.simple.codec.product.core.PojoProjection

case class CatNameTest3(
  id3: Int,
  str3: Option[String],
  @JsonKey("MyClassMiaoMiaoMiao") uClass3: Option[Long],
  name113: String,
  friends: List[CatNameTest3]
)

object CatNameTest3 {

  val longOptEncoder: Encoder[Option[Long]] = Encoder[Option[String]].contramap((opt: Option[Long]) => for (u <- opt) yield u.toString)

  implicit val modelLinkPojo: ModelLinkPojo[CatNameTest3] = ModelLink.Pojo[CatNameTest3].derived

  implicit def defValue: DefaultValueGeneric.Pojo[CatNameTest3] = DefaultValueGeneric.Pojo[CatNameTest3].derived

  implicit def annInstance: ModelAnnotations.Pojo[CatNameTest3, JsonKey] = ModelAnnotations.Pojo[CatNameTest3, JsonKey].derived
  import Circe._
  implicit val jsonLabelled: ConfigGeneric.Pojo[CatNameTest3, CircePoly] =
    ConfigGeneric
      .Pojo[CatNameTest3, CircePoly]
      .derived
      .mapLabelled(_.copy(_.id3)("miaomiao id"))
      .mapLabelled(CirceHepler.jsonKeyPojo)
      .useDefaultValue

  implicit def modelEncoder: Packager.Pojo[Encoder, CatNameTest3] =
    Packager.Pojo[Encoder, CatNameTest3].derived.copy(_.uClass3)(longOptEncoder)
  implicit def modelDecoder: Packager.Pojo[Decoder, CatNameTest3] = Packager.Pojo[Decoder, CatNameTest3].derived

}

object CatNameTest3TestCase {

  import Circe._

  val cat1: CatNameTest3 = CatNameTest3(
    id3 = 1257,
    str3 = Option("cat-b"),
    uClass3 = Option(3256),
    name113 = "HardCoreTest0032",
    friends = List.empty
  )

  val modelInstance: CatNameTest3 = CatNameTest3(
    id3 = 8594,
    str3 = Option("aaTest3"),
    uClass3 = Option.empty,
    name113 = "xxiwerwjkl",
    friends = List(cat1)
  )

  def getNames(model: PojoProjection[({ type M1[_] = String })#M1, CatNameTest3]): List[String] = {
    val ge = ToListByTheSameTypeGeneric[({ type U1[X[_]] = PojoProjection[X, CatNameTest3] })#U1].derived(
      Fold1Generic[({ type U1[X[_]] = PojoProjection[X, CatNameTest3] })#U1]
        .derived(implicitly[ModelLinkPojo[CatNameTest3]].simpleRunner.simpleRelease1)
    )

    ge.toListByTheSameType[String, List[String]](List.empty, (t1, t2) => t2 :: t1)(model)
  }

  final def main(args: Array[String]): Unit = {
    println(modelInstance.asJson.spaces2)
    println(parser.parse(modelInstance.asJson.spaces2).flatMap(_.as[CatNameTest3]))
    println("// ===")
    val labelled1 = implicitly[ModelLinkPojo[CatNameTest3]].labelled.stringLabelled
    val labelled2 = labelled1.copy(_.name113)("name224")
    println(getNames(labelled1))
    println(getNames(labelled2))
    println(labelled1(_.name113))
    println(labelled2(_.name113))
    println(labelled1(_.id3))
    println(labelled2(_.id3))
    println(labelled1(_.friends))
    println(labelled2(_.friends))
  }

}
