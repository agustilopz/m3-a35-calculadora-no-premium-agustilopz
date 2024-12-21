package org.example

import org.example.models.Usuari
import utils.*


/**
 * Aquesta funció serveix per oferir a l'usuari una sèrie d'operacions a realitzar i dur-les a terme en funció de la selecció de l'usuari. Aquesta funció crida i agrupa diferents funcions externes.
 * @author agustí.lópez
 * @since 20/12/2024
 * @param usuariActual Usuari que té la sessió iniciada
 */
fun ferOperacions(usuariActual: Usuari){
    do {
        var continuar = true
        val MENU: String = mostrarMenu(opc0 = "Sortir")
        println(MENU)

        var seleccioMenu = triarOpcioMenu(nMin = 0, nMax = 6, missatge = "Escriu l'opció escollida a continuació:")

        when (seleccioMenu) {
            1 -> {
                var entradaUsuari = llegirDosNumeros()
                var operacio = operarDosNumeros(entradaUsuari, "suma")

                println(PURPLE + "-----------------------------------------------------" + RESET)
                println(PURPLE + "El resultat de la suma entre ${RESET}$PURPLE_BOLD${operacio[0]}$RESET ${PURPLE}i ${RESET}$PURPLE_BOLD${operacio[1]}$RESET ${PURPLE}és${RESET} $PURPLE_BOLD_BRIGHT${operacio[2]}$RESET")
                println(PURPLE + "-----------------------------------------------------" + RESET)

                usuariActual.operacionsDisponibles--
            }

            2 -> {
                var entradaUsuari = llegirDosNumeros()
                var operacio = operarDosNumeros(entradaUsuari, "resta")

                println(PURPLE + "-----------------------------------------------------" + RESET)
                println(PURPLE + "El resultat de la resta entre ${RESET}$PURPLE_BOLD${operacio[0]}$RESET ${PURPLE}i ${RESET}$PURPLE_BOLD${operacio[1]}$RESET ${PURPLE}és${RESET} $PURPLE_BOLD_BRIGHT${operacio[2]}$RESET")
                println(PURPLE + "-----------------------------------------------------" + RESET)

                usuariActual.operacionsDisponibles--
            }

            3 -> {
                var entradaUsuari = llegirDosNumeros()
                var operacio = operarDosNumeros(entradaUsuari, "multiplicacio")

                println(PURPLE + "-----------------------------------------------------" + RESET)
                println(PURPLE + "El resultat de la multiplicació entre ${RESET}$PURPLE_BOLD${operacio[0]}$RESET ${PURPLE}i ${RESET}$PURPLE_BOLD${operacio[1]}$RESET ${PURPLE}és${RESET} $PURPLE_BOLD_BRIGHT${operacio[2]}$RESET")
                println(PURPLE + "-----------------------------------------------------" + RESET)

                usuariActual.operacionsDisponibles--
            }

            4 -> {
                var entradaUsuari = llegirDosNumeros()
                var operacio = operarDosNumeros(entradaUsuari, "divisio")

                println(PURPLE + "-----------------------------------------------------" + RESET)
                println(PURPLE + "El resultat de la divisó entre ${RESET}$PURPLE_BOLD${operacio[0]}$RESET ${PURPLE}i ${RESET}$PURPLE_BOLD${operacio[1]}$RESET ${PURPLE}és${RESET} $PURPLE_BOLD_BRIGHT${operacio[2]}$RESET")
                println(PURPLE + "-----------------------------------------------------" + RESET)

                usuariActual.operacionsDisponibles--
            }

            5 -> {
                var num1 = llegirUnNumeroEnter("Introdueix un número enter positiu")
                var resultat = operar(num1, ::quadrat)

                println(PURPLE + "-----------------------------------------------------" + RESET)
                println(PURPLE + "El resultat del quadrat de ${RESET}$PURPLE_BOLD${num1}$RESET ${PURPLE} és${RESET} $PURPLE_BOLD_BRIGHT${resultat}$RESET")
                println(PURPLE + "-----------------------------------------------------" + RESET)

                usuariActual.operacionsDisponibles--
            }

            6 -> {
                println(PURPLE + "-----------------------------------------------------" + RESET)
                println(PURPLE + "Et queden ${PURPLE_BOLD}${usuariActual.operacionsDisponibles}${RESET} ${PURPLE}operacions restants." + RESET)
                println(PURPLE + "-----------------------------------------------------"+ RESET )
            }

            0 -> {
                continuar = false
            }
        }

        //println("Et queden ${usuariActual.operacionsDisponibles} operacions disponibles")
        if (continuar && usuariActual.operacionsDisponibles > 0) {
            continuar = preguntaTrueFalse("\nVols seguir fent operacions? (Si/No)", "Has d'escriure 'Si' o 'No'", "si", "no")
        }
        if (usuariActual.operacionsDisponibles == 0) {
            println(YELLOW_BOLD + "Has exhaurit les 5 operacions de prova. Fes-te premium pel mòdic preu de 299,99€ al mes per gaudir de operacions il·limitades!" + RESET)
        }

} while (continuar && usuariActual.operacionsDisponibles>0)
}

