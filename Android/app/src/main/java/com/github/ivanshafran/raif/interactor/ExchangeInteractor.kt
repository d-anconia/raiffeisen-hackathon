package com.github.ivanshafran.raif.interactor

import com.github.ivanshafran.raif.data.model.ExchangeList
import com.github.ivanshafran.raif.data.model.ExchangeUsdEuro
import com.github.ivanshafran.raif.data.repository.ExchangeRepository
import com.github.ivanshafran.raif.rxjava.SchedulerProvider
import io.reactivex.Single
import javax.inject.Inject

class ExchangeInteractor @Inject constructor(
    private val exchangeRepository: ExchangeRepository,
    private val schedulerProvider: SchedulerProvider
) {

    fun getExchangeUsdEuro(): Single<ExchangeUsdEuro> {
        return exchangeRepository
            .getExchangeList()
            .observeOn(schedulerProvider.computation())
            .map(::toUsdEuro)
    }

    private fun toUsdEuro(exchangeList: ExchangeList): ExchangeUsdEuro {
        return ExchangeUsdEuro(
            usd = exchangeList.valute.usd.value,
            euro = exchangeList.valute.euro.value
        )
    }

}
