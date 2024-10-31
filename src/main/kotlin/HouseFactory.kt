package org.example
import org.example.interfaces.HouseFactory
import org.example.House

class HouseFactory: HouseFactory() {
    override fun createHouse(countFloors: Int?, typeRoof: String?, square: Int?, garageAvailable: Boolean?): House {
        NotifyObservers.notifyObservers("House created")
        return House.Builder()
            .countFloors(countFloors!!)
            .typeRoof(typeRoof!!)
            .square(square!!)
            .garageAvailable(garageAvailable!!)
            .build()
    }
}