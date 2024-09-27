package domain.model

final case class Classroom(
    id: ClassroomId,
    name: ClassroomName,
    teacher: Teacher,
    students: Seq[Student]
)

final case class ClassroomId(value: Long) extends AnyVal with Id

final case class ClassroomName(value: String) extends AnyVal
