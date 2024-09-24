package infrastructure.repository.entity

import domain.model._
import infrastructure.repository.entity.ImplicitColumnType.{localDateColumnType, _}
import slick.jdbc.MySQLProfile.api._
import slick.lifted.{ForeignKeyQuery, ProvenShape}

import java.time.LocalDate

class WorkbookDeliveries(tag: Tag)
    extends Table[WorkbookDelivery](tag, "workbook_deliveries") {
  def id: Rep[WorkbookDeliveryId] =
    column[WorkbookDeliveryId]("id", O.PrimaryKey, O.AutoInc)
  def from: Rep[LocalDate] = column[LocalDate]("from_date")
  def to: Rep[LocalDate] = column[LocalDate]("to_date")
  def workbookId: Rep[WorkbookId] = column[WorkbookId]("workbook_id")

  def workbookFk: ForeignKeyQuery[Workbooks, Workbook] =
    foreignKey(
      "workbook_delivery_workbook_id",
      workbookId,
      Workbooks.query
    )(_.id)

  def * : ProvenShape[WorkbookDelivery] = (id, from, to, workbookId) <> (
    (id, from, to, workbookId) =>
      WorkbookDelivery(id, from, to, workbookId, Seq.empty),
    (wd: WorkbookDelivery) => Some((wd.id, wd.from, wd.to, wd.workbookId))
  )
}

object WorkbookDeliveries {
  val query = TableQuery[WorkbookDeliveries]
}
