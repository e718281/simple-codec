package net.scalax.simple.adt.test

import net.scalax.simple.adt.{typedadt => Adt}

import org.scalatest._
import flatspec._
import matchers._

/** @author
  *   djx314
  */
class TestCase1 extends AnyFlatSpec with should.Matchers {

  case class TempForData(typeName: String, value: Option[Int])
  def inputAdtData[T: Adt.CoProducts3[*, None.type, Some[Int], Option[Int]]](t: T): TempForData = {
    val applyM = Adt.CoProduct3[None.type, Some[Int], Option[Int]].instance(t)

    applyM
      .fold3(n => TempForData("None", n))
      .fold2(n => TempForData("Some", Some(n.get + 1)))
      .fold1(n => TempForData("Option", n.map(_ + 2)))
  }

  "Test case created by djx314-1" should "Simple adt fold in test data." in {
    val data1     = None
    val foldData1 = inputAdtData(data1)
    foldData1 should be(TempForData("None", None))

    val data2     = Some(2)
    val foldData2 = inputAdtData(data2)
    foldData2 should be(TempForData("Some", Some(2 + 1)))

    val data3     = Option(2)
    val foldData3 = inputAdtData(data3)
    foldData3 should be(TempForData("Option", Some(2 + 2)))
  }

}
