package com.mine.domain.model

data class ServerItemType(
    val title: String,
    val ip: String,
    val port: String,
    val image: Int,
    val action: () -> Unit
)








