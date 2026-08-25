package net.scalax.simple.codec
package to_list_generic

import net.scalax.simple.adt.nat.support.SimpleProductContextX
import net.scalax.simple.adt.nat.support.v5.AppenderSupport4

trait BasedInstalledSimpleProduct[F[_[_]]] {
  def basedInstalled: SimpleProductContextX[F]
  def simpleRunner: AppenderSupport4[F]
}

trait BasedInstalledLabelled[F[_[_]]] {
  def labelled: CompatLabelled[F]
}

trait BasedInstalledModelSized[F[_[_]]] {
  def size: ModelSize[F]
}
