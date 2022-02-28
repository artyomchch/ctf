package kozlov.artyom.ctf.presentation.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kozlov.artyom.ctf.domain.entity.ValueItem
import kozlov.artyom.ctf.domain.usecases.GetItemsFromNetworkUseCase
import kozlov.artyom.ctf.utils.Resource
import java.io.IOException
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val getItemsFromNetworkUseCase: GetItemsFromNetworkUseCase
) : ViewModel() {


    private val _valueItems = MutableLiveData<Resource<Pair<List<ValueItem>, String>>>()
    val valueItems: LiveData<Resource<Pair<List<ValueItem>, String>>>
        get() = _valueItems


    init {
        getFirstData()
    }

    fun getFirstData() {
        _valueItems.value = Resource.Loading()
        getDataFromInternet()
    }

    fun getDataFromInternet(){
        viewModelScope.launch {
            delay(1500)
            try {
                _valueItems.value = Resource.Success(getItemsFromNetworkUseCase.invoke())
            } catch (e: IOException){
                _valueItems.value = Resource.Error()
            }

        }
    }




}