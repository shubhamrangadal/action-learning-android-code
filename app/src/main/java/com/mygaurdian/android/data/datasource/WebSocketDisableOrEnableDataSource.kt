package com.mygaurdian.android.data.datasource

interface WebSocketDisableOrEnableDataSource {

    suspend fun disableBlocker()

    suspend fun enableBlocker()

}