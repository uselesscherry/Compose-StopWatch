package com.cherry.composestopwatch

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StopWatchViewModel : ViewModel() {

    private var isRunning = false

    private var secs = 0

    private val resetTime = "00:00:00"

    private val _currentTime = mutableStateOf(resetTime)
    val currentTime: State<String> = _currentTime

    fun onStart() {
        if (isRunning) {
            return
        }
        isRunning = true
        viewModelScope.launch {
            delay(1000)

            while (isRunning) {
                Log.i("coroutine-alive", this.toString())

                secs++
                _currentTime.value = secs.toFormattedTime()
                delay(1000)
            }
        }
    }


    fun onStop() {
        isRunning = false
    }

    fun onReset() {
        isRunning = false
        secs = 0
        _currentTime.value = resetTime
    }


    private fun Int.toFormattedTime(): String {
        val hours = this / 3600
        val minutes = (this % 3600) / 60
        val seconds = this % 60
        return String.format("%02d:%02d:%02d", hours, minutes, seconds)
    }

}