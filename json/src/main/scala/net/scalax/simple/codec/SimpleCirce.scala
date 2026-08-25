package net.scalax.simple
package codec

import io.circe.generic.extras.JsonKey
import net.scalax.simple.adt.nat.support.v5.AppenderSupport1
import net.scalax.simple.adt.nat.support.ABCFunc
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
  class Impl[F[_[_]]: AppenderSupport1.Simple3.Runner](
    override val labelledValueFunc: F[({ type Str[_] = String })#Str] => F[({ type Str[_] = String })#Str],
    override val defaultValue: Option[F[({ type OptF[U1] = Option[() => U1] })#OptF]]
  ) extends SimpleJsonLabelled[F] { ImplSelf =>
    override def annotationsLabelled(implicit ann: ModelAnnotations[F, JsonKey]): SimpleJsonLabelled[F] = {
      type Type1[T]       = String
      type Type2[T]       = Option[JsonKey]
      type Type3[T]       = String
      type MFunc[A, B, C] = (A, B) => C

      val appender = new AppenderSupport1.Simple3.Appender[MFunc, Type1, Type2, Type3] {
        override def append[T, B1, B2, B3, C1, C2, C3](
          abc1: ABCFunc[String, B1, C1],
          abc2: ABCFunc[Option[JsonKey], B2, C2],
          abc3: ABCFunc[String, B3, C3],
          ma: (B1, B2) => B3
        ): (C1, C2) => C3 = (c1: C1, c2: C2) => {
          val str1: String             = abc1.takeHead(c1)
          val b1: B1                   = abc1.takeTail(c1)
          val jsonKey: Option[JsonKey] = abc2.takeHead(c2)
          val b2: B2                   = abc2.takeTail(c2)
          val b3: B3                   = ma(b1, b2)
          val newName: String          = jsonKey.fold[String](str1)(jk => jk.value)

          abc3.append(newName, b3)
        }
      }

      val zero: AppenderSupport1.Simple3.Zero[MFunc] = new AppenderSupport1.Simple3.Zero[MFunc] {
        override def zero[B1, B2, B3](b1: B1, b2: B2, b3: B3): (B1, B2) => B3 = (b1: B1, b2: B2) => b3
      }

      val runner: AppenderSupport1.Simple3.Runner[F] = implicitly

      val func: (F[Type1], F[Type2]) => F[Type3] = runner.append[MFunc, Type1, Type2, Type3](appender = appender, zero = zero)

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
    implicit def sp2: AppenderSupport1.Simple3.Runner[U1] = spx.simpleRunner.simpleRunner3

    new SimpleJsonLabelledSelf.Impl[U1](labelledValueFunc = identity[U1[({ type Str[_] = String })#Str]], defaultValue = Option.empty)
  }

  type Pojo[Model] = SimpleJsonLabelled[({ type U1[Xu[_]] = PojoInstance[Xu, Model] })#U1]
  def pojo[Model](implicit
    spx: BasedInstalledSimpleProduct[({ type U1[Xu[_]] = PojoInstance[Xu, Model] })#U1]
  ): SimpleJsonLabelled[({ type U1[Xu[_]] = PojoInstance[Xu, Model] })#U1] =
    SimpleJsonLabelledSelf.F[({ type U1[Xu[_]] = PojoInstance[Xu, Model] })#U1]
}
