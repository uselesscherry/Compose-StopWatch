package com.cherry.composestopwatch.di

import android.app.Application
import org.koin.core.context.startKoin


class StopWatchApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule)
        }
    }
}