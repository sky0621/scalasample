package usecase

import domain.model.Todo
import domain.repository.TodoRepository
import wvlet.airframe.newDesign

trait CreateTodoUseCase {
  def execute(title: String): Todo
}

object CreateTodoUseCase {
  lazy val design = newDesign.bind[CreateTodoUseCase].to[CreateTodoUseCaseImpl]
}

class CreateTodoUseCaseImpl(todoRepository: TodoRepository)
    extends CreateTodoUseCase {
  override def execute(title: String): Todo = {
    val todo = Todo(None, title)
    todoRepository.save(todo)
  }
}
