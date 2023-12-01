package com.example.paymentapp.data.model

import com.google.gson.annotations.SerializedName

data class ResponseList(
    @SerializedName("amount")
    val amount: String? = null,
    @SerializedName("created")
    val created: String? = null,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String
)