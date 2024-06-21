package com.mrfatworm.pttdemo

import android.app.Application
import com.mrfatworm.pttdemo.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class PttDemoApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@PttDemoApplication)
            modules(appModule)
        }

    }
}