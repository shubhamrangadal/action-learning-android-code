package com.mygaurdian.android.data.datasourceImpl

import com.mygaurdian.android.data.api.RetrofitService
import com.mygaurdian.android.data.datasource.WebSocketDisableOrEnableDataSource

class WebSocketDisableOrEnableBlockerImpl(var retrofitService : RetrofitService):WebSocketDisableOrEnableDataSource {

    override suspend fun disableBlocker() {
        TODO("Not yet implemented")
    }

    override suspend fun enableBlocker() {
        TODO("Not yet implemented")
    }


}