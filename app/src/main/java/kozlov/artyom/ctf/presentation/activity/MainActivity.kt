package kozlov.artyom.ctf.presentation.activity


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kozlov.artyom.ctf.databinding.ActivityMainBinding
import kozlov.artyom.ctf.utils.App
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var valueItemAdapter: ValueItemAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[(MainActivityViewModel::class.java)]
    }

    private val component by lazy {
        (application as App).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        component.inject(this)
        setupRecyclerView()
        setDataValueList()

    }

    private fun setDataValueList() {
        viewModel.valueItems.observe(this) {

            valueItemAdapter.submitList(it.first)
            valueItemAdapter.data = it.second
        }
    }

    private fun setupRecyclerView() {
        valueItemAdapter = ValueItemAdapter()
        binding.listRecyclerView.adapter = valueItemAdapter
    }



}