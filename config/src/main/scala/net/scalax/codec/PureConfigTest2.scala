package net.scalax.codec

import com.typesafe.config.ConfigRenderOptions
import net.scalax.simple.codec.ConfigGeneric
import net.scalax.simple.codec.pureconfig.PureConfigPoly
import net.scalax.simple.codec.product.core.DefaultValueGeneric
import net.scalax.simple.codec.to_list_generic.{ModelLink, Packager}
import pureconfig._
import net.scalax.simple.codec.product.core.PojoProjection

case class SampleConf2(foo: Int = 22, name2: String, age: Int, bar: String, nick: String)

object SampleConf2 {

  implicit val modelLinkPojo: ModelLink.Pojo[SampleConf2] = ModelLink.Pojo[SampleConf2].derived

  import net.scalax.simple.codec.pureconfig.PureConfigUtils._
  implicit def pureConfigNamed: ConfigGeneric.Pojo[SampleConf2, PureConfigPoly] = ConfigGeneric.Pojo[SampleConf2, PureConfigPoly].derived

  implicit def readerInstance: PojoProjection[ConfigReader, SampleConf2] = Packager.Pojo[ConfigReader, SampleConf2].derived
  implicit def writerInstance: PojoProjection[ConfigWriter, SampleConf2] = Packager.Pojo[ConfigWriter, SampleConf2].derived

  implicit def defaultValueInstance: DefaultValueGeneric.Pojo[SampleConf2] = DefaultValueGeneric.Pojo[SampleConf2].derived

}

object Runner {
  import net.scalax.simple.codec.pureconfig.PureConfigUtils._

  def main(arr: Array[String]): Unit = {
    locally {
      val modelIns: SampleConf2 = SampleConf2(name2 = "abc", age = 2345, bar = "uacb", nick = "accbs")
      println("=== Writer Start ===")
      println(ConfigWriter[SampleConf2].to(modelIns))
      println(ConfigWriter[SampleConf2].to(modelIns).render(ConfigRenderOptions.concise()))
      println("=== Writer End ===")
    }
  }
}
