package kozlov.artyom.ctf.presentation.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kozlov.artyom.ctf.databinding.FragmentConvertValuteBinding
import java.math.RoundingMode
import kotlin.math.expm1


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
        unitListener()
        rateListener()

        return binding.root
    }

    private fun rateListener() {
        binding.editUnitValuate.addTextChangedListener(object : TextWatcher {
            var isOnTextChanged = false
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {




            }

            override fun afterTextChanged(s: Editable?) {

                if (et1Focus) binding.editRateField.setText(convert(s.toString(), rate, units))
            }
        })

        binding.editUnitValuate.onFocusChangeListener = OnFocusChangeListener { _, b -> et1Focus = b }


    }

    private fun unitListener() {
        binding.editRateField.addTextChangedListener(object : TextWatcher {
            //  var checker = false
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("focus2", "beforeTextChanged  $et2Focus ")
                Log.d("focus1", "beforeTextChanged: $et1Focus ")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                Log.d("focus2", "focus2 $et2Focus ")
                Log.d("focus1", "onTextChanged: $et1Focus ")
            }

            override fun afterTextChanged(s: Editable?) {
                if (et2Focus ) binding.editRateField.setText(convert(s.toString(), units, rate))
                Log.d("focus2", "afterTextChanged: $et2Focus ")
                Log.d("focus1", "afterTextChanged: $et1Focus ")
            }
        })
        binding.editRateField.onFocusChangeListener = OnFocusChangeListener { _, b -> et2Focus = b }
    }

    val convert: (String, Double, Double) -> String =
        { a, b, c -> ((a.toDoubleOrNull()?.times(b))?.div(c))?.toBigDecimal()?.setScale(2, RoundingMode.UP).toString() }
//


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