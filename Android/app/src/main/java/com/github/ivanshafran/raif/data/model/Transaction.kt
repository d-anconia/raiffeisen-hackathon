package com.github.ivanshafran.raif.data.model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

class Transaction(
    @SerializedName("accountFrom")
    val accountFrom: Long,
    val nameFrom: String,
    @SerializedName("accountTo")
    val accountTo: Long,
    @SerializedName("volume")
    val volume: BigDecimal
)
