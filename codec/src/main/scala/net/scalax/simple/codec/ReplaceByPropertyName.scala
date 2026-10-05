package net.scalax.simple.codec

import net.scalax.simple.adt.nat.support.{ABCFunc, FromToFunc}
import net.scalax.simple.adt.nat.support.v5.AppenderSupport1
import net.scalax.simple.codec.to_list_generic.{BasedInstalledLabelled, BasedInstalledSimpleProduct}

trait ReplaceByPropertyName[F[_[_]]] {
  def replaceImpl[UX](proName: String, proValue: UX): F[({ type X1[_] = UX })#X1] => F[({ type X1[_] = UX })#X1]
  def replace[T[_]](proName: String, proValue: Any): F[T] => F[T] = {
    val funcImpl: F[({ type X1[_] = Any })#X1] => F[({ type X1[_] = Any })#X1] = replaceImpl[Any](proName = proName, proValue = proValue)
    funcImpl.asInstanceOf[F[T] => F[T]]
  }
}

object ReplaceByPropertyName {
  type Named[_] = String
  def replaceImpl[ProType, F[_[_]]](
    proName: String,
    proValue: ProType,
    labelled: F[Named],
    model: F[({ type X1[_] = ProType })#X1],
    sp2: AppenderSupport1.Simple2.Release[F]
  ): (F[({ type X1[_] = ProType })#X1], Boolean) = {
    type ProTypeF[_] = ProType
    type Func[A, B]  = (A, B) => (B, Boolean)
    val appender: AppenderSupport1.Simple2.Appender[Func, Named, ProTypeF] = new AppenderSupport1.Simple2.Appender[Func, Named, ProTypeF] {
      override def append[T, B1, B2, C1, C2](
        abc1: ABCFunc[String, B1, C1],
        abc2: ABCFunc[ProType, B2, C2],
        ma: (B1, B2) => (B2, Boolean)
      ): (C1, C2) => (C2, Boolean) = (c1, c2) => {
        val name: String = abc1.takeHead(c1)
        val b2: B2       = abc2.takeTail(c2)
        if (name == proName) {
          (abc2.append(proValue, b2), true)
        } else {
          val b1: B1                = abc1.takeTail(c1)
          val unChangValue: ProType = abc2.takeHead(c2)
          val newB2: (B2, Boolean)  = ma(b1, b2)
          (abc2.append(unChangValue, newB2._1), newB2._2)
        }
      }
    }
    val one: AppenderSupport1.Simple2.One[Func, Named, ProTypeF] = new AppenderSupport1.Simple2.One[Func, Named, ProTypeF] {
      override def one[T, B1, B2](abc1: FromToFunc[String, B1], abc2: FromToFunc[ProType, B2]): (B1, B2) => (B2, Boolean) = (b1, b2) => {
        val name: String = abc1.to(b1)
        if (name == proName) (abc2.from(proValue), true) else (b2, false)
      }
    }
    val func: (F[Named], F[ProTypeF]) => (F[ProTypeF], Boolean) = sp2.append[Func, Named, ProTypeF](appender, one)
    func(labelled, model)
  }

  class Builder[F[_[_]]] {
    def derivedImpl(
      indexOfPropertyName: IndexOfPropertyName[F],
      replaceByIndex: ReplaceByIndex[F],
      labelled: CompatLabelled[F]
    ): ReplaceByPropertyName[F] = new ReplaceByPropertyName[F] {
      override def replaceImpl[UX](proName: String, proValue: UX): F[({ type X1[_] = UX })#X1] => F[({ type X1[_] = UX })#X1] = {
        val indexInt = indexOfPropertyName.ofName(proName, labelled.stringLabelled)
        replaceByIndex.replaceImpl[UX](indexInt, proValue)
      }
    }

    def derived(basedInstalled: BasedInstalledSimpleProduct[F], labelled: BasedInstalledLabelled[F]): ReplaceByPropertyName[F] = {
      val appender1 = basedInstalled.simpleRunner.simpleRelease1
      derivedImpl(IndexOfPropertyName[F].derived(appender1), ReplaceByIndex[F].derived(appender1), labelled.labelled)
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
