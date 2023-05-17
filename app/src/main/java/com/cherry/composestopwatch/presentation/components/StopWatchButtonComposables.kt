package com.cherry.composestopwatch.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Pause
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Stop
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun StopWatchManipulators(onStart: () -> Unit, onStop: () -> Unit, onReset: () -> Unit) {
    Row {
        StopwatchButton(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStartPercent = 100,
                        bottomStartPercent = 100
                    )
                ),
            onClick = onStart,
            icon = Icons.Rounded.PlayArrow
        )

        StopwatchButtonSeparator()

        StopwatchButton(
            modifier = Modifier,
            onClick = onStop,
            icon = Icons.Rounded.Pause
        )

        StopwatchButtonSeparator()

        StopwatchButton(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topEndPercent = 100,
                        bottomEndPercent = 100
                    )
                ),
            onClick = onReset,
            icon = Icons.Rounded.Stop
        )
    }
}

@Composable
fun StopwatchButton(modifier: Modifier, onClick: () -> Unit, icon: ImageVector) =
    Box(
        modifier = modifier
            .clickable(onClick = onClick)
            .size(96.dp)
            .background(MaterialTheme.colorScheme.secondary)
    ) {
        Icon(
            modifier = Modifier
                .align(Alignment.Center)
                .size(48.dp),
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSecondary
        )
    }

@Composable
fun StopwatchButtonSeparator() = Box(
    modifier = Modifier
        .height(96.dp)
        .width(2.dp)
        .background(MaterialTheme.colorScheme.secondaryContainer)
)
