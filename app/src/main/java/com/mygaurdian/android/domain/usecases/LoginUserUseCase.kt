package com.mygaurdian.android.domain.usecases

import com.mygaurdian.android.data.model.LoginUserPost
import com.mygaurdian.android.domain.repo.LoginRepo

class LoginUserUseCase (var loginRepo : LoginRepo, var loginUserPost : LoginUserPost){

    suspend fun execute() = loginRepo.loginUser(loginUserPost)
}