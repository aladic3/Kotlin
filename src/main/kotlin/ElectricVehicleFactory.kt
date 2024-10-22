package org.example

class ElectricVehicleFactory: VehicleFactory() {
    override fun createVehicle(year: Int, brand: String): Vehicle {
        Logger.log("Creating Electric Vehicle")
        return ElectricVehicle( year ,brand)
    }
}