package com.mygaurdian.android.data.model

data class RegisterResponse(
    val message: String,
    val token: String,
    val user: User
)

data class User(
    val child_name: String,
    val createdAt: String,
    val email_address: String,
    val id: Int,
    val password: String,
    val updatedAt: String
)