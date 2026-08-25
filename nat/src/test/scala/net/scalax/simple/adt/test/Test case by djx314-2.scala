package net.scalax.simple.adt.test

import net.scalax.simple.adt.{typedadt => Adt}

import org.scalatest._
import flatspec._
import matchers._

/** @author
  *   djx314
  */
class TestCase2 extends AnyFlatSpec with should.Matchers {

  case class TempForData(typeName: String, value: Option[Int])
  def inputAdtData(
    t: Adt.CoProduct3Apply[None.type, Some[Int], Option[Int]] => Adt.CoProduct3[None.type, Some[Int], Option[Int]]
  ): TempForData = {
    val applyM = t(Adt.CoProduct3[None.type, Some[Int], Option[Int]])

    applyM
      .fold3(n => TempForData("None", n))
      .fold2(n => TempForData("Some", Some(n.get + 1)))
      .fold1(n => TempForData("Option", n.map(_ + 2)))
  }

  "Test case created by djx314-2" should "Simple adt fold in test data in a builder function." in {
    val data1     = None
    val foldData1 = inputAdtData(_.instance(data1))
    foldData1 should be(TempForData("None", None))

    val data2     = Some(2)
    val foldData2 = inputAdtData(_.instance(data2))
    foldData2 should be(TempForData("Some", Some(2 + 1)))

    val data3     = Option(2)
    val foldData3 = inputAdtData(_.instance(data3))
    foldData3 should be(TempForData("Option", Some(2 + 2)))
  }

}
