package infrastructure.repository.entity

import domain.model.{ClassroomId, ClassroomName}
import infrastructure.repository.entity.ImplicitColumnType._
import slick.jdbc.MySQLProfile.api._
import slick.lifted.Tag

final case class ClassroomRow(
    id: ClassroomId,
    name: ClassroomName
)

class Classrooms(tag: Tag) extends Table[ClassroomRow](tag, "classrooms") {
  def id = column[ClassroomId]("id", O.PrimaryKey, O.AutoInc)
  def name = column[ClassroomName]("name")
  def * = (id, name) <> (ClassroomRow.tupled, ClassroomRow.unapply)
}

object Classrooms {
  val query = TableQuery[Classrooms]
}
