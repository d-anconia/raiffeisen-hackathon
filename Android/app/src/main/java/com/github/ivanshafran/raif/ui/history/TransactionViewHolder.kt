package com.github.ivanshafran.raif.ui.history

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.ivanshafran.raif.R

abstract class TransactionViewHolder(view: View) : RecyclerView.ViewHolder(view)

class AddReceiptViewHolder(
    view: View
) : TransactionViewHolder(view) {

    interface Listener {
        fun onClick()
    }

    private var listener: Listener? = null

    init {
        view.setOnClickListener { listener?.onClick() }
    }

    fun bind(listener: Listener) {
        this.listener = listener
    }

}

class TransactionInfoViewHolder(view: View) : TransactionViewHolder(view) {

    private val fromNameTextView = view.findViewById<TextView>(R.id.fromNameTextView)
    private val dateTextView = view.findViewById<TextView>(R.id.dateTextView)
    private val volumeTextView = view.findViewById<TextView>(R.id.volumeTextView)
    private val typeImageView = view.findViewById<ImageView>(R.id.typeIcon)

    fun bind(transaction: TransactionInfo) {
        val context = fromNameTextView.context
        fromNameTextView.text = transaction.name
        volumeTextView.text = context.getString(
            R.string.transaction_rub,
            transaction.volume.toString()
        )
        dateTextView.text = transaction.date
        typeImageView.setImageResource(
            if (transaction.isCash) {
                R.drawable.ic_cash
            } else {
                R.drawable.ic_online
            }
        )
    }

}
