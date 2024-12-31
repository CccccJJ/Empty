package com.example.springsecurity.dto

data class LoginRequest(
    val username: String,
    val password: String,
    val captcha: String,
    val captchaKey: String
)

data class LoginResponse(
    val token: String,
    val username: String
)

data class ApiResponse<T>(
    val success: Boolean,
    val message: String? = null,
    val data: T? = null
) 