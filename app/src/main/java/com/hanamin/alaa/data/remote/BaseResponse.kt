package com.hanamin.alaa.data.remote

import com.google.gson.annotations.SerializedName

open class BaseResponse {
    @SerializedName("Response")
    var responses = ""
    @SerializedName("Error")
    var error = ""
}
