package com.github.ivanshafran.raif.data.model

import com.google.gson.annotations.SerializedName

class SignInArgs(
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String
)
