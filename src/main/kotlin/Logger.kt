package org.example

import java.io.FileWriter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class InvalidLogLevelException(message: String) : Exception(message)
object Logger {
    enum class LogLevel {
        DEBUG, INFO, WARNING, ERROR, FATAL
    }

    private var currentLevel: LogLevel = LogLevel.INFO

    init {
        println("Logger initialized")
    }
    private fun logMessage(message: String, level: LogLevel) {
        val currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        println("[${level}] $message")
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