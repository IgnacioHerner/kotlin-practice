/*
Descripción:
Vamos a desarrollar un sistema de pedidos, donde el usuario podrá:
✅ Agregar pedidos, cada uno con una lista de productos.
✅ Actualizar un pedido, añadiendo o eliminando productos.
✅ Eliminar un pedido completo.
✅ Listar todos los pedidos, mostrando el total a pagar.
✅ Buscar pedidos por cliente.

📌 Objetivo: Practicar listas anidadas, clases, funciones y manejo de colecciones en Kotlin.

Lógica del Ejercicio
1️⃣ Creamos una clase Producto con nombre, precio y cantidad.
2️⃣ Creamos una clase Pedido, que tendrá un cliente, un ID y una lista de productos.
3️⃣ Usamos una lista mutable para almacenar pedidos.
4️⃣ Implementamos funciones para cada acción (agregar, actualizar, eliminar, buscar).
5️⃣ Hacemos un menú interactivo en consola con while (true) y when para gestionar las opciones.
 */

data class ProductoPedido(val nombre: String, var precio: Double, var cantidad: Int)
data class Pedido(val id: Int, val cliente: String, val productos: MutableList<ProductoPedido>)

// Lista mutable para almacenar los pedidos
val pedidos = mutableListOf<Pedido>()

// Funcion para agregar un nuevo pedido
fun agregarPedido() {
    print("Ingrese el nombre del cliente: ")
    val cliente = readLine()?.trim() ?: ""

    if (cliente.isBlank()){
        println("Error: El nombre del cliente no puede estar vacío.")
        return
    }

    val productos = mutableListOf<ProductoPedido>()

    while (true){
        print("Ingrese el nombre del producto (o 'fin' para terminar):")
        val nombreProducto = readLine()?.trim() ?: ""
        if(nombreProducto.lowercase() == "fin") break

        print("Ingrese el precio: ")
        val precio = readLine()?.toDoubleOrNull()
        print("Ingrese la cantidad: ")
        val cantidad = readLine()?.toIntOrNull()

        if(nombreProducto.isBlank() || precio == null || cantidad == null || precio < 0 || cantidad < 0) {
            println("Error: Datos inválidos. Intente de nuevo")
            continue
        }

        productos.add(ProductoPedido(nombreProducto, precio, cantidad))
    }

    if (productos.isNotEmpty()) {
        val nuevoPedido = Pedido(pedidos.size + 1, cliente, productos)
        pedidos.add(nuevoPedido)
        println("Pedido agregado con éxito para $cliente")
    } else {
        println("Error: No se agregó ningún producto.")
    }
}

// Función para listar los pedidos y calcular el total
fun listarPedidos() {
    if(pedidos.isEmpty()){
        println("No hay pedidos registrados")
        return
    }

    println("\n Listado de Pedidos:")
    pedidos.forEach { pedido ->
        println("Pedido #${pedido.id} | Cliente: ${pedido.cliente}")
        var total = 0.0
        pedido.productos.forEach { productoPedido ->
            val subTotal = productoPedido.precio * productoPedido.cantidad
            total += subTotal
            println("Nombre: ${productoPedido.nombre} Precio: ${productoPedido.precio} Cantidad: ${productoPedido.cantidad} Subtotal: $subTotal")
        }
        println("Total a pagar: $total\n")
    }
}

fun actualizarPedido() {
    listarPedidos()
    print("Ingrese el ID del pedido a actualizar: ")
    val id = readLine()?.toIntOrNull()

    val pedido = pedidos.find { it.id == id }
    if(pedido != null) {
        println("📌 ¿Qué desea hacer?")
        println("1️⃣ Agregar producto")
        println("2️⃣ Eliminar producto")
        print("👉 Opción: ")

        when(readLine()) {
            "1" -> {
                print("Nombre del nuevo producto: ")
                val nombreProducto = readLine()?.trim() ?: ""

                print("Precio: ")
                val precio = readLine()?.toDoubleOrNull()
                print("Cantidad: ")
                val cantidad = readLine()?.toIntOrNull()

                if (nombreProducto.isBlank() || precio == null || cantidad == null || precio < 0 || cantidad < 0){
                    println("Error: Datos inválidos")
                } else {
                    pedido.productos.add(ProductoPedido(nombreProducto, precio, cantidad))
                    println("Produto agregado al pedido")
                }
            }
            "2" -> {
                print("Nombre del producto a eliminar: ")
                val nombreProducto = readLine()?.trim() ?: ""

                if (pedido.productos.removeIf{ it.nombre == nombreProducto}) {
                    println("Producto eliminado del pedido")
                } else {
                    println("No se encontro el producto en el pedido")
                }
            }
            else -> println("Opcion inválida")
        }
    } else {
        println("No se encontro un pedido con ese ID")
    }
}

fun eliminarPedido() {
    listarPedidos()
    println("Ingrese el ID del pedido a eliminar: ")
    val id = readLine()?.toIntOrNull()

    if(pedidos.removeIf { it.id == id }) {
        println("Pedido eliminado con exito")
    } else {
        println("No se encontro un pedido con ese ID")
    }
}

fun buscarPedidoPorCliente() {
    print("Ingrese el nombre del cliente: ")
    val cliente = readLine()?.trim() ?: ""

    val pedidosCliente = pedidos.filter {it.cliente.equals(cliente, ignoreCase = true)}

    if (pedidosCliente.isEmpty()){
        println("No se encontraron pedidos para $cliente")
    } else {
        println("\n Pedidos de $cliente:")
        pedidosCliente.forEach { pedido ->
            println("ID Pedido: #${pedido.id}")
            pedido.productos.forEach { productoPedido ->
                println("Nombre: ${productoPedido.nombre} Precio: ${productoPedido.precio} Cantidad: ${productoPedido.cantidad}")
            }
        }
    }
}

fun main() {
    while (true) {
        println("\n=== 📦 GESTOR DE PEDIDOS ===")
        println("1️⃣ Agregar pedido")
        println("2️⃣ Listar pedidos")
        println("3️⃣ Actualizar pedido")
        println("4️⃣ Eliminar pedido")
        println("5️⃣ Buscar pedido por cliente")
        println("6️⃣ Salir")
        print("👉 Ingrese una opción: ")

        when(readLine()) {
            "1" -> agregarPedido()
            "2" -> listarPedidos()
            "3" -> actualizarPedido()
            "4" -> eliminarPedido()
            "5" -> buscarPedidoPorCliente()
            "6" -> {
                println("👋 Saliendo del gestor de pedidos.")
                break
            }
            else -> println("❌ Opción inválida. Intente de nuevo.")
        }
    }
}