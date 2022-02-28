package kozlov.artyom.ctf.domain.usecases

import androidx.lifecycle.LiveData
import kozlov.artyom.ctf.domain.entity.ValueItem
import kozlov.artyom.ctf.domain.repository.ValueListRepository
import javax.inject.Inject

class GetValueListUseCase @Inject constructor(private val valueListRepository: ValueListRepository) {

    operator fun invoke(): LiveData<List<ValueItem>> = valueListRepository.getValuesListFromDB()

}