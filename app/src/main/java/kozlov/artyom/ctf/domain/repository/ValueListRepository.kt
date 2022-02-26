package kozlov.artyom.ctf.domain.repository

import kozlov.artyom.ctf.domain.entity.ValueItem

interface ValueListRepository {

    suspend fun getValuesList(): Pair<List<ValueItem>, String>
}