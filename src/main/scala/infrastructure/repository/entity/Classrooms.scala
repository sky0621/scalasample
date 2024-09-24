package infrastructure.repository.entity

import domain.model.{Classroom, ClassroomId, ClassroomName}
import infrastructure.repository.entity.ImplicitColumnType._
import slick.jdbc.MySQLProfile.api._
import slick.lifted.{ProvenShape, Rep, Tag}

class Classrooms(tag: Tag) extends Table[Classroom](tag, "classroom") {
  def id: Rep[ClassroomId] = column[ClassroomId]("id", O.PrimaryKey, O.AutoInc)
  def name: Rep[ClassroomName] = column[ClassroomName]("name")

  def * : ProvenShape[Classroom] =
    (id, name) <> (Classroom.tupled, Classroom.unapply)
}

object Classrooms {
  val classrooms = TableQuery[Classrooms]
}
