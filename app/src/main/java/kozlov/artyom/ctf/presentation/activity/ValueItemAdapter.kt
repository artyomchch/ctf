package kozlov.artyom.ctf.presentation.activity


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import kozlov.artyom.ctf.databinding.HeaderInfoBinding
import kozlov.artyom.ctf.databinding.ValueItemBinding
import kozlov.artyom.ctf.domain.entity.Info
import kozlov.artyom.ctf.domain.entity.ListMarker
import kozlov.artyom.ctf.domain.entity.ValueItem
import kozlov.artyom.ctf.presentation.activity.viewholders.BaseViewHolder
import kozlov.artyom.ctf.presentation.activity.viewholders.HeaderItemViewHolder
import kozlov.artyom.ctf.presentation.activity.viewholders.ValueItemViewHolder

class ValueItemAdapter : ListAdapter<ListMarker, BaseViewHolder<*>>(ValueItemDiffCallback()) {

//    var data: String = ""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {

        return when (viewType) {
            TYPE_HEADER -> {
                val binding = HeaderInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                HeaderItemViewHolder(binding)
            }
            TYPE_ITEMS -> {
                val binding = ValueItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ValueItemViewHolder(binding)
            }
            else -> throw RuntimeException("Unknown view type: $viewType")
        }

    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val valueItem = getItem(position)
        when (holder){
            is HeaderItemViewHolder -> holder.bind(valueItem as Info)
            is ValueItemViewHolder -> holder.bind(valueItem as ValueItem)
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return TYPE_HEADER
        }
        return TYPE_ITEMS
    }



    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_ITEMS = 1

    }


}