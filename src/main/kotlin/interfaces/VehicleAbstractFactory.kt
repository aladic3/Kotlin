package org.example.interfaces

import org.example.Engine
import org.example.Motorcycle
import org.example.Car
import org.example.ElectricVehicle
import org.example.Truck
import org.example.*


interface VehicleAbstractFactory {
    fun createMotorcycle(year: Int, brand: String, engine: Engine): Motorcycle
    fun createTruck(year: Int, brand: String, engine: Engine): Truck
    fun createCar(year: Int, brand: String, engine: Engine): Car
    fun createElectricCar(year: Int, brand: String, batteryCapacity: Int, engine: Engine): ElectricVehicle
    fun createEngine(horsePower: Int, type: String): Engine
}