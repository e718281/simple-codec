package net.scalax.simple.codec

import net.scalax.simple.adt.nat.support.{ABCFunc, FromToFunc}
import net.scalax.simple.adt.nat.support.v5.AppenderSupport1
import net.scalax.simple.codec.to_list_generic.{BasedInstalledLabelled, BasedInstalledSimpleProduct}

trait GetPropertyByPropertyName[F[_[_]]] {
  def getPropertyImpl[T](proName: String): F[({ type Model[_] = T })#Model] => T
  def getProperty[T[_], U](proName: String): F[T] => T[U] = {
    val pa: F[GetPropertyByPropertyName.AnyF] => Any = getPropertyImpl[Any](proName)
    pa.asInstanceOf[F[T] => T[U]]
  }
}

object GetPropertyByPropertyName {
  type Named[_] = String
  type AnyF[_]  = Any

  def getPropertyInstance[F[_[_]], T](
    proName: String,
    namedModel: F[Named],
    model: F[({ type Model[_] = T })#Model],
    sp2: AppenderSupport1.Simple2.Release[F]
  ): Option[T] = {
    type ModelT[_]  = T
    type Func[A, B] = (A, B) => Option[T]
    val appender: AppenderSupport1.Simple2.Appender[Func, Named, ModelT] = new AppenderSupport1.Simple2.Appender[Func, Named, ModelT] {
      override def append[U, B1, B2, C1, C2](
        abc1: ABCFunc[String, B1, C1],
        abc2: ABCFunc[T, B2, C2],
        ma: (B1, B2) => Option[T]
      ): (C1, C2) => Option[T] = (c1, c2) => {
        val name: String = abc1.takeHead(c1)
        def b1: B1       = abc1.takeTail(c1)
        def t: T         = abc2.takeHead(c2)
        def b2: B2       = abc2.takeTail(c2)
        if (name == proName) Some(t)
        else ma(b1, b2)
      }
    }
    val one: AppenderSupport1.Simple2.One[Func, Named, ModelT] = new AppenderSupport1.Simple2.One[Func, Named, ModelT] {
      override def one[U, B1, B2](abc1: FromToFunc[String, B1], abc2: FromToFunc[T, B2]): (B1, B2) => Option[T] = (b1, b2) => {
        val name: String = abc1.to(b1)
        def t: T         = abc2.to(b2)
        if (name == proName) Some(t) else None
      }
    }
    val func = sp2.append[Func, Named, ModelT](appender, one)
    func(namedModel, model)
  }

  class Builder[F[_[_]]] {
    def derived(appender1: BasedInstalledSimpleProduct[F], labelled: BasedInstalledLabelled[F]): GetPropertyByPropertyName[F] =
      new GetPropertyByPropertyName[F] {
        override def getPropertyImpl[T](proName: String): F[({ type Model[_] = T })#Model] => T = (ft: F[({ type Model[_] = T })#Model]) =>
          {
            val getP: Option[T] =
              getPropertyInstance[F, T](proName, labelled.labelled.stringLabelled, ft, appender1.simpleRunner.simpleRelease2)
            getP.get
          }
      }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
