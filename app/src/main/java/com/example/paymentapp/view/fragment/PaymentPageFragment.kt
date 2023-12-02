package com.example.paymentapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paymentapp.R
import com.example.paymentapp.databinding.PaymentsPageBinding
import com.example.paymentapp.view.MyApp
import com.example.paymentapp.view.adapter.PaymentsRecyclerAdapter
import com.example.paymentapp.view.viewModel.ListPaymentsViewModel


class PaymentPageFragment : Fragment() {

    private var _binding: PaymentsPageBinding? = null
    private val binding get() = _binding!!

    private lateinit var listPaymentsViewModel: ListPaymentsViewModel
    private lateinit var adapter: PaymentsRecyclerAdapter
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

        binding.paymentsRecyclerView.setHasFixedSize(true)
        binding.paymentsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = PaymentsRecyclerAdapter(listOf())
        binding.paymentsRecyclerView.adapter = adapter

        getPayments()
    }

    fun getPayments() {
        listPaymentsViewModel.getPaymentsList()

        listPaymentsViewModel.getStatus().observe(viewLifecycleOwner, Observer {value ->
            if (value == "true") {
                adapter.setListening(listPaymentsViewModel.getList())
            } else
                Toast.makeText(context, "Exception with token", Toast.LENGTH_SHORT).show()

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}