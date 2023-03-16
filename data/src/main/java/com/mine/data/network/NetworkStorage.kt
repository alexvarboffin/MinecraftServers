package com.mine.data.network


import com.mine.data.BaseResponse
import com.mine.data.model.Servers
import com.mine.domain.model.ServersDto
import retrofit2.Response

interface NetworkStorage {
    suspend fun getServers(): Response<BaseResponse<ArrayList<Servers>>>
}

