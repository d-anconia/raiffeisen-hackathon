package com.github.ivanshafran.raif.di

import com.github.ivanshafran.raif.interactor.AccountInteractor
import com.github.ivanshafran.raif.interactor.RevenueInteractor
import com.github.ivanshafran.raif.interactor.SignInInteractor
import com.github.ivanshafran.raif.interactor.TranscationInteractor
import toothpick.config.Module

class InteractorModule : Module() {

    init {
        bind(SignInInteractor::class.java).singletonInScope()
        bind(TranscationInteractor::class.java).singletonInScope()
        bind(AccountInteractor::class.java).singletonInScope()
        bind(RevenueInteractor::class.java).singletonInScope()
    }

}
