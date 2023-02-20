package com.mine.minecraftservers.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.mine.domain.model.ServerDivider
import com.mine.domain.model.ServerGamesType
import com.mine.minecraftservers.base.BaseViewHolder
import com.mine.minecraftservers.databinding.ListGamesItemBinding
import com.mine.minecraftservers.databinding.ServerDividerThreeBinding


class ServerGamesAdapter : ListAdapter<Any, BaseViewHolder<ViewBinding, Any>>(
    object : DiffUtil.ItemCallback<Any>() {
        override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean = when {
            oldItem is ServerGamesType && newItem is ServerGamesType -> oldItem.title == newItem.title
            oldItem is ServerDivider && newItem is ServerDivider -> true
            else -> false
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean = when {
            oldItem is ServerGamesType && newItem is ServerGamesType -> oldItem == newItem
            oldItem is ServerDivider && newItem is ServerDivider -> true
            else -> false
        }
    }
) {
    override fun getItemViewType(position: Int): Int = when (getItem(position)) {
        is ServerGamesType -> SERVER_GAMES_TYPE
        is ServerDivider -> SERVER_DIVIDER
        else -> throw IllegalArgumentException(
            "ServerGamesAdapter can't handle item" + getItem(
                position
            )
        )
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BaseViewHolder<ViewBinding, Any> = when (viewType) {
        SERVER_GAMES_TYPE -> ServerGamesViewHolder(parent) as BaseViewHolder<ViewBinding, Any>
        SERVER_DIVIDER -> ServerDividerViewHolder(parent) as BaseViewHolder<ViewBinding, Any>
        else -> throw java.lang.IllegalArgumentException("ServerGamesAdapter can't handle $viewType viewType")
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ViewBinding, Any>, position: Int) {
        holder.handleItem(getItem(position))
    }

    private class ServerGamesViewHolder(private val parent: ViewGroup) :
        BaseViewHolder<ListGamesItemBinding, ServerGamesType>(
            ListGamesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        ) {
        @SuppressLint("SetTextI18n")
        override fun ListGamesItemBinding.bind(value: ServerGamesType) {
            tittleServerGame.text = value.title
            tittleIpGame.text = value.ip
            tittlePort.text = value.port
            tittleVersionGame.text = value.version

            Glide
                .with(parent.context)
                .load(value.image)
                .into(imageServerGame)

            itemView.setOnClickListener {
                value.action()
            }
        }
    }

    companion object {
        private const val SERVER_GAMES_TYPE = 999
        private const val SERVER_DIVIDER = 998
    }

    private class ServerDividerViewHolder(parent: ViewGroup) :
        BaseViewHolder<ServerDividerThreeBinding, ServerDivider>(
            ServerDividerThreeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
}

