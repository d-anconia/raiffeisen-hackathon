package com.github.ivanshafran.raif.ui.history

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface HistoryView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showTranscations(transcations: List<TransactionViewModel>)

}
