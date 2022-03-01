package kozlov.artyom.ctf.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kozlov.artyom.ctf.databinding.FragmentConvertValuteBinding


class ConvertValuateFragment : Fragment() {

    private var _binding: FragmentConvertValuteBinding? = null
    private val binding: FragmentConvertValuteBinding
        get() = _binding ?: throw RuntimeException("FragmentConvertValuteBinding == null")

    private var name: String? = CURRENCY_NAME
    private var units: Double? = 0.0
    private var rate: Double? = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseParams()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConvertValuteBinding.inflate(inflater, container, false)

        closeFragment()
        initView()


        return binding.root
    }

    private fun closeFragment() {
        binding.closeFragment.setOnClickListener {
           requireActivity().onBackPressed()
        }
    }

    private fun parseParams() {
        val args = requireArguments()
        name = args.getString(CURRENCY_NAME)
        units = args.getDouble(UNITS)
        rate = args.getDouble(RATE)
    }

    private fun initView(){
        binding.chooseValuate.text = name
        binding.unitValuate.hint = units.toString()
        binding.rateTextField.hint = rate.toString()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private const val CURRENCY_NAME = "extra_currency_mode"
        private const val UNITS = "extra_units"
        private const val RATE = "extra_rate"

        fun newInstanceConvertValue(name: String, units: Double, rate: Double): ConvertValuateFragment {
            return ConvertValuateFragment().apply {
                arguments = Bundle().apply {
                    putString(CURRENCY_NAME, name)
                    putDouble(UNITS, units)
                    putDouble(RATE, rate)

                }
            }
        }
    }
}