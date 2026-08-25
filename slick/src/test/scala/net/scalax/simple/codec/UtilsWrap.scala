package net.scalax.simple.codec

import net.scalax.simple.adt.nat.support.{ABCFunc, FromToFunc}
import net.scalax.simple.adt.nat.support.v5.AppenderSupport1
import net.scalax.simple.codec.to_list_generic.{
  BasedInstalledLabelled,
  BasedInstalledSimpleProduct,
  Fold1FGenerc,
  ToListByTheSameTypeGeneric
}
import slick.ast.TypedType
import slick.jdbc.JdbcProfile
import slick.lifted.ShapedValue

abstract class UtilsWrap[F[_[_]], Model, V <: JdbcProfile](
  val slickProfile: V,
  bi: BasedInstalledSimpleProduct[F],
  named: BasedInstalledLabelled[F]
) {
  import slickProfile.api._

  val tb: Table[Model]

  private val folderGeneric: Fold1FGenerc[F]                                = Fold1FGenerc[F].derived(bi.basedInstalled.simpleProduct1)
  private val toListGeneric: ToListByTheSameTypeGeneric[F]                  = ToListByTheSameTypeGeneric[F].derived(folderGeneric)
  private val fromListByTheSameTypeGeneric: FromListByTheSameTypeGeneric[F] =
    FromListByTheSameTypeGeneric[F].derived(bi.basedInstalled.simpleProduct1)
  private val indexOfPropertyName: IndexOfPropertyName[F] = IndexOfPropertyName[F].derived(bi.basedInstalled.simpleProduct1)

  type ShapeF[T] = Shape[_ <: FlatShapeLevel, Rep[T], T, Rep[T]]

  def getIndexByName1(n: String)(implicit bi: BasedInstalledSimpleProduct[F]): Int =
    indexOfPropertyName.ofName(n, named.labelled.stringLabelled)

  private def helperUtil: helperUtils[slickProfile.type, F] = new helperUtils[slickProfile.type, F](
    slickProfile = slickProfile
  )(
    toListGeneric = toListGeneric,
    fromListByTheSameTypeGeneric = fromListByTheSameTypeGeneric
  )

  def mapShape(
    shapeModel: F[({ type ShapeF[T] = Shape[_ <: FlatShapeLevel, Rep[T], T, Rep[T]] })#ShapeF],
    repModel: F[Rep],
    cst: scala.reflect.ClassTag[Model],
    modelGet: ModelGet[F, Model],
    modelSet: ModelSet[F, Model]
  ): slick.lifted.MappedProjection[Model] = {
    import slick.collection.heterogeneous.{HList => SlickHList}
    val shapedValue: ShapedValue[SlickHList, SlickHList] =
      anyToShapedValue(helperUtil.toRep(repModel))(helperUtil.toShape(shapeModel))

    val from1: F[({ type IDF[T] = T })#IDF] => SlickHList = helperUtil.fromModel
    val to1: SlickHList => F[({ type IDF[T] = T })#IDF]   = helperUtil.toModel

    ShapedValueCompat.mapToPro[SlickHList, SlickHList, Model](
      shapedValue,
      from1.compose(modelGet.toIdentity),
      to1.andThen(modelSet.fromIdentity),
      modelClassTag = cst
    )
  }

  private def colN[T](name: String, func: ColumnOpt[T], tt: TypedType[T]): Rep[T] = {
    val columnName = func.name.getOrElse(name)
    val tpToUse    = func.typedType.getOrElse(tt)
    tb.column(columnName, func.opts: _*)(tpToUse)
  }

  def userRep(
    labelled: BasedInstalledSimpleProduct[F],
    opt: F[ColumnOpt],
    typedType: F[TypedType]
  ): F[Rep] = {
    val l1 = named.labelled.stringLabelled

    type Type1[T1]             = String
    type TypeFunc4[A, B, C, D] = (A, B, C) => D

    val appender = new AppenderSupport1.Simple4.Appender[TypeFunc4, Type1, ColumnOpt, TypedType, Rep] {
      override def append[T, B1, B2, B3, B4, C1, C2, C3, C4](
        abc1: ABCFunc[String, B1, C1],
        abc2: ABCFunc[ColumnOpt[T], B2, C2],
        abc3: ABCFunc[TypedType[T], B3, C3],
        abc4: ABCFunc[Rep[T], B4, C4],
        ma: (B1, B2, B3) => B4
      ): (C1, C2, C3) => C4 = (c1: C1, c2: C2, c3: C3) => {
        val str1: String            = abc1.takeHead(c1)
        val b1: B1                  = abc1.takeTail(c1)
        val colOpt: ColumnOpt[T]    = abc2.takeHead(c2)
        val b2: B2                  = abc2.takeTail(c2)
        val typedType: TypedType[T] = abc3.takeHead(c3)
        val b3: B3                  = abc3.takeTail(c3)
        val b4: B4                  = ma(b1, b2, b3)
        val repT: Rep[T]            = colN[T](str1, colOpt, typedType)

        abc4.append(repT, b4)
      }
    }

    val one: AppenderSupport1.Simple4.One[TypeFunc4, Type1, ColumnOpt, TypedType, Rep] =
      new AppenderSupport1.Simple4.One[TypeFunc4, Type1, ColumnOpt, TypedType, Rep] {
        override def one[T, B1, B2, B3, B4](
          func1: FromToFunc[String, B1],
          func2: FromToFunc[ColumnOpt[T], B2],
          func3: FromToFunc[TypedType[T], B3],
          func4: FromToFunc[Rep[T], B4]
        ): (B1, B2, B3) => B4 = (b1: B1, b2: B2, b3: B3) => {
          val str1: String            = func1.to(b1)
          val colOpt: ColumnOpt[T]    = func2.to(b2)
          val typedType: TypedType[T] = func3.to(b3)
          val repT: Rep[T]            = colN[T](str1, colOpt, typedType)

          func4.from(repT)
        }
      }

    val func: (F[Type1], F[ColumnOpt], F[TypedType]) => F[Rep] =
      labelled.simpleRunner.simpleRelease4.append[TypeFunc4, Type1, ColumnOpt, TypedType, Rep](appender = appender, zero = one)

    func(l1, opt, typedType)
  }

}

import slick.collection.heterogeneous.HList.{HListShape => SlickHListShape}
import slick.collection.heterogeneous.{HCons => SlickHCons, HList => SlickHList, HNil => SlickHNil}

private class helperUtils[V <: JdbcProfile, ModelF[_[_]]](val slickProfile: V)(
  toListGeneric: ToListByTheSameTypeGeneric[ModelF],
  fromListByTheSameTypeGeneric: FromListByTheSameTypeGeneric[ModelF]
) {
  import slickProfile.api._

  type ShapeF[T] = Shape[_ <: FlatShapeLevel, Rep[T], T, Rep[T]]

  def toShape(t1: ModelF[ShapeF]): SlickHListShape[FlatShapeLevel, SlickHList, SlickHList, SlickHList] = {
    val toListFunc = toListGeneric.toListByTheSameType[ShapeF[Any], SlickHListShape[
      FlatShapeLevel,
      SlickHList,
      SlickHList,
      SlickHList
    ]](
      SlickHList.hnilShape.asInstanceOf[SlickHListShape[
        FlatShapeLevel,
        SlickHList,
        SlickHList,
        SlickHList
      ]],
      (sum, each) =>
        SlickHList
          .hconsShape(each, sum)
          .asInstanceOf[SlickHListShape[
            FlatShapeLevel,
            SlickHList,
            SlickHList,
            SlickHList
          ]]
    )

    val model2: ModelF[({ type X1[_] = Shape[_ <: FlatShapeLevel, Rep[Any], Any, Rep[Any]] })#X1] =
      t1.asInstanceOf[ModelF[({ type X1[_] = Shape[_ <: FlatShapeLevel, Rep[Any], Any, Rep[Any]] })#X1]]

    toListFunc(model2)
  }

  def toRep(t1: ModelF[Rep]): SlickHList = {
    val toListFunc = toListGeneric.toListByTheSameType[Rep[Any], SlickHList](
      SlickHNil,
      (sum, each) => each :: sum
    )

    val model2: ModelF[({ type X1[_] = Rep[Any] })#X1] = t1.asInstanceOf[ModelF[({ type X1[_] = Rep[Any] })#X1]]

    toListFunc(model2)
  }

  def fromModel(m: ModelF[({ type IdImpl[T] = T })#IdImpl]): SlickHList = {
    val toListFunc = toListGeneric.toListByTheSameType[Any, SlickHList](
      SlickHNil,
      (sum, each) => each :: sum
    )

    val model2: ModelF[({ type X1[_] = Any })#X1] = m.asInstanceOf[ModelF[({ type X1[_] = Any })#X1]]
    toListFunc(model2)
  }

  def toModel(m: SlickHList): ModelF[({ type IdImpl[T] = T })#IdImpl] = {
    val fromListFunc = fromListByTheSameTypeGeneric.fromListByTheSameType[Any, SlickHList](
      t => t.asInstanceOf[SlickHCons[Any, SlickHList]].head,
      t => t.asInstanceOf[SlickHCons[Any, SlickHList]].tail
    )

    fromListFunc(m).asInstanceOf[ModelF[({ type IdImpl[T] = T })#IdImpl]]
  }
}
