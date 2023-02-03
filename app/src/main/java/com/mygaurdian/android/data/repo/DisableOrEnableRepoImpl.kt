package com.mygaurdian.android.data.repo

import com.mygaurdian.android.data.datasource.WebSocketDisableOrEnableDataSource
import com.mygaurdian.android.data.service.MyAccessibilityService
import com.mygaurdian.android.domain.repo.DisableOrEnableRepository

class DisableOrEnableRepoImpl(var webSocketDisableOrEnableDataSource : WebSocketDisableOrEnableDataSource): DisableOrEnableRepository {
    override suspend fun disableBlockerApp() {
        webSocketDisableOrEnableDataSource.disableBlocker()
    }

    override suspend fun enableBlockerApp() {
        MyAccessibilityService.isBlockerOn = true
    }


}