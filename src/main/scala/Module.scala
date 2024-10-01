import domain.repository._
import infrastructure.repository._
import interface.controller.WorkbookController
import slick.jdbc.MySQLProfile.api._
import wvlet.airframe._

import scala.concurrent.ExecutionContext

object Module {
  val design: DesignWithContext[WorkbookController] = newDesign
    .bind[Database]
    .toInstance(Database.forConfig("mydb"))
    .bind[ExecutionContext]
    .toInstance(scala.concurrent.ExecutionContext.global)
    .bind[WorkbookRepository]
    .to[SlickWorkbookRepository]
    .bind[DeliveryRepository]
    .to[SlickDeliveryRepository]
    .bind[usecase.GetWorkbookUseCase]
    .toSingleton
    .bind[interface.controller.WorkbookController]
    .toSingleton
}
