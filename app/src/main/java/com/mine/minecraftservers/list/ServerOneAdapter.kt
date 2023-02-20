package com.mine.minecraftservers.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.mine.domain.model.ServerDivider
import com.mine.domain.model.ServerItemType
import com.mine.minecraftservers.base.BaseViewHolder
import com.mine.minecraftservers.databinding.ListServerItemBinding
import com.mine.minecraftservers.databinding.ServerDividerOneBinding


class ServerOneAdapter : ListAdapter<Any, BaseViewHolder<ViewBinding, Any>>(
    object : DiffUtil.ItemCallback<Any>() {
        override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean = when {
            oldItem is ServerItemType && newItem is ServerItemType -> oldItem.title == newItem.title
            oldItem is ServerDivider && newItem is ServerDivider -> true
            else -> false
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean = when {
            oldItem is ServerItemType && newItem is ServerItemType -> oldItem == newItem
            oldItem is ServerDivider && newItem is ServerDivider -> true
            else -> false
        }
    }
) {
    override fun getItemViewType(position: Int): Int = when (getItem(position)) {
        is ServerItemType -> SERVER_ITEM_TYPE
        is ServerDivider -> SERVER_DIVIDER
        else -> throw IllegalArgumentException(
            "ServerOneAdapter can't handle item" + getItem(
                position
            )
        )
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BaseViewHolder<ViewBinding, Any> = when (viewType) {
        SERVER_ITEM_TYPE -> ServerViewHolder(parent) as BaseViewHolder<ViewBinding, Any>
        SERVER_DIVIDER -> ServerDividerViewHolder(parent) as BaseViewHolder<ViewBinding, Any>
        else -> throw java.lang.IllegalArgumentException("ServerOneAdapter can't handle $viewType viewType")
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ViewBinding, Any>, position: Int) {
        holder.handleItem(getItem(position))
    }

    companion object {
        private const val SERVER_ITEM_TYPE = 999
        private const val SERVER_DIVIDER = 998
    }


    private class ServerViewHolder(private val parent: ViewGroup) :
        BaseViewHolder<ListServerItemBinding, ServerItemType>(
            ListServerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        ) {
        @SuppressLint("SetTextI18n")
        override fun ListServerItemBinding.bind(value: ServerItemType) {
            tittleServer.text = value.title
            tittleIp.text = value.ip
            tittlePort.text = value.port

            Glide
                .with(parent.context)
                .load(value.image)
                .into(imageServer)

            itemView.setOnClickListener {
                value.action()
            }
        }
    }

    private class ServerDividerViewHolder(parent: ViewGroup) :
        BaseViewHolder<ServerDividerOneBinding, ServerDivider>(
            ServerDividerOneBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
}


