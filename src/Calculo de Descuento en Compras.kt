/*
    Descripción:
    Crea un programa que calcule el precio final de un producto después de aplicar un descuento. El usuario ingresará el precio original y el porcentaje de descuento, y el programa deberá calcular el precio con el descuento aplicado.

    ✅ El precio original debe ser mayor a 0
    ✅ El porcentaje de descuento debe estar entre 0 y 100
    ✅ Mostrar el precio final con dos decimales
 */

fun calcularDescuento(precio: Double, descuento: Double): Double {
    // Si el descuento no está en el rango válido, devolvemos el precio original
    if (descuento < 0 || descuento > 100) {
        println("❌ Error: El porcentaje de descuento debe estar entre 0 y 100.")
        return precio
    }

    // Calculamos el precio con descuento
    return  precio * (1 - descuento / 100)
}

fun main() {
    print("Ingrese el precio del producto: ")
    val precio = readLine()?.replace(",", ".")?.toDoubleOrNull()  // Reemplazar ',' por '.'

    print("Ingrese el porcentaje de descuento: ")
    val descuento = readLine()?.replace(",", ".")?.toDoubleOrNull()

    if (precio == null || precio <= 0 || descuento == null) {
        println("❌ Error: Ingrese valores válidos.")
        return
    }

    val precioFinal = calcularDescuento(precio, descuento)
    println("💰 Precio final con descuento: %.2f".format(precioFinal))  // Mostrar bien formateado
}
