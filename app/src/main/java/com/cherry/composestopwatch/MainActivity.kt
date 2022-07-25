package com.cherry.composestopwatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.cherry.composestopwatch.ui.theme.ComposeStopWatchTheme


class MainActivity : ComponentActivity() {

    private val viewModel: StopWatchViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStopWatchTheme {

                StopWatchScreen(viewModel = viewModel)

            }
        }
    }
}
