package com.cherry.composestopwatch

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StopWatchViewModel(private val savedState: SavedStateHandle) : ViewModel() {

    private val isRunningKey = "isRunning"
    private val secsKey = "secs"
    private val currentTimeKey = "currentTime"

    private var timerJob: Job? = null
    private var isRunning = savedState.get<Boolean>(isRunningKey) ?: false


    private val secs = mutableStateOf(savedState.get<Int>(secsKey) ?: 0)

    private val resetTime = "00:00:00"

    private val _currentTime = mutableStateOf(savedState.get<String>(currentTimeKey) ?: resetTime)
    val currentTime: State<String> = _currentTime


    init {
        onCounting()
    }

    fun onStart() {
        if (!isRunning) {
            isRunning = true
            savedState.set(isRunningKey, isRunning)
            onCounting()
        }
    }

    private fun onCounting() {
        timerJob = null
        if (isRunning) {
            timerJob = viewModelScope.launch(Dispatchers.Default) {
                delay(1000)

                while (isRunning) {
                    Log.i("coroutine-alive", this.toString())

                    secs.value++
                    savedState.set(secsKey, secs.value)
                    _currentTime.value = secs.value.toFormattedTime()
                    savedState.set(currentTimeKey, _currentTime.value)
                    delay(1000)
                }
            }
        }
    }

    fun onStop() {
        timerJob?.cancel()
        isRunning = false
        savedState.set(isRunningKey, isRunning)
        timerJob = null
    }

    fun onReset() {
        timerJob?.cancel()
        isRunning = false
        savedState.set(isRunningKey, isRunning)
        timerJob = null
        secs.value = 0
        savedState.set(secsKey, secs.value)
        _currentTime.value = resetTime
        savedState.set(currentTimeKey, _currentTime.value)
    }

    override fun onCleared() {
        super.onCleared()
        timerJob?.cancel()
        timerJob = null
        Log.i("onClearedVM", timerJob.toString())
    }

    private fun Int.toFormattedTime(): String {
        val hours = this / 3600
        val minutes = (this % 3600) / 60
        val seconds = this % 60
        return String.format("%02d:%02d:%02d", hours, minutes, seconds)
    }

}