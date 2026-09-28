package net.scalax.simple.codec

import net.scalax.simple.adt.nat.support.v5.AppenderSupport1
import net.scalax.simple.codec.product.core.{Fold2Generic, Map3Generic}
import net.scalax.simple.codec.to_list_generic.BasedInstalledSimpleProduct
import slick.ast.{ColumnOption, TypedType}
import slick.jdbc.JdbcProfile
import slick.lifted.ShapedValue

trait UtilsWrap[V <: JdbcProfile] {
  val slickProfile: V
  import slickProfile.api._

  object CodecUtils {
    type ShapeF[T]   = Shape[_ <: FlatShapeLevel, Rep[T], T, Rep[T]]
    type Id[T]       = T
    type Labelled[T] = String
    type ColOpt[T]   = Seq[ColumnOption[T]]

    def mapShape[F[_[_]], Model](
      bi: BasedInstalledSimpleProduct[F],
      shapeModel: F[ShapeF],
      repModel: F[Rep],
      cst: scala.reflect.ClassTag[Model],
      modelGet: ModelGet[F, Model],
      modelSet: ModelSet[F, Model],
      fmodelGet: FModelGet[F],
      fmodelSet: FModelSet[F]
    ): slick.lifted.MappedProjection[Model] = {
      val folde2Generic: Fold2Generic[F] = Fold2Generic[F].derived(bi.simpleRunner.simpleRelease2)
      val foldFunc                       = new Fold2Generic.Folder[Rep, ShapeF, ShapedValueCompat.RepAdd] {
        override def fold[T](
          rep: Rep[T],
          shape: Shape[_ <: FlatShapeLevel, Rep[T], T, Rep[T]],
          add: ShapedValueCompat.RepAdd
        ): ShapedValueCompat.RepAdd = ShapedValueCompat.RepAdd.cons[T](rep, shape, add)

        override def zero: ShapedValueCompat.RepAdd = ShapedValueCompat.RepAdd.zero
      }
      val repAdd: ShapedValueCompat.RepAdd = folde2Generic.foldRight(repModel, shapeModel, foldFunc)

      ShapedValueCompat.mapToPro[repAdd.RepType, repAdd.ModelType, Model](
        ShapedValue(repAdd.rep, repAdd.shape),
        from = (model: Model) =>
          repAdd.fromShapeless(fmodelSet.FToHList[Id](modelGet.toIdentity(model)).asInstanceOf[repAdd.ShapelessModelType]),
        to = (h: repAdd.ModelType) => modelSet.fromIdentity(fmodelGet.FFromHList[Id](repAdd.toShapeless(h))),
        modelClassTag = cst
      )
    }

    def userRep[F[_[_]], Model](
      bs: AppenderSupport1.Simple4.Release[F],
      labelled: F[Labelled],
      colOpt: F[ColOpt],
      typedType: F[TypedType],
      tb: Table[Model]
    ): F[Rep] = {
      val mep3Generic: Map3Generic[F]                                        = Map3Generic[F].derived(bs)
      val mapFunc: Map3Generic.MapFunction[Labelled, ColOpt, TypedType, Rep] =
        new Map3Generic.MapFunction[Labelled, ColOpt, TypedType, Rep] {
          override def func[X1](colName: String, colOpts: Seq[ColumnOption[X1]], typedType: TypedType[X1]): Rep[X1] =
            tb.column[X1](colName, colOpts: _*)(typedType)
        }

      val func: (F[Labelled], F[ColOpt], F[TypedType]) => F[Rep] = mep3Generic.map[Labelled, ColOpt, TypedType, Rep](mapFunc)

      func(labelled, colOpt, typedType)
    }

  }

  /*import slick.collection.heterogeneous.HList.{HListShape => SlickHListShape}
  import slick.collection.heterogeneous.{HCons => SlickHCons, HList => SlickHList, HNil => SlickHNil}
  import slick.lifted.{FlatShapeLevel, Rep, Shape}

  private object helperUtils {

    type ShapeF[T] = Shape[_ <: FlatShapeLevel, Rep[T], T, Rep[T]]

    def toShape[ModelF[_[_]]](
      t1: ModelF[ShapeF],
      toListGeneric: ToListByTheSameTypeGeneric[ModelF]
    ): SlickHListShape[FlatShapeLevel, SlickHList, SlickHList, SlickHList] = {
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

    def toRep[ModelF[_[_]]](t1: ModelF[Rep], toListGeneric: ToListByTheSameTypeGeneric[ModelF]): SlickHList = {
      val toListFunc = toListGeneric.toListByTheSameType[Rep[Any], SlickHList](
        SlickHNil,
        (sum, each) => each :: sum
      )

      val model2: ModelF[({ type X1[_] = Rep[Any] })#X1] = t1.asInstanceOf[ModelF[({ type X1[_] = Rep[Any] })#X1]]

      toListFunc(model2)
    }

    def fromModel[ModelF[_[_]]](
      m: ModelF[({ type IdImpl[T] = T })#IdImpl],
      toListGeneric: ToListByTheSameTypeGeneric[ModelF]
    ): SlickHList = {
      val toListFunc = toListGeneric.toListByTheSameType[Any, SlickHList](
        SlickHNil,
        (sum, each) => each :: sum
      )

      val model2: ModelF[({ type X1[_] = Any })#X1] = m.asInstanceOf[ModelF[({ type X1[_] = Any })#X1]]
      toListFunc(model2)
    }

    def toModel[ModelF[_[_]]](
      m: SlickHList,
      fromListByTheSameTypeGeneric: FromListByTheSameTypeGeneric[ModelF]
    ): ModelF[({ type IdImpl[T] = T })#IdImpl] = {
      val fromListFunc = fromListByTheSameTypeGeneric.fromListByTheSameType[Any, SlickHList](
        t => t.asInstanceOf[SlickHCons[Any, SlickHList]].head,
        t => t.asInstanceOf[SlickHCons[Any, SlickHList]].tail
      )
      fromListFunc(m).asInstanceOf[ModelF[({ type IdImpl[T] = T })#IdImpl]]
    }
  }*/
}
