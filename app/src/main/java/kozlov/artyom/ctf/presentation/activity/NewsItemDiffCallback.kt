package kozlov.artyom.ctf.presentation.activity

import androidx.recyclerview.widget.DiffUtil
import kozlov.artyom.ctf.domain.entity.ListMarker
import kozlov.artyom.ctf.domain.entity.ValueItem


class ValueItemDiffCallback : DiffUtil.ItemCallback<ListMarker>() {


    override fun areItemsTheSame(oldItem : ListMarker, newItem: ListMarker): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ListMarker, newItem: ListMarker): Boolean {
        return true
    }

}
