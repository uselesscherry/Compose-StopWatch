package com.cherry.composestopwatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.cherry.composestopwatch.presentation.StopWatchScreen
import com.cherry.composestopwatch.presentation.model.TimeData
import com.cherry.composestopwatch.ui.theme.ComposeStopWatchTheme

class MainActivity : ComponentActivity() {

    private val viewModel: StopWatchViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStopWatchTheme {

                val time = viewModel.stopWatchTime.collectAsState(initial = TimeData.ZERO)

                StopWatchScreen(
                    time = time.value,
                    onStart = viewModel::onStart,
                    onStop = viewModel::onStop,
                    onReset = viewModel::onReset
                )
            }
        }
    }
}