fun main () {
    print("Ingrese una cadena de texto: ")
    val texto = readLine() ?: ""

    val textoInvertido = texto.reversed()

    println("Texto invertido: $textoInvertido")
}

/*
    1️⃣ Solicitamos una cadena de texto al usuario

    readLine() captura la entrada como una cadena (String).
    Si el usuario no ingresa nada (null), se usa "" (cadena vacía) por defecto.
    2️⃣ Usamos la función reversed()

    texto.reversed() invierte la cadena.
    "Hola" → "aloH".
    3️⃣ Mostramos la cadena invertida

    Se imprime en pantalla el texto invertido.
 */