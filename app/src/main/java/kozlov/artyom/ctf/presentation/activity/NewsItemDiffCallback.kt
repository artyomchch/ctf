package kozlov.artyom.ctf.presentation.activity

import androidx.recyclerview.widget.DiffUtil
import kozlov.artyom.ctf.domain.entity.ValueItem


class ValueItemDiffCallback : DiffUtil.ItemCallback<ValueItem>() {
    override fun areItemsTheSame(oldItem: ValueItem, newItem: ValueItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ValueItem, newItem: ValueItem): Boolean {
        return oldItem == newItem
    }

}
