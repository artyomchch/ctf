package kozlov.artyom.ctf.presentation.activity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
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
    var job: Job? = null

    init {
        getFirstData()
        startUpdates()
    }

    fun getFirstData() {

        getDataFromInternet()
    }


    private fun startUpdates() {
        CoroutineScope(Dispatchers.IO).launch {
            while (true) {
                delay(TIMER_UPDATE_REQUEST)
                getDataFromInternet()
                Log.d("request", "startUpdates: ")
            }
        }
    }

    private fun stopUpdates() {
        job?.cancel()
        job = null
    }

    fun getDataFromInternet() {

        viewModelScope.launch {
            delay(TIMER_SHOW_SHIMMER)
            try {
                _valueItems.value = Resource.Success(getItemsFromNetworkUseCase.invoke())
                addValueItemUseCase.invoke(networkValue)

            } catch (e: IOException) {
                if (dataBaseValue.isNullOrEmpty()) {
                    _valueItems.value = Resource.Error()
                } else {
                    _valueItems.value = Resource.DataBase(Pair(dataBaseValue, DATA_FROM_DB))
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

    companion object {
        const val TIMER_UPDATE_REQUEST = 5000L
        const val TIMER_SHOW_SHIMMER = 1000L
        const val DATA_FROM_DB = "Данные были взяты с локальной БД"
    }
}


