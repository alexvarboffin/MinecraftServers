package com.mine.data.convertor

import com.mine.data.model.Servers
import com.mine.domain.base.Convertor
import com.mine.domain.model.Field
import com.mine.domain.model.ServersDto

class ServersToServersDtoConvertor : Convertor<Servers, ServersDto> {
    override fun invoke(params: Servers): ServersDto {
        return ServersDto(
            params.name ?: "",
            params.id ?: "",
            params.fields.map {
                Field(
                    it.title ?: "",
                    it.ip ?: "",
                    it.port ?: -1,
                    it.image ?: "",
                    it.version ?: "",
                    it.description ?: ""
                )
            }
        )
    }
}




