package com.mygaurdian.android.domain.repo

interface PreventUninstallRespository {

    suspend fun disablePreventUninstall()

    suspend fun enablePreventUninstall()

}