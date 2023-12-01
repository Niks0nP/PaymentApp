package com.example.paymentapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.paymentapp.R
import com.example.paymentapp.data.model.ResponseList

class PaymentsRecyclerAdapter(private var paymentsList: List<ResponseList>) :
    RecyclerView.Adapter<PaymentsRecyclerAdapter.PaymentsRecyclerHolder>() {

    class PaymentsRecyclerHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleText: TextView
        val amountText: TextView
        val createdText: TextView
        init{
            titleText = view.findViewById(R.id.title_text_view)
            amountText = view.findViewById(R.id.amount_text_view)
            createdText = view.findViewById(R.id.created_text_view)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentsRecyclerHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item, parent, false)

        return PaymentsRecyclerHolder(view)
    }

    override fun onBindViewHolder(holder: PaymentsRecyclerHolder, position: Int) {
        val list = paymentsList[position]

        with(holder) {
            titleText.text = list.title
            amountText.text = "Amount: ${list.amount}"
            createdText.text = "Created: ${list.created}"
        }
    }

    fun setListening(payList: List<ResponseList>) {
        paymentsList = payList
        notifyDataSetChanged()
    }

    override fun getItemCount() = paymentsList.size
}