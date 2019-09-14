package com.github.ivanshafran.raif.data.model

import com.google.gson.annotations.SerializedName

class ExchangeUsd(
    @SerializedName("Value")
    val value: String
)

class ExchangeEuro(
    @SerializedName("Value")
    val value: String
)

class ExchangeValute(
    @SerializedName("USD")
    val usd: ExchangeUsd,
    @SerializedName("EUR")
    val euro: ExchangeEuro
)

class ExchangeList(
    @SerializedName("Valute")
    val valute: ExchangeValute
)
