package org.example

import org.example.interfaces.Vehicle
import org.example.interfaces.VehicleFactory

class CarFactory: VehicleFactory() {
    override fun createVehicle(year: Int, brand: String, engine: Engine): Vehicle {
        showNotification(Notification("Creating Car", NotificationTyper.success("Car created")))
        NotificationTyper.success("Car created")
        return Car.Builder()
            .year(year)
            .brand(brand)
            .engine(engine)
            .build()
    }
}