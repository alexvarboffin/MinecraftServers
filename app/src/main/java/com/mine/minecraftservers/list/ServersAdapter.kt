package com.mine.minecraftservers.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.mine.data.convertor.ServersToServersDtoConvertor
import com.mine.domain.model.Field
import com.mine.domain.model.ServersDto
import com.mine.minecraftservers.base.BaseViewHolder
import com.mine.minecraftservers.databinding.ListServerItemBinding


class ServersAdapter :
    ListAdapter<Any, BaseViewHolder<ViewBinding, Any>>(object : DiffUtil.ItemCallback<Any>() {
        override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean = when {
            oldItem is ServersDto && newItem is ServersDto -> oldItem.id == newItem.id
            else -> false
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean = when {
            oldItem is ServersDto && newItem is ServersDto -> oldItem == newItem
            else -> false
        }
    }) {

    override fun getItemViewType(position: Int): Int = when (getItem(position)) {
        is ServersDto -> SERVER_ITEM_TYPE
        else -> throw java.lang.IllegalArgumentException(
            "ServersAdapter can't handle item" + getItem(
                position
            )
        )
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BaseViewHolder<ViewBinding, Any> = when (viewType) {
        SERVER_ITEM_TYPE -> ServersViewHolder(parent) as BaseViewHolder<ViewBinding, Any>
        else -> throw java.lang.IllegalArgumentException(
            "ServersAdapter can't handle  $viewType viewType"
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ViewBinding, Any>, position: Int) {
        holder.handleItem(getItem(position))
    }

    companion object {
        private const val SERVER_ITEM_TYPE = 997
    }
}

private class ServersViewHolder(private val parent: ViewGroup) :
    BaseViewHolder<ListServerItemBinding, ServersDto>(
        ListServerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    ) {
    override fun ListServerItemBinding.bind(value: ServersDto) {

    }
}






