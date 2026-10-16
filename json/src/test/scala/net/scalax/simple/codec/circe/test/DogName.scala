package net.scalax.simple.codec.circe.test

import net.scalax.simple.codec.to_list_generic.ModelLink

case class DogName(foo1: Int, foo2: Option[String] = Option("foo"), foo3: Option[Long], bar1: String = "bar", bar2: String)
object DogName {
  implicit val modelLink: ModelLink.Pojo[DogName] = ModelLink.Pojo[DogName].derived
}
