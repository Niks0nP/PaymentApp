package com.example.paymentapp.view.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paymentapp.data.model.LoginRequest
import com.example.paymentapp.data.network.ApiService
import com.example.paymentapp.data.network.common.Common
import com.example.paymentapp.view.MyApp
import kotlinx.coroutines.launch

class MyViewModel() : ViewModel() {

    private lateinit var apiService: ApiService
    private val tokenContent = MutableLiveData<String?>()

    private val paymentsRepository = MyApp.getInstance().paymentsRepository

    fun setText(log: String, pass: String) {
        paymentsRepository.setLogin(log)
        paymentsRepository.setPassword(pass)
    }

    fun sendPostRequest() {

        apiService = Common.apiService
        val loginClient = LoginRequest(paymentsRepository.getLogin(),
            paymentsRepository.getPassword())

        viewModelScope.launch {
            try {
                apiService.login(loginClient)
                val resp = apiService.login(loginClient)
                val response = resp.response.token

                paymentsRepository.setToken(response)
                tokenContent.value = paymentsRepository.getToken()
            } catch (e: Exception) {
                Log.e("TAG", "Exception after request -> ${e.localizedMessage}")
            }
        }
    }

    fun getResponse(): LiveData<String?> {
        return tokenContent
    }

//    fun getPaymentsList() {
//
//        apiService = Common.apiService
//
//        viewModelScope.launch {
//            try {
//                apiService.getPayments(tokenContent.value)
//            } catch (e: Exception) {
//                Log.e("TAG", "Exception after request -> ${e.localizedMessage}")
//            }
//        }
//    }
}