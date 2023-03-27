package com.mine.minecraftservers.di


import com.mine.minecraftservers.fragment.serverGames.ServerGamesViewModel
import com.mine.minecraftservers.fragment.serverOneVersion.ServerOneViewModel
import com.mine.minecraftservers.fragment.serverTwoVersion.serverDescriptionTwo.ServerTwoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<ServerGamesViewModel> {
        ServerGamesViewModel(get())
    }
    viewModel<ServerOneViewModel> {
        ServerOneViewModel(get())
    }
    viewModel<ServerTwoViewModel> {
        ServerTwoViewModel(get())
    }
}
