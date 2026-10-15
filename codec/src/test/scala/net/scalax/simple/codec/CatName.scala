package net.scalax.simple
package codec

import net.scalax.simple.codec.to_list_generic.ModelLink

case class CatName[F[_]](foo1: F[Int], foo2: F[Option[String]], foo3: F[Option[Long]], bar1: F[String], bar2: F[String])
object CatName {
  type Named[_] = String
  implicit val deco2_1: ModelLink.F[CatName] = ModelLink.F[CatName].derived
}
