package interface.controller

import interface.json.TodoJsonProtocol._
import org.apache.pekko.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import org.apache.pekko.http.scaladsl.model.StatusCodes
import org.apache.pekko.http.scaladsl.server.Directives._
import org.apache.pekko.http.scaladsl.server.Route
import usecase.{CreateTodoUseCase, GetTodoUseCase}
import wvlet.airframe._

class TodoController(
    getTodoUseCase: GetTodoUseCase,
    createTodoUseCase: CreateTodoUseCase
) {
  val route: Route = pathPrefix("todos") {
    get {
      complete {
        getTodoUseCase.execute()
      }
    } ~
      post {
        entity(as[String]) { title =>
          complete {
            val todo = createTodoUseCase.execute(title)
            (StatusCodes.Created, todo)
          }
        }
      }
  }
}

object TodoController {
  lazy val design = newDesign.bind[TodoController].toSingleton
}