/**
 * Aquesta funció serveix realitzar el registre d'un usuari mitjançant la crida de diferents funcions, i mostrar la informació pertinent
 * @author agustí.lópez
 * @since 20/12/2024
 * @param llistaUsuaris Llista de tots els usuaris registrats
 */
fun registre(llistaUsuaris: MutableList<Usuari>){
    val NUMERO_OPERACIONS_DISPONIBLES:Int=5
    println(BOLD+"Has escollit registrar-te."+RESET)
    var nom = readWord("Introdueix el teu nom a continuació:","Has d'escriure el teu nom")
    var cognom = readWord("Introdueix el teu primer cognom a continuació:","Has d'escriure el teu cognom")
    var nomUsuari=llegirNomUsuariRegistre("Introdueix un nom d'usuari:", llistaUsuaris)
    var contrasenya=llegirContrasenyaRegistre("Introdueix una contrasenya:", llistaUsuaris)
    var operacionsDisponibles=NUMERO_OPERACIONS_DISPONIBLES
    llistaUsuaris.add(Usuari(nom,cognom,nomUsuari,contrasenya,operacionsDisponibles,1))
    println(GREEN_BOLD+"---------------------------------------------------------------------------"+RESET)
    println(GREEN_BOLD+"El registre de l'usuari "+RESET+ GREEN_BOLD_BRIGHT + nomUsuari + RESET + GREEN_BOLD+" s'ha realitzat correctament."+RESET)
    println(GREEN_BOLD+"---------------------------------------------------------------------------"+RESET)
}

/**
 * Aquesta funció serveix per guardar les dades de l'usuari que ha iniciat sessió
 * @author agustí.lópez
 * @since 20/12/2024
 * @param llistaUsuaris Llista de tots els usuaris registrats
 * @param llegirNomUsuariLogin Nom d'usuari ja validat prèviament
 * @param llegirContrasenyaLogin Contrasenya de l'usuari ja validada prèviament
 * @return Usuari que té la sessió inciciada (data class)
 */
fun login(llistaUsuaris: MutableList<Usuari>,llegirNomUsuariLogin:String,llegirContrasenyaLogin:String):Usuari {
    var usuariActual:Usuari=Usuari("","","","",0,1)
    for(usuari in llistaUsuaris) {
        if(llegirNomUsuariLogin==usuari.nomUsuari && llegirContrasenyaLogin==usuari.contrasenya){
            usuariActual=usuari
        }
    }
    return usuariActual
}



fun logout(){}


