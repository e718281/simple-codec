package net.scalax.simple.codec

import net.scalax.simple.adt.nat.support.v5.AppenderSupport1
import net.scalax.simple.adt.nat.support.{ABCFunc, FromToFunc}

trait IndexOfPropertyName[F[_[_]]] {
  def ofName(input1: String, model: F[({ type T1[_] = String })#T1]): Int
}

object IndexOfPropertyName {

  trait ListLike {
    def size: Int
  }
  object PositiveListLike extends (ListLike => ListLike) {
    override def apply(v1: ListLike): ListLike = new ListLike {
      override def size: Int = v1.size + 1
    }
  }
  object ZeroListLike extends ListLike {
    override def size: Int = 0
  }

  trait ContainsString[T] {
    def input(str: T): Either[ListLike, ListLike]
  }

  def appendMonad(findName: String): AppenderSupport1.Simple1.Appender[ContainsString, ({ type T1[_] = String })#T1] =
    new AppenderSupport1.Simple1.Appender[ContainsString, ({ type T1[_] = String })#T1] {
      override def append[V, B1, C1](abc1: ABCFunc[String, B1, C1], ma: ContainsString[B1]): ContainsString[C1] = new ContainsString[C1] {
        override def input(str: C1): Either[ListLike, ListLike] = {
          val nameStr: String = abc1.takeHead(str)
          val b1: B1          = abc1.takeTail(str)
          val either1         = ma.input(b1)
          either1.fold(
            pos =>
              if (findName == nameStr) Right(PositiveListLike(pos))
              else Left(PositiveListLike(pos)),
            rightIndex => Right(rightIndex)
          )
        }
      }
    }

  def toNamed(proNameToFind: String): AppenderSupport1.Simple1.One[ContainsString, ({ type T1[_] = String })#T1] =
    new AppenderSupport1.Simple1.One[ContainsString, ({ type T1[_] = String })#T1] {
      override def one[V, B1](abc1: FromToFunc[String, B1]): ContainsString[B1] = new ContainsString[B1] {
        override def input(str: B1): Either[ListLike, ListLike] = {
          val nameStr: String = abc1.to(str)
          if (nameStr == proNameToFind) Right(ZeroListLike) else Left(ZeroListLike)
        }
      }
    }

  class Builder[F[_[_]]] {
    def derived(appender1: AppenderSupport1.Simple1.Release[F]): IndexOfPropertyName[F] = new IndexOfPropertyName[F] {
      override def ofName(input1: String, model: F[({ type T1[_] = String })#T1]): Int = {
        val containFunc = appender1.append[ContainsString, ({ type T1[_] = String })#T1](appendMonad(input1), toNamed(input1))
        containFunc.input(model).left.getOrElse(throw new Exception(s"Not confirm property name.(name: $input1)")).size
      }
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
