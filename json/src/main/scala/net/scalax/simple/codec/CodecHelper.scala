package net.scalax.simple.codec

import io.circe._

trait CodecHelper[F[_], G[_]] {
  def to[T](f: F[T]): G[T]
}
object CodecHelper {

  implicit val f1: CodecHelper[Codec, Decoder] = new CodecHelper[Codec, Decoder] {
    override def to[T](f: Codec[T]): Decoder[T] = f
  }

  implicit val f2: CodecHelper[Codec, Encoder] = new CodecHelper[Codec, Encoder] {
    override def to[T](f: Codec[T]): Encoder[T] = f
  }

  implicit def identity[En[_]]: CodecHelper[En, En] = new CodecHelper[En, En] {
    override def to[T](f: En[T]): En[T] = f
  }

}
