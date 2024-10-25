package org.example
import org.example.interfaces.Prototype
import org.example.interfaces.Truck
import org.example.interfaces.Vehicle


@ConsistentCopyVisibility
data class Truck private constructor(private val year: Int?,
                                     private val brand: String?,
                                     private val payloadCapacity: Int? = 1000,
                                     private val engine: Engine?): Vehicle, Prototype, Truck {


    class Builder {
        private var year: Int? = null
        private var brand: String? = null
        private var payloadCapacity: Int? = 1000
        private var engine: Engine? = null

        fun year(year: Int) = apply { this.year = year }
        fun brand(brand: String) = apply { this.brand = brand }
        fun payloadCapacity(payloadCapacity: Int) = apply { this.payloadCapacity = payloadCapacity }
        fun engine(engine: Engine) = apply { this.engine = engine }

        fun build() = Truck(year, brand, payloadCapacity, engine ?: Engine.Builder().build())
    }
    override fun clone(): Prototype {
        return this.copy(engine = engine?.clone() as Engine)
    }
   override fun info() {
        Logger.log("Truck with $year year, brand $brand, payload capacity $payloadCapacity")

    }
    override fun drive(): String {
        return "Driving a $year $brand Truck"
    }

     override fun load(): String {
         return "Loading a $year $brand Truck"
     }

}