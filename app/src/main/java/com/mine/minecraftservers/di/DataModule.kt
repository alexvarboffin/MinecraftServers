package com.mine.minecraftservers.di

import com.google.gson.GsonBuilder
import com.mine.data.RetrofitCreator
import com.mine.data.convertor.ServersToServersDtoConvertor
import com.mine.data.network.NetworkService
import com.mine.data.network.NetworkStorage
import com.mine.data.network.NetworkStorageImpl
import com.mine.data.repository.NetworkRepositoryImpl
import com.mine.domain.repository.NetworkRepository
import org.koin.dsl.module

val dataModule = module {
    single { GsonBuilder().serializeNulls().create() }

    val creator = RetrofitCreator()

    single { creator.createService(get(), NetworkService::class.java) as NetworkService }

    single<NetworkStorage> {
        NetworkStorageImpl(get())
    }

    single<NetworkRepository> {
        NetworkRepositoryImpl(get(), get())
    }
    factory { ServersToServersDtoConvertor() }
}

