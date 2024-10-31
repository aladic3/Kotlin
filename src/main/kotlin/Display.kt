package org.example

import org.example.interfaces.Observer

object Display: Observer {
    override fun update(message: String) {
        println("Display: $message")
    }

}