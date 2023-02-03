package com.mygaurdian.android.data.model

data class LoginUserResponse(
    val data: List<Data1>,
    val message: String,
    val token: String
)

data class Data1(
    val child: Child,
    val parent: Parent
)

data class Child(
    val child_name: String,
    val createdAt: String,
    val device_id: String,
    val email_address: String,
    val id: Int,
    val updatedAt: String
)

data class Parent(
    val child_name: String,
    val createdAt: String,
    val email_address: String,
    val id: Int,
    val password: String,
    val updatedAt: String
)