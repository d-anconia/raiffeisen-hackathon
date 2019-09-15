package com.github.ivanshafran.raif.ui.account

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.github.ivanshafran.raif.data.model.Account
import com.github.ivanshafran.raif.data.model.RevenueInfo

interface AccountView : MvpView {

    enum class Screen {
        INFO,
        HISTORY,
        TAX
    }

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showScreen(screen: Screen)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showAccount(account: Account)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showRevenue(revenue: RevenueInfo)

}
