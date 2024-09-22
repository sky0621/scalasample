package domain.model

final case class WorkbookDeliveryTarget(
    id: WorkbookDeliveryTargetId,
    classroom: Option[Classroom],
    group: Option[Group],
    workbookDeliveryId: WorkbookDeliveryId
)

final case class WorkbookDeliveryTargetId(value: Long) extends AnyVal with Id
