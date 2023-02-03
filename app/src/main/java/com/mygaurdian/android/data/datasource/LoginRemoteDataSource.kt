package com.mygaurdian.android.data.datasource

import com.mygaurdian.android.data.model.LoginUserPost
import com.mygaurdian.android.data.model.LoginUserResponse
import com.mygaurdian.android.data.model.RegisterResponse
import com.mygaurdian.android.data.model.SignUpPost
import retrofit2.Response

interface LoginRemoteDataSource {

    suspend fun checkifUserIsAuthenciated(loginUser : LoginUserPost): Response<LoginUserResponse>

    suspend fun signUpNewUser(signUpPost : SignUpPost): Response<RegisterResponse>

}