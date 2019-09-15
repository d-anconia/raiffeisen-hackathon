package com.github.ivanshafran.raif.di

import android.content.Context
import toothpick.Toothpick

object ToothpickInitializer {

    fun initialize(context: Context) {
        Toothpick
            .openScope(Scopes.GLOBAL_SCOPE)
            .installModules(
                AppModule(context),
                DataModule(),
                RxJavaModule(),
                InteractorModule()
            )
    }

}
