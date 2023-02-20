package com.mine.data.convertor

import com.mine.data.model.Servers
import com.mine.domain.base.Convertor
import com.mine.domain.model.ServersDto

class ServersToServersDtoConvertor : Convertor<Servers, ServersDto> {
    override fun invoke(param: Servers): ServersDto {
        return ServersDto(
            param.title ?: "",
            param.ip ?: "",
            param.port ?: "",
            param.image?:"",
            param.version?:"",
            param.description?:""
            )
    }
}

