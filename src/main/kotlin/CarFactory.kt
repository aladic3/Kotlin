package org.example

import org.example.interfaces.Vehicle
import org.example.interfaces.VehicleFactory

class CarFactory: VehicleFactory() {
    override fun createVehicle(year: Int, brand: String, engine: Engine): Vehicle {
        Logger.log("Creating Car")
        return Car.Builder()
            .year(year)
            .brand(brand)
            .engine(engine)
            .build()
    }
}