package domain.model

//final case class Group(id: GroupId, name: GroupName, students: Seq[Student])
final case class Group(id: GroupId, name: GroupName)

final case class GroupId(value: Long) extends AnyVal with Id

final case class GroupName(value: String) extends AnyVal
