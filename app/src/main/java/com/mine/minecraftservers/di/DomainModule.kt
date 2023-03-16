package com.mine.minecraftservers.di


import com.mine.domain.usecase.ServersUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { ServersUseCase(get()) }
}