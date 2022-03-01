package kozlov.artyom.ctf.utils

import kozlov.artyom.ctf.domain.entity.Info
import kozlov.artyom.ctf.domain.entity.ListMarker
import kozlov.artyom.ctf.domain.entity.ValueItem

open class Extensions {

    fun MutableList<ListMarker>.convertToRecycler(list: List<ValueItem>, info: Info): List<ListMarker>{
        this.add(info)
        this.addAll(list)
        return this
    }

}