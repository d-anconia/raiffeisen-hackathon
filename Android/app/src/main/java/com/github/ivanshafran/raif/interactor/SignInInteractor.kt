package com.github.ivanshafran.raif.interactor

import com.github.ivanshafran.raif.data.model.SignInArgs
import com.github.ivanshafran.raif.data.repository.APIRepository
import com.github.ivanshafran.raif.data.repository.UserInfoRepository
import com.github.ivanshafran.raif.rxjava.SchedulerProvider
import io.reactivex.Completable
import javax.inject.Inject

class SignInInteractor @Inject constructor(
    private val apiRepository: APIRepository,
    private val userInfoRepository: UserInfoRepository,
    private val schedulerProvider: SchedulerProvider
) {

    fun signIn(signInArgs: SignInArgs): Completable {
        return apiRepository
            .signIn(signInArgs.username, signInArgs.password)
            .observeOn(schedulerProvider.ui())
            .doOnSuccess { signInResult ->
                userInfoRepository.setUserId(signInResult.userId)
            }
            .ignoreElement()
    }

}
