package com.example.paymentapp.data.repository

class PaymentsRepository {

    private var token: String? = null
    private var login: String? = null
    private var password: String? = null

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

}