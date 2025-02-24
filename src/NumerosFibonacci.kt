/*
    📌 Objetivo:
    La secuencia de Fibonacci es una serie matemática donde cada número es la suma de los dos anteriores. Comienza así:

    0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...

    Tu tarea es crear un programa que:

    Pida un número N al usuario.
    Genere los primeros N números de Fibonacci.
    Los muestre en pantalla.

 */

fun generarFibonnacci(n: Int): List<Int> {
    if (n <= 0) return emptyList()
    if (n == 1) return listOf(0)

    val fibonacci = mutableListOf(0,1)

    for (i in 2 until n) {
        fibonacci.add(fibonacci[i - 1] + fibonacci[i -2]) // Sumar los dos anteriores
    }

    return fibonacci
}

fun main() {
    println("Ingrese la cantidad de numeros de Fibonacci que desea ver: ")
    val n = readLine()?.toIntOrNull() ?: 0

    val resultado = generarFibonnacci(n)
    println("Los primeros $n numeros de fibonacci son: $resultado")
}