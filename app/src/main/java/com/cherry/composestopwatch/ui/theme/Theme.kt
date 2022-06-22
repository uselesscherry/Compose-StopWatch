package com.cherry.composestopwatch.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext


private val DarkColorPalette = darkColorScheme(
    primary = Bordo40,
    onPrimary = Bordo100,
    primaryContainer = Bordo90,
    onPrimaryContainer = Bordo10
)

private val LightColorPalette = lightColorScheme(
    primary = LightBlue40,
    onPrimary = LightBlue100,
    primaryContainer = LightBlue90,
    onPrimaryContainer = LightBlue10
)

@Composable
fun ComposeStopWatchTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val useDynamicColors = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
    val colors = when {
        useDynamicColors && darkTheme -> dynamicDarkColorScheme(LocalContext.current)
        useDynamicColors && !darkTheme -> dynamicLightColorScheme(LocalContext.current)
        darkTheme -> DarkColorPalette
        else -> LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        content = content
    )
}