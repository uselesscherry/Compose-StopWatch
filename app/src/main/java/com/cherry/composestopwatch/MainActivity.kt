package com.cherry.composestopwatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.cherry.composestopwatch.ui.theme.ComposeStopWatchTheme


class MainActivity : ComponentActivity() {

    private val viewModel: StopWatchViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStopWatchTheme {

                val currentTime by remember {
                    viewModel.currentTime
                }

                StopWatchScreen(
                    currentTime = currentTime,
                    onStart = viewModel::onStart,
                    onStop = viewModel::onStop,
                    onReset = viewModel::onReset
                )

            }
        }
    }
}
