package com.globalnews.repo

import com.globalnews.models.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {

//    @GET("4bd5a7f5-56fb-4d81-980a-998a070cf85f")
//    fun fetchdata(): Call<ApiResponse>?

    // Post method
    @FormUrlEncoded
    @POST("login")
    fun userlogin(
        @Field("email") email:String,
        @Field("password") password:String
    ): Call<LoginResponse>
}