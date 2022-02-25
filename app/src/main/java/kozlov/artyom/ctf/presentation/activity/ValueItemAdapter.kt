package kozlov.artyom.ctf.presentation.activity


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import kozlov.artyom.ctf.databinding.ValueItemBinding
import kozlov.artyom.ctf.domain.entity.ValueItem

class ValueItemAdapter: ListAdapter<ValueItem, ValueItemViewHolder>(ValueItemDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ValueItemViewHolder {
        val binding = ValueItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ValueItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ValueItemViewHolder, position: Int) {
        val valueItem = getItem(position)
        with(holder.binding){
            currencyValue.text = valueItem.currency
            nameValue.text = valueItem.name
            nominalValue.text = valueItem.nominal.toString()
            priceValue.text = valueItem.value.toString()
            ratioPriceValue.text = (valueItem.value - valueItem.percent).toString()
        }
    }
}