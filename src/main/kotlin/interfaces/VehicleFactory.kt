package org.example.interfaces

import org.example.Engine

abstract class VehicleFactory {
    abstract fun createVehicle(year: Int, brand: String, engine: Engine): Vehicle

}