package infrastructure.repository.entity

import domain.model._
import infrastructure.repository.entity.ImplicitColumnType._
import slick.jdbc.MySQLProfile.api._

final case class WorkbookDeliveryTargetRow(
    id: WorkbookDeliveryTargetId,
    classroomId: Option[ClassroomId],
    groupId: Option[GroupId],
    workbookDeliveryId: WorkbookDeliveryId
)

class WorkbookDeliveryTargets(tag: Tag)
    extends Table[WorkbookDeliveryTargetRow](tag, "workbook_delivery_targets") {
  def id = column[WorkbookDeliveryTargetId]("id", O.PrimaryKey, O.AutoInc)
  def classroomId = column[Option[ClassroomId]]("classroom_id")
  def groupId = column[Option[GroupId]]("group_id")
  def workbookDeliveryId = column[WorkbookDeliveryId]("workbook_delivery_id")
  def * = (
    id,
    classroomId,
    groupId,
    workbookDeliveryId
  ) <> (WorkbookDeliveryTargetRow.tupled, WorkbookDeliveryTargetRow.unapply)
  def classroom = foreignKey(
    "workbook_delivery_target_classroom_id",
    classroomId,
    Classrooms.query
  )(_.id.?)
  def group =
    foreignKey("workbook_delivery_target_group_id", groupId, Groups.query)(
      _.id.?
    )
  def workbookDelivery = foreignKey(
    "workbook_delivery_target_workbook_delivery_id",
    workbookDeliveryId,
    WorkbookDeliveries.query
  )(_.id)
}

object WorkbookDeliveryTargets {
  val query = TableQuery[WorkbookDeliveryTargets]
}
