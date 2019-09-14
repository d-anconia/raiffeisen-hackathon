package com.github.ivanshafran.raif.ui.signin

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.github.ivanshafran.raif.data.model.SignInData
import com.github.ivanshafran.raif.data.repository.APIRepository
import javax.inject.Inject

@InjectViewState
class SignInPresenter @Inject constructor(
    private val apiRepository: APIRepository
) : MvpPresenter<SignInView>() {

    fun onLoginClicked(signInData: SignInData) {

    }

}
