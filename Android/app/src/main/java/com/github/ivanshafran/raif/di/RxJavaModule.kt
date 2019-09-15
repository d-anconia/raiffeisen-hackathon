package com.github.ivanshafran.raif.di

import com.github.ivanshafran.raif.rxjava.SchedulerProvider
import com.github.ivanshafran.raif.rxjava.SchedulerProviderImpl
import io.reactivex.exceptions.UndeliverableException
import io.reactivex.plugins.RxJavaPlugins
import toothpick.config.Module
import java.io.IOException

class RxJavaModule : Module() {

    init {
        initializeErrorHandler()
        bind(SchedulerProvider::class.java)
            .to(SchedulerProviderImpl::class.java)
            .singletonInScope()
    }

    private fun initializeErrorHandler() {
        RxJavaPlugins.setErrorHandler { e ->
            var error = e
            if (e is UndeliverableException) {
                error = e.cause
            }

            if (error is InterruptedException || error is IOException) {
                return@setErrorHandler
            }

            if (error is NullPointerException || error is IllegalArgumentException) {
                propogate(e)
                return@setErrorHandler
            }

            if (error is IllegalStateException) {
                propogate(e)
                return@setErrorHandler
            }
        }
    }

    private fun propogate(throwable: Throwable) {
        Thread.currentThread().uncaughtExceptionHandler.uncaughtException(
            Thread.currentThread(),
            throwable
        )
    }

}
