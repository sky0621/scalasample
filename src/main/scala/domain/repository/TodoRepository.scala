package domain.repository

import domain.model.Todo

trait TodoRepository {
  def findAll(): Seq[Todo]
  def findById(id: Int): Option[Todo]
  def save(todo: Todo): Todo
}
