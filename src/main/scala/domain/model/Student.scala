package domain.model

final case class Student(
    id: StudentId,
    name: StudentName,
    classroomId: ClassroomId,
    groupId: Option[GroupId]
)

final case class StudentId(value: Long) extends AnyVal with Id

final case class StudentName(value: String) extends AnyVal
