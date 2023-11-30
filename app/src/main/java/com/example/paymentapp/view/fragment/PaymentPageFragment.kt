package com.example.paymentapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.paymentapp.R
import com.example.paymentapp.data.repository.PaymentsRepository
import com.example.paymentapp.databinding.PaymentsPageBinding
import com.example.paymentapp.view.MyApp
import com.example.paymentapp.view.viewModel.ListPaymentsViewModel


class PaymentPageFragment : Fragment() {

    private var _binding: PaymentsPageBinding? = null
    private val binding get() = _binding!!
//    private val paymentsRepository: PaymentsRepository?
//        get() = (activity?.applicationContext as? MyApp)?.paymentsRepository

    private lateinit var listPaymentsViewModel: ListPaymentsViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PaymentsPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listPaymentsViewModel = ViewModelProvider(this)[ListPaymentsViewModel::class.java]

        binding.buttonBack.setOnClickListener{
            val fragmentTransaction = parentFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, LoginFragment())
            fragmentTransaction.commit()
        }
    }

    override fun onResume() {
        super.onResume()

        getPayments()
    }

    fun getPayments() {
        listPaymentsViewModel.getPaymentsList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}