package com.example.paymentapp.data.model

data class ResponsePayments(
    val response: List<ResponseList>,
    val success: String?
)