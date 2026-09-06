package net.scalax.simple.adt
package nat
package support
package v5

trait AppenderSupport4[F[_[_]]] {

  def simpleRelease1: AppenderSupport1.Simple1.Release[F]

  def simpleRelease2: AppenderSupport1.Simple2.Release[F]

  def simpleRelease3: AppenderSupport1.Simple3.Release[F]

  def simpleRelease4: AppenderSupport1.Simple4.Release[F]

  def simpleRelease5: AppenderSupport1.Simple5.Release[F]

  def simpleRelease6: AppenderSupport1.Simple6.Release[F]

  def simpleRelease7: AppenderSupport1.Simple7.Release[F]

}
