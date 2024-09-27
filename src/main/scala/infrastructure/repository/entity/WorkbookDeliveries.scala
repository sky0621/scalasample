package infrastructure.repository.entity

import domain.model._
import infrastructure.repository.entity.ImplicitColumnType._
import slick.jdbc.MySQLProfile.api._

import java.time.LocalDate

final case class WorkbookDeliveryRow(
    id: WorkbookDeliveryId,
    from: LocalDate,
    to: LocalDate,
    workbookId: WorkbookId
)

class WorkbookDeliveries(tag: Tag)
    extends Table[WorkbookDeliveryRow](tag, "workbook_deliveries") {
  def id = column[WorkbookDeliveryId]("id", O.PrimaryKey, O.AutoInc)
  def from = column[java.sql.Date]("from")
  def to = column[java.sql.Date]("to")
  def workbookId = column[WorkbookId]("workbook_id")
  def * = (id, from, to, workbookId) <> ({
    case (id, fromDate, toDate, workbookId) =>
      WorkbookDeliveryRow(
        id,
        fromDate.toLocalDate,
        toDate.toLocalDate,
        workbookId
      )
  }, { row: WorkbookDeliveryRow =>
    Some(
      (
        row.id,
        java.sql.Date.valueOf(row.from),
        java.sql.Date.valueOf(row.to),
        row.workbookId
      )
    )
  })
  def workbook =
    foreignKey("workbook_delivery_workbook_id", workbookId, Workbooks.query)(
      _.id
    )
}

object WorkbookDeliveries {
  val query = TableQuery[WorkbookDeliveries]
}
