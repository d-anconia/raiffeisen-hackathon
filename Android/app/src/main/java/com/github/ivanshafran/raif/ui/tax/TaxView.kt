package com.github.ivanshafran.raif.ui.tax

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.github.ivanshafran.raif.data.model.RevenueInfo

interface TaxView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showRevenue(info: RevenueInfo)

}
