package com.mine.minecraftservers.fragment.servers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

//class ServersViewModel(private val useCase: ServersUseCase) : ViewModel() {
//    private val _serversLiveData = MutableLiveData<List<ServersDto>>()
//    val serversLiveData: LiveData<List<ServersDto>> = _serversLiveData
//    fun getServers() {
//        viewModelScope.launch {
//           _serversLiveData.value = useCase.execute()
//
//        }
//    }
//}
