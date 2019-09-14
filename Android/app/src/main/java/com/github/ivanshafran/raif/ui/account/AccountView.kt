package com.github.ivanshafran.raif.ui.account

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.github.ivanshafran.raif.data.model.Transaction

interface AccountView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showTranscations(transcations: List<Transaction>)

}
