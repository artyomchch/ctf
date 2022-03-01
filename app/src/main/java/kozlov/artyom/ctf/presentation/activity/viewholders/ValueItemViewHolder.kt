package kozlov.artyom.ctf.presentation.activity.viewholders


import android.util.Log
import kozlov.artyom.ctf.databinding.ValueItemBinding
import kozlov.artyom.ctf.domain.entity.ValueItem

class ValueItemViewHolder(private val binding: ValueItemBinding) : BaseViewHolder<ValueItem>(binding.root) {

    override fun bind(item: ValueItem) {
        binding.currencyValue.text = item.currency
        binding.nameValue.text = item.name
        binding.nominalValue.text = item.nominal.toString()
        binding.priceValue.text = item.value.toString()
        binding.ratioPriceValue.text = item.percent.toString()

//        binding.root.setOnClickListener {
//            Log.d("TAG", "bind: ${item.name}")
//
//        }
    }


}




