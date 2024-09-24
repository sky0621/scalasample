package infrastructure.repository

import domain.error.DomainError
import domain.model.{Workbook, WorkbookId}
import domain.repository.WorkbookRepository
import slick.jdbc.JdbcBackend.Database

import scala.concurrent.{ExecutionContext, Future}

class InStoreWorkbookRepository(db: Database)(implicit ec: ExecutionContext)
    extends WorkbookRepository {

  override def findAll(): Future[Seq[Workbook]] = db.run()

  override def findById(id: WorkbookId): Future[Either[DomainError, Workbook]] =
    ???

  override def save(workbook: Workbook): Future[Either[DomainError, Workbook]] =
    ???
}
