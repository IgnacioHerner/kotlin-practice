/*
    📌 Objetivo:
    Ahora vamos a hacer el proceso inverso del Cifrado César. Dado un mensaje cifrado y el número de desplazamiento usado, debemos recuperar el mensaje original.

    Tu tarea es crear un programa que:

    Pida un mensaje cifrado al usuario.
    Solicite el número de desplazamiento usado en el cifrado.
    Descifre el mensaje restando el desplazamiento.
    Muestre el mensaje original en pantalla.
 */

fun main() {
    print("Ingrese el mensaje cifrado: ")
    val mensajeCifrado = readLine() ?: ""

    println("Ingrese el numero de desplazamiento: ")
    val desplazamiento = readLine()?.toIntOrNull() ?: 0

    val mensajeOriginal = descifrarCesar(mensajeCifrado, desplazamiento)
    println("Mensaje descifrado: $mensajeOriginal")

}

fun descifrarCesar (texto: String, desplazamiento: Int): String {
    val resultado = StringBuilder()

    for(caracter in texto) {
        when {
            caracter.isLetter() -> {
                val base = if (caracter.isUpperCase()) 'A' else 'a'
                val nuevoCaracter = ((caracter - base - desplazamiento + 26) % 26 + base.code).toChar()
                resultado.append(nuevoCaracter)
            }
            else -> resultado.append(caracter)
        }
    }
    return resultado.toString()
}