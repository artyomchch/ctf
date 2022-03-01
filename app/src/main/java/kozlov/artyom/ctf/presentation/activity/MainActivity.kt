package kozlov.artyom.ctf.presentation.activity


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kozlov.artyom.ctf.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    fun isOnePaneMode(): Boolean {
        return binding.containerConvertValuate == null
    }

}