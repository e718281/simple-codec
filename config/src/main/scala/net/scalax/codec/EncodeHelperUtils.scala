package net.scalax.simple.codec.pureconfig

import com.typesafe.config.{ConfigFactory, ConfigObject, ConfigValue}
import net.scalax.simple.adt.nat.support.v5.AppenderSupport1
import net.scalax.simple.adt.nat.support.{ABCFunc, FromToFunc}
import net.scalax.simple.codec.product.core.Fold3Generic
import pureconfig._

import scala.jdk.CollectionConverters._

object EncodeHelperUtils {
  type Named[_]  = String
  type IdType[T] = T

  val emptyObj: ConfigObject = ConfigFactory.parseMap(Map.empty[String, ConfigValue].asJava).root()

  def encodeImpl[F[_[_]]](
    sp3: AppenderSupport1.Simple3.Release[F],
    namedIns: F[Named],
    encIns: () => F[ConfigWriter]
  ): F[IdType] => ConfigValue = {
    val folderGeneric: Fold3Generic[F] = Fold3Generic[F].derived(sp3)

    val folderFunc = new Fold3Generic.Folder[Named, ConfigWriter, IdType, ConfigObject] {
      override def fold[T](n1: String, n2: ConfigWriter[T], n3: T, col: ConfigObject): ConfigObject = col.withValue(n1, n2.to(n3))
      override def zero: ConfigObject                                                               = emptyObj
    }

    (model: F[IdType]) => folderGeneric.foldLeft(namedIns, encIns(), model, folderFunc)
  }

}
