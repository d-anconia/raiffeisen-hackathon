package com.github.ivanshafran.raif.ui.account

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface AccountView : MvpView {

    enum class Screen {
        INFO,
        HISTORY,
        TAX
    }

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showScreen(screen: Screen)

}
