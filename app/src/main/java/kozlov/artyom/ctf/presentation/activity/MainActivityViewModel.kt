package kozlov.artyom.ctf.presentation.activity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kozlov.artyom.ctf.domain.entity.ValueItem
import kozlov.artyom.ctf.domain.usecases.GetItemsFromNetworkUseCase
import javax.inject.Inject
import kotlin.math.log

class MainActivityViewModel @Inject constructor(
    private val getItemsFromNetworkUseCase: GetItemsFromNetworkUseCase
) : ViewModel() {

    private val _valueItems = MutableLiveData<List<ValueItem>>()
    val valueItems: LiveData<List<ValueItem>>
        get() = _valueItems

    init {
       viewModelScope.launch {
           _valueItems.value = getItemsFromNetworkUseCase.invoke()
       }
    }

    fun getData(){
        viewModelScope.launch {
            val s =getItemsFromNetworkUseCase.invoke()
            Log.d("title", "$s ")
        }
    }
}