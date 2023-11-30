package com.example.paymentapp.data.network

import com.example.paymentapp.data.model.AnswerServer
import com.example.paymentapp.data.model.LoginRequest
import com.example.paymentapp.data.model.PaymentModel
import com.example.paymentapp.data.model.ResponsePayments
import com.example.paymentapp.data.model.TokenResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @Headers("app-key: 12345", "v: 1")
    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest): AnswerServer

    @Headers("app-key: 12345", "v: 1")
    @GET("payments")
    suspend fun getPayments(@Header("token") token: String?): ResponsePayments
}