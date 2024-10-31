package org.example

import org.example.interfaces.Observer
import java.io.FileWriter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import org.example.interfaces.*
import kotlin.properties.Delegates


object Logger: Observer {
    class InvalidLogLevelException(message: String) : Exception(message)
    enum class LogLevel {
        DEBUG, INFO, WARNING, ERROR, FATAL
    }
    override fun update(message: String) {
        log(message, LogLevel.INFO)
    }

    private var currentLevel : LogLevel by Delegates.observable(LogLevel.INFO) { _, _, newLevel ->
        log("Log level changed to $newLevel", LogLevel.INFO)
    }

    init {
        log("Logger initialized")
    }
    private fun logMessage(message: String, level: LogLevel) {
        val currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        println("[$currentTime] [${level}] $message")
        FileWriter("log.txt", true).use { it.write("[$currentTime] [$level] $message\n") }
    }

    fun log(message: String, level: LogLevel? = currentLevel) {
        if ((level?.ordinal ?: Int.MIN_VALUE) >= currentLevel.ordinal) {
            logMessage(message, level!!)
        }
    }

    fun changeLevel(level: LogLevel?) {
        if (level == null) {
            throw InvalidLogLevelException("Invalid log level")
        }
        currentLevel = level
    }
}