package com.example.letsgetcheckedapplication

import android.app.Application
import com.example.letsgetcheckedapplication.di.networkModule
import com.example.letsgetcheckedapplication.di.viewModelModule
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                networkModule,
                viewModelModule
            )
        }
    }
}