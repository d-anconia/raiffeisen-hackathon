package com.github.ivanshafran.raif.ui.account_list

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.github.ivanshafran.raif.data.model.ExchangeUsdEuro

interface AccountListView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showExchange(exchangeUsdEuro: ExchangeUsdEuro)

}
