package com.mine.data.repository

import com.mine.data.convertor.ServersToServersDtoConvertor
import com.mine.data.network.NetworkStorage
import com.mine.domain.model.ServersDto
import com.mine.domain.repository.NetworkRepository

class NetworkRepositoryImpl(
    private val networkStorage: NetworkStorage,
    private val serversToServersDtoConvertor: ServersToServersDtoConvertor,
) : NetworkRepository {
    override suspend fun getServers(count: Int): List<ServersDto> {
        try {
            val response = networkStorage.getServers(count)
            if (response.isSuccessful) {
                response.body()?.let { baseResponse ->
                    val server = mutableListOf<ServersDto>()
                    baseResponse.serverGamesList?.map { servers ->
                        server.add(
                            serversToServersDtoConvertor.invoke(servers)
                        )
                    }
                    baseResponse.serverTwoList?.map { servers ->
                        server.add(
                            serversToServersDtoConvertor.invoke(servers)
                        )
                    }
                    baseResponse.serverOneList?.map { servers ->
                        server.add(
                            serversToServersDtoConvertor.invoke(servers)
                        )
                    }
                    return server
                }
            }
        } catch (e: Exception) {
            println(e.message)
        }
        return emptyList()
    }
}

