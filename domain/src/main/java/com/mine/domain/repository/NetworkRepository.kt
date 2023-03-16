package com.mine.domain.repository

import com.mine.domain.model.ServersDto


interface NetworkRepository {
    suspend fun getServers(): List<ServersDto>
    suspend fun getServersTwo(): List<ServersDto>
    suspend fun getServersThree(): List<ServersDto>
}

