package com.mygaurdian.android.domain.usecases

import com.mygaurdian.android.domain.repo.DisableOrEnableRepository

class DisableBlockerUseCase(var disableOrEnableRepository: DisableOrEnableRepository) {

    suspend fun execute() = disableOrEnableRepository.disableBlockerApp()

}