package domain.repository

import domain.error.DomainError
import domain.model.{Workbook, WorkbookId}

import scala.concurrent.Future

trait WorkbookRepository {
  def findAll(): Future[Seq[Workbook]]
  def findById(id: WorkbookId): Future[Either[DomainError, Workbook]]
  def save(workbook: Workbook): Future[Either[DomainError, Workbook]]
}
