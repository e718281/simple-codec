package net.scalax.simple.codec

import play.api.libs.json._

trait FormatHelper[F[_], G[_]] {
  def to[T](f: F[T]): G[T]
}
object FormatHelper {

  implicit val f1: FormatHelper[Format, Reads] = new FormatHelper[Format, Reads] {
    override def to[T](f: Format[T]): Reads[T] = f
  }

  implicit val f2: FormatHelper[Format, Writes] = new FormatHelper[Format, Writes] {
    override def to[T](f: Format[T]): Writes[T] = f
  }

  implicit def identity[En[_]]: FormatHelper[En, En] = new FormatHelper[En, En] {
    override def to[T](f: En[T]): En[T] = f
  }

}
