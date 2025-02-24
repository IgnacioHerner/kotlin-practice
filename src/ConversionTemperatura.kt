fun main() {
    // Pedimos al usuario que elija la conversion
    print("Ingrese 'C' para convertir de Celsius a Fahrenheit o 'F' para convertir de Fahrenheit a Celsius: ")
    val opcion = readLine()?.uppercase() ?: ""

    // Verificamos la opcion ingresada
    if (opcion == "C") {
        println("Ingrese la temperatura en Celsius: ")
        val celsius = readLine()?.toDoubleOrNull()

        if (celsius != null) {
            val fahrenheit = (celsius * 9/5) + 32
            println("$celsius equivale a $fahrenheit")
        } else {
            println("Error: Ingrese un numero valido")
        }
    } else if (opcion == "F") {
        println("Ingrese la temperatura en Fahrenheit: ")
        val fahrenheit = readLine()?.toDoubleOrNull()

        if (fahrenheit != null){
            val celsius = (fahrenheit -32) *5/9
            println("$fahrenheit equivale a $celsius")
        }
    } else {
        println("Opcion no valida. Debe ingresar 'C' o 'F' ")
    }
}

/*
    Explicación Paso a Paso
    1️⃣ Pedimos al usuario que elija la conversión

    Se usa readLine()?.uppercase() para leer la opción y convertirla a mayúsculas.
    Si la entrada es null, se usa "" (cadena vacía).
    2️⃣ Si elige Celsius a Fahrenheit (C)

    Pedimos la temperatura en Celsius.
    toDoubleOrNull() convierte la entrada en número o devuelve null si no es válido.

    3️⃣ Si elige Fahrenheit a Celsius (F)
    Pedimos la temperatura en Fahrenheit.

    4️⃣ Manejamos errores

    Si el usuario ingresa un valor no numérico, mostramos un mensaje de error.
    Si ingresa una opción no válida, le indicamos que debe ingresar "C" o "F".

 */