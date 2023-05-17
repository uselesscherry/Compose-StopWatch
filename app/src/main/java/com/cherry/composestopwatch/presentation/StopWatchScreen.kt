package com.cherry.composestopwatch.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.cherry.composestopwatch.presentation.components.StopWatchManipulators
import com.cherry.composestopwatch.presentation.components.StopWatchTimer
import com.cherry.composestopwatch.presentation.model.TimeData

@Composable
fun StopWatchScreen(
    time: TimeData,
    onStart: () -> Unit,
    onStop: () -> Unit,
    onReset: () -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color(0xff402332)),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        StopWatchTimer(time = time)

        StopWatchManipulators(onStart, onStop, onReset)
    }
}