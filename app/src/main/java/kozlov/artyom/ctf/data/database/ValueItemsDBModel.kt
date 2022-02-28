package kozlov.artyom.ctf.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "value_items")
data class ValueItemsDBModel(
    @PrimaryKey
    val id: String,
    val currency: String,
    val name: String,
    val nominal: Int,
    val value: Double,
    val percent: Double,
)
