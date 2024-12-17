package org.example

import kotlin.math.sqrt
import utils.*

/**
 * Aquesta funció serveix per mostrar un missatge de benvinguda personalitzable
 * @author agustí.lópez
 * @since 10/12/2024
 * @param funcio Funció del programa
 * @return resultat String del missatge de benvinguda
 */
fun benvinguda(funcioApp: String): String {
    var benvinguda = "\nBenvingut a l'aplicació per $funcioApp!\n"
    return benvinguda
}

/**
 * Aquesta funció serveix per mostrar un menú amb una sèrie d'opcions personalitzables
 * @author agustí.lópez
 * @since 17/12/2024
 * @param opc0 Opció de sortida per defecte
 * @param opc1 Opció 1 del menú
 * @return resultat String del missatge del menú
 */
fun mostrarMenu(
    opc1: String = "Sumar", opc2: String = "Restar", opc3: String = "Multiplicar", opc4: String = "Dividir",
    opc5: String = "Quadrat", opc6: String = "Mostrar operacions restants", opc0: String = "Extra"
): String {
    var menu: String = """
        Escolleix una de les següents opcions:
        
        1. $opc1
        2. $opc2
        3. $opc3
        4. $opc4
        5. $opc5
        6. $opc6
        0. $opc0
        
    """.trimIndent()
    return menu

}

/**
 * Aquesta funció servei per demanar un valor de tipus enter a l'usuari i controlar que estigui dins del rang establert
 * @author agustí.lópez
 * @since 10/12/2024
 * @param nMin Valor mínim que pot introduir l'usuari
 * @param nMax Valor màxim que pot introduir l'usuari
 * @return opcioMenu El número enter escollit
 */
fun triarOpcioMenu(missatge: String = "Tria una opció", nMin: Int, nMax: Int): Int {
    var valorCorrecte: Boolean = true
    var opcioMenu: Int = 0
    do {
        println(missatge)
        valorCorrecte = scan.hasNextInt()
        if (valorCorrecte == false) {
            println(RED_BOLD + "ERROR: Has d'introduir un número entre $nMin i $nMax" + RESET)
            scan.nextLine()
        } else {
            opcioMenu = scan.nextInt()
            scan.nextLine()
            if (opcioMenu < nMin || opcioMenu > nMax) {
                println(RED_BOLD + "ERROR: Has d'introduir un número entre $nMin i $nMax" + RESET)
                valorCorrecte = false
            }
        }
    } while (valorCorrecte == false)
    return opcioMenu
}


/**
 * Aquesta funció pot ser utilitzada per a sumar dos valors de tipus enter
 * @author agustí.lópez
 * @since 10/12/2024
 * @param x Primer valor de la suma
 * @param y Segon valor de la suma
 * @return resultat Resultat de la suma
 */
fun suma(x: Int, y: Int): Int {
    var resultat: Int
    resultat = x + y
    return resultat
}

/**
 * Aquesta funció pot ser utilitzada per a sumar dos valors de tipus float
 * @author agustí.lópez
 * @since 10/12/2024
 * @param x Primer valor de la suma
 * @param y Segon valor de la suma
 * @return resultat Resultat de la suma
 */
fun suma(x: Float, y: Float): Float {
    var resultat: Float
    resultat = x + y
    return resultat
}

/**
 * Aquesta funció pot ser utilitzada per a restar dos valors de tipus enter
 * @author agustí.lópez
 * @since 10/12/2024
 * @param x Primer valor de la resta
 * @param y Segon valor de la resta
 * @return resultat Resultat de la resta
 */
fun resta(x: Int, y: Int): Int {
    var resultat: Int
    resultat = x - y
    return resultat
}

/**
 * Aquesta funció pot ser utilitzada per a restar dos valors de tipus float
 * @author agustí.lópez
 * @since 10/12/2024
 * @param x Primer valor de la resta
 * @param y Segon valor de la resta
 * @return resultat Resultat de la resta
 */
fun resta(x: Float, y: Float): Float {
    var resultat: Float
    resultat = x - y
    return resultat
}

