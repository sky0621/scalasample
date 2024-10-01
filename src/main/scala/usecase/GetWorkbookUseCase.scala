package usecase

import domain.model.Workbook
import domain.repository.{DeliveryRepository, WorkbookRepository}

import scala.concurrent.{ExecutionContext, Future}

class GetWorkbookUseCase(
    workbookRepository: WorkbookRepository,
    deliveryRepository: DeliveryRepository
)(implicit ec: ExecutionContext) {
  def execute(id: Long): Future[Option[Workbook]] = {
    workbookRepository.findById(id).flatMap {
      case Some(workbook) =>
        deliveryRepository.findByWorkbookId(id).map { deliveries =>
          Some(workbook.copy(deliveries = deliveries))
        }
      case None =>
        Future.successful(None)
    }
  }
}
