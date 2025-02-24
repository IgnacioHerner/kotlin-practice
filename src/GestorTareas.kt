/*
Ejercicio Avanzado: Gestor de Tareas con Kotlin
Descripción:
Vamos a crear un pequeño gestor de tareas en consola, donde el usuario podrá:
✅ Agregar tareas con título y descripción.
✅ Marcar tareas como completadas.
✅ Listar todas las tareas.
✅ Eliminar tareas.

📌 Objetivo: Practicar listas, clases, funciones y entrada/salida en Kotlin.
 */

// Clase que representa una tarea
data class Tarea(val id: Int, var titulo: String, var descripcion: String, var completada: Boolean = false)

// Lista mutable para almacenar las tareas
var tareas = mutableListOf<Tarea>()

// Funcion para agregar una nueva tarea
fun agregarTarea() {
    println("Ingrese el titulo de la tarea: ")
    val titulo = readLine() ?: ""

    println("Ingrese la descripcion de la tarea: ")
    val descripcion = readLine() ?: ""

    if(titulo.isBlank() || descripcion.isBlank()) {
        println("Error: El titulo y la descripcion no pueden estar vacios")
        return
    }

    val nuevaTarea = Tarea(tareas.size + 1, titulo, descripcion)
    tareas.add(nuevaTarea)
    println("Tarea agregada con exito: $titulo")
}

// Funcion para marcar una tarea como completada
fun completarTarea() {
    listarTareas()
    println("Ingrese el ID de la tarea a completar: ")
    val id = readLine()?.toIntOrNull()

    val tarea = tareas.find { it.id == id }
    if(tarea != null) {
        tarea.completada = true
        println("Tarea '${tarea.titulo}' marcada como completada")
    } else {
        println("No se encontro una tarea con ese ID")
    }
}

// Funcion para eliminar una tarea
fun eliminarTarea() {
    listarTareas()
    println("Ingrese el ID de la tarea a eliminar")
    val id = readLine()?.toIntOrNull()

    if(tareas.removeIf {it.id == id}){
        println("Tarea eliminada con exito")
    } else {
        println("No se encontro tarea con ese ID")
    }
}

// Funcion para listar todas las tareas
fun listarTareas() {
    if(tareas.isEmpty()){
        println("No hay tareas registradas")
        return
    }

    println("\n Lista de tareas: ")
    tareas.forEach{tarea ->
        val estado = if(tarea.completada) "✅" else "❌"
        println("${tarea.id}. $estado ${tarea.titulo} - ${tarea.descripcion}")
    }
}

fun main() {
    while (true) {
        println("\n=== GESTOR DE TAREAS ===")
        println("1️⃣ Agregar tarea")
        println("2️⃣ Completar tarea")
        println("3️⃣ Eliminar tarea")
        println("4️⃣ Listar tareas")
        println("5️⃣ Salir")
        print("👉 Ingrese una opción: ")

        when (readLine()) {
            "1" -> agregarTarea()
            "2" -> completarTarea()
            "3" -> eliminarTarea()
            "4" -> listarTareas()
            "5" -> {
                println("👋 Saliendo del gestor de tareas.")
                break
            }

            else -> println("Opcion inválida. Intente de nuevo")
        }
    }
}

/*
    Puntos Claves del Código:
    ✅ Clases y Objetos: Se usa data class para representar cada tarea.
    ✅ Listas Mutables: Se usa mutableListOf<Tarea>() para almacenar tareas.
    ✅ Funciones: Cada operación (agregar, eliminar, completar, listar) está separada en funciones reutilizables.
    ✅ Bucle y Entrada de Usuario: Un while (true) mantiene el programa en ejecución hasta que el usuario elija salir.
    ✅ Manejo de Errores: Se validan entradas vacías o incorrectas (toIntOrNull()).
 */