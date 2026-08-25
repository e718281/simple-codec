package net.scalax.simple.codec

import io.circe._
import io.circe.syntax._
import net.scalax.simple.codec.CirceGen.Pojo._
import net.scalax.simple.codec.to_list_generic.SingletonMap

object JsonObjectTest {

  case object Value1 {
    implicit def in1: SingletonMap[Value1.type] = SingletonMap[Value1.type].derived
  }

  def main(str: Array[String]): Unit = {
    println(Value1.asJson)
    println(implicitly[SingletonMap[Value1.type]].instance)
  }

}
