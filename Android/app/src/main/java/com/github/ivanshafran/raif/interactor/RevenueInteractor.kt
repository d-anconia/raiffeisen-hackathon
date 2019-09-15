package com.github.ivanshafran.raif.interactor

import com.github.ivanshafran.raif.data.model.RevenueInfo
import com.github.ivanshafran.raif.data.repository.APIRepository
import com.github.ivanshafran.raif.data.repository.UserInfoRepository
import com.github.ivanshafran.raif.rxjava.SchedulerProvider
import io.reactivex.Single
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class RevenueInteractor @Inject constructor(
    private val apiRepository: APIRepository,
    private val schedulerProvider: SchedulerProvider,
    private val userInfoRepository: UserInfoRepository
) {

    fun getRevenue(): Single<RevenueInfo> {
        return Single
            .create<RevenueInfo> { emitter ->
                val userId = userInfoRepository.getUserId()
                if (userId == null) {
                    return@create
                }
                val (yearValue, taxValue) = getYearAndTaxValue(userId)
                emitter.onSuccess(
                    RevenueInfo(
                        monthName = getMonthName(),
                        yearToDate = getYearTo(),
                        monthValue = getMonthValue(userId),
                        taxValue = taxValue,
                        yearValue = yearValue
                    )
                )
            }
            .subscribeOn(schedulerProvider.io())
    }

    private fun getMonthName(): String {
        val format = SimpleDateFormat("MMMM")
        val calendar = Calendar.getInstance()
        return format.format(calendar.time)
    }

    private fun getYearTo(): String {
        val format = SimpleDateFormat("dd MMMM yyyy")
        val calendar = getTaxEndCalendar()
        return format.format(calendar.time)
    }

    private fun getMonthValue(userId: String): String {
        val calendarNow = Calendar.getInstance()
        val calendarMonthStart = Calendar.getInstance()
        calendarMonthStart.set(Calendar.DAY_OF_MONTH, 1)
        val transactions = apiRepository.getTransactionsByPeriod(
            userId = userId,
            from = calendarMonthStart.timeInMillis,
            to = calendarNow.timeInMillis
        ).blockingGet()

        return transactions.sumByDouble { it.volume.toDouble() }.toString()
    }

    private fun getYearAndTaxValue(userId: String): Pair<String, String> {
        val calendarTaxYearEnd = getTaxEndCalendar()
        val calendarTaxYearStart = getTaxEndCalendar()
        calendarTaxYearStart.timeInMillis =
            calendarTaxYearStart.timeInMillis - TimeUnit.DAYS.toMillis(365)

        val transactions = apiRepository.getTransactionsByPeriod(
            userId = userId,
            from = calendarTaxYearStart.timeInMillis,
            to = calendarTaxYearEnd.timeInMillis
        ).blockingGet()

        val year = transactions.sumByDouble { it.volume.toDouble() }
        val tax = year * 4 / 100

        return Pair(year.toString(), tax.toString())
    }

    private fun getTaxEndCalendar(): Calendar {
        val calendar = Calendar.getInstance()
        calendar.set(2020, Calendar.APRIL, 1)
        return calendar
    }

}
