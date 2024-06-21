package com.mrfatworm.pttdemo.di

import com.mrfatworm.pttdemo.login.LoginInRepository
import com.mrfatworm.pttdemo.login.LoginInRepositoryImpl
import com.mrfatworm.pttdemo.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

// Constructor DSL
val appModule = module {
    single<LoginInRepository> { LoginInRepositoryImpl() }
    viewModel { LoginViewModel(get()) }
}

// Classic DSL
//val appModule = module {
//    single<UserRepository> { UserRepositoryImpl() }
//    single { UserService(get()) }
//}