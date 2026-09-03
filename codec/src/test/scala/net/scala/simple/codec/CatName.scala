package net.scalax.simple
package codec

import net.scalax.simple.codec.to_list_generic.ModelLink

case class CatName[F[_]](id1: F[Int], str1: F[Option[String]], uClass1: F[Option[Long]], name1: F[String], namexu1: F[String])
object CatName {
  type Named[_] = String
  implicit val deco2_1: ModelLink.F[CatName] = ModelLink.F[CatName].derived
}
