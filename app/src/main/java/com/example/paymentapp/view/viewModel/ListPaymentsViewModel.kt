package com.example.paymentapp.view.viewModel

import android.util.Log
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
        paymentsContent.value = paymentsRepository.getToken()

        viewModelScope.launch {
            try {
                apiService.getPayments(paymentsContent.value)
            } catch (e: Exception) {
                Log.e("TAG", "Exception after request -> ${e.localizedMessage}")
            }
        }
    }
}