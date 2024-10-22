package org.example

class Truck: Vehicle {
    private val year: Int
    private val brand: String
    private val payloadCapacity: Int = 1000

    constructor(year: Int, brand: String) {
        this.year = year
        this.brand = brand
    }
    fun info() {
        println("Brand $brand year $year")
    }
    override fun drive(): String {
        return "Driving a $year $brand Truck"
    }
}