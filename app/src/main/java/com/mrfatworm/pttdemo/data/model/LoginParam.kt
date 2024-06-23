package com.mrfatworm.pttdemo.data.model

import kotlinx.serialization.Serializable

@Serializable
data class LoginParam(
    val email: String,
    val password: String
)
