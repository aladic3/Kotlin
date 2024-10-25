package org.example

import org.example.interfaces.Observer
import java.io.FileWriter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import org.example.interfaces.*

class InvalidLogLevelException(message: String) : Exception(message)
object Logger: Observer {
    enum class LogLevel {
        DEBUG, INFO, WARNING, ERROR, FATAL
    }
    override fun update() {
        log("Logger updated", LogLevel.INFO)
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