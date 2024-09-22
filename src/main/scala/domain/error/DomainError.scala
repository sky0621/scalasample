package domain.error

import domain.model.Id

sealed trait DomainError

case class NotFoundError(id: Id) extends DomainError

case class UnexpectedError(e: Exception) extends DomainError
