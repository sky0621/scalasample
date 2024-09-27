package infrastructure.repository.entity

import domain.model._
import slick.jdbc.MySQLProfile.api._

import java.time.LocalDate

object ImplicitColumnType {
  implicit val workbookIdColumnType: BaseColumnType[WorkbookId] =
    MappedColumnType.base[WorkbookId, Long](
      _.value,
      WorkbookId
    )

  implicit val workbookContentIdColumnType: BaseColumnType[WorkbookContentId] =
    MappedColumnType.base[WorkbookContentId, Long](
      _.value,
      WorkbookContentId
    )

  implicit val workbookContentNameColumnType
      : BaseColumnType[WorkbookContentName] =
    MappedColumnType.base[WorkbookContentName, String](
      _.value,
      WorkbookContentName
    )

  implicit val workbookDeliveryIdColumnType
      : BaseColumnType[WorkbookDeliveryId] =
    MappedColumnType.base[WorkbookDeliveryId, Long](
      _.value,
      WorkbookDeliveryId
    )

  implicit val workbookDeliveryTargetIdColumnType
      : BaseColumnType[WorkbookDeliveryTargetId] =
    MappedColumnType.base[WorkbookDeliveryTargetId, Long](
      _.value,
      WorkbookDeliveryTargetId
    )

  implicit val classroomIdColumnType: BaseColumnType[ClassroomId] =
    MappedColumnType.base[ClassroomId, Long](
      _.value,
      ClassroomId
    )

  implicit val classroomNameColumnType: BaseColumnType[ClassroomName] =
    MappedColumnType.base[ClassroomName, String](
      _.value,
      ClassroomName
    )

  implicit val groupIdColumnType: BaseColumnType[GroupId] =
    MappedColumnType.base[GroupId, Long](
      _.value,
      GroupId
    )

  implicit val groupNameColumnType: BaseColumnType[GroupName] =
    MappedColumnType.base[GroupName, String](
      _.value,
      GroupName
    )

  implicit val localDateColumnType: BaseColumnType[LocalDate] =
    MappedColumnType.base[LocalDate, java.sql.Date](
      { localDate => java.sql.Date.valueOf(localDate) },
      { sqlDate => sqlDate.toLocalDate }
    )
}
