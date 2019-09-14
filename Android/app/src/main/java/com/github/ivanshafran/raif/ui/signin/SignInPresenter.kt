package com.github.ivanshafran.raif.ui.signin

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.github.ivanshafran.raif.data.model.SignInArgs
import com.github.ivanshafran.raif.interactor.SignInInteractor
import com.github.ivanshafran.raif.rxjava.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@InjectViewState
class SignInPresenter @Inject constructor(
    private val signInInteractor: SignInInteractor,
    private val schedulerProvider: SchedulerProvider
) : MvpPresenter<SignInView>() {

    private val compositeDisposable = CompositeDisposable()

    fun onLoginClicked(signInArgs: SignInArgs) {
        viewState.showProgressBar(true)
        val disposable = signInInteractor
            .signIn(signInArgs)
            .observeOn(schedulerProvider.ui())
            .subscribe(::onComplete, ::onError)
        compositeDisposable.add(disposable)
    }

    private fun onComplete() {

    }

    private fun onError(throwable: Throwable) {
        viewState.showProgressBar(false)
        viewState.showError()
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }

}
