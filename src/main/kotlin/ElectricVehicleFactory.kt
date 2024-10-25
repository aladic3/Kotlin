package org.example

import org.example.interfaces.Vehicle
import org.example.interfaces.VehicleFactory

class ElectricVehicleFactory: VehicleFactory() {
    override fun createVehicle(year: Int, brand: String, engine: Engine): Vehicle {
        Logger.log("Creating Electric Vehicle")
        return ElectricVehicle.Builder()
            .year(year)
            .brand(brand)
            .engine(engine)
            .build()
    }
}