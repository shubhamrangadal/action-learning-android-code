package com.mygaurdian.android.domain.repo

interface DisableOrEnableRepository {

    suspend fun disableBlockerApp()

    suspend fun enableBlockerApp()

}