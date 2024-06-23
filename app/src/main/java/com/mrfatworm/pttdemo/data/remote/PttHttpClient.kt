package com.mrfatworm.pttdemo.data.remote

import com.mrfatworm.pttdemo.data.model.UserData

interface PttHttpClient {
    suspend fun login(userId: String, password: String): UserData
}
