package kozlov.artyom.ctf.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ValueListDao {

    @Query("SELECT * FROM value_items")
    fun getValueList(): LiveData<List<ValueItemsDBModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addValueItem(valueItemDbModel: List<ValueItemsDBModel>)

}