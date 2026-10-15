package net.scalax.simple
package codec

import net.scalax.simple.codec.to_list_generic.ModelLink

case class DogName(foo1: Int, foo2: Option[String] = Option("foo"), foo3: Option[Long], bar1: String = "bar", bar2: String)
object DogName {
  type Named[_] = String
  implicit val deco2_1: ModelLink.Pojo[DogName] = ModelLink.Pojo[DogName].derived
}
