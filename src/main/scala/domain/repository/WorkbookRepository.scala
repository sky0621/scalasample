package domain.repository

import domain.model.Workbook

import scala.concurrent.Future

trait WorkbookRepository {
  def findById(id: Long): Future[Option[Workbook]]
  def save(workbook: Workbook): Future[Unit]
}
