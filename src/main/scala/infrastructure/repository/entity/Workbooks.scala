package infrastructure.repository.entity

import domain.model.{Workbook, WorkbookId}
import infrastructure.repository.entity.ImplicitColumnType._
import slick.jdbc.MySQLProfile.api._
import slick.lifted.ProvenShape

class Workbooks(tag: Tag) extends Table[Workbook](tag, "workbooks") {
  def id: Rep[WorkbookId] = column[WorkbookId]("id", O.PrimaryKey, O.AutoInc)

  override def * : ProvenShape[Workbook] = (id) <> (
    id => Workbook(id, Seq.empty, Seq.empty),
    (w: Workbook) => Some(w.id)
  )
}

object Workbooks {
  val query = TableQuery[Workbooks]
}
