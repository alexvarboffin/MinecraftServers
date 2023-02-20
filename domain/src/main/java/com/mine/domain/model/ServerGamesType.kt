package com.mine.domain.model

data class ServerGamesType(
    val title: String,
    val ip: String,
    val port: String,
    val version: String,
    val image: Int,
    val action: () -> Unit,
)