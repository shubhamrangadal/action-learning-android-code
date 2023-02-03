package com.mygaurdian.android.domain.usecases

import com.mygaurdian.android.domain.repo.PreventUninstallRespository

class DisablePreventUninstallUseCase(var preventUninstallRespository : PreventUninstallRespository) {

    suspend fun execute() = preventUninstallRespository.disablePreventUninstall()
}