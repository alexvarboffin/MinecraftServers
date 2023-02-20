package com.mine.data.network

import com.mine.data.BaseResponse
import com.mine.data.model.Servers
import retrofit2.Response

class NetworkStorageImpl(private val networkService: NetworkService) : NetworkStorage {
    override suspend fun getServers(count: Int): Response<BaseResponse<ArrayList<Servers>>> =
        networkService.getServers()
}

