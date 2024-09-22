package infrastructure.repository

import domain.model.Todo
import domain.repository.TodoRepository
import wvlet.airframe.newDesign

import java.util.concurrent.atomic.AtomicInteger
import scala.collection.concurrent.TrieMap

class InMemoryTodoRepository extends TodoRepository {
  private val todos = TrieMap.empty[Int, Todo]
  private val idGenerator = new AtomicInteger(1)

  override def findAll(): Seq[Todo] = todos.values.toSeq

  override def findById(id: Int): Option[Todo] = todos.get(id)

  override def save(todo: Todo): Todo = {
    val id = idGenerator.getAndIncrement()
    val newTodo = todo.copy(id = Some(id))
    todos.put(id, newTodo)
    newTodo
  }
}

object InMemoryTodoRepository {
  lazy val design =
    newDesign.bind[TodoRepository].toSingletonOf[InMemoryTodoRepository]
}
