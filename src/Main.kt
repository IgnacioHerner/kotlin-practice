import java.lang.classfile.ClassModel
import kotlin.math.E

fun main() {

    // Declarando una variable inmutable (no puede cmabiar su valor después de asignarlo)
    val nombre: String = "Ignacio"

    // Declarando una variable mutable (su valor puede cambiar)
    var edad: Int = 24

    // Imprimir valores por consola
    println("Mi nombre es $nombre y tengo $edad años")

    // Cambiar de valor de una variable mutable
    edad = 25
    println("Ahora tengo $edad años")

    val entero: Int = 10
    val decimal: Double = 3.14
    val booleano: Boolean = true
    val caracter: Char = 'A'
    val texto: String = "Hola, Kotlin"

    // Imprimir valores de diferentes tipos de datos
    println("Entero: $entero, Decimal: $decimal, Booleano: $booleano, Caracter: $caracter, Texto: $texto")

    // Llamamos a la funcion saludar con un argumento
    saludar("Ignacio")

    // Llamamos a la funcion sumar y mostramos el resultado
    val resultado = sumar(5,3)
    println("La suma es: $resultado")

    mostrarMensaje()

    // IF
    if (edad >= 18) {
        println("Eres mayor de edad")
    } else {
        println("Eres menor de edad")
    }

    // Uso del else - if
    val nota = 85
    if(nota >= 90) {
        println("Excelente")
    } else if (nota >= 75){
        println("Aprobado")
    } else {
        println("Reprobado")
    }

    // WHEN
    val dia = 3
    val nombreDia = when (dia) {
        1 -> "Lunes"
        2 -> "Martes"
        3 -> "Miercoles"
        4 -> "Jueves"
        5 -> "Viernes"
        6 -> "Sabado"
        7 -> "Domingo"
        else -> "Dia no válido"
    }
    println("El dia $dia es $nombreDia")

    // FOR
    for (i in 1..5){
        println("Numero: $i")
    }
    // Recorriendo unas lista
    val nombres = listOf("Juan", "Ana", "Carlos")
    for (nombre in nombres){
        println("Hola, $nombre")
    }
    // WHILE
    var contador = 5
    while(contador > 0) {
        println("Contando... $contador")
        contador--
    }
    // DO-WHILE
    var numero = 1

    do {
        println("Numero: $numero")
        numero++
    } while (numero <= 3)

    // LIST
    println("Primer nombre: ${nombres[0]}")

    for (nombre in nombres) {
        println("Hola, $nombre")
    }

    val numeros = mutableListOf(1,2,3)
    numeros.add(4)
    numeros.remove(2)
    println("Lista modificada: $numeros")

    //ARRAY
    val numerosArray = arrayOf(10,20,30,40)

    println("Primer numero: ${numerosArray[0]}") // Accediendo a elementos
    for(num in numerosArray){
        println("Numeros: $num")
    }

    numerosArray[1] = 25
    println("Array modificado: ${numerosArray.joinToString()}")

    //MAP
    //Mapa inmutable
    val edades = mapOf("Juan" to 30, "Ana" to 25, "Carlos" to 35)
    println("Edad de Ana: ${edades["Ana"]}")
    // Mapa mutable
    val precios = mutableMapOf("Manzana" to 50, "Banana" to 30)

    precios["Uva"] = 40 // Agregar un nuevo par clave-valor
    precios.remove("Banana") // Eliminar un elemento

    println("Precios actualizados: $precios")

    //Creando un objeto de la clase persona
    val persona1 = Persona("Juan", 25)
    persona1.presentarse()// Llamamos al método presentarse

    val miCoche = Coche("Toyota", "Corolla", 2022)
    miCoche.mostrarInfo()

    val estudiante1 = Estudiante("Ana", 20)
    estudiante1.mostrarInfo()

    val miPerro = Perro("Rex", "Labrador")
    miPerro.hacerSonido()
    miPerro.ladrar()

    val miCuenta = CuentaBancaria(1000.0)
    miCuenta.depositar(500.0)
    miCuenta.retirar(300.0)

    val miPajaro = Pajaro()
    miPajaro.volar()

    val juan = PersonaInterface()
    juan.nadar()
    juan.correr()

    val auto1 = VehiculoInterface()
    auto1.mover()

    val miPerro2 = PerroAbs("Milo")
    miPerro2.mostrarNombre()
    miPerro2.hacerSonido()

    val persona3 = PersonaClass("Igna", 24)
    println(persona3)

    val persona4 = persona3.copy(edad = 43)
    println(persona4)

    println(persona3 == persona4)

    val producto1 = Producto("Laptop", 1000.0)
    println(producto1)

    val productoDescuento = producto1.aplicarDescuento(10.0)
    println(productoDescuento)

    val exito = Resultado.Exito("Datos cargados correctamente")
    val error = Resultado.Error("No se pudo conectar al servidor")

    procesarResultado(exito)
    procesarResultado(error)

    mostrarEstado(EstadoConexion.Conectado)
    mostrarEstado(EstadoConexion.Desconectado)
    mostrarEstado(EstadoConexion.EnProceso)

    // SET
    val conjunto = mutableSetOf(1,2,3,4,5)
    conjunto.add(6)
    conjunto.remove(3)

    println(conjunto) // Output: [1,2,4,5,6]

    println(operar(5,3, ::suma))
    println(operar(5,3, ::resta))

    /*
    ✅ map → Transforma cada elemento de la colección.
    ✅ filter → Filtra elementos según una condición.
    ✅ reduce → Acumula valores de la colección.
     */
    val numerosHOF = listOf(1,2,3,4,5)

    val cuadrados = numerosHOF.map{ it * it}
    println(cuadrados)

    val pares = numerosHOF.filter { it % 2 == 0 }
    println(pares)

    val sumaTotal = numerosHOF.reduce{acc, num -> acc + num}
    println(sumaTotal)

    val textoFDE = "Kotlin"
    println(textoFDE.reverso())

    val numeroFDE = 5
    println(numeroFDE.doble())

    val persona5 = PersonaFDE("Ignacio", 24)
    persona5.presentarse()

    println(sumaLAMBDAS(5,3))

    val numerosLambdas = listOf(1,2,3,4,5)

    //Filtrar números pares
    val pares2 = numerosLambdas.filter { it % 2 == 0 }
    println(pares2)

    val cuadrados2 = numerosLambdas.map { it * it }
    println(cuadrados2)

    println(operarLambdas(5,3){x,y -> x + y})
    println(operarLambdas(5,3){x,y -> x - y})

    // TRY Y CATCH
    try {
        val resultadoTry = 10 / 0 // Division por cero (error)
        println("Resultado: $resultadoTry")
    } catch (e: ArithmeticException) {
        println("Error no se puede dividir por cero")
    }

    // TRY Y CATCH FINALLY
    try {
        val numerosTry = listOf(1,2,3)
        println(numerosTry[5]) // Indice fuera de rango
    } catch (e: IndexOutOfBoundsException) {
        println("Error Indice fuera de los limites")
    } finally {
        println("Este bloque siempre se ejecuta")
    }

    // LANZAR EXCEPCIONES (THROW)
    try {
        validarEdad(17)
    } catch (e: IllegalArgumentException) {
        println("Error, ${e.message}")
    }

    try {
        retirarDinero(100.0, 200.0)
    } catch (e: SaldoInsuficienteException) {
        println("Error, ${e.message}")
    }

    /*
    Funciones de Alcance (Scope Functions)
    Las funciones de alcance permiten ejecutar código en el contexto de un objeto de forma más clara.

    Función	Contexto (this o it)	Devuelve
        let	              it	        El resultado del bloque
        run	              this	        El resultado del bloque
        apply	          this	        El objeto en sí mismo
        also	          it	        El objeto en sí mismo
        with	          this	        El resultado del bloque

     */

    // LET
    val nombreScope: String = "Ignacio"

    nombreScope?.let {
        println("El nombre tiene ${it.length} caracteres")
    }

    // RUN
    val resultadoRun = run {
        val a = 5
        val b = 10
        a * b
    }
    println("Resultado: $resultadoRun")

    // Apply
    val personaApply = PersonaApply("Juan", 20).apply {
        edad = 25
    }
    println(personaApply)

    // Also
    val lista = mutableListOf(1,2,3).also {
        println("Lista original: $it")
    }

    // With
    val personaWith = PersonaApply("Carlos", 30)

    with(personaWith) {
        println("Nombre:  $nombre")
        println("Edad: $edad")
    }

    // takeIf y takeUnless
    val edadTake = 26

    val mayorDeEdad = edadTake.takeIf { it >= 18 } ?: "Menor de edad"
    println(mayorDeEdad)

    val menorDeEdad = edadTake.takeUnless { it >= 18 } ?: "Mayor de edad"
    println(menorDeEdad)

}

