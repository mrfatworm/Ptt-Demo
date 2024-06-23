package com.mrfatworm.pttdemo.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserData(
    @SerialName("token")
    val userToken: String
)
