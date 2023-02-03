package com.mygaurdian.android.data.datasourceImpl

import com.mygaurdian.android.data.api.RetrofitService
import com.mygaurdian.android.data.datasource.LoginRemoteDataSource
import com.mygaurdian.android.data.model.LoginUserPost
import com.mygaurdian.android.data.model.LoginUserResponse
import com.mygaurdian.android.data.model.RegisterResponse
import com.mygaurdian.android.data.model.SignUpPost
import retrofit2.Response

class LoginRemoteDataSourceImpl(private val retrofitService : RetrofitService): LoginRemoteDataSource {
    override suspend fun checkifUserIsAuthenciated(loginUser : LoginUserPost) : Response<LoginUserResponse> {
        return retrofitService.checkIfUserIsAuthenciated(urlPath = "api/v1",loginUser)
    }

    override suspend fun signUpNewUser(signUpPost : SignUpPost) : Response<RegisterResponse> {
        return retrofitService.registerUser(urlPath = "api/v1", signUpPost = signUpPost)
    }
}