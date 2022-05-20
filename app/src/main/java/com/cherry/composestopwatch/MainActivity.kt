package com.cherry.composestopwatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: StopWatchViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[StopWatchViewModel::class.java]
        setContent {
            StopWatchScreen(viewModel = viewModel)
        }
    }
}
