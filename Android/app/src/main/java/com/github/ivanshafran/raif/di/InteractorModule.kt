package com.github.ivanshafran.raif.di

import com.github.ivanshafran.raif.interactor.SignInInteractor
import toothpick.config.Module

class InteractorModule : Module() {

    init {
        bind(SignInInteractor::class.java).singletonInScope()
    }

}
