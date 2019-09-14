package com.github.ivanshafran.raif.ui.history

import java.math.BigDecimal

sealed class TransactionViewModel

object AddReceiptViewModel : TransactionViewModel()

class TransactionInfo(
    val name: String,
    val volume: BigDecimal,
    val date: String,
    val isCash: Boolean
) : TransactionViewModel()
