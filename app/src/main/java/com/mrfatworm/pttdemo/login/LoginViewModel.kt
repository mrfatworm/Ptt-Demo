package com.mrfatworm.pttdemo.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrfatworm.pttdemo.data.PttResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {
    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            when (val loginResult = loginRepository.login(email, password)) {
                is PttResult.Success -> {
                    _state.value = LoginState(loginMessage = "Welcome, ${loginResult.data}")
                }

                is PttResult.Error -> {
                    _state.value = LoginState("Login Error")
                }
            }
        }
    }
}