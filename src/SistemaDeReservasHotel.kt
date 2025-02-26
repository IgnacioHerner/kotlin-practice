/*
    🧠 Lógica del sistema de reservas de hotel/cabañas
    Este sistema permitirá a los clientes reservar habitaciones o cabañas en ciertas fechas, asegurando que las reservas no se superpongan. También gestionará clientes, calculará costos y permitirá cancelar reservas.

    🔍 ¿Cómo lo vamos a resolver?
    Definir estructuras de datos:

    Una clase Cliente con datos personales.
    Una clase Habitacion con número, precio y disponibilidad.
    Una clase Reserva que asocia un Cliente con una Habitacion en fechas específicas.
    Manejo de datos:

    Usaremos List y MutableList para almacenar clientes, habitaciones y reservas.
    Validaremos la disponibilidad antes de confirmar una reserva.
    Funciones principales:
    ✅ Registrar clientes.
    ✅ Registrar habitaciones/cabañas.
    ✅ Crear una reserva validando disponibilidad.
    ✅ Cancelar una reserva.
    ✅ Calcular el precio total considerando noches y posibles descuentos.
 */

import java.time.LocalDate
import java.time.temporal.ChronoUnit

// Clase Cliente con datos personales
data class Cliente(val nombre: String, val dni: String, val contacto: String)

data class Habitacion(val numero: Int, val precioPorNoche: Double, var disponible: Boolean = true)

data class Reserva(val cliente: Cliente, val habitacion: Habitacion, val fechaInicio: LocalDate, val fechaFin: LocalDate) {

    // Calcula el total de la reserva en funcion de lsa noches y el precio por noche
    fun calcularCostoTotal(): Double {
        val noches = ChronoUnit.DAYS.between(fechaInicio, fechaFin).toInt()
        return noches * habitacion.precioPorNoche
    }
}

// Listas para almacenar clientes, habitaciones y reservas
val clientes = mutableListOf<Cliente>()
val habitaciones = mutableListOf<Habitacion>()
val reservas = mutableListOf<Reserva>()

// Funcion para registrar un cliente
fun registrarCliente(nombre: String, dni: String, contacto: String){
    val cliente = Cliente(nombre,dni, contacto)
    clientes.add(cliente)
    println("Cliente registrado: $cliente")
}

fun registrarHabitacion(numero: Int, precioPorNoche: Double) {
    val habitacion = Habitacion(numero, precioPorNoche)
    habitaciones.add(habitacion)
    println("Habitacion registrada: $habitacion")
}

// Funcion para realizar una reserva
fun realizarReserva(dniCliente: String, numeroHabitacion: Int, fechaInicio: LocalDate, fechaFin: LocalDate) {
    val cliente = clientes.find { it.dni == dniCliente }
    val habitacion = habitaciones.find { it.numero == numeroHabitacion && it.disponible }

    if (cliente != null && habitacion != null) {
        val reserva = Reserva(cliente,habitacion, fechaInicio, fechaFin)
        reservas.add(reserva)
        habitacion.disponible = false
        println("Reserva realizada: $reserva - Costo total: ${reserva.calcularCostoTotal()}")
    } else {
        println("Error: Cliente no encontrado o habitacion no disponible")
    }
}

fun cancelarReserva(dniCliente: String, numeroHabitacion: Int) {
    val reserva = reservas.find { it.cliente.dni == dniCliente && it.habitacion.numero == numeroHabitacion }
    if (reserva != null) {
        reservas.remove(reserva)
        reserva.habitacion.disponible = true
        println("Reserva cancelada: $reserva")
    } else {
        println("Error: No se encontro la reserva")
    }
}

fun main() {
    // Registramos clientes
    registrarCliente("Ignacio Pérez", "12345678", "ignacio@mail.com")
    registrarCliente("María López", "87654321", "maria@mail.com")

    // Registramos habitaciones
    registrarHabitacion(101, 5000.0)
    registrarHabitacion(102, 4500.0)

    // Realizamos una reserva
    realizarReserva("12345678", 101, LocalDate.of(2025, 3, 1), LocalDate.of(2025, 3, 5))

    // Intentamos reservar la misma habitación (debe fallar)
    realizarReserva("87654321", 101, LocalDate.of(2025, 3, 2), LocalDate.of(2025, 3, 6))

    // Cancelamos una reserva
    cancelarReserva("12345678", 101)

    // Probamos nuevamente reservar la habitación cancelada
    realizarReserva("87654321", 101, LocalDate.of(2025, 3, 2), LocalDate.of(2025, 3, 6))
}