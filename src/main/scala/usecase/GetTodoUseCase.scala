package usecase

import domain.model.Todo
import domain.repository.TodoRepository
import wvlet.airframe.newDesign

trait GetTodoUseCase {
  def execute(): Seq[Todo]
}

object GetTodoUseCase {
  lazy val design = newDesign.bind[GetTodoUseCase].to[GetTodoUseCaseImpl]
}

class GetTodoUseCaseImpl(todoRepository: TodoRepository)
    extends GetTodoUseCase {
  override def execute(): Seq[Todo] = todoRepository.findAll()
}
