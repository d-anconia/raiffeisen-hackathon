package com.github.ivanshafran.raif.data.repository

import com.github.ivanshafran.raif.data.model.SignInResult
import com.github.ivanshafran.raif.data.model.Transaction
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import java.math.BigDecimal

interface APIRepository {

    @GET("/login")
    fun signIn(
        @Query("username") username: String,
        @Query("password") password: String
    ): Single<SignInResult>

    @GET("/transaction")
    fun getTransactions(
        @Query("user_id") userId: String
    ): Single<List<Transaction>>

//    @GET("/balance")
//    fun getBalance(@Query("user_id") userId: String): Single<BigDecimal>

}
