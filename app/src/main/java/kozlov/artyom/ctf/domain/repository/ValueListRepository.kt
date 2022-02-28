package kozlov.artyom.ctf.domain.repository

import androidx.lifecycle.LiveData
import kozlov.artyom.ctf.domain.entity.ValueItem

interface ValueListRepository {

    suspend fun getValuesList(): Pair<List<ValueItem>, String>

    suspend fun addValueItem(valueItems: List<ValueItem>)

    fun getValuesListFromDB(): LiveData<List<ValueItem>>
}