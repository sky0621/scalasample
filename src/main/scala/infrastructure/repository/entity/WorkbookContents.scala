package infrastructure.repository.entity

import domain.model._
import infrastructure.repository.entity.ImplicitColumnType._
import slick.jdbc.MySQLProfile.api._
import slick.lifted.{ForeignKeyQuery, ProvenShape}

class WorkbookContents(tag: Tag)
    extends Table[WorkbookContent](tag, "workbook_contents") {
  def id: Rep[WorkbookContentId] =
    column[WorkbookContentId]("id", O.PrimaryKey, O.AutoInc)
  def title: Rep[WorkbookContentName] = column[WorkbookContentName]("title")
  def workbookId: Rep[WorkbookId] = column[WorkbookId]("workbook_id")

  def workbookFk: ForeignKeyQuery[Workbooks, Workbook] =
    foreignKey("workbook_content_workbook_id", workbookId, Workbooks.query)(
      _.id
    )

  override def * : ProvenShape[WorkbookContent] =
    (id, title, workbookId) <> (WorkbookContent.tupled, WorkbookContent.unapply)
}

object WorkbookContents {
  val query = TableQuery[WorkbookContents]
}
