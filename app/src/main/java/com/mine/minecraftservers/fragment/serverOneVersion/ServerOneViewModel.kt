package com.mine.minecraftservers.fragment.serverOneVersion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mine.domain.model.ServersDto
import com.mine.domain.usecase.ServersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ServerOneViewModel(private val useCase: ServersUseCase) : ViewModel() {
    private val _serverOneLiveData = MutableLiveData<List<ServersDto>>()
    val serverOneLiveData: LiveData<List<ServersDto>> = _serverOneLiveData
    fun getServers() {
        viewModelScope.launch {
            val results: List<ServersDto>
            withContext(Dispatchers.IO) {
                results = useCase.execute()
            }
            _serverOneLiveData.value = results
        }
    }
}


