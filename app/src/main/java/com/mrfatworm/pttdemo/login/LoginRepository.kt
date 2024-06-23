package com.mrfatworm.pttdemo.login

import com.mrfatworm.pttdemo.data.PttResult

interface LoginRepository {
    suspend fun login(userId: String, password: String): PttResult<String>
}

