package org.example

import utils.*
import org.example.models.*

fun main() {
    /*
    var seleccioMenu: Int = 0
    var seleccioMenuLogin: Int = 0
    val MENU: String = mostrarMenu(opc0 = "Sortir")
    val MENU_LOGIN:String= mostrarMenu("Registrar usuari","Login","Logout")
    val benvinguda: String = bold(benvinguda("fer operacions matemàtiques bàsiques"))
    var continuar: Boolean = true
    var dadesUsuari:Usuari = Usuari("","","",0,0)
    var operacionsDisponibles:Int=0

    println(benvinguda)

    println(MENU_LOGIN)
    seleccioMenuLogin = triarOpcioMenu(nMin = 1, nMax = 3, missatge = "Escriu l'opció escollida a continuació:")
    when(seleccioMenuLogin) {
        1->{
            println("Introdueix les teves dades a continuació")
            var nomUsuari = readWord("Introdueix el teu nom","Has d'escriure el teu nom")
            var cognomUsuari = readWord("Introdueix el teu cognom","Has d'escriure el teu cognom")
            var contrasenya = readWord("Introdueix una contrasenya","Has d'escriure una contrasenya")
            var id=1
            operacionsDisponibles=5
            //dadesUsuari = Usuari(nomUsuari,cognomUsuari,contrasenya,operacionsDisponibles,id)
        }
        2->{}
        3->{}
    }


    println(dadesUsuari)
        do {
            continuar = true

            println(MENU)

            seleccioMenu = triarOpcioMenu(nMin = 0, nMax = 6, missatge = "Escriu l'opció escollida a continuació:")

            when (seleccioMenu) {
                1 -> {
                    var entradaUsuari = llegirDosNumeros()
                    var operacio = operarDosNumeros(entradaUsuari, "suma")
                    println("El resultat de la suma entre $WHITE_BOLD${operacio[0]}$RESET i $WHITE_BOLD${operacio[1]}$RESET és $GREEN_BOLD${operacio[2]}$RESET")
                    operacionsDisponibles--
                    dadesUsuari.operacionsDisponibles--
                }

                2 -> {
                    var entradaUsuari = llegirDosNumeros()
                    var operacio = operarDosNumeros(entradaUsuari, "resta")
                    println("El resultat de la resta entre $WHITE_BOLD${operacio[0]}$RESET i $WHITE_BOLD${operacio[1]}$RESET és $GREEN_BOLD${operacio[2]}$RESET")
                    operacionsDisponibles--
                }

                3 -> {
                    var entradaUsuari = llegirDosNumeros()
                    var operacio = operarDosNumeros(entradaUsuari, "multiplicacio")
                    println("El resultat de la multiplicació entre $WHITE_BOLD${operacio[0]}$RESET i $WHITE_BOLD${operacio[1]}$RESET és $GREEN_BOLD${operacio[2]}$RESET")
                    operacionsDisponibles--
                }

                4 -> {
                    var entradaUsuari = llegirDosNumeros()
                    var operacio = operarDosNumeros(entradaUsuari, "divisio")
                    println("El resultat de la divisió entre $WHITE_BOLD${operacio[0]}$RESET i $WHITE_BOLD${operacio[1]}$RESET és $GREEN_BOLD${operacio[2]}$RESET")
                    operacionsDisponibles--
                }

                5 -> {
                    var num1 = llegirUnNumeroEnter("Introdueix un número enter positiu")
                    var resultat = operar(num1, ::quadrat)
                    println("El resultat del quadrat de $WHITE_BOLD$num1$RESET és $GREEN_BOLD$resultat$RESET")
                    operacionsDisponibles--
                }

                6 -> {
                    println("Et queden $operacionsDisponibles operacions restants.")
                }


                0 -> {
                    continuar = false
                }
            }
            println("Et queden $operacionsDisponibles operacions disponibles")
            println(dadesUsuari)
            if (continuar && operacionsDisponibles>0) {
                continuar = preguntaTrueFalse("\nVols continuar? (Si/No)", "Has d'escriure 'Si' o 'No'", "si", "no")
            }
            if(operacionsDisponibles==0){
                println("Has exhaurit les 5 operacions de prova. Fes-te premium pel mòdic preu de 299,99€ al mes per gaudir de operacions il·limitades!")
            }

        } while (continuar && operacionsDisponibles>0)
    println("\nFins aviat!")







     */
}