package com.mrfatworm.pttdemo.di

import com.mrfatworm.pttdemo.data.remote.PttHttpClient
import com.mrfatworm.pttdemo.data.remote.PttHttpClientImpl
import com.mrfatworm.pttdemo.login.LoginRepository
import com.mrfatworm.pttdemo.login.LoginRepositoryImpl
import com.mrfatworm.pttdemo.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

// Constructor DSL
val appModule = module {
    single<PttHttpClient> { PttHttpClientImpl() }
    single<LoginRepository> { LoginRepositoryImpl(get()) }
    viewModel { LoginViewModel(get()) }
}