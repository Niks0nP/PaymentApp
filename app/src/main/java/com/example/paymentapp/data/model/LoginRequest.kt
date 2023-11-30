package com.example.paymentapp.data.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("login") val login: String?,
    @SerializedName("password") val password: String?
)

data class TokenResponse(
    @SerializedName("token") val token: String
)

data class PaymentModel(
    @SerializedName("name") val name: String
    //добавить доп. поля
)