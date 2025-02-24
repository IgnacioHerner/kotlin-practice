fun main () {
    // Pedimos al usuario que ingrese un texto
    print("Ingrese un texto largo: ")
    val texto = readLine()

    // Verificamos si el texto está vacio o nulo
    if(texto.isNullOrBlank()) {
        println("Error: No ingresaste ningun texto")
        return
    }

    // Convertimos el texto a minusculas y eliminamos los signos de puntuacion
    val palabras = texto.lowercase()
        .replace(Regex("[^a-záéíóúüñ ]"), "")
        .split("\\s+".toRegex()) // Dividimos por espacios
        .filter { it.isNotBlank() }

    // Creamos un mapa para contar la frecuencia de cada palabra
    val frecuencia = mutableMapOf<String, Int> ()

    for (palabra in palabras) {
        frecuencia[palabra] = frecuencia.getOrDefault(palabra, 0) + 1
    }

    // Ordenamos las palabras por frecuencia en orden descendente
    val ordenadas = frecuencia.entries.sortedByDescending { it.value }

    // Mostramos el resultado
    println("\nPalabras más frecuentes en el texto")
    for((palabra, cantidad) in ordenadas){
        println("$palabra -> $cantidad veces")
    }
}