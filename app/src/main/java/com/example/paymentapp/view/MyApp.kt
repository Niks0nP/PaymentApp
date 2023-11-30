package com.example.paymentapp.view

import android.app.Application
import com.example.paymentapp.data.repository.PaymentsRepository

class MyApp : Application() {

    val paymentsRepository = PaymentsRepository()

    companion object {
        private lateinit var instance: MyApp

        fun getInstance(): MyApp {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}