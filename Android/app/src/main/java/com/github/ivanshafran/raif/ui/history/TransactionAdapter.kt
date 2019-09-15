package com.github.ivanshafran.raif.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.ivanshafran.raif.R

class TransactionAdapter(
    private val listener: AddReceiptViewHolder.Listener
) : RecyclerView.Adapter<TransactionViewHolder>() {

    companion object {
        private const val ADD_RECEIPT = 0
        private const val TRANSACTION = 1
    }

    private var transactions: List<TransactionViewModel> = listOf()

    fun setTranscations(transactions: List<TransactionViewModel>) {
        this.transactions = transactions
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            ADD_RECEIPT -> {
                val view = inflater.inflate(R.layout.list_item_receipt_create, parent, false)
                AddReceiptViewHolder(view)
            }
            TRANSACTION -> {
                val view = inflater.inflate(R.layout.list_item_transaction, parent, false)
                TransactionInfoViewHolder(view)
            }
            else -> throw IllegalStateException()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (transactions[position]) {
            AddReceiptViewModel -> ADD_RECEIPT
            is TransactionInfo -> TRANSACTION
        }
    }

    override fun getItemCount(): Int {
        return transactions.size
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        if (holder is AddReceiptViewHolder) {
            holder.bind(listener)
        } else if (holder is TransactionInfoViewHolder) {
            holder.bind(transactions[position] as TransactionInfo)
        }
    }
}
