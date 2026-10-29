package net.scalax.simple.codec.product.core

import net.scalax.simple.codec.GetPropertyByPropertyName
import net.scalax.simple.codec.to_list_generic.{BasedInstalledLabelled, BasedInstalledSimpleProduct}

trait PojoProjection[U[_], Model] {
  PojoInstanceSelf =>

  def instance: Any

  def copyImpl[T](proName: String, func: Model => T)(data: U[T])(implicit
    basedInstalledInput: BasedInstalledSimpleProduct[({ type F1[XX[_]] = PojoProjection[XX, Model] })#F1],
    basedLabelledInput: BasedInstalledLabelled[({ type F1[X[_]] = PojoProjection[X, Model] })#F1]
  ): PojoProjection[U, Model] = {
    val replaceByPropertyName: ReplaceByPropertyName[({ type F1[U1[_]] = PojoProjection[U1, Model] })#F1] =
      ReplaceByPropertyName[({ type F1[U1[_]] = PojoProjection[U1, Model] })#F1].derived(basedInstalledInput.simpleRunner.simpleRelease2)
    replaceByPropertyName.replace[U, T](proName, data, basedLabelledInput.labelled.stringLabelled, this)
  }

  def applyImpl[T](proName: String, func: Model => T)(implicit
    basedInstalledInput: BasedInstalledSimpleProduct[({ type F1[XX[_]] = PojoProjection[XX, Model] })#F1],
    basedLabelledInput: BasedInstalledLabelled[({ type F1[X[_]] = PojoProjection[X, Model] })#F1]
  ): U[T] = {
    val getPropertyByPropertyName: GetPropertyByPropertyName[({ type F1[U1[_]] = PojoProjection[U1, Model] })#F1] =
      GetPropertyByPropertyName[({ type F1[U1[_]] = PojoProjection[U1, Model] })#F1].derived(basedInstalledInput, basedLabelledInput)
    getPropertyByPropertyName.getProperty[U, T](proName)(this)
  }

  transparent inline def copy[MP](inline expr: Model => MP)(data: U[MP])(implicit
    bInstall: BasedInstalledSimpleProduct[({ type F1[XX[_]] = PojoProjection[XX, Model] })#F1],
    lInstall: BasedInstalledLabelled[({ type F1[XX[_]] = PojoProjection[XX, Model] })#F1]
  ): PojoProjection[U, Model] = ${ NameOfImpl.nameOf1('PojoInstanceSelf)('expr)('data)(using 'bInstall, 'lInstall) }

  transparent inline def apply[MP](inline expr: Model => MP)(implicit
    bInstall: BasedInstalledSimpleProduct[({ type F1[XX[_]] = PojoProjection[XX, Model] })#F1],
    lInstall: BasedInstalledLabelled[({ type F1[XX[_]] = PojoProjection[XX, Model] })#F1]
  ): U[MP] = ${ NameOfImpl.nameOf2('PojoInstanceSelf)('expr)(using 'bInstall, 'lInstall) }

  transparent inline def get[MP](inline expr: Model => MP)(implicit
    bInstall: BasedInstalledSimpleProduct[({ type F1[XX[_]] = PojoProjection[XX, Model] })#F1],
    lInstall: BasedInstalledLabelled[({ type F1[XX[_]] = PojoProjection[XX, Model] })#F1]
  ): U[MP] = ${ NameOfImpl.nameOf2('PojoInstanceSelf)('expr)(using 'bInstall, 'lInstall) }
}

object PojoProjection

import scala.annotation.tailrec
import scala.quoted.*

object NameOfImpl {

  def nameOf1[M, T, U[_]](thisObj: Expr[PojoProjection[U, M]])(expr: Expr[M => T])(data: Expr[U[T]])(using
    bInstall: Expr[BasedInstalledSimpleProduct[[XX[_]] =>> PojoProjection[XX, M]]],
    lInstall: Expr[BasedInstalledLabelled[[XX[_]] =>> PojoProjection[XX, M]]]
  )(using Quotes, Type[U], Type[M], Type[T]): Expr[PojoProjection[U, M]] = {
    import quotes.reflect.*
    @tailrec def extract(tree: Tree): String = tree match {
      case Ident(name)                                                     => name
      case Select(_, name)                                                 => name
      case DefDef("$anonfun", _, _, Some(term))                            => extract(term)
      case Block(List(stmt), _)                                            => extract(stmt)
      case Block(_, term)                                                  => extract(term)
      case Apply(term, _) if term.symbol.fullName != "<special-ops>.throw" => extract(term)
      case TypeApply(term, _)                                              => extract(term)
      case Inlined(_, _, term)                                             => extract(term)
      case Typed(term, _)                                                  => extract(term)
      case _                                                               => throw new MatchError(s"Unsupported expression: ${expr.show}")
    }

    val name: String           = extract(expr.asTerm)
    val nameExpr: Expr[String] = Expr(name)

    '{ $thisObj.copyImpl($nameExpr, $expr)($data)(using $bInstall, $lInstall) }
  }

  def nameOf2[M, T, U[_]](thisObj: Expr[PojoProjection[U, M]])(expr: Expr[M => T])(using
    bInstall: Expr[BasedInstalledSimpleProduct[[XX[_]] =>> PojoProjection[XX, M]]],
    lInstall: Expr[BasedInstalledLabelled[[XX[_]] =>> PojoProjection[XX, M]]]
  )(using Quotes, Type[U], Type[M], Type[T]): Expr[U[T]] = {
    import quotes.reflect.*
    @tailrec def extract(tree: Tree): String = tree match {
      case Ident(name)                                                     => name
      case Select(_, name)                                                 => name
      case DefDef("$anonfun", _, _, Some(term))                            => extract(term)
      case Block(List(stmt), _)                                            => extract(stmt)
      case Block(_, term)                                                  => extract(term)
      case Apply(term, _) if term.symbol.fullName != "<special-ops>.throw" => extract(term)
      case TypeApply(term, _)                                              => extract(term)
      case Inlined(_, _, term)                                             => extract(term)
      case Typed(term, _)                                                  => extract(term)
      case _                                                               => throw new MatchError(s"Unsupported expression: ${expr.show}")
    }

    val name: String = extract(expr.asTerm)

    val nameExpr: Expr[String] = Expr(name)

    '{ $thisObj.applyImpl($nameExpr, $expr)(using $bInstall, $lInstall) }
  }

}
