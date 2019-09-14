package com.github.ivanshafran.raif.ui.main

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface MainView : MvpView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openSignIn()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openStartScreen()

}
