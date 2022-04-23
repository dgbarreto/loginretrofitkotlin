package com.avanade.loginretrofit.model

import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("name")
    var name : String,
    @SerializedName("id")
    var id : String,
    @SerializedName("jobTitle")
    var jobTitle : String,
    @SerializedName("email")
    var email : String
)