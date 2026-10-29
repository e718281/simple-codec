package net.scalax.simple.codec.circe.test

import io.circe._
import net.scalax.simple.codec.to_list_generic.Packager

object DogNameHelper {
  def toJsonLaw(dogName: DogName): String = {
    import io.circe.generic.semiauto._
    import io.circe.syntax._
    implicit val enc: Encoder[DogName] = deriveEncoder
    dogName.asJson.noSpaces
  }

  def fromJsonLaw(json: Json): Decoder.Result[DogName] = {
    import io.circe.generic.semiauto._
    implicit val dec: Decoder[DogName] = deriveDecoder
    json.as[DogName]
  }

  def toJsonSimple(dogName: DogName): String = {
    import net.scalax.simple.codec.Circe._
    import io.circe.syntax._
    implicit val modelEncoder: Packager.Pojo[Encoder, DogName] = Packager.Pojo[Encoder, DogName].derived
    dogName.asJson.noSpaces
  }

  def fromJsonSimple(json: Json): Decoder.Result[DogName] = {
    import net.scalax.simple.codec.Circe._
    implicit val modelDecoder: Packager.Pojo[Decoder, DogName] = Packager.Pojo[Decoder, DogName].derived
    json.as[DogName]
  }
}
