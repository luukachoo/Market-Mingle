package com.example.friend_request.model

data class Users(
    val userId: String,
    val userName: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val avatar: String
)