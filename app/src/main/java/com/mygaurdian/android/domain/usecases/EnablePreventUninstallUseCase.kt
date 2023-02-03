package com.mygaurdian.android.domain.usecases

import com.mygaurdian.android.domain.repo.PreventUninstallRespository

class EnablePreventUninstallUseCase(var preventUninstallRespository : PreventUninstallRespository) {
    suspend fun execute() = preventUninstallRespository.enablePreventUninstall()
}