package org.example
import org.example.interfaces.Subject
import org.example.interfaces.Vehicle


class VehicleAbstractFactory: org.example.interfaces.VehicleAbstractFactory {
    private val notifyObservers = NotifyObservers


   override fun createCar(year: Int, brand: String, engine: Engine): Car {
       notifyObservers.notifyObservers("Creating Car")
        return Car.Builder()
            .year(year)
            .brand(brand)
            .engine(engine)
            .build()
    }
    override fun createTruck(year: Int, brand: String, engine: Engine): Truck {
        notifyObservers.notifyObservers("Creating Truck")
        return Truck.Builder()
            .year(year)
            .brand(brand)
            .engine(engine)
            .build()
    }
    override fun createMotorcycle(year: Int, brand: String, engine: Engine): Motorcycle {
        notifyObservers.notifyObservers("Creating Motorcycle")
        return Motorcycle.Builder()
            .year(year)
            .brand(brand)
            .engine(engine)
            .build()
    }
    override fun createElectricCar(year: Int, brand: String, battery: Int, engine: Engine): ElectricVehicle {
        notifyObservers.notifyObservers("Creating Electric Car")
        return ElectricVehicle.Builder()
            .year(year)
            .batteryCapacity(battery)
            .brand(brand)
            .engine(engine)
            .build()
    }
    override fun createEngine(horsePower: Int, type: String): Engine {
       notifyObservers.notifyObservers("Creating Engine")
        return Engine.Builder()
            .power(horsePower)
            .type(type)
            .build()
    }
}