/**
 * Aquesta funció pot ser utilitzada per a multiplicar dos valors de tipus enter
 * @author agustí.lópez
 * @since 10/12/2024
 * @param x Primer valor de la multiplicació
 * @param y Segon valor de la multiplicació
 * @return resultat Resultat de la multiplicació
 */
fun multiplicacio(x: Int, y: Int): Int {
    var resultat: Int
    resultat = x * y
    return resultat
}

/**
 * Aquesta funció pot ser utilitzada per a multiplicar dos valors de tipus float
 * @author agustí.lópez
 * @since 10/12/2024
 * @param x Primer valor de la multiplicació
 * @param y Segon valor de la multiplicació
 * @return resultat Resultat de la multiplicació
 */
fun multiplicacio(x: Float, y: Float): Float {
    var resultat: Float
    resultat = x * y
    return resultat
}

/**
 * Aquesta funció pot ser utilitzada per a dividir dos valors de tipus float
 * @author agustí.lópez
 * @since 10/12/2024
 * @param x Primer valor de la divisió
 * @param y Segon valor de la divisió
 * @return resultat Resultat de la divisió
 */
fun divisio(x: Float, y: Float): Float {
    var resultat: Float
    resultat = x / y
    return resultat
}

/**
 * Aquesta funció pot ser utilitzada per a calcular el quadat de un número de tipus enter
 * @author agustí.lópez
 * @since 10/12/2024
 * @param x Valor del que volem calcular el quadrat
 * @return resultat Resultat del quadrat
 */
fun quadrat(x: Int): Int {
    var resultat: Int
    resultat = x * x
    return resultat
}

/**
 * Aquesta funció pot ser utilitzada per a calcular l'arrel quadrada d'un número
 * @author agustí.lópez
 * @since 10/12/2024
 * @param x Valor a partir del qual calcular l'arrel quadrada
 * @return resultat Resultat de l'arrel quadrada
 */
fun arrelQuadrada(x: Float): Float {
    var resultat: Float
    resultat = sqrt(x)
    return resultat
}

/**
 * Aquesta funció pot ser utilitzada per a calcular el factorial de un número de tipus enter
 * @author agustí.lópez
 * @since 10/12/2024
 * @param x Valor del que volem calcular el factorial
 * @return resultat Resultat del factorial
 */
//Enter i positiu
fun factorial(x: Long): Long {
    var resultat: Long = 1L
    for (i in 1L..x) {
        resultat = resultat * i
    }
    return resultat
}

/**
 * Aquesta funció pot ser utilitzada per a fer càlculs a partir de dos números de tipus enter
 * @author agustí.lópez
 * @since 10/12/2024
 * @param x Valor del primer número
 * @param x Valor del segon número
 * @param operacio Funció que fa la operació desitjada (suma,resta,etc)
 * @return resultat Resultat del càlcul
 */
fun operar(x: Int, y: Int, operacio: (a: Int, b: Int) -> Int): Int {
    return operacio(x, y)
}

/**
 * Aquesta funció pot ser utilitzada per a fer càlculs a partir de dos números de tipus float
 * @author agustí.lópez
 * @since 10/12/2024
 * @param x Valor del primer número
 * @param x Valor del segon número
 * @param operacio Funció que fa l'operació desitjada (suma,resta,etc)
 * @return resultat Resultat del càlcul
 */
fun operar(x: Float, y: Float, operacio: (a: Float, b: Float) -> Float): Float {
    return operacio(x, y)
}

/**
 * Aquesta funció pot ser utilitzada per a fer càlculs a partir d'un número de tipus enter
 * @author agustí.lópez
 * @since 10/12/2024
 * @param x Valor del número
 * @param operacio Funció que fa l'operació desitjada (quadrat, arrel quadrada,etc.)
 * @return resultat Resultat del càlcul
 */
fun operar(x: Int, operacio: (a: Int) -> Int): Int {
    return operacio(x)
}

/**
 * Aquesta funció pot ser utilitzada per a fer càlculs a partir d'un número de tipus float
 * @author agustí.lópez
 * @since 10/12/2024
 * @param x Valor del número
 * @param operacio Funció que fa l'operació desitjada (quadrat, arrel quadrada,etc.)
 * @return resultat Resultat del càlcul
 */
