package com.mine.minecraftservers.fragment.servers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mine.domain.model.ServersDto
import com.mine.domain.usecase.GetServersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ServersViewModel(private val serversUseCase: GetServersUseCase) : ViewModel() {
    private val _serversLiveData = MutableLiveData<List<ServersDto>>()
    val serversLiveData: LiveData<List<ServersDto>> = _serversLiveData
    fun getServers(count: Int) {
        viewModelScope.launch {
            _serversLiveData.value = serversUseCase.execute(count)

        }
    }
}


//class ImagesViewModel(private val usersUseCase: GetImagesUseCase) : ViewModel() {
//
//    private val _userLiveData = MutableLiveData<List<ImagesDto>>()
//    val userLiveData: LiveData<List<ImagesDto>> = _userLiveData
//
//    fun getImages(count: Int) {
//        viewModelScope.launch {
//            val result: List<ImagesDto>
//            withContext(Dispatchers.IO) {
//                result = usersUseCase.execute(count)
//            }
//            _userLiveData.value = result
//        }
//    }
//}