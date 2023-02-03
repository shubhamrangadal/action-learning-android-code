package com.mygaurdian.android.domain.repo

import com.mygaurdian.android.data.model.LoginUserPost
import com.mygaurdian.android.data.model.LoginUserResponse
import com.mygaurdian.android.data.model.RegisterResponse
import com.mygaurdian.android.data.model.SignUpPost

interface LoginRepo {

    suspend fun loginUser(loginUserPost : LoginUserPost) : LoginUserResponse

    suspend fun signUp(signUpPost : SignUpPost) : RegisterResponse

}
