package org.example

import org.example.interfaces.Vehicle
import org.example.interfaces.VehicleFactory

class MotorcycleFactory: VehicleFactory() {
    override fun createVehicle(year: Int, brand: String, engine: Engine): Vehicle {
        Logger.log("Creating Motorcycle")
        return Motorcycle.Builder()
            .year(year)
            .brand(brand)
            .engine(engine)
            .build()
    }
}