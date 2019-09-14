package com.github.ivanshafran.raif.ui.signin

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface SignInView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showProgressBar(shouldShow: Boolean)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showError()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openStartScreen()

}
