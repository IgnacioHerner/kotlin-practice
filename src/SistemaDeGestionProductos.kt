/*
Descripción:
Vamos a desarrollar un sistema simple de gestión de productos, donde el usuario podrá:
✅ Agregar productos con nombre, precio y cantidad en stock.
✅ Actualizar el precio o la cantidad de un producto existente.
✅ Eliminar un producto del inventario.
✅ Listar todos los productos y calcular el valor total del inventario.

📌 Objetivo: Practicar listas, clases, funciones, when y entrada/salida en Kotlin.

Lógica del Ejercicio
1️⃣ Creamos una clase Producto con propiedades como nombre, precio y cantidad.
2️⃣ Usamos una lista mutable para almacenar los productos.
3️⃣ Implementamos funciones para cada acción (agregar, actualizar, eliminar, listar).
4️⃣ Hacemos un menú interactivo en consola con while (true) y when para gestionar las opciones del usuario.
5️⃣ Agregamos validaciones para evitar errores con entradas inválidas.


 */

data class Producto(val id: Int, var nombre: String, var precio: Double, var cantidad: Int)

// Lista mutable para almacenar los productos
val inventario = mutableListOf<Producto>()

fun agregarProducto() {
    print("Ingrese el nombre del producto: ")
    val nombre = readLine()?.trim() ?: ""

    println("Ingrese el precio del producto: ")
    val precio = readLine()?.toDoubleOrNull()

    println("Ingrese la cantidad de stock: ")
    val cantidad = readLine()?.toIntOrNull()

    if (nombre.isBlank() || precio == null || cantidad == null || precio < 0 || cantidad < 0 ){
        println("Error: Datos inválidos. Intente de nuevo")
        return
    }

    val nuevoProducto = Producto(inventario.size + 1, nombre, precio, cantidad)
    inventario.add(nuevoProducto)
    println("Producto agregado con exito: $nombre")
}

// Funcion para actualizar producto (precio o cantidad)
fun actualizarProducto() {
    listarProductos()
    println("Ingrese el ID del producto a actualizar: ")
    val id = readLine()?.toIntOrNull()

    val producto = inventario.find {  it.id == id }
    if(producto != null){
        println("¿Que desea actualizar?")
        println("1. Precio")
        println("2. Cantidad")
        println("Opcion: ")

        when(readLine()) {
            "1" -> {
                println("Ingrese el nuevo precio: ")
                val nuevoPrecio = readLine()?.toDoubleOrNull()
                if (nuevoPrecio != null && nuevoPrecio >= 0){
                    producto.precio = nuevoPrecio
                    println("Precio actualizado con exito.")
                } else {
                    println("Error: Precio inválido")
                }
            }
            "2" -> {
                println("Ingrese la nueva cantidad: ")
                val nuevaCantidad = readLine()?.toIntOrNull()
                if (nuevaCantidad != null && nuevaCantidad >= 0){
                    producto.cantidad = nuevaCantidad
                    println("Cantiad actualizada con exito")
                } else {
                    println("Error: Cantidad inválida")
                }
            }
            else -> println("Opcion inválida")
        }
    } else {
        println("No se encontro un producto con ese ID")
    }
}

// Funcion para eliminar un producto
fun eliminarProducto() {
    listarProductos()
    print("Ingrese el ID del producto a eliminar: ")
    val id = readLine()?.toIntOrNull()

    if (inventario.removeIf{it.id == id}){
        println("Producto eliminado con exito")
    }else {
        println("No se encontro un producto con ese ID")
    }
}

// Funcion para listar todos los productos y calcular el valor total del inventario
fun listarProductos() {
    if(inventario.isEmpty()) {
        println("No hay productos en el inventario")
        return
    }

    var valorTotal = 0.0
    println("\n Inventario de productos: ")
    inventario.forEach { producto ->
        val totalProducto = producto.precio * producto.cantidad
        valorTotal += totalProducto
        println("${producto.id}. Nombre: ${producto.nombre} Precio: ${producto.precio} Stock: ${producto.cantidad} unidades | Valor Total: ${totalProducto}")
    }

    println("\n Valor total de inventario: ${valorTotal}")
}


fun main () {
    while(true) {
        println("\n=== 📦 GESTOR DE INVENTARIO ===")
        println("1️⃣ Agregar producto")
        println("2️⃣ Actualizar producto")
        println("3️⃣ Eliminar producto")
        println("4️⃣ Listar productos")
        println("5️⃣ Salir")
        print("👉 Ingrese una opción: ")

        when(readLine()) {
            "1" -> agregarProducto()
            "2" -> actualizarProducto()
            "3" -> eliminarProducto()
            "4" -> listarProductos()
            "5" -> {
                println("👋 Saliendo del gestor de inventario.")
                break
            }
            else -> println("❌ Opción inválida. Intente de nuevo.")
        }
    }
}

/*
Puntos Claves del Código
✅ Uso de data class: Creamos una clase Producto con id, nombre, precio y cantidad.
✅ Lista mutable: mutableListOf<Producto>() nos permite modificar la lista de productos en tiempo de ejecución.
✅ Validaciones de entrada: Se evita que el usuario ingrese valores vacíos o inválidos (toDoubleOrNull(), toIntOrNull()).
✅ Bucle while (true) y when: Implementamos un menú interactivo.
✅ Uso de find {} y removeIf {}: Métodos para buscar y eliminar productos en la lista.
✅ Cálculo del valor total del inventario: Se multiplica precio * cantidad y se acumula.
 */