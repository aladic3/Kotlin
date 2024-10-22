package org.example

class TruckFactory: VehicleFactory() {
    override fun createVehicle(year: Int, brand: String): Vehicle {
        Logger.log("Creating Truck")
        return Truck(year, brand)
    }
}