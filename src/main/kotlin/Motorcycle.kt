package org.example

import org.example.interfaces.Prototype
import org.example.interfaces.Vehicle

data class Motorcycle private constructor(val year: Int, val brand: String = "BMW", val engine: Engine) : Vehicle, Prototype {
    override fun drive(): String {
        return "Driving"
    }
    override fun clone(): Prototype {
        return this.copy(engine = engine.clone() as Engine)
    }
   override fun info() {
       Logger.log("Motorcycle info", Logger.LogLevel.INFO)
    }
    class Builder {
        private var year: Int = 2021
        private var brand: String = "BMW"
        private var engine: Engine = Engine.Builder().build()
        fun year(year: Int) = apply { this.year = year }
        fun brand(brand: String) = apply { this.brand = brand }
        fun engine(engine: Engine) = apply { this.engine = engine }
        fun build() = Motorcycle(year, brand, engine)
    }
}