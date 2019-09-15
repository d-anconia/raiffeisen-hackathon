package com.github.ivanshafran.raif.ui.account_list

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.github.ivanshafran.raif.data.model.ExchangeUsdEuro
import com.github.ivanshafran.raif.interactor.ExchangeInteractor
import com.github.ivanshafran.raif.rxjava.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@InjectViewState
class AccountListPresenter @Inject constructor(
    private val exchangeInteractor: ExchangeInteractor,
    private val schedulerProvider: SchedulerProvider
) : MvpPresenter<AccountListView>() {

    private val compositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        val disposable = exchangeInteractor
            .getExchangeUsdEuro()
            .observeOn(schedulerProvider.ui())
            .subscribe(::onSuccess)
        compositeDisposable.add(disposable)
    }

    private fun onSuccess(exchangeUsdEuro: ExchangeUsdEuro) {
        viewState.showExchange(exchangeUsdEuro)
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }

    fun onCardClick() {
        viewState.openAccountScreen()
    }

}
