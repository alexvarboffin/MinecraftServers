package com.mine.domain.usecase

import com.mine.domain.base.SuspendUseCase
import com.mine.domain.model.ServersDto
import com.mine.domain.repository.NetworkRepository

class GetServersUseCase(private val networkRepository: NetworkRepository) :
    SuspendUseCase<Int, List<ServersDto>> {
    override suspend fun execute(param: Int?): List<ServersDto> {
        return networkRepository.getServers(param!!)
    }
}

