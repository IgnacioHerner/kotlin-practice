fun main() {
    println("Ingrese un texto: ")
    val texto = readLine()

    if(texto.isNullOrBlank()) {
        println("Error: No ingresaste ningun texto")
        return
    }

    val palabras = texto.split("\\s+".toRegex()).filter { it.isNotBlank() }// Expresion regular para multiples espacios

    val cantidadPalabras = palabras.size

    println("El texto ingresado tiene $cantidadPalabras palabras.")
}