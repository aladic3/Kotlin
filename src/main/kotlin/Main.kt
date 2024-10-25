    package org.example

    import org.example.interfaces.Vehicle
    import org.example.interfaces.VehicleFactory


    fun  processNumbers(numbers: List<Int>, operation: (Int) -> Int): List<Int> {
        return numbers.map { operation(it) }
    }
    fun printUserInfo(name: String?, age: Any?): Unit{
        val ageString = when (age) {
            is Int -> age.toString()
            is String -> age
            null -> "Unknown"
            else -> "Unknown"
        }
         "Name: ${name ?: "Guest"} Age: $ageString".also {
            println(it)
        }
    }

    fun main() {

        val house1 =   House.Builder()
            .countFloors(2)
            .square(100)
            .typeRoof("Tile")
            .build()
        val house2 =   House.Builder()
            .square(200)
            .typeRoof("Metal")
            .garageAvailable(true)
            .build()

        val house3 = house1.clone() as House
        val house4 = house3.copy(countFloors = 5)
        house3.info()
        house4.info()
        val truck1 = Truck.Builder()
            .brand("Volvo")
            .year(2010)
            .payloadCapacity(2000)
            .engine(Engine.Builder().power(200).type("Diesel").build())
            .build()
        val truck2 = truck1.clone() as Truck
        truck1.info()
        truck2.info()
        val builderVehicle = VehicleAbstractFactory()
        val engine = builderVehicle.createEngine(200, "Gasoline")
        val elEngine = builderVehicle.createEngine(100, "Electric")
        val listVehicle = mutableListOf<Vehicle>()
        listVehicle.add(builderVehicle.createCar(2010, "Toyota", engine))
        listVehicle.add(builderVehicle.createMotorcycle(2015, "BMW", engine))
        listVehicle.add(builderVehicle.createElectricCar(2018, "Audi", 1000, elEngine))
        listVehicle.add(builderVehicle.createTruck(2010, "Volvo", engine))
        listVehicle.forEach { it.drive() }
        listVehicle.forEach { it.info() }




/*
        Logger.log("This is a debug message", Logger.LogLevel.DEBUG)
        Logger.log("This is an info message", Logger.LogLevel.INFO)
        Logger.log("This is a warning message", Logger.LogLevel.WARNING)
        Logger.log("This is an error message", Logger.LogLevel.ERROR)
        Logger.log("This is a fatal message", Logger.LogLevel.FATAL)
        Logger.changeLevel(Logger.LogLevel.DEBUG)
        Logger.log("This is a debug message")
        Logger.changeLevel(Logger.LogLevel.FATAL)
        Logger.log("This is a error message", Logger.LogLevel.ERROR)
        Logger.changeLevel(null)
        Logger.log("This is a debug message")
        Logger.changeLevel(Logger.LogLevel.INFO)
        Logger.log("This is a debug message", Logger.LogLevel.DEBUG)
*/
        val carFactory: List<VehicleFactory> = listOf(MotorcycleFactory(),
            CarFactory(), ElectricVehicleFactory(), TruckFactory())

        for (factory in carFactory) {
            val vehicle = factory.createVehicle(2010, "Toyota", Engine.Builder().power(200).type("Gasoline").build())
            println(vehicle.drive())
        }

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
/*
        val cars = listOf(
            Car(2010, "Toyota"),
            Car(2015, "BMW"),
            Car(2018, "Audi"),
            ElectricVehicle(2000),
            ElectricVehicle(2010)
        )

        val updatedYear = cars.map { it.year + 10}
        val filteredCars = cars.filter { it.year > 2010 }
        val totalYears = cars.map {it.year}.reduce { acc, year -> acc + year }
        val carDetails = cars.flatMap { listOf((it as? Car)?.band ?: "Unknown", it.year.toString(), (it as? ElectricVehicle)?.batteryCapacity ?: "Unknown") }

        println(updatedYear)
        println(filteredCars)
        println(totalYears)
        println(carDetails)
*/
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
/*
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

 */
    }