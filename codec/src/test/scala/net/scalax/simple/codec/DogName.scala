package net.scalax.simple
package codec

import net.scalax.simple.codec.to_list_generic.ModelLink

case class DogName(id1: Int, str1: Option[String] = Option("foo"), uClass1: Option[Long], name1: String = "bar", namexu1: String)
object DogName {
  type Named[_] = String
  implicit val deco2_1: ModelLink.Pojo[DogName] = ModelLink.Pojo[DogName].derived
}
