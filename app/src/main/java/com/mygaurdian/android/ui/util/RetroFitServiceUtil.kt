package com.mygaurdian.android.ui.util

import com.mygaurdian.android.data.api.RetrofitService
import com.mygaurdian.android.data.model.LoginUserPost
import com.mygaurdian.android.data.model.LoginUserResponse
import com.mygaurdian.android.data.model.RegisterResponse
import com.mygaurdian.android.data.model.SignUpPost
import okhttp3.OkHttpClient
import retrofit2.Response

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroFitServiceUtil {

    companion object{

        fun getRetrofitService() : Retrofit {
            val okHttpClient = OkHttpClient.Builder()
                .build()

            return Retrofit.Builder()
                .baseUrl("https://5a64-2a01-e34-ec41-5c90-fc81-16d2-95c3-c690.eu.ngrok.io")
                .client(okHttpClient)
                .build();
        }

        suspend fun sendAppData(access_token: String){

            val client = OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val request = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer $access_token")
                        .build()
                    chain.proceed(request)
                }
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl("https://5a64-2a01-e34-ec41-5c90-fc81-16d2-95c3-c690.eu.ngrok.io")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val apiService = retrofit.create(RetrofitService::class.java)
            val response = apiService.sendAllApps(urlPath = "api/v1")
        }

        suspend fun checkIfUserIsAuth(loginUserPost : LoginUserPost): LoginUserResponse{
            var apiservice = getRetrofitService().create(RetrofitService::class.java)
            return apiservice.checkIfUserIsAuthenciated(urlPath = "api/v1",loginUserPost).body()!!
        }

        suspend fun submitToBackend(signUpPost : SignUpPost): Boolean{

            var apiservice = getRetrofitService().create(RetrofitService::class.java)
            var response: RegisterResponse = apiservice.registerUser(urlPath = "api/v1",signUpPost).body()!!

            return response.message.contains("successfully")

        }


    }



}


