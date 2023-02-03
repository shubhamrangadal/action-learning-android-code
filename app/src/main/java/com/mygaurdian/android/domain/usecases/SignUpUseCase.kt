package com.mygaurdian.android.domain.usecases

import com.mygaurdian.android.data.model.LoginUserPost
import com.mygaurdian.android.data.model.SignUpPost
import com.mygaurdian.android.domain.repo.LoginRepo

class SignUpUseCase(var loginRepo : LoginRepo,var signUpPost : SignUpPost) {

    suspend fun execute() = loginRepo.signUp(signUpPost)

}