fun generarID(llistaUsuaris:MutableList<Usuari>):Int{
    var idMax:Int=0
    if(llistaUsuaris.isEmpty()) {
        idMax=0
    }
    else {
        for (usuari in llistaUsuaris) {
            if (usuari.id > idMax) {
                idMax = usuari.id
            }
        }
    }
    var idNou:Int = idMax+1
    return idNou
}
fun operacionsDisponibles(usuariActual:Usuari) {
    if(usuariActual.operacionsDisponibles>0){
        println("Et queden ${usuariActual.operacionsDisponibles} operacions disponibles.")
        //Operacions
        usuariActual.operacionsDisponibles--

    }else {
        println("Has esgotat totes les operacions de prova.")
    }

}
fun registrarUsuari() {
    var llistaUsuaris:MutableList<Usuari> = mutableListOf<Usuari>()
    val NUMERO_OPERACIONS_DISPONIBLES:Int=5
    println("Introdueix les teves dades a continuació")
    var nomUsuari = readWord("Introdueix el teu nom","Has d'escriure el teu nom")
    var cognomUsuari = readWord("Introdueix el teu cognom","Has d'escriure el teu cognom")
    var username= llegirNomUsuariRegistre("Introdueix el teu nom d'usuari",llistaUsuaris)
    var contrasenya = readWord("Introdueix una contrasenya","Has d'escriure una contrasenya")
    var operacionsDisponibles=NUMERO_OPERACIONS_DISPONIBLES

    var idMax:Int=0
    if(llistaUsuaris.isEmpty()) {
        idMax=0
    }
    else {
        for (usuari in llistaUsuaris) {
            if (usuari.id > idMax) {
                idMax = usuari.id
            }
        }
    }
    var idNou=idMax+1

    llistaUsuaris.add(Usuari(nomUsuari,cognomUsuari,username,contrasenya,operacionsDisponibles,idNou))

    var dadesUsuari = Usuari(nomUsuari,cognomUsuari,contrasenya,"pep",operacionsDisponibles,0)
}

/**
 * Aquesta funció serveix per validar que el nom introduït per l'usuari no està ja registrat
 * @author agustí.lópez
 * @since 19/12/2024
 * @param missatgeEntrada Missatge d'entrada que es mostrarà a l'usuari
 * @param llistaUsuaris Llista de tots els usuaris registrats actualment
 * @return Nom de l'usuari validat
 */
fun llegirNomUsuariRegistre(missatgeEntrada: String, llistaUsuaris:MutableList<Usuari>
): String{

    var usuariIntroduit : String = ""
    var correctDataType : Boolean = false
    var valorRepetit : Boolean = false

    do{
        println(missatgeEntrada)
        correctDataType = scan.hasNext()
        valorRepetit=false

        if (!correctDataType){
            println(RED_BACKGROUND_BRIGHT + "ERROR: Has d'introduir un nom d'usuari"+ RESET)
        }else{
            usuariIntroduit = scan.nextLine()
            for(usuari in llistaUsuaris) {
                if(usuariIntroduit==usuari.nomUsuari){
                    valorRepetit=true
                }
            }
            if(usuariIntroduit.contains(" ")){
                println(RED_BOLD + "El nom d'usuari no pot contenir espais." + RESET)
                correctDataType =false
            }
            if(valorRepetit){
                println(RED_BOLD + "El nom d'usuari que has introduït ja esta registrat." + RESET)
            }
        }
    }while(!correctDataType || valorRepetit)

    return usuariIntroduit
}

/**
 * Aquesta funció serveix per validar que el nom introduït per l'usuari està registrat
 * @author agustí.lópez
 * @since 19/12/2024
 * @param missatgeEntrada Missatge d'entrada que es mostrarà a l'usuari
 * @param llistaUsuaris Llista de tots els usuaris registrats actualment
 * @return Nom de l'usuari validat
 */
fun llegirNomUsuariLogin(missatgeEntrada: String, llistaUsuaris:MutableList<Usuari>
): String{

    var nomUsuariIntroduit : String = ""
    var correctDataType : Boolean = false
    var usuariRegistrat : Boolean = false

    do{
        println(missatgeEntrada)
        correctDataType = scan.hasNext()

        if (!correctDataType){
            println(RED_BACKGROUND_BRIGHT + "ERROR: Has d'introduir un nom d'usuari"+ RESET)
        }else{
            nomUsuariIntroduit = scan.nextLine()
            for(usuari in llistaUsuaris) {
                if(nomUsuariIntroduit==usuari.nomUsuari){
                    usuariRegistrat=true
                }
            }
            if(!usuariRegistrat){
                println(RED_BOLD + "El nom que has introduït no esta registrat." + RESET)
            }
        }
    }while(!correctDataType || !usuariRegistrat)

    return nomUsuariIntroduit
}

/**
 * Aquesta funció serveix per validar que la contrasenya introduïda correspon amb el nom d'usuari
 * @author agustí.lópez
 * @since 19/12/2024
 * @param missatgeEntrada Missatge d'entrada que es mostrarà a l'usuari
 * @param llistaUsuaris Llista de tots els usuaris registrats actualment
 * @param nomUsuariIntroduit Nom d'usuari introduït prèviament
 * @return Contrasenya validada
 */
