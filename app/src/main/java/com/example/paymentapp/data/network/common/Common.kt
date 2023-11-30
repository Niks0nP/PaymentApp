package com.example.paymentapp.data.network.common

import com.example.paymentapp.data.network.ApiService
import com.example.paymentapp.data.network.RetrofitClass

object Common {
    private val BASE_URL = "https://easypay.world/api-test/"

    val apiService: ApiService
        get() = RetrofitClass.retrofitClient(BASE_URL).create(ApiService::class.java)
}