data class PersonaApply(var nombre: String, var edad: Int)

class SaldoInsuficienteException(mensaje: String) : Exception(mensaje)

fun retirarDinero(saldo: Double, monto: Double){
    if (monto > saldo) {
        throw SaldoInsuficienteException("No tienes suficiente saldo")
    }
    println("Retiro exitoso: $monto")
}

fun validarEdad(edad: Int) {
    if (edad < 18) {
        throw IllegalArgumentException("Debes ser mayor de edad")
    }
    println("Acceso permitido")
}


// LAMBDAS

fun operarLambdas(a: Int, b: Int, operaciones: (Int, Int) -> Int) : Int {
    return operaciones(a,b)
}

val sumaLAMBDAS = {a: Int, b: Int -> a + b}


//FUNCIONES DE EXTENSIÓN

class PersonaFDE(val nombre: String, val edad: Int)

fun PersonaFDE.presentarse() {
    println("Hola, soy $nombre y tengo $edad años")
}


fun Int.doble(): Int {
    return this * 2
}

fun String.reverso(): String {
    return this.reversed()
}


// HIGHER ORDER FUNCTIONS
fun operar (a: Int, b: Int, operaciones: (Int, Int) -> Int) : Int {
    return operaciones(a,b)
}

fun suma(x: Int, y: Int) = x + y
fun resta(x: Int, y: Int) = x - y


