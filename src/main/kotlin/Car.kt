package org.example

class InvalidYearException(message: String) : Exception(message)
class InsufficientBatteryException(message: String) : Exception(message)



fun createCar(year: Int, band: String): Car {
    if (year < 1886) {
        throw InvalidYearException("Invalid year")
    }
    return Car(year, band)
}
open class Car( val year: Int, val band: String = "BMW"): Vehicle {
    override fun drive(): String {
        return "Driving"
    }

     fun info(){
        println("Band $band year $year")
    }
}

class ElectricVehicle( val year: Int, val band: String = "Unknown", var batteryCapacity: Int = 1000) :
    Chargeable, Vehicle {
    override fun drive(): String {
        return "Driving"
    }
    fun info(){
        println("Battery capacity $batteryCapacity year $year")
    }
    override fun charge() {
        println("Charging")
        batteryCapacity += 100
        Logger.log("Charging electric vehicle", Logger.LogLevel.INFO)
    }
    fun useCharge(batteryCapacity: Int) {
        if (batteryCapacity > this.batteryCapacity) {
            throw InsufficientBatteryException("Insufficient battery")
        }
        this.batteryCapacity -= batteryCapacity
        Logger.log("Using charge", Logger.LogLevel.INFO)
    }
    fun filterVehicle(vehicles: List<ElectricVehicle>): List<ElectricVehicle> {
        return vehicles.filter { it.batteryCapacity > 1200 }
    }
}
