fun main () {
    print("Ingrese una lista de numeros separados por espacio")
    val entrada = readLine()

    if (entrada.isNullOrBlank()){
        println("Error: No ingresaste ningun numero")
        return
    }

    val numeros = entrada.split(" ").mapNotNull { it.toDoubleOrNull() }
    if(numeros.isEmpty()) {
        println("Error: No ingresaste numeros validos")
        return
    }

    val suma = numeros.sum()
    val promedio = suma / numeros.size

    println("Lista de numeros ingresados: $numeros")
    println("Suma de los numeros: $suma")
    println("Promedio de los numeros: $promedio")
}

/*
    1️⃣ Pedimos una lista de números

    readLine() captura la entrada del usuario.
    isNullOrBlank() verifica si el usuario no ingresó nada.
    2️⃣ Convertimos la entrada en una lista de números

    split(" ") separa los valores usando los espacios como separador.
    mapNotNull { it.toDoubleOrNull() } convierte cada valor en Double, ignorando valores inválidos.
    3️⃣ Verificamos si hay números válidos

    Si numeros.isEmpty(), significa que el usuario no ingresó números válidos.
    4️⃣ Calculamos la suma y el promedio

    sum() obtiene la suma de la lista.
    promedio = suma / numeros.size calcula el promedio.
    5️⃣ Mostramos los resultados

    Se imprime la lista de números ingresados, la suma y el promedio.

 */