import org.apache.pekko.actor.ActorSystem
import org.apache.pekko.http.scaladsl.Http

import scala.util.{Failure, Success}

object MainApp extends App {
  implicit val system = ActorSystem("my-system")
  implicit val ec = system.dispatcher

  val design = Module.design

  design.build[interface.controller.WorkbookController] { controller =>
    val bindingFuture =
      Http().newServerAt("localhost", 8080).bind(controller.route)

    bindingFuture.onComplete {
      case Success(binding) =>
        val address = binding.localAddress
        println(
          s"Server online at http://${address.getHostName}:${address.getPort}/"
        )
      case Failure(ex) =>
        println(
          s"Failed to bind HTTP endpoint, terminating system: ${ex.getMessage}"
        )
        system.terminate()
    }
  }
}
