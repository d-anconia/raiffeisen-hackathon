package com.github.ivanshafran.raif.data.repository

interface UserInfoRepository {

    fun setUserId(userId: String?)

    fun getUserId(): String?

}
