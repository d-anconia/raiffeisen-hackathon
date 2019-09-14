package com.github.ivanshafran.raif.di

import com.github.ivanshafran.raif.rxjava.SchedulerProvider
import com.github.ivanshafran.raif.rxjava.SchedulerProviderImpl
import toothpick.config.Module

class RxJavaModule : Module() {

    init {
        bind(SchedulerProvider::class.java)
            .to(SchedulerProviderImpl::class.java)
            .singletonInScope()
    }

}
