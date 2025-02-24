fun main () {
    print("Ingrese un numero: ")
    val numero = readLine()?.toIntOrNull() ?: 1

    if(esPrimo(numero)) {
        println("El numero $numero es primo")
    } else {
        println("El numero $numero no es primo")
    }
}

fun esPrimo(num: Int): Boolean {
    if(num < 2) return false // Los numeros menores a 2 no son primos
    for (i in 2 until num) { // recorremos desde 2 hasta num - 1
        if(num % 1 == 0){
            return false // Si es divisible por otro numero, no es primo
        }
    }
    return true // Si no se encontro ningun divisor, es primo

}

/*
    1️⃣ Solicitamos un número al usuario

    readLine() captura la entrada como texto.
    toIntOrNull() convierte la entrada a un número entero (Int).
    Si la conversión falla (por ejemplo, si el usuario ingresa letras), se usa 1 por defecto.
    2️⃣ Creamos una función esPrimo(num: Int): Boolean

    Si el número es menor que 2, retorna false (no es primo).
    Usamos un bucle for desde 2 hasta num - 1 para ver si es divisible por otro número.
    Si encontramos un divisor, retornamos false.
    Si no encontramos divisores, retornamos true (es primo).
    3️⃣ Llamamos a la función esPrimo(numero) en main()

    Si el número es primo, mostramos "El número es primo."
    Si no es primo, mostramos "El número no es primo." */