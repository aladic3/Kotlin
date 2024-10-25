package org.example

import org.example.interfaces.Vehicle

class VehicleAbstractFactory: org.example.interfaces.VehicleAbstractFactory {
   override fun createCar(year: Int, brand: String, engine: Engine): Car {
        Logger.log("Creating Car")
        return Car.Builder()
            .year(year)
            .brand(brand)
            .engine(engine)
            .build()
    }
    override fun createTruck(year: Int, brand: String, engine: Engine): Truck {
        Logger.log("Creating Truck")
        return Truck.Builder()
            .year(year)
            .brand(brand)
            .engine(engine)
            .build()
    }
    override fun createMotorcycle(year: Int, brand: String, engine: Engine): Motorcycle {
        Logger.log("Creating Motorcycle")
        return Motorcycle.Builder()
            .year(year)
            .brand(brand)
            .engine(engine)
            .build()
    }
    override fun createElectricCar(year: Int, brand: String, battery: Int, engine: Engine): ElectricVehicle {
        Logger.log("Creating Electric Vehicle")
        return ElectricVehicle.Builder()
            .year(year)
            .batteryCapacity(battery)
            .brand(brand)
            .engine(engine)
            .build()
    }
    override fun createEngine(horsePower: Int, type: String): Engine {
        Logger.log("Creating Engine")
        return Engine.Builder()
            .power(horsePower)
            .type(type)
            .build()
    }
}