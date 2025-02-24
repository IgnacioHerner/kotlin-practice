fun main() {
    print("Ingrese el primer numero: ")
    val num1 = readLine()?.toDoubleOrNull() ?: 0.0

    print("Ingrese el segundo numero: ")
    val num2 = readLine()?.toDoubleOrNull() ?: 0.0

    println("Selecione la operacion (+,-,*,/)")
    val operacion = readLine()

    val resultado = when (operacion) {
        "+" -> num1 + num2
        "-" -> num1 - num2
        "*" -> num1 * num2
        "/" -> if(num2 != 0.0) num1 / num2 else "Error: Division por 0"
        else -> "Operacion no valida"
    }

    println("El resultado es: $resultado")

}

/*
    Explicación Paso a Paso
    1️⃣ Pedimos dos números al usuario

    readLine() captura la entrada del usuario.
    toDoubleOrNull() convierte el valor ingresado a un número decimal (Double).
    Si la conversión falla (por ejemplo, si el usuario ingresa letras), se usa 0.0 como valor por defecto.
    2️⃣ Solicitamos la operación a realizar

    Se imprime un mensaje con las opciones disponibles (+, -, *, /).
    readLine() captura la operación ingresada.
    3️⃣ Realizamos la operación con when

    when actúa como un switch en otros lenguajes.
    Si la operación es válida, se ejecuta la correspondiente.
    En la división, verificamos que num2 no sea 0.0 para evitar errores.
    4️⃣ Mostramos el resultado

    Si la operación no es válida, mostramos un mensaje de error.
 */