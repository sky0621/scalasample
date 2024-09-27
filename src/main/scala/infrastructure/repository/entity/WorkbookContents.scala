package infrastructure.repository.entity

import domain.model._
import infrastructure.repository.entity.ImplicitColumnType._
import slick.jdbc.MySQLProfile.api._

final case class WorkbookContentRow(
    id: WorkbookContentId,
    title: WorkbookContentName,
    workbookId: WorkbookId
)

class WorkbookContents(tag: Tag)
    extends Table[WorkbookContentRow](tag, "workbook_contents") {
  def id = column[WorkbookContentId]("id", O.PrimaryKey, O.AutoInc)
  def title = column[WorkbookContentName]("title")
  def workbookId = column[WorkbookId]("workbook_id")
  def * = (
    id,
    title,
    workbookId
  ) <> (WorkbookContentRow.tupled, WorkbookContentRow.unapply)
  def workbook =
    foreignKey("workbook_content_workbook_id", workbookId, Workbooks.query)(
      _.id
    )
}

object WorkbookContents {
  val query = TableQuery[WorkbookContents]
}
