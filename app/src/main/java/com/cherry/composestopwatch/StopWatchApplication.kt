package com.cherry.composestopwatch

import android.app.Application
import com.cherry.composestopwatch.di.appModule
import org.koin.core.context.startKoin


class StopWatchApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule)
        }
    }
}