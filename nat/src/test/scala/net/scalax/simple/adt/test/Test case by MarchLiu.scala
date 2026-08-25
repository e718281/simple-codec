package net.scalax.simple.adt.test

import net.scalax.simple.adt.{typedadt => Adt}

import scala.collection.compat._

import org.scalatest._
import flatspec._
import matchers._

/** @author
  *   MarchLiu
  */
class TestCase4 extends AnyFlatSpec with should.Matchers {

  type TypeOpt[T] = Adt.CoProducts3[Seq[T], Seq[String], Seq[Int], Seq[Option[Long]]]

  def inputAdtData[T: TypeOpt](t: T*): Seq[Option[Long]] = {
    val applyM = Adt.CoProduct3[Seq[String], Seq[Int], Seq[Option[Long]]].instance(t)

    applyM.fold3(t1 => t1.map(t => Some(t.length.toLong))).fold2(t2 => t2.map(t => Some(t.toLong))).fold1(t3 => t3)
  }

  "Test case created by MarchLiu" should "Simple adt fold in parameter list-1" in {
    val r1 = List("aa".length, "ofjhiwehr".length, "sdfweer".length)
    val r2 = inputAdtData("aa", "ofjhiwehr", "sdfweer")
    val r3 = r1.map(t => Some(t.toLong))
    r2 should be(r3)
  }

  "Test case created by MarchLiu" should "Simple adt fold in parameter list-2" in {
    val r1 = (1 to 100).to(List)
    val r2 = inputAdtData(r1: _*)
    val r3 = r1.map(t => Some(t.toLong))
    r2 should be(r3)
  }

  "Test case created by MarchLiu" should "Simple adt fold in parameter list-3" in {
    val r1 = (1 to 100).to(List).map(t => Some(t.toLong))
    val r2 = inputAdtData(r1: _*)
    r1 should be(r2)
  }

}
