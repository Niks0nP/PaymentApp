package com.example.paymentapp.data.repository

import com.example.paymentapp.data.model.ResponsePayments

class PaymentsRepository {

    private var token: String? = null
    private var login: String? = null
    private var password: String? = null
    private var status: String? = null
    private lateinit var paymentsList: ResponsePayments

    fun setStatus(statusLog: String) {
        status = statusLog
    }

    fun getStatus() : String? {
        return status
    }

    fun setToken(tokenPay: String?) {
        token = tokenPay
    }
    fun getToken(): String? {
        return token
    }

    fun setLogin(loginUser: String?) {
        login = loginUser
    }

    fun getLogin(): String? {
        return login
    }

    fun  setPassword(passwordUser: String?) {
        password = passwordUser
    }

    fun getPassword(): String? {
        return password
    }

    fun setPaymentsList(paymentsL: ResponsePayments) {
        paymentsList = paymentsL
    }

    fun getPaymentsList() : ResponsePayments {
        return paymentsList
    }

}