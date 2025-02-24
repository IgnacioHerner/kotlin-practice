/*
    📌 Objetivo:
    Un anagrama es una palabra o frase que se forma reorganizando las letras de otra palabra o frase. Por ejemplo, "roma" y "amor" son anagramas.

    Tu tarea es crear un programa que:

    Pida dos palabras al usuario.
    Verifique si son anagramas (ignorando mayúsculas y espacios).
    Muestre el resultado en pantalla.
 */

fun main() {
    print("Ingrese la primera palabra: ")
    val palabra1 = readLine() ?: ""

    print("Ingrese la primera palabra: ")
    val palabra2 = readLine() ?: ""

    if(sonAnagramas(palabra1, palabra2)) {
        println("Las palabras \"$palabra1\" y \"$palabra2\" son anagramas")
    }else {
        println("Las palabras \"$palabra1\" y \"$palabra2\" no son anagramas")
    }
}

fun sonAnagramas(palabra1: String, palabra2: String): Boolean {
    val normalizada1 = palabra1.replace(" ", "").lowercase()
    val normalizada2 = palabra2.replace(" ", "").lowercase()

    return normalizada1.toList().sorted() == normalizada2.toList().sorted()
}