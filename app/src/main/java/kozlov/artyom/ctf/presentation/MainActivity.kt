package kozlov.artyom.ctf.presentation


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kozlov.artyom.ctf.R
import kozlov.artyom.ctf.data.network.RetrofitInstance

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getInfo()
    }

    private fun getInfo() {
        CoroutineScope(Dispatchers.IO).launch {
            val info = RetrofitInstance.api.getPost().Valute
            Log.d("price", "getInfo: $info")
        }



    }
}