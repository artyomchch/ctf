package kozlov.artyom.ctf.domain.entity

sealed class DataModel {

    data class Value(
        val id: String,
        val currency: String,
        val name: String,
        val nominal: Int,
        val value: Double,
        val percent: Double,
    ) : DataModel()

    data class Info(
        val info: String
    )  : DataModel()

}