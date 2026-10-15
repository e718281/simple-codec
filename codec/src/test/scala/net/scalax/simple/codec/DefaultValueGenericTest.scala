package net.scalax.simple.codec

import net.scalax.simple.codec.product.core.DefaultValueGeneric
import net.scalax.simple.codec.to_list_generic.ModelLink
import org.scalatest._
import org.scalatest.flatspec._
import org.scalatest.matchers._

class DefaultValueGenericTest extends AnyFlatSpec with should.Matchers {

  "DefaultValueGeneric" should "gen default value model." in {
    val defValue: DefaultValueGeneric.Pojo[DogName] = DefaultValueGeneric.Pojo[DogName].derived
    val defModel                                    = defValue.defaultValueFunction1
    defModel(_.foo1) should be(None)
    (defModel(_.foo2).get(): Option[String]) should be(Some("foo"))
    defModel(_.foo3) should be(None)
    (defModel(_.bar1).get(): String) should be("bar")
    defModel(_.bar2) should be(None)
  }

}
