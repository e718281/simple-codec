package net.scalax.simple.codec.pureconfig

import net.scalax.simple.codec.{DefaultValue, MapGenerc}
import net.scalax.simple.codec.to_list_generic.{BasedInstalledSimpleProduct, PojoInstance}
import pureconfig._

trait PureConfigLabelled[F[_[_]]] {
  PureConfigLabelledSelf =>

  def labelledValueFunc: F[({ type Str[_] = String })#Str] => F[({ type Str[_] = String })#Str]
  def defaultValue: Option[F[({ type OptF[U1] = Option[() => U1] })#OptF]]
  def useDefaultValue(
    initFunc: F[({ type OptF[U1] = Option[() => U1] })#OptF] => F[({ type OptF[U1] = Option[() => U1] })#OptF] =
      identity[F[({ type OptF[U1] = Option[() => U1] })#OptF]]
  )(implicit
    defaultValue: DefaultValue[F]
  ): PureConfigLabelled[F]
  def mapLabelled(func: F[({ type Str[_] = String })#Str] => F[({ type Str[_] = String })#Str]): PureConfigLabelled[F]
  def mapWithConfigFieldMapping(c: ConfigFieldMapping): PureConfigLabelled[F]
}

object PureConfigLabelled { PureConfigLabelledSelf =>
  class Impl[F[_[_]]: MapGenerc](
    override val labelledValueFunc: F[({ type Str[_] = String })#Str] => F[({ type Str[_] = String })#Str],
    override val defaultValue: Option[F[({ type OptF[U1] = Option[() => U1] })#OptF]]
  ) extends PureConfigLabelled[F] { ImplSelf =>
    override def useDefaultValue(
      initFunc: F[({ type OptF[U1] = Option[() => U1] })#OptF] => F[({ type OptF[U1] = Option[() => U1] })#OptF]
    )(implicit
      defaultValue: DefaultValue[F]
    ): PureConfigLabelled[F] = new PureConfigLabelledSelf.Impl[F](
      labelledValueFunc = ImplSelf.labelledValueFunc,
      defaultValue = Some(initFunc(defaultValue.defaultValueFunction1))
    )

    override def mapLabelled(func: F[({ type Str[_] = String })#Str] => F[({ type Str[_] = String })#Str]): PureConfigLabelled[F] =
      new PureConfigLabelledSelf.Impl[F](
        labelledValueFunc = in => func(ImplSelf.labelledValueFunc(in)),
        defaultValue = ImplSelf.defaultValue
      )

    override def mapWithConfigFieldMapping(c: ConfigFieldMapping): PureConfigLabelled[F] = {
      val mapping = new MapGenerc.MapFunction[({ type Str[_] = String })#Str, ({ type Str[_] = String })#Str] {
        override def map[X1](in: String): String = c(in)
      }

      ImplSelf.mapLabelled(implicitly[MapGenerc[F]].map[({ type Str[_] = String })#Str, ({ type Str[_] = String })#Str](mapping))
    }
  }

  trait Apply[F[_[_]]] {
    def default(implicit sp: BasedInstalledSimpleProduct[F]): PureConfigLabelled[F] = {
      implicit def mp: MapGenerc[F] = MapGenerc[F].derived(sp.simpleRunner.simpleRelease2)

      new PureConfigLabelledSelf.Impl[F](
        labelledValueFunc = identity[F[({ type Str[_] = String })#Str]],
        defaultValue = Option.empty
      )
    }
  }

  def build[F[_[_]]]: PureConfigLabelledSelf.Apply[F] = new PureConfigLabelledSelf.Apply[F] {
    //
  }

  type Pojo[Model] = PureConfigLabelled[({ type U1[X1[_]] = PojoInstance[X1, Model] })#U1]
  def pojo[Model]: PureConfigLabelledSelf.Apply[({ type U1[X1[_]] = PojoInstance[X1, Model] })#U1] =
    PureConfigLabelledSelf.build[({ type U1[X1[_]] = PojoInstance[X1, Model] })#U1]

}
