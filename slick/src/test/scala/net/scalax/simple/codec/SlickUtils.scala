package net.scalax.simple.codec
package aa

import net.scalax.simple.codec.product.core.Map0Generic
import net.scalax.simple.codec.to_list_generic.{BasedInstalledLabelled, BasedInstalledSimpleProduct, GenericAuxFrom, ModelLink, Packager}
import slick.ast.{ColumnOption, TypedType}
import slick.jdbc.JdbcProfile
import net.scalax.simple.codec.product.core.PojoProjection

trait SlickUtils[V <: JdbcProfile] extends UtilsWrap[V] {
  val slickProfile: V

  import slickProfile.api._

  abstract class CommonTable[F[_[_]], Model](_tableTag: Tag, _schemaName: Option[String], _tableName: String)(implicit
    classTag: scala.reflect.ClassTag[Model],
    modelGet: ModelGet[F, Model],
    modelSet: ModelSet[F, Model],
    fmodelGet: GenericAuxFrom[F],
    basedInstalled: BasedInstalledSimpleProduct[F],
    basedInstalledlabelled: BasedInstalledLabelled[F]
  ) extends Table[Model](_tableTag = _tableTag, _schemaName = _schemaName, _tableName = _tableName) {
    CommonTableSelf =>

    def this(_tableTag: Tag, _tableName: String)(implicit
      classTag: scala.reflect.ClassTag[Model],
      modelGet: ModelGet[F, Model],
      modelSet: ModelSet[F, Model],
      fmodelGet: GenericAuxFrom[F],
      basedInstalled: BasedInstalledSimpleProduct[F],
      basedInstalledlabelled: BasedInstalledLabelled[F]
    ) = this(_tableTag = _tableTag, _schemaName = None, _tableName = _tableName)

    type Columns = F[Rep]

    def columnName: F[CodecUtils.Labelled] = basedInstalledlabelled.labelled.stringLabelled
    def columnOption: F[CodecUtils.ColOpt] = Map0Generic[F]
      .derived(basedInstalled.simpleRunner.simpleRelease1)
      .map[CodecUtils.ColOpt](new Map0Generic.MapFunction[CodecUtils.ColOpt] {
        override def func[T]: Seq[ColumnOption[T]] = Seq.empty
      })

    def typedType: F[TypedType]
    def shapeCol: F[CodecUtils.ShapeF]

    def rep: Columns = CodecUtils.userRep(basedInstalled.simpleRunner.simpleRelease4, columnName, columnOption, typedType, CommonTableSelf)

    override def * : slick.lifted.ProvenShape[Model] =
      CodecUtils.mapShape(basedInstalled, shapeCol, rep, classTag, modelGet, modelSet, fmodelGet = fmodelGet)
  }

  abstract class CommonTableF[F[_[_]]](_tableTag: Tag, _schemaName: Option[String], _tableName: String)(implicit
    classTag: scala.reflect.ClassTag[F[CodecUtils.Id]],
    modelLink: ModelLink.F[F]
  ) extends CommonTable[F, F[CodecUtils.Id]](_tableTag = _tableTag, _schemaName = _schemaName, _tableName = _tableName) {
    CommonTableSelf =>

    def this(_tableTag: Tag, _tableName: String)(implicit
      classTag: scala.reflect.ClassTag[F[CodecUtils.Id]],
      modelLink: ModelLink.F[F]
    ) = this(_tableTag = _tableTag, _schemaName = None, _tableName = _tableName)

    def typedTypeBuilder: Packager.ModelFBuilder[F[TypedType]]     = Packager.F[TypedType, F]
    def shapeBuilder: Packager.ModelFBuilder[F[CodecUtils.ShapeF]] = Packager.F[CodecUtils.ShapeF, F]

  }

  abstract class CommonTablePojo[Model](_tableTag: Tag, _schemaName: Option[String], _tableName: String)(implicit
    classTag: scala.reflect.ClassTag[Model],
    modelLink: ModelLink.Pojo[Model]
  ) extends CommonTable[({ type PojoF[XU[_]] = PojoProjection[XU, Model] })#PojoF, Model](
        _tableTag = _tableTag,
        _schemaName = _schemaName,
        _tableName = _tableName
      ) {
    CommonTableSelf =>

    def this(_tableTag: Tag, _tableName: String)(implicit
      classTag: scala.reflect.ClassTag[Model],
      modelLink: ModelLink.Pojo[Model]
    ) = this(_tableTag = _tableTag, _schemaName = None, _tableName = _tableName)

    def typedTypeBuilder: Packager.ModelPojoBuilder[TypedType, Model]     = Packager.Pojo[TypedType, Model]
    def shapeBuilder: Packager.ModelPojoBuilder[CodecUtils.ShapeF, Model] = Packager.Pojo[CodecUtils.ShapeF, Model]

  }

}
