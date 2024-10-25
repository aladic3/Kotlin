package org.example
import org.example.interfaces.*

@ConsistentCopyVisibility
data class ElectricVehicle private  constructor(val year: Int?,
                                                val band: String? = "Unknown",
                                                var batteryCapacity: Int = 1000,
                                                val engine: Engine?) :
    Chargeable, Vehicle, Prototype {
    override fun clone(): Prototype {
        return this.copy(engine = engine?.clone() as Engine)
    }
    class Builder {
        private var year: Int? = 2021
        private var band: String? = "Unknown"
        private var batteryCapacity: Int = 1000
        private var engine: Engine? = Engine.Builder().build()
        fun year(year: Int?) = apply { this.year = year }
        fun brand(band: String?) = apply { this.band = band }
        fun batteryCapacity(batteryCapacity: Int) = apply { this.batteryCapacity = batteryCapacity }
        fun engine(engine: Engine?) = apply { this.engine = engine }
        fun build() = ElectricVehicle(year, band, batteryCapacity, engine)
    }

    override fun drive(): String {
        return "Driving"
    }
    override fun info(){
        println("Battery capacity $batteryCapacity year $year")
    }
    override fun charge() {
        println("Charging")
        batteryCapacity += 100
        Logger.log("Charging electric vehicle", Logger.LogLevel.INFO)
    }
    fun useCharge(batteryCapacity: Int) {
        if (batteryCapacity > this.batteryCapacity) {
            throw InsufficientBatteryException("Insufficient battery")
        }
        this.batteryCapacity -= batteryCapacity
        Logger.log("Using charge", Logger.LogLevel.INFO)
    }
    fun filterVehicle(vehicles: List<ElectricVehicle>): List<ElectricVehicle> {
        return vehicles.filter { it.batteryCapacity > 1200 }
    }
}
