package com.mygaurdian.android.data.repo

import com.mygaurdian.android.data.datasource.LoginRemoteDataSource
import com.mygaurdian.android.data.model.LoginUserPost
import com.mygaurdian.android.data.model.LoginUserResponse
import com.mygaurdian.android.data.model.RegisterResponse
import com.mygaurdian.android.data.model.SignUpPost
import com.mygaurdian.android.domain.repo.LoginRepo

class LoginRepoImpl(var loginRemoteDataSource : LoginRemoteDataSource):LoginRepo {
    override suspend fun loginUser(loginUserPost : LoginUserPost): LoginUserResponse {
        var response = loginRemoteDataSource.checkifUserIsAuthenciated(loginUserPost)
        lateinit var res: LoginUserResponse
        response.let {
            res = response.body()!!

        }
        return res
    }

    override suspend fun signUp(signUpPost : SignUpPost) :RegisterResponse{

        var response = loginRemoteDataSource.signUpNewUser(signUpPost)
        lateinit var res: RegisterResponse
        res.let {
            res = response.body()!!
        }

        return res

    }
}