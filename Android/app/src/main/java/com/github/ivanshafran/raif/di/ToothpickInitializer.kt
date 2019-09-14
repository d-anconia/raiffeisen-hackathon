package com.github.ivanshafran.raif.di

import toothpick.Toothpick

object ToothpickInitializer {

    fun initialize() {
        Toothpick
            .openScope(Scopes.GLOBAL_SCOPE)
            .installModules(DiModule())
    }

}
