package net.scalax.simple.codec

import net.scalax.simple.adt.nat.support.{ABCFunc, FromToFunc}
import net.scalax.simple.adt.nat.support.v5.AppenderSupport1
import net.scalax.simple.codec.to_list_generic.{
  BasedInstalledLabelled,
  BasedInstalledSimpleProduct,
  Fold1FGenerc,
  PojoInstance,
  ToListByTheSameTypeGeneric
}
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
      modelSet: ModelSet[F, Model]
    ): slick.lifted.MappedProjection[Model] = {
      val folderGeneric: Fold1FGenerc[F]                                = Fold1FGenerc[F].derived(bi.simpleRunner.simpleRelease1)
      val toListGeneric: ToListByTheSameTypeGeneric[F]                  = ToListByTheSameTypeGeneric[F].derived(folderGeneric)
      val fromListByTheSameTypeGeneric: FromListByTheSameTypeGeneric[F] =
        FromListByTheSameTypeGeneric[F].derived(bi.simpleRunner.simpleRelease1)

      import slick.collection.heterogeneous.{HList => SlickHList}
      val shapedValue: ShapedValue[SlickHList, SlickHList] =
        anyToShapedValue(helperUtils.toRep[F](repModel, toListGeneric))(helperUtils.toShape(shapeModel, toListGeneric))

      val from1: F[Id] => SlickHList = fId => helperUtils.fromModel[F](fId, toListGeneric)
      val to1: SlickHList => F[Id]   = hlist => helperUtils.toModel[F](hlist, fromListByTheSameTypeGeneric)

      ShapedValueCompat.mapToPro[SlickHList, SlickHList, Model](
        shapedValue,
        from1.compose(modelGet.toIdentity),
        to1.andThen(modelSet.fromIdentity),
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
      type TypeFunc4[A, B, C, D] = (A, B, C) => D

      val appender = new AppenderSupport1.Simple4.Appender[TypeFunc4, Labelled, ColOpt, TypedType, Rep] {
        override def append[T, B1, B2, B3, B4, C1, C2, C3, C4](
          abc1: ABCFunc[String, B1, C1],
          abc2: ABCFunc[Seq[ColumnOption[T]], B2, C2],
          abc3: ABCFunc[TypedType[T], B3, C3],
          abc4: ABCFunc[Rep[T], B4, C4],
          ma: (B1, B2, B3) => B4
        ): (C1, C2, C3) => C4 = (c1: C1, c2: C2, c3: C3) => {
          val str1: String                 = abc1.takeHead(c1)
          val b1: B1                       = abc1.takeTail(c1)
          val colOpt: Seq[ColumnOption[T]] = abc2.takeHead(c2)
          val b2: B2                       = abc2.takeTail(c2)
          val typedType: TypedType[T]      = abc3.takeHead(c3)
          val b3: B3                       = abc3.takeTail(c3)
          val b4: B4                       = ma(b1, b2, b3)
          val repT: Rep[T]                 = tb.column[T](str1, colOpt: _*)(typedType)

          abc4.append(repT, b4)
        }
      }

      val one: AppenderSupport1.Simple4.One[TypeFunc4, Labelled, ColOpt, TypedType, Rep] =
        new AppenderSupport1.Simple4.One[TypeFunc4, Labelled, ColOpt, TypedType, Rep] {
          override def one[T, B1, B2, B3, B4](
            func1: FromToFunc[String, B1],
            func2: FromToFunc[Seq[ColumnOption[T]], B2],
            func3: FromToFunc[TypedType[T], B3],
            func4: FromToFunc[Rep[T], B4]
          ): (B1, B2, B3) => B4 = (b1: B1, b2: B2, b3: B3) => {
            val str1: String                 = func1.to(b1)
            val colOpt: Seq[ColumnOption[T]] = func2.to(b2)
            val typedType: TypedType[T]      = func3.to(b3)
            val repT: Rep[T]                 = tb.column[T](str1, colOpt: _*)(typedType)

            func4.from(repT)
          }
        }

      val func: (F[Labelled], F[ColOpt], F[TypedType]) => F[Rep] =
        bs.append[TypeFunc4, Labelled, ColOpt, TypedType, Rep](appender = appender, zero = one)

      func(labelled, colOpt, typedType)
    }

  }

  import slick.collection.heterogeneous.HList.{HListShape => SlickHListShape}
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
  }
}
