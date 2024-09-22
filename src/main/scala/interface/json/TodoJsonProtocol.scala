package interface.json

import domain.model.Todo
import spray.json._

object TodoJsonProtocol extends DefaultJsonProtocol {
  implicit val todoFormat: RootJsonFormat[Todo] = jsonFormat3(Todo)
}
