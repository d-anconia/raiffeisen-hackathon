package com.github.ivanshafran.raif.data.repository

import com.github.ivanshafran.raif.data.model.SignInResult
import com.github.ivanshafran.raif.data.model.Transaction
import io.reactivex.Single
import java.math.BigDecimal

class TestAPIRepository : APIRepository {

    override fun signIn(username: String, password: String): Single<SignInResult> {
        return Single.just(SignInResult("user id"))
    }

    override fun getTransactions(userId: String): Single<List<Transaction>> {
        return Single.just(
            listOf(
                Transaction(1, "Петро", 777, BigDecimal(100)),
                Transaction(2, "Вася", 777, BigDecimal(200)),
                Transaction(3, "Олеся", 777, BigDecimal(200)),
                Transaction(1, "Петро", 777, BigDecimal(100)),
                Transaction(2, "Вася", 777, BigDecimal(200)),
                Transaction(3, "Олеся", 777, BigDecimal(200)),
                Transaction(1, "Петро", 777, BigDecimal(100)),
                Transaction(2, "Вася", 777, BigDecimal(200)),
                Transaction(3, "Олеся", 777, BigDecimal(200)),
                Transaction(1, "Петро", 777, BigDecimal(100)),
                Transaction(2, "Вася", 777, BigDecimal(200)),
                Transaction(3, "Олеся", 777, BigDecimal(200)),
                Transaction(1, "Петро", 777, BigDecimal(100)),
                Transaction(2, "Вася", 777, BigDecimal(200)),
                Transaction(3, "Олеся", 777, BigDecimal(200))
            )
        )
    }

//    override fun getBalance(userId: String): Single<BigDecimal> {
//        return Single.just(BigDecimal(1331))
//    }
}
