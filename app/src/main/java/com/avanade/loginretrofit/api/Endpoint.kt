package com.avanade.loginretrofit.api

import com.avanade.loginretrofit.model.User
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface Endpoint {
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("/users/auth")
    fun authenticate(@Field("user") username : String, @Field("password") password : String) : Call<User>
}