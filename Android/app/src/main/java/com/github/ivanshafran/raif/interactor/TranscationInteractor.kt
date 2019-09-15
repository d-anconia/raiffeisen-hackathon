package com.github.ivanshafran.raif.interactor

import com.github.ivanshafran.raif.data.model.Transaction
import com.github.ivanshafran.raif.data.repository.APIRepository
import com.github.ivanshafran.raif.data.repository.UserInfoRepository
import com.github.ivanshafran.raif.rxjava.SchedulerProvider
import io.reactivex.Single
import javax.inject.Inject

class TranscationInteractor @Inject constructor(
    private val apiRepository: APIRepository,
    private val userInfoRepository: UserInfoRepository,
    private val schedulerProvider: SchedulerProvider
) {

    fun getTransactions(): Single<List<Transaction>> {
        val userId = userInfoRepository.getUserId()
        return if (userId == null) {
            Single.error(IllegalStateException())
        } else {
            apiRepository
                .getTransactions(userId)
                .map { it.sortedBy { -it.date } }
        }
    }

}
