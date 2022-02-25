package kozlov.artyom.ctf.domain.usecases

import kozlov.artyom.ctf.domain.entity.ValueItem
import kozlov.artyom.ctf.domain.repository.ValueListRepository
import javax.inject.Inject

class GetItemsFromNetworkUseCase @Inject constructor (private val valueListRepository: ValueListRepository) {

    suspend operator fun invoke(): List<ValueItem> = valueListRepository.getValuesList()
}