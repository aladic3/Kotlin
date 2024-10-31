package org.example.interfaces
import org.example.House
abstract class HouseFactory {
    abstract fun createHouse( countFloors: Int?,
                              typeRoof: String?,
                              square: Int?,
                              garageAvailable: Boolean?): House
}