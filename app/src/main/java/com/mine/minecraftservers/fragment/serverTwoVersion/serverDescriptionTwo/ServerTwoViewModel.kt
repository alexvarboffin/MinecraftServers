package com.mine.minecraftservers.fragment.serverTwoVersion.serverDescriptionTwo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mine.domain.model.ServersDto
import com.mine.domain.usecase.ServersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ServerTwoViewModel(private val useCase: ServersUseCase) : ViewModel() {
    private val _serverTwoLiveData = MutableLiveData<List<ServersDto>>()
    val serverTwoLiveData: LiveData<List<ServersDto>> = _serverTwoLiveData
    fun getServers() {
        viewModelScope.launch {
            val result: List<ServersDto>
            withContext(Dispatchers.IO) {
                result = useCase.execute()
            }
            _serverTwoLiveData.value = result
        }
    }
}
