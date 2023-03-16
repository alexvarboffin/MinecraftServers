package com.mine.domain.usecase

import com.mine.domain.base.SuspendUseCase
import com.mine.domain.model.ServersDto
import com.mine.domain.repository.NetworkRepository


class ServersUseCase(private val networkRepository: NetworkRepository) :
    SuspendUseCase<String, List<ServersDto>> {
    override suspend fun execute(param: String?): List<ServersDto> {
        return networkRepository.getServers()
    }
}