fun llegirContrasenyaLogin(missatgeEntrada: String, llistaUsuaris:MutableList<Usuari>,nomUsuariIntroduit:String): String {
    var contrasenyaIntroduida: String = ""
    var correctDataType: Boolean = false
    var contransenyaCorrecte: Boolean = false

    do {
        println(missatgeEntrada)
        correctDataType = scan.hasNext()

        if (!correctDataType) {
            println(RED_BACKGROUND_BRIGHT + "ERROR: Has d'introduir un nom d'usuari" + RESET)
        } else {
            contrasenyaIntroduida = scan.next()
            scan.nextLine()
            for (usuari in llistaUsuaris) {
                if (nomUsuariIntroduit == usuari.nomUsuari) {
                    if (contrasenyaIntroduida == usuari.contrasenya) {
                        contransenyaCorrecte = true
                    } else {
                        println(RED_BOLD + "La contrasenya que has introduït no correspon amb el nom d'usuari." + RESET)
                        contransenyaCorrecte = false
                    }
                }
            }
        }
        }while (!correctDataType || !contransenyaCorrecte)

        return contrasenyaIntroduida
}


/**
 * Aquesta funció serveix per validar que la contrasenya introduïda compleix amb els criteris corresponents
 * @author agustí.lópez
 * @since 19/12/2024
 * @param missatgeEntrada Missatge d'entrada que es mostrarà a l'usuari
 * @param llistaUsuaris Llista de tots els usuaris registrats actualment
 * @return Contrasenya validada
 */
fun llegirContrasenyaRegistre(missatgeEntrada: String, llistaUsuaris:MutableList<Usuari>
): String{

    var contrasenyaIntroduida : String = ""
    var correctDataType : Boolean = false
    var contransenyaSegura : Boolean = false

    do{
        println(missatgeEntrada)
        correctDataType = scan.hasNext()

        if (!correctDataType){
            println(RED_BACKGROUND_BRIGHT + "ERROR: Has d'introduir un nom d'usuari"+ RESET)
        }else{
            contrasenyaIntroduida = scan.next()

            if(contrasenyaIntroduida.length<5){
                println(RED_BOLD + "La contrasenya ha de tenir un mínim de 5 caràcters." + RESET)
                contransenyaSegura=false
            }else contransenyaSegura=true

        }
    }while(!correctDataType || !contransenyaSegura)

    return contrasenyaIntroduida
}

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
        ------------------------------------------
        Escolleix una de les següents opcions:
        
        1. $opc1
        2. $opc2
        3. $opc3
        4. $opc4
        5. $opc5
        6. $opc6
        0. $opc0
        ------------------------------------------
    """.trimIndent()
    return menu
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
    opc1: String, opc2: String, opc3: String, opc0: String
): String {
    var menu: String = """
        ------------------------------------------
        Escolleix una de les següents opcions:
        
        1. $opc1
        2. $opc2
        3. $opc3
        0. $opc0
        ------------------------------------------
    """.trimIndent()
    return menu
}

/**
 * Aquesta funció serveix per mostrar un menú amb una sèrie d'opcions personalitzables
 * @author agustí.lópez
 * @since 17/12/2024
 * @param opc0 Opció de sortida per defecte
 * @param opc1 Opció 1 del menú
 * @param opc2 Opció 2 del menú
 * @return resultat String del missatge del menú
 */
fun mostrarMenu(
    opc1: String, opc2: String, opc0: String
): String {
    var menu: String = """
        Escolleix una de les següents opcions:
        
        1. $opc1
        2. $opc2
        0. $opc0
        
    """.trimIndent()
    return menu
}



/**
 * Aquesta funció serveix per mostrar un menú amb una sèrie d'opcions personalitzables
 * @author agustí.lópez
 * @since 17/12/2024
 * @param opc1 Opció 1 del menú
 * @param opc2 Opció 2 del menú
 * @return resultat String del missatge del menú
 */
fun mostrarMenu(
    opc1: String, opc2: String
): String {
    var menu: String = """
        ------------------------------------------
        Escolleix una de les següents opcions:
        
        1. $opc1
        2. $opc2
        ------------------------------------------
    """.trimIndent()
    return menu
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
    opc1: String
): String {
    var menu: String = """
        Escolleix una de les següents opcions:
        
        1. $opc1

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

/* ----------------------------Funcions no utilitzades----------------------------------------- */
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
