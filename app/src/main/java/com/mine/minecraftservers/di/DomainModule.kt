package com.mine.minecraftservers.di


import com.mine.domain.usecase.GetServersUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetServersUseCase> { GetServersUseCase(get()) }
}