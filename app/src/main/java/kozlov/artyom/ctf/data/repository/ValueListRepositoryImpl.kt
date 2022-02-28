package kozlov.artyom.ctf.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import kozlov.artyom.ctf.data.database.ValueListDao
import kozlov.artyom.ctf.data.mapper.ValueListMapper
import kozlov.artyom.ctf.data.network.CurrencyApi
import kozlov.artyom.ctf.domain.entity.ValueItem
import kozlov.artyom.ctf.domain.repository.ValueListRepository
import javax.inject.Inject

class ValueListRepositoryImpl @Inject constructor(
    private val mapper: ValueListMapper,
    private val retrofit: CurrencyApi,
    private val valueListDao: ValueListDao
) : ValueListRepository {


    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getValuesList(): Pair<List<ValueItem>, String> {
        return mapper.mapListNetworkModelToListEntityNews(retrofit.getPost())
    }

    override suspend fun addValueItem(valueItems: List<ValueItem>) {
        valueListDao.addValueItem(mapper.mapListEntityToListDbModel(valueItems))
    }

    override fun getValuesListFromDB(): LiveData<List<ValueItem>> = Transformations.map(valueListDao.getValueList()) {
        mapper.mapListDbModelToListEntity(it)
    }


}