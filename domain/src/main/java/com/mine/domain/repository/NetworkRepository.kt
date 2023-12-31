package com.mine.domain.repository

import com.mine.domain.model.ServersDto


interface NetworkRepository {
    suspend fun getServers(): List<ServersDto>

}