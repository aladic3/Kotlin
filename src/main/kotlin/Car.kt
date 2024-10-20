package org.example

class Car(val year: Int, val band: String = "BMW") {
    fun info(){
        println("Band $band year $year")
    }
}