package com.github.ivanshafran.raif.data.repository

import retrofit2.http.GET

interface APIRepository {

    @GET()
    fun signIn():

}
