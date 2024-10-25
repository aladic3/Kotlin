package org.example

import org.example.interfaces.Prototype

data class House private constructor(
    val countFloors: Int?,
    val typeRoof: String?,
    val square: Int?,
    val garageAvailable: Boolean?

): Prototype {

     class Builder {
        private var countFloors: Int? = null
        private var typeRoof: String? = null
        private var square: Int? = null
        private var garageAvailable: Boolean? = null

        fun countFloors(countFloors: Int) = apply { this.countFloors = countFloors }
        fun typeRoof(typeRoof: String) = apply { this.typeRoof = typeRoof }
        fun square(square: Int) = apply { this.square = square }
        fun garageAvailable(garageAvailable: Boolean) = apply { this.garageAvailable = garageAvailable }

        fun build() = House(countFloors, typeRoof, square, garageAvailable)
    }
    override fun clone(): Prototype {
        return this.copy()
    }
    fun info() {
        Logger.log("House with $countFloors floors, type of roof $typeRoof, square $square, garage available $garageAvailable")
    }
}