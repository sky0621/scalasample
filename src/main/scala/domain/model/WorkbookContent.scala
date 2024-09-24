package domain.model

final case class WorkbookContent(
    id: WorkbookContentId,
    title: WorkbookContentName,
    workbookId: WorkbookId
)

final case class WorkbookContentId(value: Long) extends AnyVal with Id

final case class WorkbookContentName(value: String) extends AnyVal