fun operar(x: Float, operacio: (a: Float) -> Float): Float {
    return operacio(x)
}

/**
 * Aquesta funció pot ser utilitzada per a fer càlculs a partir d'un número de tipus Long
 * @author agustí.lópez
 * @since 10/12/2024
 * @param x Valor del número
 * @param operacio Funció que fa l'operació desitjada (quadrat, arrel quadrada,etc.)
 * @return resultat Resultat del càlcul
 */
fun operar(x: Long, operacio: (a: Long) -> Long): Long {
    return operacio(x)
}


/**
 * Aquesta funció pot ser utilitzada per a llegir, controlar i emmagatzemar un número de tipus float introduit per l'usuari
 * @author agustí.lópez
 * @since 10/12/2024
 * @param missatge Missatge que es mostrarà per pantalla
 * @return numero Numero introduit per l'usuari
 */
fun llegirUnNumero(missatge: String = "Introdueix un número positiu a continuació:"): Float {
    var valorCorrecte: Boolean = true
    var numero: Float = 0.0f
    do {
        println(missatge)
        valorCorrecte = scan.hasNextFloat()
        if (valorCorrecte == false) {
            println(RED_BOLD + "ERROR: Has d'introduir un número positiu" + RESET)
            scan.nextLine()
        } else {
            numero = scan.nextFloat()
            scan.nextLine()
            if (numero <= 0.0f) {
                println(RED_BOLD + "ERROR: Has d'introduir un número positiu" + RESET)
                valorCorrecte = false
            }
        }
    } while (valorCorrecte == false)
    return numero

}

/**
 * Aquesta funció pot ser utilitzada per a llegir, controlar i emmagatzemar un número de tipus enter introduit per l'usuari
 * @author agustí.lópez
 * @since 10/12/2024
 * @param missatge Missatge que es mostrarà en pantalla
 * @return numero Numero introduit per l'usuari
 */
fun llegirUnNumeroEnter(missatge: String = "Introdueix un número positiu a continuació"): Int {
    var valorCorrecte: Boolean = true
    var numero: Int = 0
    do {
        println(missatge)
        valorCorrecte = scan.hasNextInt()
        if (valorCorrecte == false) {
            println(RED_BOLD + "ERROR: Has d'introduir un número positiu" + RESET)
            scan.nextLine()
        } else {
            numero = scan.nextInt()
            scan.nextLine()
            if (numero <= 0) {
                println(RED_BOLD + "ERROR: Has d'introduir un número positiu" + RESET)
                valorCorrecte = false
            }
        }
    } while (valorCorrecte == false)
    return numero

}


/**
 * Aquesta funció pot ser utilitzada per a llegir, controlar i emmagatzemar dos números de tipus float introduit per l'usuari
 * @author agustí.lópez
 * @since 10/12/2024
 * @param missatge Missatge que es mostrarà en pantalla
 * @return resultat Array amb els dos números introduits per l'usuari
 */
fun llegirDosNumeros(
    missatge1: String = "Introdueix el primer número positius",
    missatge2: String = "Introdueix el segon número positiu"
): Array<Float> {
    var resultat: Array<Float>
    var valorCorrecte: Boolean = true
    var num1: Float = 0.0f
    do {
        println(missatge1)
        valorCorrecte = scan.hasNextFloat()
        if (valorCorrecte == false) {
            println(RED_BOLD + "ERROR: Has d'introduir un número positiu" + RESET)
            scan.nextLine()
        } else {
            num1 = scan.nextFloat()
            scan.nextLine()
            if (num1 <= 0.0f) {
                println(RED_BOLD + "ERROR: Has d'introduir un número positiu" + RESET)
                valorCorrecte = false
            }
        }
    } while (valorCorrecte == false)
    valorCorrecte = true
    var num2: Float = 0.0f
    do {
        println(missatge2)
        valorCorrecte = scan.hasNextFloat()
        if (valorCorrecte == false) {
            println(RED_BOLD + "ERROR: Has d'introduir un número positiu" + RESET)
            scan.nextLine()
        } else {
            num2 = scan.nextFloat()
            scan.nextLine()
            if (num2 <= 0.0f) {
                println(RED_BOLD + "ERROR: Has d'introduir un número positiu" + RESET)
                valorCorrecte = false
            }
        }
    } while (valorCorrecte == false)
    resultat = arrayOf(num1, num2)
    return resultat

}

