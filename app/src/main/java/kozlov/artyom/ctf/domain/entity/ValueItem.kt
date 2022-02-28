package kozlov.artyom.ctf.domain.entity

data class ValueItem(
    val id: String,
    val currency: String,
    val name: String,
    val nominal: Int,
    val value: Double,
    val percent: Double,

): ListMarker
