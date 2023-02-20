package com.mine.minecraftservers.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<VIEW_BINDING : ViewBinding, VALUE_TYPE>(
    val binding: VIEW_BINDING,
) : RecyclerView.ViewHolder(binding.root) {
    fun handleItem(value: VALUE_TYPE) = binding.bind(value)

    protected open fun VIEW_BINDING.bind(value: VALUE_TYPE) {
    }
}
