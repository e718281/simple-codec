package net.scalax.simple.codec.circe.test

import org.scalatest._
import org.scalatest.flatspec._
import org.scalatest.matchers._

class CirceCommonTest extends AnyFlatSpec with should.Matchers {

  "Circe" should "work with simple-codec" in {
    val dogName: DogName         = DogName(foo1 = 15, foo2 = Option("foo2"), foo3 = Option(32L), bar1 = "bar1", bar2 = "bar2")
    val jsonStringLaw: String    = DogNameHelper.toJsonLaw(dogName)
    val jsonStringSimple: String = DogNameHelper.toJsonSimple(dogName)
    jsonStringLaw should be(jsonStringSimple)
    val jsonObj       = io.circe.parser.parse(jsonStringLaw).toOption.get
    val obj1: DogName = DogNameHelper.fromJsonLaw(jsonObj).toOption.get
    val obj2: DogName = DogNameHelper.fromJsonSimple(jsonObj).toOption.get
    obj1 should be(dogName)
    obj2 should be(dogName)
  }

}
