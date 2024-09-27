package infrastructure.repository.entity

import domain.model.{GroupId, GroupName}
import infrastructure.repository.entity.ImplicitColumnType._
import slick.jdbc.MySQLProfile.api._
import slick.lifted.Tag

final case class GroupRow(
    id: GroupId,
    name: GroupName
)

class Groups(tag: Tag) extends Table[GroupRow](tag, "groups") {
  def id = column[GroupId]("id", O.PrimaryKey, O.AutoInc)
  def name = column[GroupName]("name")
  def * = (id, name) <> (GroupRow.tupled, GroupRow.unapply)
}

object Groups {
  val query = TableQuery[Groups]
}
