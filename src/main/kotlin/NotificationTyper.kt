package org.example

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

sealed class NotificationTyper {
    data class success(val message: String) : NotificationTyper()
    data class error(val message: String, val code: Int) : NotificationTyper( )
    data class warning(val message: String) : NotificationTyper()
}
data class Notification(val title: String, val type: NotificationTyper,
        val time:   String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
fun showNotification(notification: Notification) {
    when (val type = notification.type) {
        is NotificationTyper.success -> {
            println("{${notification.time}}: ${type} - ${type.message}")
        }
        is NotificationTyper.error -> {
            println("Error: ${notification.title} - ${notification.type.message} - ${notification.type.code}")
        }
        is NotificationTyper.warning -> {
            println("Warning: ${notification.title} - ${notification.type.message}")
        }
    }
}