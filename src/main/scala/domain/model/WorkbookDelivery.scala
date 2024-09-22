package domain.model

final case class WorkbookDelivery(
    id: WorkbookDeliveryId,
    from: java.time.LocalDate,
    to: java.time.LocalDate,
    workbookId: WorkbookId,
    targets: Seq[WorkbookDeliveryTarget]
)

final case class WorkbookDeliveryId(value: Long) extends AnyVal with Id
