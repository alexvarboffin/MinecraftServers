package com.mine.data

import com.google.gson.annotations.SerializedName
import com.mine.data.model.Servers

data class BaseResponse(
    @SerializedName("server1.1-1.16") var serverOneList: Servers?,

    @SerializedName("server1.16-1.19") var serverTwoList: Servers?,

    @SerializedName("serverMiniGames") var serverGamesList: Servers?,
)

