package org.example

class MotorcycleFactory: VehicleFactory() {
    override fun createVehicle(year: Int, brand: String): Vehicle {
        Logger.log("Creating Motorcycle")
        return Motorcycle(year, brand)
    }
}