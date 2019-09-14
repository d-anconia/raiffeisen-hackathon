package com.github.ivanshafran.raif.data.repository

import com.github.ivanshafran.raif.data.model.ExchangeList
import io.reactivex.Single
import retrofit2.http.GET

interface ExchangeRepository {

    @GET("daily_json.js")
    fun getExchangeList(): Single<ExchangeList>

}
