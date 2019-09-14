package com.github.ivanshafran.raif.ui.account

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.github.ivanshafran.raif.data.model.Account
import com.github.ivanshafran.raif.interactor.AccountInteractor
import com.github.ivanshafran.raif.rxjava.SchedulerProvider
import io.reactivex.disposables.Disposable
import javax.inject.Inject

@InjectViewState
class AccountPresenter @Inject constructor(
    private val accountInteractor: AccountInteractor,
    private val schedulerProvider: SchedulerProvider
) : MvpPresenter<AccountView>() {

    private var disposable: Disposable? = null

    override fun onFirstViewAttach() {
        viewState.showScreen(AccountView.Screen.HISTORY)

        disposable = accountInteractor
            .getAccount()
            .observeOn(schedulerProvider.ui())
            .subscribe(::onSuccess)
    }

    private fun onSuccess(account: Account) {
        viewState.showAccount(account)
    }

    override fun onDestroy() {
        disposable?.dispose()
    }

    fun onTabSelected(position: Int) {
        viewState.showScreen(AccountView.Screen.values()[position])
    }

}
