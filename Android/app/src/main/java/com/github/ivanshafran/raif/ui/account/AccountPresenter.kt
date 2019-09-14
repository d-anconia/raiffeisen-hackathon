package com.github.ivanshafran.raif.ui.account

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import javax.inject.Inject

@InjectViewState
class AccountPresenter @Inject constructor(

) : MvpPresenter<AccountView>() {

    override fun onFirstViewAttach() {
        viewState.showScreen(AccountView.Screen.HISTORY)
    }

}
