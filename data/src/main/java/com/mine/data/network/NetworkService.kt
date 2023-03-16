package com.mine.data.network

import com.mine.data.BaseResponse
import com.mine.data.SERVERS
import com.mine.data.model.Servers
import com.mine.domain.model.ServersDto
import retrofit2.Response
import retrofit2.http.GET

interface NetworkService {
    @GET(SERVERS)
    suspend fun getServers(): Response<BaseResponse<ArrayList<Servers>>>
}


