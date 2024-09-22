import infrastructure.repository.InMemoryTodoRepository
import interface.controller.TodoController
import org.apache.pekko.actor.ActorSystem
import org.apache.pekko.stream.Materializer
import usecase.{CreateTodoUseCase, GetTodoUseCase}
import wvlet.airframe._

object MainApp extends App {
  implicit val system: ActorSystem = ActorSystem("TodoApp")
  implicit val materializer: Materializer = Materializer(system)

  val design = newDesign
    .bind[ActorSystem]
    .toInstance(system)
    .bind[Materializer]
    .toInstance(materializer)
    .add(InMemoryTodoRepository.design)
    .add(GetTodoUseCase.design)
    .add(CreateTodoUseCase.design)
    .add(TodoController.design)

  design.build[Server] { server =>
    server.start()
  }
}

class Server(todoController: TodoController)(implicit
    system: ActorSystem,
    materializer: Materializer
) {
  import org.apache.pekko.http.scaladsl.Http
  import system.dispatcher

  def start(): Unit = {
    val bindingFuture =
      Http().newServerAt("localhost", 8080).bind(todoController.route)
    println("サーバーはhttp://localhost:8080/ で起動しています。")
    sys.addShutdownHook {
      bindingFuture
        .flatMap(_.unbind())
        .onComplete(_ => system.terminate())
    }
  }
}
