package com.mine.data

import com.google.gson.annotations.SerializedName

data class BaseResponse<DATA_TYPE>(
    @SerializedName("data") var data: DATA_TYPE?,
)