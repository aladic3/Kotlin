package org.example

import org.example.interfaces.Prototype

data class Engine(private val power: Int, private val type: String): Prototype {
    class Builder {
        private var power: Int = 0
        private var type: String = ""

        fun power(power: Int) = apply { this.power = power }
        fun type(type: String) = apply { this.type = type }

        fun build() = Engine(power, type)
    }
    override fun clone(): Prototype {
        return this.copy()
    }
    fun info() {
        Logger.log("Engine with power $power, type $type")
    }
    fun start() {
        Logger.log("Engine started with power $power")
    }
    fun stop() {
        Logger.log("Engine stopped")
    }
}