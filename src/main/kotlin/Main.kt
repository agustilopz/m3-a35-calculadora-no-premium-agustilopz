package org.example

import utils.*
import org.example.models.*
val llistaUsuaris:MutableList<Usuari> = mutableListOf<Usuari>()

fun main() {
    var seleccioMenu: Int = 0
    var seleccioMenuLogin: Int = 0
    val MENU_LOGIN: String = mostrarMenu("Registrar usuari", "Login","Esborrar usuari", "Sortir")
    val MENU_LOGIN_0: String = mostrarMenu("Realitzar operacions", "Logout")
    val benvinguda: String = bold(benvinguda("fer operacions matemàtiques bàsiques"))
    var continuar: Boolean = true
    //var dadesUsuari:Usuari = Usuari("","","",0,0)
    var operacionsDisponibles: Int = 0
    var usuariActiu:Boolean=false
    var usuariActual:Usuari
    println(benvinguda)

    do {
        println(MENU_LOGIN)
        seleccioMenuLogin = triarOpcioMenu(nMin = 0, nMax = 3, missatge = "Escriu l'opció escollida a continuació:")
        when (seleccioMenuLogin) {
            1 -> {
                var registre = registre(llistaUsuaris)
                println(llistaUsuaris)
            }

            2 -> {
                if (llistaUsuaris.isEmpty()) {
                    println("Actualment no hi ha cap usuari registrat, per poder iniciar sessió has d'estar registrat.")
                } else {
                    var llegirNomUsuari = llegirNomUsuariLogin("Escriu el nom d'usuari", llistaUsuaris)
                    var llegirContrasenyaLogin =
                        llegirContrasenyaLogin("Escriu la contrasneya", llistaUsuaris, llegirNomUsuari)
                    usuariActual = login(llistaUsuaris, llegirNomUsuari, llegirContrasenyaLogin)
                    usuariActiu = true
                    println("Benvingut, ${usuariActual.nom} ${usuariActual.cognom}!")
                    do {
                        println(MENU_LOGIN_0)
                        var seleccioMenu0 =
                            triarOpcioMenu(nMin = 1, nMax = 2, missatge = "Escriu l'opció escollida a continuació:")
                        when (seleccioMenu0) {
                            1 -> {
                                var operar = ferOperacions(usuariActual)
                            }

                            2 -> {

                            }

                        }

                    } while (seleccioMenu0 != 2)


                }

            }

            3 -> {
                if (llistaUsuaris.isEmpty()) {
                    println("Actualment no hi ha cap usuari registrat.")
                } else {
                    val llegirNomUsuari = llegirNomUsuariLogin("Escriu el nom d'usuari", llistaUsuaris)
                    val llegirContrasenyaLogin =
                        llegirContrasenyaLogin("Escriu la contrasneya", llistaUsuaris, llegirNomUsuari)
                    var usuariABorrar = login(llistaUsuaris, llegirNomUsuari, llegirContrasenyaLogin)
                    llistaUsuaris.remove(usuariABorrar)
                }


            }

            0->{continuar=false}
        }
        //continuar = preguntaTrueFalse("\nVols continuar? (Si/No)", "Has d'escriure 'Si' o 'No'", "si", "no")
        if(!continuar) {
            continuar= preguntaTrueFalse("Estas seguríssim que vols abandonar?","Escriu Si o No", "no", "si")
        }
    } while (continuar)


    //println(dadesUsuari)

    println("\nFins aviat!")







}