package com.mine.data.network

import com.mine.data.BaseResponse
import com.mine.data.model.Servers
import retrofit2.Response

interface NetworkStorage {
    suspend fun getServers(count:Int):Response<BaseResponse<ArrayList<Servers>>>
}
