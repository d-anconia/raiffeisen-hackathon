package com.github.ivanshafran.raif.di

import com.github.ivanshafran.raif.data.repository.*
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import toothpick.config.Module

class DataModule : Module() {

    init {
        bind(APIRepository::class.java)
            .toInstance(createApiRepository())

        bind(ExchangeRepository::class.java)
            .toInstance(createExchangeRepository())

        bind(UserInfoRepository::class.java)
            .to(UserInfoRepositoryImpl::class.java)
            .singletonInScope()
    }

    private fun createApiRepository(): APIRepository {
        val retrofit = Retrofit
            .Builder()
            .baseUrl("http://10.91.5.152:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
        return retrofit.create(APIRepository::class.java)
    }

    private fun createExchangeRepository(): ExchangeRepository {
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://www.cbr-xml-daily.ru/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()

        return retrofit.create(ExchangeRepository::class.java)
    }

}
