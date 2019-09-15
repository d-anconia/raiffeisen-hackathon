package com.github.ivanshafran.raif.ui.account

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.github.ivanshafran.raif.data.model.Account
import com.github.ivanshafran.raif.data.model.RevenueInfo
import com.github.ivanshafran.raif.interactor.AccountInteractor
import com.github.ivanshafran.raif.interactor.RevenueInteractor
import com.github.ivanshafran.raif.rxjava.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@InjectViewState
class AccountPresenter @Inject constructor(
    private val accountInteractor: AccountInteractor,
    private val revenueInteractor: RevenueInteractor,
    private val schedulerProvider: SchedulerProvider
) : MvpPresenter<AccountView>() {

    private var compositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        viewState.showScreen(AccountView.Screen.HISTORY)

        val accountDisposable = accountInteractor
            .getAccount()
            .observeOn(schedulerProvider.ui())
            .subscribe(::onAccountSuccess)

        compositeDisposable.add(accountDisposable)

        val revenueDisposable = revenueInteractor
            .getRevenue()
            .observeOn(schedulerProvider.ui())
            .subscribe(::onRevenueSuccess)
        compositeDisposable.add(revenueDisposable)
    }

    private fun onAccountSuccess(account: Account) {
        viewState.showAccount(account)
    }

    private fun onRevenueSuccess(revenue: RevenueInfo) {
        viewState.showRevenue(revenue)
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }

    fun onTabSelected(position: Int) {
        viewState.showScreen(AccountView.Screen.values()[position])
    }

}
