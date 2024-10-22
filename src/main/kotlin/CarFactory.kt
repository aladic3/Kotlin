package org.example

class CarFactory: VehicleFactory() {
    override fun createVehicle(year: Int, brand: String): Vehicle {
        Logger.log("Creating Car")
        return Car(year, brand)
    }
}