package com.github.ivanshafran.raif.ui.account

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.github.ivanshafran.raif.data.model.Transaction
import com.github.ivanshafran.raif.interactor.TranscationInteractor
import com.github.ivanshafran.raif.rxjava.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@InjectViewState
class AccountPresenter @Inject constructor(
    private val transactionInteractor: TranscationInteractor,
    private val schedulerProvider: SchedulerProvider
): MvpPresenter<AccountView>() {

    private val compositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        val transactionDisposable = transactionInteractor
            .getTransactions()
            .observeOn(schedulerProvider.ui())
            .subscribe(::onSuccess)

        compositeDisposable.add(transactionDisposable)
    }

    private fun onSuccess(transactions: List<Transaction>) {
        viewState.showTranscations(transactions)
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }

}
