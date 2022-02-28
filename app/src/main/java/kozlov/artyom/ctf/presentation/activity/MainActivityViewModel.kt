package kozlov.artyom.ctf.presentation.activity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kozlov.artyom.ctf.domain.entity.ValueItem
import kozlov.artyom.ctf.domain.usecases.AddValueItemUseCase
import kozlov.artyom.ctf.domain.usecases.GetItemsFromNetworkUseCase
import kozlov.artyom.ctf.domain.usecases.GetValueListUseCase
import kozlov.artyom.ctf.utils.Resource
import java.io.IOException
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val getItemsFromNetworkUseCase: GetItemsFromNetworkUseCase,
    private val addValueItemUseCase: AddValueItemUseCase,
    getValueListUseCase: GetValueListUseCase
) : ViewModel() {


    private val _valueItems = MutableLiveData<Resource<Pair<List<ValueItem>, String>>>()
    val valueItems: LiveData<Resource<Pair<List<ValueItem>, String>>>
        get() = _valueItems

    val getValueList = getValueListUseCase.invoke()

    private var dataBaseValue = listOf<ValueItem>()
    private var networkValue = listOf<ValueItem>()


    init {
        getFirstData()
    }

    fun getFirstData() {

        getDataFromInternet()
    }

    fun getDataFromInternet() {
        viewModelScope.launch {
            delay(1500)
            try {
                _valueItems.value = Resource.Success(getItemsFromNetworkUseCase.invoke())
                addValueItemUseCase.invoke(networkValue)

            } catch (e: IOException) {
                if (dataBaseValue.isNullOrEmpty()) {
                    _valueItems.value = Resource.Error()
                } else {
                    _valueItems.value = Resource.DataBase(Pair(dataBaseValue, "Данные были взяты с БД"))
                    Log.d("tagch", "getDataFromInternet: ")
                }


            }

        }
    }

    fun setDatabaseValue(list: List<ValueItem>) {
        dataBaseValue = list
    }

    fun setNetValue(list: List<ValueItem>) {
        networkValue = list
    }
}


