package kozlov.artyom.ctf.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kozlov.artyom.ctf.R
import kozlov.artyom.ctf.databinding.FragmentValuateBinding
import kozlov.artyom.ctf.domain.entity.Info
import kozlov.artyom.ctf.domain.entity.ListMarker
import kozlov.artyom.ctf.domain.entity.ValueItem
import kozlov.artyom.ctf.presentation.ViewModelFactory
import kozlov.artyom.ctf.presentation.activity.MainActivity
import kozlov.artyom.ctf.presentation.activity.MainActivityViewModel
import kozlov.artyom.ctf.presentation.activity.ValueItemAdapter
import kozlov.artyom.ctf.utils.App
import kozlov.artyom.ctf.utils.Resource
import javax.inject.Inject


class ValuateFragment : Fragment() {


    private lateinit var valueItemAdapter: ValueItemAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[(MainActivityViewModel::class.java)]
    }

    private var _binding: FragmentValuateBinding? = null
    private val binding: FragmentValuateBinding
        get() = _binding ?: throw RuntimeException("FragmentValuateBinding == null")

    private val component by lazy {
        (requireActivity().application as App).component
    }


    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentValuateBinding.inflate(inflater, container, false)

        setupRecyclerView()
        setDataValueList()
        retryOnClickListener()
        setupButtonMenuToolbar()
        observeDatabaseList()
        setupClickListener()

        return binding.root
    }

    private fun setupClickListener() {

        valueItemAdapter.onValueItemClickListener = {
            Log.d("args", "${(activity as MainActivity).isOnePaneMode()}")
            if ((activity as MainActivity).isOnePaneMode()) {
                launchFragment(ConvertValuateFragment.newInstanceConvertValue(it.name, it.nominal.toDouble(), it.value), R.id.container_view)
            } else launchFragment(ConvertValuateFragment.newInstanceConvertValue(it.name, it.nominal.toDouble(), it.value), R.id.container_convert_valuate)

        }
    }

    private fun observeDatabaseList() {
        viewModel.getValueList.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                viewModel.setDatabaseValue(it)
            }
        }
    }


    private fun setupButtonMenuToolbar() {
        binding.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.update_data -> {
                    viewModel.getFirstData()
                    setupInternetConnectionViewDisable()
                    true
                }
                else -> false
            }
        }
    }


    private fun retryOnClickListener() {
        binding.retry.setOnClickListener {
            viewModel.getDataFromInternet()
            setupInternetConnectionViewDisable()

        }
    }

    private fun setDataValueList() {
        viewModel.valueItems.observe(viewLifecycleOwner) { status ->
            status.data?.let { viewModel.setNetValue(it.first) }
            when (status) {
                is Resource.Loading -> {
                    binding.shimmerLayout.startShimmer()
                }
                is Resource.Success -> {
                    status.data?.let {
                        val listNetwork = mutableListOf<ListMarker>()
                        valueItemAdapter.submitList(listNetwork.convertToRecycler(it.first, Info(it.second)))
                        showRecyclerView()
                    }

                }
                is Resource.Error -> {
                    setupInternetConnectionView()
                }
                is Resource.DataBase -> {
                    status.data?.let {
                        val listDatabase = mutableListOf<ListMarker>()
                        valueItemAdapter.submitList(listDatabase.convertToRecycler(it.first, Info(it.second)))
                        showRecyclerView()
                    }
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


    private fun setupInternetConnectionView() {
        binding.noInternetFrame.visibility = View.VISIBLE
        binding.shimmerLayout.apply {
            stopShimmer()
            visibility = View.GONE
        }
    }

    private fun setupInternetConnectionViewDisable() {
        binding.noInternetFrame.visibility = View.GONE
        binding.listRecyclerView.visibility = View.GONE
        binding.shimmerLayout.apply {
            startShimmer()
            visibility = View.VISIBLE
        }
    }

    private fun launchFragment(fragment: Fragment, fragment_container: Int) {
        requireActivity().supportFragmentManager.popBackStack()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun MutableList<ListMarker>.convertToRecycler(list: List<ValueItem>, info: Info): List<ListMarker> {
        this.add(info)
        this.addAll(list)
        return this
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}