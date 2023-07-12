package com.example.cleanfizz

import android.app.Application
import com.example.cleanfizz.di.appModule
import com.example.cleanfizz.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(appModule, viewModelModule)
        }
    }
}