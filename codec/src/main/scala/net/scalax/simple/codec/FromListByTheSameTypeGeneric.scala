package net.scalax.simple.codec

import net.scalax.simple.adt.nat.support.v5.AppenderSupport1
import net.scalax.simple.adt.nat.support.{ABCFunc, FromToFunc}

trait FromListByTheSameTypeGeneric[F[_[_]]] {
  def fromListByTheSameType[TA, SeqType](
    takeHead: SeqType => TA,
    takeTail: SeqType => SeqType
  ): SeqType => F[({ type U1[_] = TA })#U1]
}

object FromListByTheSameTypeGeneric {

  private def toNamed[T, SeqType](
    takeHead: SeqType => T,
    takeTail: SeqType => SeqType
  ): AppenderSupport1.Simple1.One[({ type T1[U] = SeqType => (SeqType, U) })#T1, ({ type T1[_] = T })#T1] =
    new AppenderSupport1.Simple1.One[({ type T1[U] = SeqType => (SeqType, U) })#T1, ({ type T1[_] = T })#T1] {
      override def one[V, B1](abc1: FromToFunc[T, B1]): SeqType => (SeqType, B1) = seq => (takeTail(seq), abc1.from(takeHead(seq)))
    }

  private def addAppender[T, SeqType](
    takeHead: SeqType => T,
    takeTail: SeqType => SeqType
  ): AppenderSupport1.Simple1.Appender[({ type T1[U] = SeqType => (SeqType, U) })#T1, ({ type T1[_] = T })#T1] =
    new AppenderSupport1.Simple1.Appender[({ type T1[U] = SeqType => (SeqType, U) })#T1, ({ type T1[_] = T })#T1] {
      /*override def append[A1, B1, C1](c: ABCFunc[A1, B1, C1])(
        ma: SeqType => (SeqType, A1),
        mb: SeqType => (SeqType, B1)
      ): SeqType => (SeqType, C1) = { l =>
        val rb = ma(l)
        val ra = mb(rb._1)
        (ra._1, c.append(rb._2, ra._2))
      }*/
      override def append[V, B1, C1](abc1: ABCFunc[T, B1, C1], ma: SeqType => (SeqType, B1)): SeqType => (SeqType, C1) = seq => {
        val (newSeq, b1) = ma(seq)
        (takeTail(newSeq), abc1.append(takeHead(seq), b1))
      }
    }

  class Builder[F[_[_]]] {
    def derived(o1: AppenderSupport1.Simple1.Release[F]): FromListByTheSameTypeGeneric[F] = new FromListByTheSameTypeGeneric[F] {
      override def fromListByTheSameType[TA, SeqType](
        takeHead: SeqType => TA,
        takeTail: SeqType => SeqType
      ): SeqType => F[({ type U1[_] = TA })#U1] = { u1 =>
        val u = o1.append[({ type ModelF[M] = SeqType => (SeqType, M) })#ModelF, ({ type T1[_] = TA })#T1](
          addAppender[TA, SeqType](takeHead, takeTail),
          toNamed[TA, SeqType](takeHead, takeTail)
        )
        u(u1)._2
      }
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
