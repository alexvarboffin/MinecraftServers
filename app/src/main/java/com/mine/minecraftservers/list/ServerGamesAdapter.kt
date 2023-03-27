package com.mine.minecraftservers.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.mine.domain.model.ServersDto
import com.mine.minecraftservers.base.BaseViewHolder
import com.mine.minecraftservers.databinding.ListGamesItemBinding


class ServerGamesAdapter : ListAdapter<Any, BaseViewHolder<ViewBinding, Any>>(
    object : DiffUtil.ItemCallback<Any>() {
        override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean = when {
            oldItem is ServersDto && newItem is ServersDto -> oldItem.id == newItem.id
            else -> false
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean = when {
            oldItem is ServersDto && newItem is ServersDto -> oldItem == newItem
            else -> false
        }
    }
) {
    override fun getItemViewType(position: Int): Int = when (getItem(position)) {
        is ServersDto -> SERVER_GAMES_TYPE
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
        else -> throw java.lang.IllegalArgumentException("ServerGamesAdapter can't handle $viewType viewType")
    }

    companion object {
        private const val SERVER_GAMES_TYPE = 997
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ViewBinding, Any>, position: Int) {
        holder.handleItem(getItem(position))
    }

    private class ServerGamesViewHolder(private val parent: ViewGroup) :
        BaseViewHolder<ListGamesItemBinding, ServersDto>(
            ListGamesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        ) {
        @SuppressLint("SetTextI18n")
        override fun ListGamesItemBinding.bind(value: ServersDto) {
//            tittleServerGame.text = value.fields[3].title
//            tittleIpGame.text = value.fields[3].ip
//            tittlePort.text = value.fields[3].port.toString()
//            tittleVersionGame.text = value.fields[3].version
//
//            Glide
//                .with(parent.context)
//                .load(value.fields[3].image)
//                .into(imageServerGame)
        }
    }
}