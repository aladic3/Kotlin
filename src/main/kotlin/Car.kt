package org.example


open class vehicle(val year: Int) {
    open fun info(){
        println("year $year")
    }
}
class Car( year: Int, val band: String = "BMW") : vehicle(year) {
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
    fun filterVehicle(vehicles: List<ElectricVehicle>): List<ElectricVehicle> {
        return vehicles.filter { it.batteryCapacity > 1200 }
    }
}
