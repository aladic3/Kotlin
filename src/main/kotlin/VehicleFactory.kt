package org.example

abstract class VehicleFactory {
    abstract fun createVehicle(year: Int, brand: String): Vehicle

}