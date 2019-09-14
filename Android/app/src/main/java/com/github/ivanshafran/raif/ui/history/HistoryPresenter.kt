package com.github.ivanshafran.raif.ui.history

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.github.ivanshafran.raif.data.model.Transaction
import com.github.ivanshafran.raif.interactor.TranscationInteractor
import com.github.ivanshafran.raif.rxjava.SchedulerProvider
import io.reactivex.disposables.Disposable
import javax.inject.Inject

@InjectViewState
class HistoryPresenter @Inject constructor(
    private val transcationInteractor: TranscationInteractor,
    private val schedulerProvider: SchedulerProvider
) : MvpPresenter<HistoryView>() {

    private var disposable: Disposable? = null

    override fun onFirstViewAttach() {
        disposable = transcationInteractor
            .getTransactions()
            .observeOn(schedulerProvider.ui())
            .subscribe(::onSuccess)
    }

    private fun onSuccess(transactions: List<Transaction>) {
        viewState.showTranscations(transactions)
    }

    override fun onDestroy() {
        disposable?.dispose()
    }

}