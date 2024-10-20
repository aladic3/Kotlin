    package org.example

    import java.time.Year



    fun main() {
        val name = "Kotlin"
        var smt: String? = null
        var age: Int = 5;
        println(smt?.length ?: "Hello, $name!")
        println(smt?.length )
        println("Hello+ $name  ${age+1}")

        fun  greet(name: String = "Kotlin"): String {
            return "Hello, $name!"}
        println(greet())

        var sum: (Int, Int) -> Int = {x, y -> x + y}

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
    }