package com.example.paymentapp.view.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paymentapp.data.network.ApiService
import com.example.paymentapp.data.network.common.Common
import com.example.paymentapp.view.MyApp
import kotlinx.coroutines.launch

class ListPaymentsViewModel : ViewModel() {

    private lateinit var apiService: ApiService
    private val paymentsContent = MutableLiveData<String?>()

    private val paymentsRepository = MyApp.getInstance().paymentsRepository

    fun getPaymentsList() {

        apiService = Common.apiService
        val token = paymentsRepository.getToken()

        viewModelScope.launch {
            try {
                val resp = apiService.getPayments(token)

                paymentsRepository.setPaymentsList(resp)

                paymentsContent.value = resp.success

            } catch (e: Exception) {
                Log.e("TAG", "Exception after request -> ${e.localizedMessage}")
            }
        }
    }

    fun getStatus() : LiveData<String?> {
        return paymentsContent
    }
}