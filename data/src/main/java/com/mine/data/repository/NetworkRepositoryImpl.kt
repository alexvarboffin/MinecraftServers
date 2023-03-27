package com.mine.data.repository

import com.mine.data.convertor.ServersToServersDtoConvertor
import com.mine.data.model.Field
import com.mine.data.model.Servers
import com.mine.data.network.NetworkStorage
import com.mine.domain.model.ServersDto
import com.mine.domain.repository.NetworkRepository


class NetworkRepositoryImpl(
    private val networkStorage: NetworkStorage,
    private val serversToServersDtoConvertor: ServersToServersDtoConvertor,
) : NetworkRepository {
    override suspend fun getServers(): List<ServersDto> {
        try {
            val response = networkStorage.getServers()
            if (response.isSuccessful) {
                response.body()?.let { baseResponse ->
                    val list = mutableListOf<ServersDto>()
                    baseResponse.data?.map { lists ->
                        list.add(serversToServersDtoConvertor.invoke(lists))
                    }
                    return list
                }
            }
        } catch (e: Exception) {
            println(e.message)
        }
        return emptyList()
    }
}