/**
 * Aquesta funció servei per fer una operació entre dos números de tipus float i retorna el resultat amb els dos numeros operats en una array
 * @author agustí.lópez
 * @since 10/12/2024
 * @param entradaUsuari Array que conté els dos números a partir dels quals operar
 * @param operacio Operació a realitzar entre els dos números
 * @return resultat Array amb el resultat de l'operació més els números operats
 */
fun operarDosNumeros(entradaUsuari: Array<Float>, operacio: String): Array<Float> {
    var num1 = entradaUsuari[0]
    var num2 = entradaUsuari[1]
    var resultat: Float = 0.0f
    var sortida:Array<Float>

    when (operacio.lowercase()) {
        "suma" -> {
            resultat = operar(num1, num2, ::suma)
        }

        "resta" -> {
            resultat = operar(num1, num2, ::resta)
        }

        "multiplicacio" -> {
            resultat = operar(num1, num2, ::multiplicacio)
        }

        "divisio" -> {
            resultat = operar(num1, num2, ::divisio)
        }
    }
    resultat=arrodonimentDecimals(resultat,2)
    sortida=arrayOf(num1,num2,resultat)

    return sortida
}

/**
 * Aquesta funció serveix per convertir un text a negreta
 * @author agustí.lópez
 * @since 12/12/2024
 * @param text Text d'entrada
 * @return sortida Text convertit a negreta
 */
fun bold(text:String): String {
    var sortida:String=""
    sortida=BOLD+text+RESET
    return sortida
}


/* Funcions no utilitzades */

/**
 * Aquesta funció servei per fer una operació entre dos números de tipus float
 * @author agustí.lópez
 * @since 10/12/2024
 * @param entradaUsuari Array que conté els dos números a partir dels quals operar
 * @param operacio Operació a realitzar entre els dos números
 * @return resultat Resultat de l'operació
 */
fun resultatOperacioDosNumeros(entradaUsuari: Array<Float>, operacio: String): Float {
    var num1 = entradaUsuari[0]
    var num2 = entradaUsuari[1]
    var resultat: Float = 0.0f

    when (operacio.lowercase()) {
        "suma" -> {
            resultat = operar(num1, num2, ::suma)
        }

        "resta" -> {
            resultat = operar(num1, num2, ::resta)
        }

        "multiplicacio" -> {
            resultat = operar(num1, num2, ::multiplicacio)
        }

        "divisio" -> {
            resultat = operar(num1, num2, ::divisio)
        }
    }

    return resultat
}

/**
 * Aquesta funció servei per fer una operació amb un número de tipus float
 * @author agustí.lópez
 * @since 10/12/2024
 * @param entradaUsuari Número a partir del qual realitzar l'operació
 * @param operacio Operació a realitzar
 * @return resultat Resultat de l'operació
 */
fun resultatOperacioUnNumero(entradaUsuari: Float, operacio: String): Float {
    var num1 = entradaUsuari
    var resultat: Float = 0.0f

    when (operacio.lowercase()) {
        "arrel quadrada" -> {
            resultat = operar(num1, ::arrelQuadrada)
        }
    }

    return resultat
}

/**
 * Aquesta funció servei per fer una operació amb un número de tipus enter
 * @author agustí.lópez
 * @since 10/12/2024
 * @param entradaUsuari Número a partir del qual realitzar l'operació
 * @param operacio Operació a realitzar
 * @return resultat Resultat de l'operació
 */
fun resultatOperacioUnNumero(entradaUsuari: Int, operacio: String): Int {
    var num1 = entradaUsuari
    var resultat: Int = 0

    when (operacio.lowercase()) {
        "quadrat" -> {
            resultat = operar(num1, ::quadrat)
        }

    }

    return resultat
}

fun resultatOperacioUnNumero(entradaUsuari: Long, operacio: String): Long {
    var num1 = entradaUsuari
    var resultat: Long = 0L

    when (operacio.lowercase()) {

        "factorial" -> {
            resultat = operar(num1, ::factorial)
        }
    }

    return resultat
}