package com.cherry.composestopwatch

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration


@Composable
fun StopWatchScreen(
    viewModel: StopWatchViewModel
) {

    val timerText by remember {
        viewModel.currentTime
    }


    val config = LocalConfiguration.current

    val isPortrait by remember {
        mutableStateOf(config.orientation == Configuration.ORIENTATION_PORTRAIT)
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color(0xff2D4263))
        ,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = timerText,
            modifier = Modifier
                .fillMaxHeight(0.25f),
            fontWeight = MaterialTheme.typography.headlineLarge.fontWeight,
            fontSize = MaterialTheme.typography.displayLarge.fontSize,
            color = MaterialTheme.colorScheme.onBackground
        )
        Box(
            Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth(0.5f)
        ) {

            Button(
                modifier = Modifier.align(
                    if (isPortrait) Alignment.TopCenter
                    else Alignment.CenterStart
                ),
                onClick = { viewModel.onStart() }
            ) {
                Text(text = "Start", color = MaterialTheme.colorScheme.onPrimary)
            }

            Button(
                modifier = Modifier.align(Alignment.Center),
                onClick = {
                    viewModel.onStop()
                }
            ) {
                Text(text = "Stop", color = MaterialTheme.colorScheme.onPrimary)
            }
            Button(
                modifier = Modifier.align(

                    if (isPortrait) Alignment.BottomCenter
                    else Alignment.CenterEnd
                ),
                onClick = {
                    viewModel.onReset()
                }
            ) {
                Text(text = "Reset", color = MaterialTheme.colorScheme.onPrimary)
            }
        }
    }
}