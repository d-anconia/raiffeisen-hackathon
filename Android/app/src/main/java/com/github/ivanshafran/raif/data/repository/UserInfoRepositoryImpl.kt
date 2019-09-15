package com.github.ivanshafran.raif.data.repository

import android.content.Context
import javax.inject.Inject

class UserInfoRepositoryImpl @Inject constructor(
    context: Context
) : UserInfoRepository {

    companion object {
        private const val FILENAME = "USER_INFO"
        private const val USER_ID_KEY = "USER_ID_KEY"
    }

    private val sharedPreferences = context.getSharedPreferences(
        FILENAME,
        Context.MODE_PRIVATE
    )

    override fun setUserId(userId: String?) {
        sharedPreferences.edit().putString(USER_ID_KEY, userId).apply()
    }

    override fun getUserId(): String? {
        return sharedPreferences.getString(USER_ID_KEY, null)
    }

}
