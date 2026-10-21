package net.scalax.simple.codec

import io.circe._
import io.circe.generic.extras.JsonKey
import net.scalax.simple.adt.nat.support.v5.AppenderSupport4
import net.scalax.simple.codec.circe.EncodeHelperUtils
import net.scalax.simple.codec.product.core.Map2Generic
import net.scalax.simple.codec.to_list_generic.{BasedInstalledLabelled, BasedInstalledSimpleProduct, PojoInstance, SingletonMap}
import net.scalax.simple.codec.utils.ByNameImplicit

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
