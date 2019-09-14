package com.github.ivanshafran.raif.data.model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

class Account(
    @SerializedName("balance")
    val balance: BigDecimal,
    @SerializedName("cardname")
    val cardName: String
)
