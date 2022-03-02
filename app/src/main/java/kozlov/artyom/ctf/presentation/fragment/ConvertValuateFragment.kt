package kozlov.artyom.ctf.presentation.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kozlov.artyom.ctf.databinding.FragmentConvertValuteBinding
import java.math.RoundingMode


class ConvertValuateFragment : Fragment() {

    private var _binding: FragmentConvertValuteBinding? = null
    private val binding: FragmentConvertValuteBinding
        get() = _binding ?: throw RuntimeException("FragmentConvertValuteBinding == null")

    private var name: String? = CURRENCY_NAME
    private var units: Double = 0.0
    private var rate: Double = 0.0

    var et1Focus = false
    var et2Focus = false
    var t = false


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
        focusListeners()
        unitListener()
        rateListener()

        return binding.root
    }

    private fun focusListeners() {
        binding.editUnitValuate.onFocusChangeListener = OnFocusChangeListener { _, b -> et1Focus = b }
        binding.editRateField.onFocusChangeListener = OnFocusChangeListener { _, b -> et2Focus = b }
    }

    private fun rateListener() {
        binding.editUnitValuate.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (et1Focus) binding.editRateField.setText(convert(s.toString(), rate, units))
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

    }

    private fun unitListener() {
        binding.editRateField.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (et2Focus) binding.editUnitValuate.setText(convert(s.toString(), units, rate))
            }

            override fun afterTextChanged(s: Editable?) {}
        })

    }

    val convert: (String, Double, Double) -> String =
        { a, b, c -> ((a.toDoubleOrNull()?.times(b))?.div(c))?.toBigDecimal()?.setScale(2, RoundingMode.UP).toString() }


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

    private fun initView() {
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