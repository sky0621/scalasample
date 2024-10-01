package infrastructure.repository

import domain.model.Workbook
import domain.repository.WorkbookRepository
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.{ExecutionContext, Future}

class SlickWorkbookRepository(db: Database)(implicit ec: ExecutionContext)
    extends WorkbookRepository {
  class Workbooks(tag: Tag) extends Table[Workbook](tag, "workbooks") {
    def id = column[Long]("id", O.PrimaryKey)
    def title = column[String]("title")
    def * = (id, title).mapTo[Workbook]
  }

  val workbooks: TableQuery[Workbooks] = TableQuery[Workbooks]

  override def findById(id: Long): Future[Option[Workbook]] = {
    db.run(workbooks.filter(_.id === id).result.headOption)
  }

  override def save(workbook: Workbook): Future[Unit] = {
    db.run(workbooks.insertOrUpdate(workbook)).map(_ => ())
  }
}
