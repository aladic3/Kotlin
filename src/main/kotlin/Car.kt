package org.example

class InvalidYearException(message: String) : Exception(message)
class InsufficientBatteryException(message: String) : Exception(message)

open class vehicle(val year: Int) {
    open fun info(){
        println("year $year")
    }
}

fun createCar(year: Int, band: String): Car {
    if (year < 1886) {
        throw InvalidYearException("Invalid year")
    }
    return Car(year, band)
}
open class Car( year: Int, val band: String = "BMW") : vehicle(year) {


    override fun info(){
        println("Band $band year $year")
    }
}

class ElectricVehicle(var batteryCapacity: Int = 1000, year: Int) : vehicle(year), Chargeable {
    override fun info(){
        println("Battery capacity $batteryCapacity year $year")
    }
    override fun charge() {
        println("Charging")
        batteryCapacity += 100
    }
    fun useCharge(batteryCapacity: Int) {
        if (batteryCapacity > this.batteryCapacity) {
            throw InsufficientBatteryException("Insufficient battery")
        }
        this.batteryCapacity -= batteryCapacity
    }
    fun filterVehicle(vehicles: List<ElectricVehicle>): List<ElectricVehicle> {
        return vehicles.filter { it.batteryCapacity > 1200 }
    }
}
