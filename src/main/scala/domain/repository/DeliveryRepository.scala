package domain.repository

import domain.model.Delivery

import scala.concurrent.Future

trait DeliveryRepository {
  def findByWorkbookId(workbookId: Long): Future[Seq[Delivery]]
  def save(delivery: Delivery): Future[Unit]
}
