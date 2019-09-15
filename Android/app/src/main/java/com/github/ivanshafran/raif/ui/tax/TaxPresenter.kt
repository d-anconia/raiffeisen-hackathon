package com.github.ivanshafran.raif.ui.tax

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.github.ivanshafran.raif.data.model.RevenueInfo
import com.github.ivanshafran.raif.interactor.RevenueInteractor
import com.github.ivanshafran.raif.rxjava.SchedulerProvider
import io.reactivex.disposables.Disposable
import javax.inject.Inject

@InjectViewState
class TaxPresenter @Inject constructor(
    private val revenueInteractor: RevenueInteractor,
    private val schedulerProvider: SchedulerProvider
) : MvpPresenter<TaxView>() {

    private var disposable: Disposable? = null

    override fun onFirstViewAttach() {
        disposable = revenueInteractor
            .getRevenue()
            .observeOn(schedulerProvider.ui())
            .subscribe(::onSuccess)
    }

    private fun onSuccess(info: RevenueInfo) {
        viewState.showRevenue(info)
    }

    override fun onDestroy() {
        disposable?.dispose()
    }

}
