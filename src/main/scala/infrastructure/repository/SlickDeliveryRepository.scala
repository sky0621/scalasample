package infrastructure.repository

import domain.model.Delivery
import domain.repository.DeliveryRepository
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.{ExecutionContext, Future}

class SlickDeliveryRepository(db: Database)(implicit ec: ExecutionContext)
    extends DeliveryRepository {

  class Deliveries(tag: Tag) extends Table[Delivery](tag, "deliveries") {
    def id = column[Long]("id", O.PrimaryKey)
    def workbookId = column[Long]("workbook_id")
    def content = column[String]("content")
    def * =
      (id, workbookId, content) <> ((Delivery.apply _).tupled, Delivery.unapply)
  }

  val deliveries = TableQuery[Deliveries]

  override def findByWorkbookId(workbookId: Long): Future[Seq[Delivery]] = {
    db.run(deliveries.filter(_.workbookId === workbookId).result)
  }

  override def save(delivery: Delivery): Future[Unit] = {
    db.run(deliveries.insertOrUpdate(delivery)).map(_ => ())
  }
}
