package kozlov.artyom.ctf.data.repository

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kozlov.artyom.ctf.data.mapper.ValueListMapper
import kozlov.artyom.ctf.data.network.CurrencyApi
import kozlov.artyom.ctf.data.network.pojo.CurrencyDTO
import kozlov.artyom.ctf.domain.entity.ValueItem
import kozlov.artyom.ctf.domain.repository.ValueListRepository
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

class ValueListRepositoryImpl @Inject constructor(
    private val mapper: ValueListMapper,
    private val retrofit: CurrencyApi
) : ValueListRepository {


    override suspend fun getValuesList(): List<ValueItem> {
       return mapper.mapListNetworkModelToListEntityNews(retrofit.getPost())
    }
}