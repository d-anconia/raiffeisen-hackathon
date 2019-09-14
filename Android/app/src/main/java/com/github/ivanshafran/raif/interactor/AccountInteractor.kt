package com.github.ivanshafran.raif.interactor

import com.github.ivanshafran.raif.data.model.Account
import com.github.ivanshafran.raif.data.repository.APIRepository
import com.github.ivanshafran.raif.data.repository.UserInfoRepository
import io.reactivex.Single
import javax.inject.Inject

class AccountInteractor @Inject constructor(
    private val userInfoRepository: UserInfoRepository,
    private val apiRepository: APIRepository
) {

    fun getAccount(): Single<Account> {
        val userId = userInfoRepository.getUserId()
        return if (userId == null) {
            Single.error(IllegalStateException())
        } else {
            apiRepository.getAccount(userId)
        }
    }

}