package com.mygaurdian.android.domain.usecases

import com.mygaurdian.android.domain.repo.DisableOrEnableRepository

class EnableBlockerUseCase(var disableOrEnableRepository : DisableOrEnableRepository) {
    suspend fun execute() = disableOrEnableRepository.enableBlockerApp()
}