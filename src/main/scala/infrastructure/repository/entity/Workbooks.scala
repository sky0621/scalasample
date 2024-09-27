package infrastructure.repository.entity

import domain.model.WorkbookId
import infrastructure.repository.entity.ImplicitColumnType._
import slick.jdbc.MySQLProfile.api._

final case class WorkbookRow(id: WorkbookId)

class Workbooks(tag: Tag) extends Table[WorkbookRow](tag, "workbooks") {
  def id = column[WorkbookId]("id", O.PrimaryKey, O.AutoInc)
  def * = (id) <> (WorkbookRow, WorkbookRow.unapply)
}

object Workbooks {
  val query = TableQuery[Workbooks]
}
