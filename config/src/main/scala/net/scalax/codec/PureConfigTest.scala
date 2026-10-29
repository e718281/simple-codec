package net.scalax.simple.codec.pureconfig

import net.scalax.simple.codec.ConfigGeneric
import net.scalax.simple.codec.product.core.DefaultValueGeneric
import net.scalax.simple.codec.to_list_generic.{ModelLink, Packager}
import pureconfig._
import net.scalax.simple.codec.product.core.PojoProjection

case class SampleConf(foo: Int = 22, bar: String = "333", optValue: Option[SampleConf])

object SampleConf {

  implicit val modelLinkPojo: ModelLink.Pojo[SampleConf] = ModelLink.Pojo[SampleConf].derived

  import PureConfigUtils._
  implicit def pureConfigNamed: ConfigGeneric.Pojo[SampleConf, PureConfigPoly] =
    ConfigGeneric
      .Pojo[SampleConf, PureConfigPoly]
      .derived
      .mapLabelled(_.copy(_.optValue)("nextValue"))
      .mapLabelled(configFieldMappingPojo(fieldName => fieldName.toUpperCase))
      .useDefaultValue

  implicit def readerInstance: PojoProjection[ConfigReader, SampleConf] = Packager.Pojo[ConfigReader, SampleConf].derived
  implicit def writerInstance: PojoProjection[ConfigWriter, SampleConf] = Packager.Pojo[ConfigWriter, SampleConf].derived

  implicit def defaultValueInstance: DefaultValueGeneric.Pojo[SampleConf] = DefaultValueGeneric.Pojo[SampleConf].derived

}

object Runner {
  import PureConfigUtils._

  def main(arr: Array[String]): Unit = {
    {
      val value1: ConfigReader.Result[SampleConf] = ConfigSource.string("{ FOO: 2, BAR: two, NEXTVALUE: null }").load[SampleConf]
      println("=== Reader Start ===")
      println(value1)
      println("=== Reader End ===")

      println("=== Writer Start ===")
      println(for (t <- value1) yield ConfigWriter[SampleConf].to(t))
      println(for (t <- value1) yield ConfigWriter[SampleConf].to(t).render())
      println("=== Writer End ===")
    }

    {
      val value1: ConfigReader.Result[SampleConf] = ConfigSource.string("{ NEXTVALUE: null }").load[SampleConf]
      println("=== Reader2 Start ===")
      println(value1)
      println("=== Reader2 End ===")
    }

    val ins = implicitly[DefaultValueGeneric.Pojo[SampleConf]].defaultValueFunction1
    println("=== DefaultValue Start ===")
    println(ins(_.foo).map(_.apply()))
    println(ins(_.bar).map(_.apply()))
    println(ins(_.optValue).map(_.apply()))
    println("=== DefaultValue End ===")

  }
}
