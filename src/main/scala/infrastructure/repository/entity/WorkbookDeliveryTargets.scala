package infrastructure.repository.entity

import domain.model._
import infrastructure.repository.entity.ImplicitColumnType._
import slick.jdbc.MySQLProfile.api._
import slick.lifted.ProvenShape

class WorkbookDeliveryTargets(tag: Tag)
    extends Table[WorkbookDeliveryTarget](tag, "workbook_delivery_targets") {
  def id: Rep[WorkbookDeliveryTargetId] =
    column[WorkbookDeliveryTargetId]("id", O.PrimaryKey, O.AutoInc)
  def classroomId: Rep[Option[ClassroomId]] =
    column[Option[ClassroomId]]("classroom_id")
  def groupId: Rep[Option[GroupId]] = column[Option[GroupId]]("group_id")
  def workbookDeliveryId: Rep[WorkbookDeliveryId] =
    column[WorkbookDeliveryId]("workbook_delivery_id")

  def * : ProvenShape[WorkbookDeliveryTarget] =
    (id, classroomId, groupId, workbookDeliveryId) <> ({
      (id, classroomId, groupId, workbookDeliveryId) =>
        WorkbookDeliveryTarget(id, classroomId, groupId, workbookDeliveryId)
    }, { wdt: WorkbookDeliveryTarget =>
      Some(
        (
          wdt.id,
          wdt.classroom.map {
            case Some(c) => c.id
            case _       => 0
          },
          wdt.group.map(g => g.id),
          wdt.workbookDeliveryId
        )
      )
    })

  def workbookDelivery = foreignKey(
    "fk_wdt_workbook_delivery",
    workbookDeliveryId,
    WorkbookDeliveries.query
  )(_.id)
}

object WorkbookDeliveryTargets {
  val query = TableQuery[WorkbookDeliveryTargets]
}
