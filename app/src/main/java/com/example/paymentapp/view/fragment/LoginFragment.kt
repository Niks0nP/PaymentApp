package com.example.paymentapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.paymentapp.R
import com.example.paymentapp.databinding.LoginLayoutBinding
import com.example.paymentapp.view.viewModel.MyViewModel

class LoginFragment: Fragment() {

    private var _binding: LoginLayoutBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LoginLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[MyViewModel::class.java]

        setText()
    }

    private fun setText() {
        binding.loginButton.setOnClickListener{
            val login = binding.loginTextview.text.toString()
            val password = binding.passwordTextview.text.toString()
            viewModel.setText(login, password)

            sendPostRequest()

//            Если не пройдена авторизация, не переходить на другой Fragment
            viewModel.getResponse().observe(viewLifecycleOwner, Observer { value ->
                if (value != null){
//                    println("Token: ${value}")
                    val fragmentTransaction = parentFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.fragment_container, PaymentPageFragment())
                    fragmentTransaction.commit()

//                    viewModel.getPaymentsList()
                }else {
                    // какая то реализация
                }
            })
        }
    }

    private fun sendPostRequest() {
        viewModel.sendPostRequest()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}