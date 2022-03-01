package kozlov.artyom.ctf.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kozlov.artyom.ctf.R
import kozlov.artyom.ctf.databinding.FragmentConvertValuteBinding


class ConvertValuateFragment : Fragment() {

    private var _binding: FragmentConvertValuteBinding? = null
    private val binding: FragmentConvertValuteBinding
        get() = _binding ?: throw RuntimeException("FragmentConvertValuteBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConvertValuteBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}