package com.mine.domain.model

data class ServersDto(
    val name: String,
    val id: String,
    val fields: List<Field>,
)

data class Field(
    val title: String,
    val ip: String,
    val port: Int,
    val image: String,
    val version: String,
    val description: String,

)



