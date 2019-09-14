package com.github.ivanshafran.raif.ui.account

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.ivanshafran.raif.R
import com.github.ivanshafran.raif.data.model.Transaction

class TransactionViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val fromNameTextView = view.findViewById<TextView>(R.id.fromNameTextView)
    private val volumeTextView = view.findViewById<TextView>(R.id.volumeTextView)

    fun bind(transaction: Transaction) {
        fromNameTextView.text = transaction.nameFrom
        volumeTextView.text = transaction.volume.toString()
    }

}
