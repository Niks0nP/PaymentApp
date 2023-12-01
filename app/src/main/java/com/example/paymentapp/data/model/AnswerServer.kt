package com.example.paymentapp.data.model

import com.google.gson.annotations.SerializedName

data class AnswerServer(
    @SerializedName("response")
    val response: Response?,
    @SerializedName("success")
    val success: String,
    @SerializedName("error")
    val error: Error?
)