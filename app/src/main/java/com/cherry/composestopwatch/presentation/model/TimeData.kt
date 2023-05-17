package com.cherry.composestopwatch.presentation.model

data class TimeData(private val secs: Int) {
    companion object {

        private const val TIME_FORMAT = "%02d"

        val ZERO get() = TimeData(0)
    }

    private val minutes: Int
        get() = (secs % 3600) / 60

    private val seconds: Int
        get() = secs % 60
    val formattedMinutes: String
        get() = String.format(TIME_FORMAT, minutes)

    val formattedSeconds: String
        get() = String.format(TIME_FORMAT, seconds)
}