package domain.model

case class Todo(id: Option[Int], title: String, completed: Boolean = false)
