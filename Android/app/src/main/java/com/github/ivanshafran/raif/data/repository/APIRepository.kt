package com.github.ivanshafran.raif.data.repository

import com.github.ivanshafran.raif.data.model.SignInResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface APIRepository {

    @GET("login")
    fun signIn(
        @Query("username") username: String,
        @Query("password") password: String
    ): Single<SignInResult>

}
