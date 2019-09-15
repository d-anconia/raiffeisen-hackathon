package com.github.ivanshafran.raif.data.repository

import com.github.ivanshafran.raif.data.model.Account
import com.github.ivanshafran.raif.data.model.SignInResult
import com.github.ivanshafran.raif.data.model.Transaction
import io.reactivex.Single
import java.math.BigDecimal

class TestAPIRepository : APIRepository {

    override fun signIn(username: String, password: String): Single<SignInResult> {
        return Single.just(SignInResult("1"))
    }

    override fun getTransactions(userId: String): Single<List<Transaction>> {
        return Single.just(
            listOf(
                Transaction(
                    accountFrom = 0,
                    accountTo = 0,
                    isCash = false,
                    date = 2621876712,
                    volume = BigDecimal(3),
                    fromName = "Wow"
                ),
                Transaction(
                    accountFrom = 0,
                    accountTo = 0,
                    isCash = true,
                    date = 26218721312,
                    volume = BigDecimal(6),
                    fromName = "Wsds"
                )
            )
        )
    }

    override fun getAccount(userId: String): Single<Account> {
        return Single.just(Account(balance = BigDecimal(13), cardName = "Wassa"))
    }

    override fun getTransactionsByPeriod(from: Long, to: Long): Single<List<Transaction>> {
        return Single.just(
            listOf(
                Transaction(
                    accountFrom = 0,
                    accountTo = 0,
                    isCash = false,
                    date = 2621876712,
                    volume = BigDecimal(3),
                    fromName = "Wow"
                ),
                Transaction(
                    accountFrom = 0,
                    accountTo = 0,
                    isCash = true,
                    date = 26218721312,
                    volume = BigDecimal(6),
                    fromName = "Wsds"
                )
            )
        )
    }
}
