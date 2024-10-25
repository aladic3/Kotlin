package org.example

import org.example.interfaces.Vehicle
import org.example.interfaces.VehicleFactory

class TruckFactory: VehicleFactory() {
    override fun createVehicle(year: Int, brand: String, engine: Engine): Vehicle {
        Logger.log("Creating Truck")
        return Truck.Builder()
            .year(year)
            .brand(brand)
            .engine(engine)
            .build()
    }
}