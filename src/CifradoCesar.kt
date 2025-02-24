/*
    📌 Objetivo:
    El cifrado César es una de las técnicas de encriptación más antiguas. Consiste en desplazar cada letra de un mensaje un número fijo de posiciones en el alfabeto. Por ejemplo, con un desplazamiento de 3, la letra A se convierte en D, la B en E, y así sucesivamente.

    Tu tarea es crear un programa que:

    Pida un mensaje al usuario.
    Solicite un número de desplazamiento.
    Cifre el mensaje usando el Cifrado César.
    Muestre el mensaje cifrado en pantalla.

 */

fun main () {
    print("Ingrese el mensaje a cifrar: ")
    val mensaje = readLine() ?: ""

    print("Ingrese el número de desplazamiento")
    val desplazamiento = readLine()?.toIntOrNull() ?: 0

    // Ciframos el mensaje y mostramos el resultado
    val mensajeCifrado = cifrarCesar(mensaje, desplazamiento)
    println("Mensaje cifrado: $mensajeCifrado")

}

fun cifrarCesar(texto: String, desplazamiento: Int) : String {
    val resultado = StringBuilder()

    for(caracter in texto ) {
        when {
            caracter.isLetter() -> {
                val base = if(caracter.isUpperCase()) 'A' else 'a'
                val nuevoCaracter = ((caracter - base + desplazamiento)% 26 + base.code).toChar()
                resultado.append(nuevoCaracter)
            }
            else -> resultado.append(caracter) // Mantener espacios y signos sin cambios
        }
    }
    return resultado.toString()
}

/*
    Puntos Claves 🔑
    1️⃣ Leer la entrada del usuario:
    readLine() captura el texto y el número de desplazamiento.
    toIntOrNull() convierte el número y previene errores si no es válido.

    2️⃣ Procesar cada letra del mensaje:
    isLetter() verifica si el carácter es una letra.
    isUpperCase() detecta si es mayúscula para usar la base correcta.
    (caracter - base + desplazamiento) % 26 aplica el cifrado.

    3️⃣ Ignorar espacios y signos:
    Si el carácter no es una letra, se mantiene sin cambios.
 */