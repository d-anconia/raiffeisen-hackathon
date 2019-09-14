package com.github.ivanshafran.raif.di

import com.github.ivanshafran.raif.data.repository.APIRepository
import com.github.ivanshafran.raif.data.repository.UserInfoRepository
import com.github.ivanshafran.raif.data.repository.UserInfoRepositoryImpl
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import toothpick.config.Module

class DataModule : Module() {

    init {
        val retrofit = createRetrofit()
        val apiRepository: APIRepository = retrofit.create(APIRepository::class.java)
        bind(APIRepository::class.java)
            .toInstance(apiRepository)
        bind(UserInfoRepository::class.java)
            .to(UserInfoRepositoryImpl::class.java)
            .singletonInScope()
    }

    private fun createRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("http://10.91.5.152:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }

}
