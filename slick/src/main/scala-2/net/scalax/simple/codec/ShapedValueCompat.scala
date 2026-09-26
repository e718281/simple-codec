package net.scalax.simple.codec

import slick.collection.heterogeneous.HList.HListShape
import slick.lifted.{FlatShapeLevel, MappedProjection, Rep, Shape, ShapedValue}

object ShapedValueCompat {
  def mapToPro[T, U, Model](
    sv: ShapedValue[T, U],
    from: Model => U,
    to: U => Model,
    modelClassTag: scala.reflect.ClassTag[Model]
  ): MappedProjection[Model] = {
    sv.<>[Model](f = to, g = from.andThen(Some.apply))(modelClassTag)
  }

  trait RepAdd {
    type RepType <: slick.collection.heterogeneous.HList
    type ModelType <: slick.collection.heterogeneous.HList
    type ShapelessModelType <: shapeless.HList
    val rep: RepType
    def shape: HListShape[_ <: FlatShapeLevel, RepType, ModelType, RepType]
    def toShapeless(slickHList: ModelType): ShapelessModelType
    def fromShapeless(smt: ShapelessModelType): ModelType
  }
  object RepAdd {
    val zero: RepAdd = new RepAdd {
      override type RepType            = slick.collection.heterogeneous.HNil.type
      override type ModelType          = slick.collection.heterogeneous.HNil.type
      override type ShapelessModelType = shapeless.HNil
      override val rep: slick.collection.heterogeneous.HNil.type = slick.collection.heterogeneous.HNil
      override def shape: HListShape[
        _ <: FlatShapeLevel,
        slick.collection.heterogeneous.HNil.type,
        slick.collection.heterogeneous.HNil.type,
        slick.collection.heterogeneous.HNil.type
      ] = slick.collection.heterogeneous.HList.hnilShape
      override def toShapeless(slickHList: slick.collection.heterogeneous.HNil.type): shapeless.HNil = shapeless.HNil
      override def fromShapeless(smt: shapeless.HNil): slick.collection.heterogeneous.HNil.type      = slick.collection.heterogeneous.HNil
    }

    def cons[T](rep: Rep[T], shape: Shape[_ <: FlatShapeLevel, Rep[T], T, Rep[T]], tail: RepAdd): RepAdd = {
      val rep1   = rep
      val shape1 = shape
      new RepAdd {
        override type RepType            = slick.collection.heterogeneous.HCons[Rep[T], tail.RepType]
        override type ModelType          = slick.collection.heterogeneous.HCons[T, tail.ModelType]
        override type ShapelessModelType = shapeless.::[T, tail.ShapelessModelType]
        override val rep: RepType = new slick.collection.heterogeneous.HCons(rep1, tail.rep)
        override def shape: HListShape[_ <: FlatShapeLevel, RepType, ModelType, RepType] =
          slick.collection.heterogeneous.HList.hconsShape(shape1, tail.shape)
        override def toShapeless(slickHList: ModelType): ShapelessModelType =
          shapeless.::(slickHList.head, tail.toShapeless(slickHList.tail))
        override def fromShapeless(smt: ShapelessModelType): ModelType =
          new slick.collection.heterogeneous.HCons(smt.head, tail.fromShapeless(smt.tail))
      }
    }
  }

}