//SELADED CLASS CON OBJECT
sealed class EstadoConexion {
    object Conectado : EstadoConexion()
    object Desconectado : EstadoConexion()
    object EnProceso : EstadoConexion()
}

fun mostrarEstado(estado: EstadoConexion) {
    when(estado) {
        EstadoConexion.Conectado -> println("Conectado a internet")
        EstadoConexion.Desconectado -> println("No hay conexión")
        EstadoConexion.EnProceso -> println("Conectando...")
    }
}


//SEALDED CLASS
sealed class Resultado {
    class Exito (val data: String) : Resultado()
    class Error(val mensaje: String) : Resultado()
}

fun procesarResultado(resultado: Resultado) {
    when (resultado) {
        is Resultado.Exito -> println("Exito: ${resultado.data}")
        is Resultado.Error -> println("Error: ${resultado.mensaje}")
    }
}

//DATA CLASSES

data class Producto(val nombre: String, val precio: Double) {
    fun aplicarDescuento (porcentaje: Double): Producto {
        val nuevoPrecio = precio - (precio * porcentaje / 100)
        return this.copy(precio = nuevoPrecio)
    }
}

data class PersonaClass(val nombre: String, val edad: Int)

// CLASE ABSTRACTA
abstract class AnimalAbs(val nombre: String) {
    abstract fun hacerSonido() // Metodo abstracto, debe ser implementado en subclases

    fun mostrarNombre() {
        println("El animal se llama $nombre")
    }
}

class PerroAbs (nombre: String) : AnimalAbs(nombre){
    override fun hacerSonido() {
        println("$nombre dice: Guau guau")
    }
}


// INTERFACES

interface Vehiculo {
    fun mover() {
        println("El auto esta en movimiento")
    }
}

class VehiculoInterface : Vehiculo


interface Nadador {
    fun nadar() {
        println("Estoy nadando")
    }
}

interface Corredor {
    fun correr() {
        println("Estoy corriendo")
    }
}

class PersonaInterface : Nadador, Corredor

interface Volador {
    fun volar()
}

class Pajaro: Volador {
    override fun volar() {
        println("El pajaro esta volando")
    }
}

// MODIFICADORES DE ACCESO
/*
    public → Accesible desde cualquier parte.
    private → Solo accesible dentro de la clase.
    protected → Accesible dentro de la clase y sus subclases.
    internal → Accesible dentro del mismo módulo.
*/

class CuentaBancaria(private var saldo: Double){
    fun depositar(cantidad: Double) {
        saldo += cantidad
        println("Deposito realizado. Saldo actual: $saldo")
    }

    fun retirar(cantidad: Double){
        if (cantidad <= saldo){
            saldo -= cantidad
            println("Retiro realizado. Saldo actual: $saldo")
        } else {
            println("Saldo insuficiente")
        }
    }
}

// HERENCIA
open class Animal (val nombre: String){
    fun hacerSonido() {
        println("$nombre hace un sonido")
    }
}

class Perro(nombre: String, val raza: String) : Animal(nombre){
    fun ladrar() {
        println("$nombre de raza $raza esta ladrando")
    }
}

// Constructor Primario
class Coche(val marca: String, val modelo: String, val año: Int) {
    fun mostrarInfo() {
        println("Coche: $marca $modelo, Año: $año")
    }
}

// Constructor Secundario
class Estudiante {
    var nombre: String
    var edad: Int

    // Constructor secundario
    constructor(nom: String, ed:Int) {
        nombre = nom
        edad = ed
    }

    fun mostrarInfo() {
        println("Estudiante: $nombre, Edad: $edad")
    }

}


class Persona(val nombre: String, val edad: Int) {
    // Metodo de la clase
    fun presentarse() {
        println("Hola, soy $nombre y tengo $edad años")
    }
}

// Funcion que recibe un parámetro y no devuelve nada (Unit es Opcional)
fun saludar(nombre: String){
    println("Hola, $nombre!")
}

// Funcion que recibe dos numeros y devuelve suma
fun sumar(a: Int, b: Int) : Int {
    return a + b
}

// Funcion sin parametros ni retorno
fun mostrarMensaje() {
    println("Estre es un mensaje desde una funcion")
}

