package com.mine.data.model

import com.google.gson.annotations.SerializedName

data class Servers(
    @SerializedName("id") val id: String? = null,
    @SerializedName("fields") val fields: List<Field>,
)

data class Field(
    @SerializedName("title") val title: String? = null,
    @SerializedName("ip") val ip: String? = null,
    @SerializedName("port") val port: String? = null,
    @SerializedName("image") val image: String? = null,
    @SerializedName("version") val version: String? = null,
    @SerializedName("description") val description: String? = null,
)
