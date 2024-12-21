package org.example

import utils.*
import org.example.models.*

val llistaUsuaris: MutableList<Usuari> = mutableListOf<Usuari>()

fun main() {
    var seleccioMenu: Int = 0
    var seleccioMenuLogin: Int = 0
    val MENU_LOGIN: String = mostrarMenu("Registrar usuari", "Login", "Esborrar usuari", "Sortir")
    val MENU_LOGIN_0: String = mostrarMenu("Realitzar operacions", "Logout")
    val benvinguda: String =
        bold(benvinguda("fer operacions matemàtiques bàsiques. Si et registres pots gaudir de 5 operacions gratuïtes de prova!"))
    var continuar: Boolean = true
    var usuariActual: Usuari

    println(benvinguda)

    do {
        println(BLUE + MENU_LOGIN + RESET)
        seleccioMenuLogin = triarOpcioMenu(nMin = 0, nMax = 3, missatge = "Escriu l'opció escollida a continuació:")
        when (seleccioMenuLogin) {
            1 -> {
                // REGISTRE
                var registre = registre(llistaUsuaris)
            }

            2 -> {
                // LOGIN
                if (llistaUsuaris.isEmpty()) {
                    println(WHITE_BOLD + "--------------------------------------------------------------------------------------------" + RESET)
                    println(WHITE_BOLD + "Actualment no hi ha cap usuari registrat, per poder iniciar sessió has d'estar registrat." + RESET)
                    println(WHITE_BOLD + "--------------------------------------------------------------------------------------------" + RESET)
                } else {
                    var llegirNomUsuari = llegirNomUsuariLogin("Escriu el nom d'usuari", llistaUsuaris)
                    var llegirContrasenyaLogin =
                        llegirContrasenyaLogin("Escriu la contrasneya", llistaUsuaris, llegirNomUsuari)
                    usuariActual = login(llistaUsuaris, llegirNomUsuari, llegirContrasenyaLogin)
                    println(GREEN_BOLD + "---------------------------------------------------------------------------" + RESET)
                    println(GREEN_BOLD + "Benvingut, " + RESET + GREEN_BOLD_BRIGHT + usuariActual.nom + " " + usuariActual.cognom + RESET + GREEN_BOLD + "!" + RESET)
                    println(GREEN_BOLD + "---------------------------------------------------------------------------" + RESET)

                    // Un cop l'usuari ja ha iniciat sessió, mostrarem el següent menú (Fer operacions/Logout)
                    do {
                        println(CYAN_BOLD + MENU_LOGIN_0 + RESET)
                        var seleccioMenu0 =
                            triarOpcioMenu(nMin = 1, nMax = 2, missatge = "Escriu l'opció escollida a continuació:")
                        when (seleccioMenu0) {

                            1 -> {
                                // FER OPERACIONS
                                if (usuariActual.operacionsDisponibles <= 0) {
                                    println(YELLOW_BOLD + "Has exhaurit les 5 operacions de prova gratuïtes de la teva compte. Subscriu-te per a gaudir d'operacions il·limitades" + RESET)
                                } else {
                                    // Si l'usuari té operacions disponibles, mostrem el menú d'operacions
                                    var operar = ferOperacions(usuariActual)
                                }
                            }

                            2 -> {
                                // LOGOUT
                            }
                        }
                    } while (seleccioMenu0 != 2)
                }
            }

            3 -> {
                // BORRAR USUARI
                if (llistaUsuaris.isEmpty()) {
                    println(WHITE_BOLD + "--------------------------------------------" + RESET)
                    println(WHITE_BOLD + "Actualment no hi ha cap usuari registrat." + RESET)
                    println(WHITE_BOLD + "--------------------------------------------" + RESET)

                } else {
                    val llegirNomUsuari = llegirNomUsuariLogin("Escriu el nom d'usuari", llistaUsuaris)
                    val llegirContrasenyaLogin =
                        llegirContrasenyaLogin("Escriu la contrasneya", llistaUsuaris, llegirNomUsuari)
                    var usuariABorrar = login(llistaUsuaris, llegirNomUsuari, llegirContrasenyaLogin)
                    var borrarUsuari = preguntaTrueFalse(
                        "Estàs segur que vols el·liminar l'usuari $llegirNomUsuari? Aquesta acció és irreversible. (Si/No)",
                        "Has d'escriure 'Si' o 'No'",
                        "si",
                        "no"
                    )
                    if (borrarUsuari) {
                        llistaUsuaris.remove(usuariABorrar)
                        println(RED + "--------------------------------------------" + RESET)
                        println(RED + "L'usuari ${RED_BOLD}${llegirNomUsuari}${RESET}$RED s'ha eliminat correctament." + RESET)
                        println(RED + "--------------------------------------------" + RESET)
                    }
                }
            }

            0 -> {
                // SORTIR
                continuar = false
            }
        }
        if (!continuar) {
            continuar = preguntaTrueFalse(
                "Estas seguríssim que vols abandonar? (Si/No)",
                "Escriu 'Si' o 'No' en funció de si vols abandonar.",
                "no",
                "si"
            )
        }
    } while (continuar)

    println(GREEN_BOLD + "\nFins aviat!" + RESET)

}