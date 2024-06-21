package com.mrfatworm.pttdemo.login

import androidx.lifecycle.ViewModel

class LoginViewModel(private val loginInRepository: LoginInRepository):ViewModel() {

    fun loginUser(email:String,password:String): String{
        val loginResult = loginInRepository.login(email,password)
        println( "Hello '$loginResult' from $this")
        return loginResult.let { "Hello '$it' from $this" }
    }
}