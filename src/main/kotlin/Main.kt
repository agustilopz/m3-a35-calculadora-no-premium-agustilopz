package org.example

import utils.*
import org.example.models.*
val llistaUsuaris:MutableList<Usuari> = mutableListOf<Usuari>()

fun main() {
    var seleccioMenu: Int = 0
    var seleccioMenuLogin: Int = 0
    val MENU_LOGIN: String = mostrarMenu("Registrar usuari", "Login","Esborrar usuari", "Sortir")
    val MENU_LOGIN_0: String = mostrarMenu("Realitzar operacions", "Logout")
    val benvinguda: String = bold(benvinguda("fer operacions matemàtiques bàsiques. Si et registres pots gaudir de 5 operacions gratuïtes de prova!"))
    var continuar: Boolean = true
    var usuariActiu:Boolean=false
    var usuariActual:Usuari
    println(benvinguda)

    do {
        println(MENU_LOGIN)
        seleccioMenuLogin = triarOpcioMenu(nMin = 0, nMax = 3, missatge = "Escriu l'opció escollida a continuació:")
        when (seleccioMenuLogin) {
            1 -> {
                var registre = registre(llistaUsuaris)
                //println(llistaUsuaris)
            }

            2 -> {
                if (llistaUsuaris.isEmpty()) {
                    println(WHITE_BOLD+"--------------------------------------------------------------------------------------------"+RESET)
                    println(WHITE_BOLD + "Actualment no hi ha cap usuari registrat, per poder iniciar sessió has d'estar registrat." + RESET)
                    println(WHITE_BOLD+"--------------------------------------------------------------------------------------------"+RESET)
                } else {
                    var llegirNomUsuari = llegirNomUsuariLogin("Escriu el nom d'usuari", llistaUsuaris)
                    var llegirContrasenyaLogin =
                        llegirContrasenyaLogin("Escriu la contrasneya", llistaUsuaris, llegirNomUsuari)
                    usuariActual = login(llistaUsuaris, llegirNomUsuari, llegirContrasenyaLogin)
                    usuariActiu = true
                    println(GREEN_BOLD+"---------------------------------------------------------------------------"+RESET)
                    println(GREEN_BOLD+"Benvingut, "+ RESET + GREEN_BOLD_BRIGHT + usuariActual.nom + " " + usuariActual.cognom + RESET + GREEN_BOLD + "!" + RESET)
                    println(GREEN_BOLD+"---------------------------------------------------------------------------"+RESET)
                    do {
                        println(MENU_LOGIN_0)
                        var seleccioMenu0 =
                            triarOpcioMenu(nMin = 1, nMax = 2, missatge = "Escriu l'opció escollida a continuació:")
                        when (seleccioMenu0) {
                            1 -> {
                                if(usuariActual.operacionsDisponibles<=0){
                                    println(YELLOW_BOLD + "Has exhaurit les 5 operacions de prova gratuïtes de la teva compte. Subscriu-te per a gaudir d'operacions il·limitades" + RESET)
                                }
                                else {
                                    var operar = ferOperacions(usuariActual)
                                }
                            }

                            2 -> {

                            }

                        }

                    } while (seleccioMenu0 != 2)

                }

            }

            3 -> {
                if (llistaUsuaris.isEmpty()) {
                    println(WHITE_BOLD+"--------------------------------------------"+RESET)
                    println(WHITE_BOLD + "Actualment no hi ha cap usuari registrat." + RESET)
                    println(WHITE_BOLD+"--------------------------------------------"+RESET)
                } else {
                    val llegirNomUsuari = llegirNomUsuariLogin("Escriu el nom d'usuari", llistaUsuaris)
                    val llegirContrasenyaLogin =
                        llegirContrasenyaLogin("Escriu la contrasneya", llistaUsuaris, llegirNomUsuari)
                    var usuariABorrar = login(llistaUsuaris, llegirNomUsuari, llegirContrasenyaLogin)
                    var borrarUsuari= preguntaTrueFalse("Estàs segur que vols el·liminar l'usuari $llegirNomUsuari? Aquesta acció és irreversible. (Si/No)","Has d'escriure 'Si' o 'No'","si","no")
                    if(borrarUsuari) {
                        llistaUsuaris.remove(usuariABorrar)
                        println(RED + "--------------------------------------------" + RESET)
                        println(RED + "L'usuari ${RED_BOLD}${llegirNomUsuari}${RESET}$RED s'ha eliminat correctament." + RESET)
                        println(RED + "--------------------------------------------" + RESET)
                    }
                }


            }

            0->{continuar=false}
        }
        //continuar = preguntaTrueFalse("\nVols continuar? (Si/No)", "Has d'escriure 'Si' o 'No'", "si", "no")
        if(!continuar) {
            continuar= preguntaTrueFalse("Estas seguríssim que vols abandonar?","Escriu Si o No", "no", "si")
        }
    } while (continuar)


    println("\nFins aviat!")







}