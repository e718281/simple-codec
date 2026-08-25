package net.scalax.codec

import com.typesafe.config.ConfigRenderOptions
import net.scalax.simple.codec.pureconfig.PureConfigLabelled
import net.scalax.simple.codec.DefaultValuePojo
import net.scalax.simple.codec.to_list_generic.{FillIdentity, ModelLink, PojoInstance}
import pureconfig._

case class SampleConf2(foo: Int = 22, name2: String, age: Int, bar: String, nick: String)

object SampleConf2 {

  implicit val modelLinkPojo: ModelLink.Pojo[SampleConf2] = ModelLink.Pojo[SampleConf2].derived

  import net.scalax.simple.codec.pureconfig.PureConfigUtils._
  implicit def pureConfigNamed: PureConfigLabelled.Pojo[SampleConf2] = PureConfigLabelled.pojo[SampleConf2].default

  implicit def readerInstance: PojoInstance[ConfigReader, SampleConf2] = FillIdentity.Pojo[ConfigReader, SampleConf2].derived
  implicit def writerInstance: PojoInstance[ConfigWriter, SampleConf2] = FillIdentity.Pojo[ConfigWriter, SampleConf2].derived

  implicit def defaultValueInstance: DefaultValuePojo[SampleConf2] = DefaultValuePojo[SampleConf2].derives

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
