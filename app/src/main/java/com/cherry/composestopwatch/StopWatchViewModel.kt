package com.cherry.composestopwatch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cherry.composestopwatch.presentation.model.TimeData
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map

class StopWatchViewModel : ViewModel() {

    private val stopWatch = StopWatch(viewModelScope)

    val stopWatchTime = stopWatch.currentTime.map { TimeData(it) }

    init {
        stopWatchTime.launchIn(viewModelScope)
    }

    fun onStart() {
        stopWatch.start()
    }

    fun onStop() {
        stopWatch.stop()
    }

    fun onReset() {
        stopWatch.reset()
    }
}