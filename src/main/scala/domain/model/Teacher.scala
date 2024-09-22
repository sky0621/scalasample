package domain.model

final case class Teacher(id: TeacherId, name: TeacherName, email: Email)

final case class TeacherId(value: Long) extends AnyVal with Id

final case class TeacherName(value: String) extends AnyVal
