package kozlov.artyom.ctf.presentation.activity.viewholders

import kozlov.artyom.ctf.databinding.HeaderInfoBinding

class HeaderItemViewHolder(private val binding: HeaderInfoBinding) : BaseViewHolder<String>(binding.root) {

    override fun bind(item: String) {
        binding.dateTimeUpdateValue.text = item
    }
}