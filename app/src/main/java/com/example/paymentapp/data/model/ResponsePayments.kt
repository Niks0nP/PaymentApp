package com.example.paymentapp.data.model

import com.google.gson.annotations.SerializedName

data class ResponsePayments(
    @SerializedName("response")
    val response: List<ResponseList>,
    @SerializedName("success")
    val success: String?
)