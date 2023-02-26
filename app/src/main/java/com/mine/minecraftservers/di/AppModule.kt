package com.mine.minecraftservers.di


import com.mine.minecraftservers.fragment.servers.ServersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<ServersViewModel> {
        ServersViewModel(get())
    }
}
