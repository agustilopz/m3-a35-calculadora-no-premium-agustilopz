package org.example

import utils.*
import org.example.models.*

val llistaUsuaris: MutableList<Usuari> = mutableListOf<Usuari>()

fun main() {
    var seleccioMenuPrincipal: Int = 0
    val MENU_LOGIN: String = mostrarMenu("Registrar usuari", "Login", "Esborrar usuari", "Sortir")
    val benvinguda: String =
        bold(benvinguda("fer operacions matemàtiques bàsiques. Si et registres pots gaudir de 5 operacions gratuïtes de prova!"))
    var continuar: Boolean = true

    println(benvinguda)

    do {
        println(BLUE + MENU_LOGIN + RESET)
        seleccioMenuPrincipal = triarOpcioMenu(nMin = 0, nMax = 3, missatge = "Escriu l'opció escollida a continuació:")
        when (seleccioMenuPrincipal) {
            1 -> {
                // REGISTRE
                var registre = registre(llistaUsuaris)
            }

            2 -> {
                // LOGIN
                var login= login()
            }

            3 -> {
                // ESBORRAR USUARI
                var esborrarUsuari= esborrarUsuari()
            }

            0 -> {
                // SORTIR
                continuar = false
            }
        }
        if (!continuar) {
            continuar = preguntaTrueFalse(
                "Estàs seguríssim de que vols abandonar l'aplicació? (Si/No)",
                "Escriu 'Si' o 'No' en funció de si vols abandonar.",
                "no",
                "si"
            )
        }
    } while (continuar)

    println(GREEN_BOLD + "\nFins la propera!" + RESET)

}