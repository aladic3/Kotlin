package org.example

class Motorcycle(val year: Int, val brand: String = "BMW") : Vehicle {
    override fun drive(): String {
        return "Driving"
    }

    fun info() {
        println("Brand $brand year $year")
    }
}