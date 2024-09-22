package domain.model

final case class Workbook(
    id: WorkbookId,
    contents: Seq[WorkbookContent],
    deliveries: Seq[WorkbookDelivery]
)

final case class WorkbookId(value: Long) extends AnyVal with Id
