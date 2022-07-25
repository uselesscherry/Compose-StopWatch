package com.cherry.composestopwatch.di

import com.cherry.composestopwatch.StopWatchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        StopWatchViewModel()
    }
}