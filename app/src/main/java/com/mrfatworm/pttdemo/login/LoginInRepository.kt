package com.mrfatworm.pttdemo.login

interface LoginInRepository {
    fun login(userId: String, password: String): String
}

class LoginInRepositoryImpl : LoginInRepository {
    override fun login(userId: String, password: String): String {
        return "mrfatworm"
    }

}