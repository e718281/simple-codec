package net.scalax.simple.codec
package aa

import net.scalax.simple.codec.to_list_generic.{FillIdentity, ModelLink}
import slick.ast.TypedType
import slick.jdbc.JdbcProfile

case class UserAbs[F[_]](id: F[Option[Int]], first: F[String], last: F[String], age: F[Long])

object UserAbs {

  implicit def appender: ModelLink.F[UserAbs] = ModelLink.F[UserAbs].derived

  abstract class UserAbsTable[V <: JdbcProfile] extends SlickUtils[V] {
    override val slickProfile: V

    import slickProfile.api._
    type ShapeF[T] = Shape[_ <: FlatShapeLevel, Rep[T], T, Rep[T]]

    class CommonT(tag: Tag) extends CommonTableF[UserAbs](tag, "user") {
      override def columnOption: ColOpt => ColOpt =
        _.copy[ColumnOpt](id = _.column(O.AutoInc, O.PrimaryKey), first = _.column("first_name"), last = _.column("last_name"))
      override def typedType = typedTypeBuilder.derived
      override def shapeCol  = shapeBuilder.derived
    }

    object CommonT {
      import scala.language.implicitConversions
      implicit def TableUserAbsTableImpl(tb: CommonT): UserAbs[Rep] = tb.rep
    }
    def CommonTq: TableQuery[CommonT] = TableQuery(cons => new CommonT(cons))
  }

}

object Runner1 {
  type Id[T] = T

  def main(arr: Array[String]): Unit = {
    val p = slick.jdbc.MySQLProfile

    import p.api._

    object newTB extends UserAbs.UserAbsTable[slick.jdbc.H2Profile] {
      override val slickProfile = slick.jdbc.H2Profile
    }

    val db: Database = Database.forURL(url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", user = "sa", password = "", driver = "org.h2.Driver")
    val sql1         = newTB.CommonTq.schema.create
    val sql2         = newTB.CommonTq += UserAbs[Id](id = None, first = "first_name1", last = "last_name1", age = 5201314)
    val sql3         = newTB.CommonTq += UserAbs[Id](id = None, first = "first_name2", last = "last_name2", age = 114514)
    val sql4         = newTB.CommonTq += UserAbs[Id](id = None, first = "first_name3", last = "last_name3", age = 314159)

    val action1 = DBIO.seq(sql1, sql2, sql3, sql4)
    val action2 = newTB.CommonTq.result
    val action3 = newTB.CommonTq.filter(_.last endsWith "3").filter(_.first endsWith "3").result

    import scala.concurrent.ExecutionContext.Implicits.global

    val futureAction = for {
      _     <- action1
      list1 <- action2
      list2 <- action3
    } yield {
      println(list1)
      println(list2)
    }

    scala.concurrent.Await.result(db.run(futureAction), scala.concurrent.duration.Duration.Inf)

    println(newTB.CommonTq.result.statements)
  }

}
