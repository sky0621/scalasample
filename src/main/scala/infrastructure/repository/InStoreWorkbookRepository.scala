package infrastructure.repository

import domain.error.DomainError
import domain.model.{Workbook, WorkbookId}
import domain.repository.WorkbookRepository
import slick.jdbc.JdbcBackend.Database
import slick.lifted.ProvenShape

import scala.concurrent.{ExecutionContext, Future}

class InStoreWorkbookRepository(db: Database)(implicit ec: ExecutionContext)
    extends WorkbookRepository {
  import slick.jdbc.MySQLProfile.api._

  class Workbooks(tag: Tag) extends Table[Workbook](tag = "workbooks") {
    override def * : ProvenShape[Workbook] = ???
  }

  override def findAll(): Future[Seq[Workbook]] = ???

  override def findById(id: WorkbookId): Future[Either[DomainError, Workbook]] =
    ???

  override def save(workbook: Workbook): Future[Either[DomainError, Workbook]] =
    ???
}
