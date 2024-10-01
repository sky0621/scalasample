package interface.controller

import domain.model.{Delivery, Workbook}
import org.apache.pekko.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import org.apache.pekko.http.scaladsl.marshalling.ToResponseMarshallable
import org.apache.pekko.http.scaladsl.model.StatusCodes
import org.apache.pekko.http.scaladsl.server.Directives._
import org.apache.pekko.http.scaladsl.server.{ExceptionHandler, Route}
import spray.json._
import usecase.GetWorkbookUseCase

import scala.concurrent.ExecutionContext

// JSON用のフォーマッタを定義
trait JsonSupport extends DefaultJsonProtocol {
  implicit val deliveryFormat: RootJsonFormat[Delivery] = jsonFormat3(
    domain.model.Delivery
  )
  implicit val workbookFormat: RootJsonFormat[Workbook] = jsonFormat3(
    domain.model.Workbook
  )
}

class WorkbookController(getWorkbookUseCase: GetWorkbookUseCase)(implicit
    ec: ExecutionContext
) extends JsonSupport
    with SprayJsonSupport {

  // エラーハンドラー
  implicit def myExceptionHandler: ExceptionHandler =
    ExceptionHandler { case ex: Exception =>
      extractUri { uri =>
        complete(
          StatusCodes.InternalServerError,
          s"エラーが発生しました: ${ex.getMessage}"
        )
      }
    }

  val route: Route =
    handleExceptions(myExceptionHandler) {
      pathPrefix("workbooks" / LongNumber) { id =>
        get {
          onComplete(getWorkbookUseCase.execute(id)) {
            case scala.util.Success(Some(workbook)) =>
              complete(ToResponseMarshallable(workbook.toJson))
            case scala.util.Success(None) =>
              complete(StatusCodes.NotFound, "Workbook not found")
            case scala.util.Failure(ex) =>
              complete(
                StatusCodes.InternalServerError,
                s"エラーが発生しました: ${ex.getMessage}"
              )
          }
        }
      }
    }
}
