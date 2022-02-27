package kozlov.artyom.ctf.presentation.activity


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kozlov.artyom.ctf.databinding.ActivityMainBinding
import kozlov.artyom.ctf.presentation.ViewModelFactory
import kozlov.artyom.ctf.utils.App
import kozlov.artyom.ctf.utils.InternetConnection
import kozlov.artyom.ctf.utils.Resource
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
        checkInternetConnection()
        setDataValueList()

    }

    private fun setDataValueList() {
        viewModel.valueItems.observe(this) { status ->
            when (status) {
                is Resource.Loading -> {
                    binding.shimmerLayout.startShimmer()
                }
                is Resource.Success -> {
                    status.data?.let {
                        valueItemAdapter.submitList(it.first)
                        valueItemAdapter.data = it.second
                        showRecyclerView()
                    }

                }
                is Resource.Error -> {
                    setupInternetConnectionView()
                }
                is Resource.DataBase -> {

                }
            }

        }
    }

    private fun setupRecyclerView() {
        valueItemAdapter = ValueItemAdapter()
        binding.listRecyclerView.adapter = valueItemAdapter
    }

    private fun showRecyclerView() {
        binding.shimmerLayout.apply {
            stopShimmer()
            visibility = View.GONE
        }
        binding.listRecyclerView.visibility = View.VISIBLE
    }

    private fun checkInternetConnection() {
        if (!InternetConnection.checkInternet(this)) {
            viewModel.setStatusNoInternetAndData()
            viewModel.setInternetConnection(false)
        } else {
            viewModel.setInternetConnection(true)
            viewModel.checkInternet.observe(this){
                if (it) viewModel.getFirstData()
            }
            viewModel.setInternetConnection(false)
        }

    }

    private fun setupInternetConnectionView() {
        binding.noInternetFrame.visibility = View.VISIBLE
        binding.shimmerLayout.stopShimmer()
        binding.shimmerLayout.visibility = View.GONE
    }


}