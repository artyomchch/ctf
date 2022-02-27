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
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val getItemsFromNetworkUseCase: GetItemsFromNetworkUseCase
) : ViewModel() {

    private val _checkInternet = MutableLiveData<Boolean>()
    val checkInternet: LiveData<Boolean>
        get() = _checkInternet

    private val _valueItems = MutableLiveData<Resource<Pair<List<ValueItem>, String>>>()
    val valueItems: LiveData<Resource<Pair<List<ValueItem>, String>>>
        get() = _valueItems



    fun getFirstData() {
        _valueItems.value = Resource.Loading()
        getDataFromInternet()
    }

    fun getDataFromInternet(){
        viewModelScope.launch {
            delay(1500)
            _valueItems.value = Resource.Success(getItemsFromNetworkUseCase.invoke())
        }
    }

    fun setStatusNoInternetAndData() {
        _valueItems.value = Resource.Error()
    }

    fun setInternetConnection(status: Boolean){
        _checkInternet.value = status
    }



}