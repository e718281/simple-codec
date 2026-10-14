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
    defModel(_.id1) should be(None)
    (defModel(_.str1).get(): Option[String]) should be(Some("foo"))
    defModel(_.uClass1) should be(None)
    (defModel(_.name1).get(): String) should be("bar")
    defModel(_.namexu1) should be(None)
  }

}
