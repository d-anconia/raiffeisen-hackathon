package com.github.ivanshafran.raif.di

import android.content.Context
import toothpick.config.Module

class AppModule(context: Context) : Module() {

    init {
        bind(Context::class.java).toInstance(context)
    }

}
