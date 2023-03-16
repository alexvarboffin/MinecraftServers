package com.mine.data.repository

import com.mine.data.convertor.ServersToServersDtoConvertor
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
                    val listOne = mutableListOf<ServersDto>()
                    baseResponse.data?.map { list1 ->
                        listOne.add(serversToServersDtoConvertor.invoke(list1))
                    }
                    return listOne
                }
            }
        } catch (e: Exception) {
            println(e.message)
        }
        return emptyList()
    }

    override suspend fun getServersTwo(): List<ServersDto> {
        try {
            val response = networkStorage.getServers()
            if (response.isSuccessful) {
                response.body()?.let { baseResponse ->
                    val listTwo = mutableListOf<ServersDto>()
                    baseResponse.data?.map { list2 ->
                        listTwo.add(serversToServersDtoConvertor.invoke(list2))
                    }
                    return listTwo
                }
            }
        } catch (e: Exception) {
            println(e.message)
        }
        return emptyList()
    }

    override suspend fun getServersThree(): List<ServersDto> {
        try {
            val response = networkStorage.getServers()
            if (response.isSuccessful) {
                response.body()?.let { baseResponse ->
                    val listThree = mutableListOf<ServersDto>()
                    baseResponse.data?.map { list3 ->
                        listThree.add(serversToServersDtoConvertor.invoke(list3))
                    }
                    return listThree
                }
            }
        } catch (e: Exception) {
            println(e.message)
        }
        return emptyList()
    }
}




