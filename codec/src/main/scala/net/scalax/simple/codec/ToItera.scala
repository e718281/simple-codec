package net.scalax.simple.codec

import net.scalax.simple.adt.nat.support.v5.{AppenderSupport1, AppenderSupport4, SimpleRunnerIt10Codengen}
import net.scalax.simple.codec.to_list_generic.{BasedInstalledLabelled, BasedInstalledModelSized, BasedInstalledSimpleProduct, ModelLink}
import net.scalax.simple.adt.nat.support.{SimpleProduct1, SimpleProductContextX, SimpleProductIt10Codengen}

trait ToItera[F[_[_]]] {
  toIteraSelf =>

  @inline def to[T](
    simpleProductX: SimpleProductContextX[F]
  ): SimpleProductContextX[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
    SimpleProductIt10Codengen.toItera[F, T](simpleProductX)

  @inline def to2[T](
    simpleProductX: AppenderSupport4[F]
  ): AppenderSupport4[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
    SimpleRunnerIt10Codengen.toItera[F, T](simpleProductX)

  def toBasedInstalled[T](
    oldInstanlled: BasedInstalledSimpleProduct[F] with BasedInstalledLabelled[F] with BasedInstalledModelSized[F]
  ): BasedInstalledSimpleProduct[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1]
    with BasedInstalledLabelled[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1]
    with BasedInstalledModelSized[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
    new BasedInstalledSimpleProduct[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1]
      with BasedInstalledLabelled[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1]
      with BasedInstalledModelSized[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] {
      override def basedInstalled: SimpleProductContextX[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
        toIteraSelf.to[T](oldInstanlled.basedInstalled)
      override def simpleRunner: AppenderSupport4[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
        toIteraSelf.to2[T](oldInstanlled.simpleRunner)
      override def labelled: CompatLabelled[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
        new CompatLabelled[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] {
          override def stringLabelled: F[({ type T1[_] = String })#T1] = oldInstanlled.labelled.stringLabelled
          override def symbolLabelled: F[({ type T1[_] = Symbol })#T1] = oldInstanlled.labelled.symbolLabelled
        }
      override def size: ModelSize[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
        ModelSize[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1].instance(oldInstanlled.size.modelSize)
    }

  /*def toModelLink[T](
    oldInstanlled: ModelLink[F, F[({ type X1[U] = U })#X1]]
  ): ModelLink[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1, F[({ type X1[_] = T })#X1]] =
    new ModelLink[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1, F[({ type X1[_] = T })#X1]] {
      override def basedInstalled: SimpleProductContextX[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
        toIteraSelf.to[T](oldInstanlled.basedInstalled)
      override def labelled: CompatLabelled[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
        new CompatLabelled[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] {
          override def stringLabelled: F[({ type T1[_] = String })#T1] = oldInstanlled.labelled.stringLabelled
          override def symbolLabelled: F[({ type T1[_] = Symbol })#T1] = oldInstanlled.labelled.symbolLabelled
        }
      override def size: ModelSize[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
        ModelSize[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1].instance(oldInstanlled.size.modelSize)

      override def toIdentity(t: F[({ type X1[_] = T })#X1]): F[({ type X1[_] = T })#X1]   = t
      override def fromIdentity(t: F[({ type X1[_] = T })#X1]): F[({ type X1[_] = T })#X1] = t
      override def FFromHList[U[_]](t: Any): F[({ type T1[_] = U[T] })#T1] = oldInstanlled.FFromHList[({ type T1[_] = U[T] })#T1](t)
      override def FToHList[U[_]](t: F[({ type T1[_] = U[T] })#T1]): Any   = oldInstanlled.FToHList[({ type T1[_] = U[T] })#T1](t)
    }*/
}

object ToItera {

  class Builder[F[_[_]]] {
    @inline def derived: ToItera[F] = new ToItera[F] {
      //
    }
  }

  @inline def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
