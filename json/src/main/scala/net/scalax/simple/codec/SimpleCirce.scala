package net.scalax.simple
package codec

import io.circe.generic.extras.JsonKey
import net.scalax.simple.adt.nat.support.v5.AppenderSupport1
import net.scalax.simple.adt.nat.support.{ABCFunc, FromToFunc}
import net.scalax.simple.codec.to_list_generic.{BasedInstalledSimpleProduct, PojoInstance}

trait SimpleJsonLabelled[F[_[_]]] {
  SimpleJsonEncodeLabelledSelf =>

  def annotationsLabelled(implicit ann: ModelAnnotations[F, JsonKey]): SimpleJsonLabelled[F]
  def labelledValueFunc: F[({ type Str[_] = String })#Str] => F[({ type Str[_] = String })#Str]
  def defaultValue: Option[F[({ type OptF[U1] = Option[() => U1] })#OptF]]
  def useDefaultValue(initFunc: F[({ type OptF[U1] = Option[() => U1] })#OptF] => F[({ type OptF[U1] = Option[() => U1] })#OptF])(implicit
    defaultValue: DefaultValue[F]
  ): SimpleJsonLabelled[F]
  def mapLabelled(func: F[({ type Str[_] = String })#Str] => F[({ type Str[_] = String })#Str]): SimpleJsonLabelled[F]
}

object SimpleJsonLabelled { SimpleJsonLabelledSelf =>
  class Impl[F[_[_]]: AppenderSupport1.Simple3.Release](
    override val labelledValueFunc: F[({ type Str[_] = String })#Str] => F[({ type Str[_] = String })#Str],
    override val defaultValue: Option[F[({ type OptF[U1] = Option[() => U1] })#OptF]]
  ) extends SimpleJsonLabelled[F] { ImplSelf =>
    override def annotationsLabelled(implicit ann: ModelAnnotations[F, JsonKey]): SimpleJsonLabelled[F] = {
      type Type1[T]       = String
      type Type2[T]       = Option[JsonKey]
      type MFunc[A, B, C] = (A, B) => C

      val map2Generc: Map2Generc[F]                             = Map2Generc[F].derived(implicitly)
      val funcMap: Map2Generc.Map2Function[Type1, Type2, Type1] = new Map2Generc.Map2Function[Type1, Type2, Type1] {
        override def map[X1](in: String, in2: Option[JsonKey]): String = in2.fold(in)(_.value)
      }

      val func: (F[Type1], F[Type2]) => F[Type1] = map2Generc.map[Type1, Type2, Type1](funcMap)

      new SimpleJsonLabelled.Impl[F](
        labelledValueFunc = (in: F[({ type Str[_] = String })#Str]) => func(ImplSelf.labelledValueFunc(in), ann.annInstance),
        defaultValue = ImplSelf.defaultValue
      )
    }

    override def useDefaultValue(
      initFunc: F[({ type OptF[U1] = Option[() => U1] })#OptF] => F[({ type OptF[U1] = Option[() => U1] })#OptF]
    )(implicit
      defaultValue: DefaultValue[F]
    ): SimpleJsonLabelled[F] = new SimpleJsonLabelled.Impl[F](
      labelledValueFunc = ImplSelf.labelledValueFunc,
      defaultValue = Some(initFunc(defaultValue.defaultValueFunction1))
    )

    override def mapLabelled(func: F[({ type Str[_] = String })#Str] => F[({ type Str[_] = String })#Str]): SimpleJsonLabelled[F] =
      new SimpleJsonLabelled.Impl[F](
        labelledValueFunc = (in: F[({ type Str[_] = String })#Str]) => func(ImplSelf.labelledValueFunc(in)),
        defaultValue = ImplSelf.defaultValue
      )
  }

  type F[U1[_[_]]] = SimpleJsonLabelled[U1]
  def F[U1[_[_]]](implicit spx: BasedInstalledSimpleProduct[U1]): SimpleJsonLabelled[U1] = {
    implicit def sp2: AppenderSupport1.Simple3.Release[U1] = spx.simpleRunner.simpleRelease3

    new SimpleJsonLabelledSelf.Impl[U1](labelledValueFunc = identity[U1[({ type Str[_] = String })#Str]], defaultValue = Option.empty)
  }

  type Pojo[Model] = SimpleJsonLabelled[({ type U1[Xu[_]] = PojoInstance[Xu, Model] })#U1]
  def pojo[Model](implicit
    spx: BasedInstalledSimpleProduct[({ type U1[Xu[_]] = PojoInstance[Xu, Model] })#U1]
  ): SimpleJsonLabelled[({ type U1[Xu[_]] = PojoInstance[Xu, Model] })#U1] =
    SimpleJsonLabelledSelf.F[({ type U1[Xu[_]] = PojoInstance[Xu, Model] })#U1]
}
