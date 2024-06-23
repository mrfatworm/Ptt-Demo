package com.mrfatworm.pttdemo.login

import com.mrfatworm.pttdemo.data.PttResult
import com.mrfatworm.pttdemo.data.remote.PttHttpClient
import kotlinx.coroutines.withTimeout

class LoginRepositoryImpl(private val httpClient: PttHttpClient) : LoginRepository {
    override suspend fun login(userId: String, password: String): PttResult<String> {
        return try {
            val result = withTimeout(5000) {
                httpClient.login(userId, password)
            }
            PttResult.Success(result.userToken)
        } catch (cause: Throwable) {
            PttResult.Error(Exception(cause))
        }
    }

}