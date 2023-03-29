package com.mine.minecraftservers.fragment.serverGames

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mine.domain.model.ServersDto
import com.mine.domain.usecase.ServersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ServerGamesViewModel(private val useCase: ServersUseCase) : ViewModel() {
    private val _gamesLiveData = MutableLiveData<List<ServersDto>>()
    val gamesLiveData: LiveData<List<ServersDto>> = _gamesLiveData
    fun getServers() {
        viewModelScope.launch {
            val result: List<ServersDto>
            withContext(Dispatchers.IO) {
                result = useCase.execute()
            }
            _gamesLiveData.value = result
        }
    }
}
