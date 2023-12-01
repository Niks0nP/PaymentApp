package com.example.paymentapp.data.model

import com.google.gson.annotations.SerializedName

data class Error(
    @SerializedName("error_code")
    val errorCode: Int,
    @SerializedName("error_msg")
    val errorMsg: String
)