package infrastructure.repository.entity

import domain.model.{Group, GroupId, GroupName}
import infrastructure.repository.entity.ImplicitColumnType._
import slick.jdbc.MySQLProfile.api._
import slick.lifted.{ProvenShape, Rep, Tag}

class Groups(tag: Tag) extends Table[Group](tag, "group") {
  def id: Rep[GroupId] = column[GroupId]("id", O.PrimaryKey, O.AutoInc)
  def name: Rep[GroupName] = column[GroupName]("name")

  def * : ProvenShape[Group] = (id, name) <> (Group.tupled, Group.unapply)
}

object Groups {
  val groups = TableQuery[Groups]
}
