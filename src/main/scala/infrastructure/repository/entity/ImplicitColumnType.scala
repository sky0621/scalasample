package infrastructure.repository.entity

import domain.model._
import slick.ast.BaseTypedType
import slick.jdbc.JdbcType
import slick.jdbc.MySQLProfile.api._

import java.sql.Date
import java.time.LocalDate

object ImplicitColumnType {
  implicit val workbookIdColumnType
      : JdbcType[WorkbookId] with BaseTypedType[WorkbookId] =
    MappedColumnType.base[WorkbookId, Long](
      _.value,
      WorkbookId
    )

  implicit val workbookContentIdColumnType
      : JdbcType[WorkbookContentId] with BaseTypedType[WorkbookContentId] =
    MappedColumnType.base[WorkbookContentId, Long](
      _.value,
      WorkbookContentId
    )
  implicit val workbookContentNameColumnType
      : JdbcType[WorkbookContentName] with BaseTypedType[WorkbookContentName] =
    MappedColumnType.base[WorkbookContentName, String](
      _.value,
      WorkbookContentName
    )

  implicit val workbookDeliveryIdColumnType
      : JdbcType[WorkbookDeliveryId] with BaseTypedType[WorkbookDeliveryId] =
    MappedColumnType.base[WorkbookDeliveryId, Long](
      _.value,
      WorkbookDeliveryId
    )

  implicit val workbookDeliveryTargetIdColumnType
      : JdbcType[WorkbookDeliveryTargetId]
        with BaseTypedType[WorkbookDeliveryTargetId] =
    MappedColumnType.base[WorkbookDeliveryTargetId, Long](
      _.value,
      WorkbookDeliveryTargetId
    )

  implicit val classroomIdColumnType
      : JdbcType[ClassroomId] with BaseTypedType[ClassroomId] =
    MappedColumnType.base[ClassroomId, Long](
      _.value,
      ClassroomId
    )

  implicit val groupIdColumnType
      : JdbcType[GroupId] with BaseTypedType[GroupId] =
    MappedColumnType.base[GroupId, Long](
      _.value,
      GroupId
    )

  implicit val emailColumnType: JdbcType[Email] with BaseTypedType[Email] =
    MappedColumnType.base[Email, String](
      _.value,
      Email
    )

  implicit val classroomNameColumnType
      : JdbcType[ClassroomName] with BaseTypedType[ClassroomName] =
    MappedColumnType.base[ClassroomName, String](
      _.value,
      ClassroomName
    )

  implicit val studentIdColumnType
      : JdbcType[StudentId] with BaseTypedType[StudentId] =
    MappedColumnType.base[StudentId, Long](
      _.value,
      StudentId
    )

  implicit val studentNameColumnType
      : JdbcType[StudentName] with BaseTypedType[StudentName] =
    MappedColumnType.base[StudentName, String](
      _.value,
      StudentName
    )

  implicit val teacherIdColumnType
      : JdbcType[TeacherId] with BaseTypedType[TeacherId] =
    MappedColumnType.base[TeacherId, Long](
      _.value,
      TeacherId
    )

  implicit val teacherNameColumnType
      : JdbcType[TeacherName] with BaseTypedType[TeacherName] =
    MappedColumnType.base[TeacherName, String](
      _.value,
      TeacherName
    )

  implicit val groupNameColumnType
      : JdbcType[GroupName] with BaseTypedType[GroupName] =
    MappedColumnType.base[GroupName, String](
      _.value,
      GroupName
    )

  implicit val localDateColumnType
      : JdbcType[LocalDate] with BaseTypedType[LocalDate] =
    MappedColumnType.base[LocalDate, Date](
      Date.valueOf,
      _.toLocalDate
    )
}
