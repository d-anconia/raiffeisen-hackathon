package com.github.ivanshafran.raif.ui.main

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.github.ivanshafran.raif.data.repository.UserInfoRepository
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(
    private val userInfoRepository: UserInfoRepository
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        if (userInfoRepository.getUserId() == null) {
            viewState.openSignIn()
        } else {
            viewState.openAccount()
        }
    }

}
