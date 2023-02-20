package com.mine.domain.model


data class ServersDto(
    val title: String,
    val ip: String,
    val port: String,
    val image: String,
    val version: String,
    val description: String,
)

data class Test(
 val fields: List<Field>
)

data class Field(
    val title: String,
    val ip: String,
    val port: String,
    val image: String,
    val version: String,
    val description: String,
)