package com.cherry.composestopwatch

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class StopWatch(private val scope: CoroutineScope) {

    private var isRunning = false

    private val _currentTime = MutableStateFlow(0)
    val currentTime: StateFlow<Int> = _currentTime

    fun start() {
        if (isRunning) {
            return
        }
        isRunning = true
        scope.launch {
            delay(1000)

            while (isRunning) {
                _currentTime.update { it + 1 }
                delay(1000)
            }
        }
    }

    fun stop() {
        isRunning = false
    }

    fun reset() {
        isRunning = false
        _currentTime.value = 0
    }

}