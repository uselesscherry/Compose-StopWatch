package com.cherry.composestopwatch.presentation.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.cherry.composestopwatch.presentation.model.TimeData

@Composable
fun StopWatchTimer(time: TimeData) {
    Row {
        TimeCounter(time = time.formattedMinutes)
        TimeSeparator()
        TimeCounter(time = time.formattedSeconds)
    }
}

@Composable
fun TimeSeparator() = Text(
    text = ":",
    fontWeight = MaterialTheme.typography.headlineLarge.fontWeight,
    fontSize = MaterialTheme.typography.displayLarge.fontSize * 2,
    color = MaterialTheme.colorScheme.onBackground
)

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TimeCounter(time: String) {

    var oldTime by remember {
        mutableStateOf(time)
    }
    SideEffect {
        oldTime = time
    }

    Row {
        for (i in time.indices) {
            val oldChar = oldTime.getOrNull(i)
            val newChar = time[i]
            val char = if (oldChar == newChar) oldChar else newChar
            AnimatedContent(
                targetState = char,
                transitionSpec = {
                    slideInVertically { -it } with slideOutVertically { it }
                }) { text ->
                Text(
                    text = text.toString(),
                    fontWeight = MaterialTheme.typography.headlineLarge.fontWeight,
                    fontSize = MaterialTheme.typography.displayLarge.fontSize * 2,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}
