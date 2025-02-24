/*
    📌 Objetivo:
    Crear un programa que evalue expresiones matemáticas simples como:

    ✅ "3 + 5 * (2 - 8)" → Resultado: -27
    ✅ "10 / 2 + 6 * 3" → Resultado: 23

    Tu tarea es:

    Pedir una expresión matemática al usuario.
    Convertir la expresión a notación postfija (Reverse Polish Notation - RPN).
    Evaluar la expresión utilizando una pila (Stack).
    Mostrar el resultado final.

 */

import java.util.*

fun precedencia (op: Char): Int {
    return when(op) {
        '+', '-' -> 1
        '*','/' -> 2
        else -> 0
    }
}

fun infijaAPostfija(expresion: String): String {
    val resultado = StringBuilder()
    val pila = Stack<Char>()

    for (caracter in expresion.replace(" ","")){
        when {
            caracter.isDigit() -> resultado.append(caracter) // SI es numero, lo agregamos
            caracter == '(' -> pila.push(caracter) // Si es parentesis de apertura lo metemos en la pila
            caracter == ')' -> {
                while (pila.isNotEmpty() && pila.peek() != '('){
                    resultado.append(" ").append(pila.pop()) // Extraemos operadores hasta encontrar '('
                }
                pila.pop() // Quitamos el '(' de la pila
            }
            else -> {
                while (pila.isNotEmpty() && precedencia(caracter) <= precedencia(pila.peek())) {
                    resultado.append(" ").append(pila.pop()) // Extraemos operadores de mayor o igual precedencia
                }
                resultado.append(" ")
                pila.push(caracter)
            }
        }
    }
    while (pila.isNotEmpty()){
        resultado.append(" ").append(pila.pop()) // Vaciamos la pila
    }

    return resultado.toString()
}

fun evaluarPostFija(expresion: String): Int {
    val pila = Stack<Int>()

    println("Evaluando postfija: $expresion")

    for (token in expresion.split(" ")) {
        when {
            token.isNotEmpty() && token.all { it.isDigit() || (it == '-' && token.length > 1) } -> {
                pila.push(token.toInt()) // Número, lo metemos en la pila
                println("Pila tras insertar número: $pila")
            }
            token in "+-*/" -> {
                val b = pila.pop()
                val a = pila.pop()
                val resultado = when (token) {
                    "+" -> a + b
                    "-" -> a - b
                    "*" -> a * b
                    "/" -> a / b
                    else -> 0
                }
                pila.push(resultado)
                println("Operación $a $token $b = $resultado")
                println("Pila tras operación: $pila")
            }
        }
    }

    return pila.pop()
}

fun main () {
    println("Ingrese una expresion matematica: ")
    val expresion = readLine() ?: ""

    val postFija = infijaAPostfija(expresion)
    val resultado = evaluarPostFija(postFija)

    println("Expresion en notacion postfija: $postFija")
    println("Resultado: $resultado")
}