package com.mygaurdian.android.data.model

data class SendAppsResponse(
    val data: List<Data>
)

data class Data(
    val app_status: String,
    val createdAt: String,
    val device_id: String,
    val id: Int,
    val installed_app_name: String,
    val updatedAt: String
)