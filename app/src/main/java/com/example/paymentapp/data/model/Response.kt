package com.example.paymentapp.data.model

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("token")
    val token: String?
)