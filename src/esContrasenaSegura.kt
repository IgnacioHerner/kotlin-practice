/*
    Descripción:
    Escribe un programa que verifique si una contraseña ingresada por el usuario es segura.
    Para que una contraseña sea considerada segura, debe cumplir con los siguientes requisitos:

    ✅ Tener al menos 8 caracteres
    ✅ Contener al menos una letra mayúscula
    ✅ Contener al menos una letra minúscula
    ✅ Contener al menos un número
    ✅ Contener al menos un carácter especial (ejemplo: !@#$%^&*)
 */

fun esContrasenaSegura(contrasena: String): Boolean {
    // Verificar si tiene al menos 8 caracterers
    if (contrasena.length < 8) return false

    var tieneMayuscula = false
    var tieneMinusucla = false
    var tieneNumero = false
    var tieneEspecial = false

    // Lista de caracteres especiales
    val caracteresEspeciales = "!@#$%^&*()_+-={}[]|:;<>,.?/~"

    // Recorrer cada caracter de la contraseña
    for(char in contrasena) {
        when{
            char.isUpperCase() -> tieneMayuscula = true
            char.isLowerCase() -> tieneMinusucla = true
            char.isDigit() -> tieneNumero = true
            caracteresEspeciales.contains(char) -> tieneEspecial = true
        }
    }

    // Retorna true solo si cumple con todas las condiciones
    return tieneMayuscula && tieneMinusucla && tieneNumero && tieneEspecial
}

fun main () {
    println("Ingrese una contraseña: ")
    val input = readLine() ?: ""

    if(esContrasenaSegura(input)) {
        println("Contraseña segura")
    } else {
        println("Contraseña no es segura, Intenta con otra")
    }
}