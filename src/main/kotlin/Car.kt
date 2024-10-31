package org.example

import org.example.interfaces.Chargeable
import org.example.interfaces.Prototype
import org.example.interfaces.Vehicle

class InvalidYearException(message: String) : Exception(message)
class InsufficientBatteryException(message: String) : Exception(message)

 @ConsistentCopyVisibility
 data class Car private constructor(val year: Int? ,
                                    val band: String? = "BMW",
                                    val engine: Engine?): Vehicle, Prototype {

    init {
        if (year == null || year < 1886) {
            throw InvalidYearException("Invalid year")
        }

    }

    override fun drive(): String {
        return "Driving"
    }

     override fun info(){
         NotifyObservers.notifyObservers("Car with year $year, band $band, engine $engine")
    }

        override fun clone(): Prototype {
            return this.copy(engine = engine?.clone() as Engine)
        }
     class Builder {
        private var year: Int? = 2021
        private var band: String? = "BMW"
        private var engine: Engine? = Engine.Builder().build()
        fun year(year: Int?) = apply { this.year = year }
        fun brand(band: String?) = apply { this.band = band }
        fun engine(engine: Engine?) = apply { this.engine = engine }
        fun build() = Car(year, band, engine)
     }
}

