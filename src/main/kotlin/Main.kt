    package org.example

    import java.time.Year

    fun  processNumbers(numbers: List<Int>, operation: (Int) -> Int): List<Int> {
        return numbers.map { operation(it) }
    }
    fun printUserInfo(name: String?, age: Any?): Unit{
        val ageString = when (age) {
            is Int -> age.toString()
            is String -> age
            else -> "Unknown"
        }
         "Name: ${name ?: "Guest"} Age: ${ageString ?: "Unknown"}".also {
            println(it)
        }
    }

    fun main() {
        printUserInfo("John", 25)
        printUserInfo(null, 25)
        printUserInfo("John", null)
        printUserInfo(null, "null")

        val name = "Kotlin"
        var smt: String? = null
        var age: Int = 5;
        println(smt?.length ?: "Hello, $name!")
        println(smt?.length )
        println("Hello+ $name  ${age+1}")

        val cars = listOf(
            Car(2010, "Toyota"),
            Car(2015, "BMW"),
            Car(2018, "Audi"),
            ElectricVehicle(2000, 2020),
            ElectricVehicle(1000, 2010)
        )

        val updatedYear = cars.map { it.year + 10}
        val filteredCars = cars.filter { it.year > 2010 }
        val totalYears = cars.map {it.year}.reduce { acc, year -> acc + year }
        val carDetails = cars.flatMap { listOf((it as? Car)?.band ?: "Unknown", it.year.toString(), (it as? ElectricVehicle)?.batteryCapacity ?: "Unknown") }

        println(updatedYear)
        println(filteredCars)
        println(totalYears)
        println(carDetails)

        fun  greet(name: String = "Kotlin"): String {
            return "Hello, $name!"}
        println(greet())

        var sum: (Int, Int) -> Int = {a, b -> a + b}

        println(sum(5, 6))

        val numbers = listOf(1, 2, 3, 4, 5)

        var numbers2 = numbers.filter { it % 2 == 0 }
        println(numbers2.reduce { acc , i -> acc + i })
        var list = (1 .. 20).toList()
        list = list.filter { it % 2 != 0 }
        println(list)

        var car = Car(Year.now().value, "Toyota")
        car.info();
        car = Car(2010)

        car.info();
        var electronicVehicle = ElectricVehicle(2000, 2020)
        electronicVehicle.info()
        electronicVehicle.charge()
        electronicVehicle.info()
        val electricVehicles = listOf(ElectricVehicle(2000, 2020), ElectricVehicle(1000, 2010), ElectricVehicle (1210, 2015))
        val filteredVehicles = electronicVehicle.filterVehicle(electricVehicles)
        filteredVehicles.forEach { it.info() }
        numbers2 = processNumbers(numbers) { it * 2 }
        println(numbers2)

        try {
            val car2 = createCar(1885, "BMW")
        } catch (e: InvalidYearException) {
            println(e.message)
        }
       try {
            electronicVehicle.useCharge(4999)
        } catch (e: InsufficientBatteryException) {
            println(e.message)
       }
    }