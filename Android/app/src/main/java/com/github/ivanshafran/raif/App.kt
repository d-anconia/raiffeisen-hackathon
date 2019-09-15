package com.github.ivanshafran.raif

import android.app.Application
import com.github.ivanshafran.raif.di.ToothpickInitializer

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        ToothpickInitializer.initialize(this)
    }

}
