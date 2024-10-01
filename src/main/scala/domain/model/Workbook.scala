package domain.model

case class Workbook(
    id: Long,
    title: String,
    deliveries: Seq[Delivery] = Seq.empty[Delivery]
)
