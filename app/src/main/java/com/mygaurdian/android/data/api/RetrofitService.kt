package com.mygaurdian.android.data.api

import com.mygaurdian.android.data.model.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface RetrofitService {


    @POST("{url_path}/add-apps")
    suspend fun sendAllApps(@Path("url_path") urlPath: String): Response<Any>


    @POST("/{url_path}/login")
    suspend fun checkIfUserIsAuthenciated(@Path("url_path") urlPath: String, @Body loginUser: LoginUserPost): Response<LoginUserResponse>

    @POST("/{urlPath}/register")
    suspend fun registerUser(@Path("url_path") urlPath: String, @Body signUpPost : SignUpPost): Response<RegisterResponse>

    @GET
    fun listen(@Url url: String): Call<ResponseBody>


}