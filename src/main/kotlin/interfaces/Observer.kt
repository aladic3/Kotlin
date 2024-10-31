package org.example.interfaces

import sun.security.util.LocalizedMessage

interface Observer {
    fun update(message: String)
}