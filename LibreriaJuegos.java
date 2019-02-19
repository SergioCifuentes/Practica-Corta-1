import java.util.Scanner;

/**
 *
 * @author Sergio Cifuentes
 */
public class LibreriaJuegos {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] juego) {
        int opcionJuego = 0;
        System.out.println("BIENVENIDO");
        if (juego.length == 1) {       //en caso de que el usuario ingrese un parametro
            switch (juego[0]) {
                case "ahorcado":
                    opcionJuego = 1;
                    break;
                case "basketball":
                    opcionJuego = 2;
                    break;
                case "cartas":
                    opcionJuego = 3;
                    break;
                case "hanoi":
                    opcionJuego = 4;
                    break;
                default:
                    System.out.println("Parametro invalido");
            }
        }
        do {
            if (opcionJuego == 0) {
                System.out.println("Escoja el Juego que Desee:");//Menu Principal
                System.out.println("[1] Ahorcado");
                System.out.println("[2] Basketball");
                System.out.println("[3] Juego de Cartas");
                System.out.println("[4] Hanoi");
                System.out.println("[5] Salir");
                opcionJuego = scanner.nextInt();
            }
            switch (opcionJuego) {
                case 1:
                    System.out.println("AHORCADO");
                    jugarAhorcado();
                    break;
                case 2:
                    System.out.println("BASKETBALL");
                    jugarBasketball();
                    break;
                case 3:
                    System.out.println("JUEGO DE CARTAS");
                    jugarCartas();
                    break;
                case 4:
                    System.out.println("HANOI");
                    jugarHanoi();
                    break;
                case 5:
                    System.out.println("Regrese Pronto");
                    break;
            }//Este es el menu que aparecera despues del termino de un juego
            System.out.println("[1] Jugar De Nuevo");
            System.out.println("[2] Escojer Otro Juego");
            System.out.println("[3] Salir");
            int opcionJuegoTerminado = scanner.nextInt();
            switch (opcionJuegoTerminado) {
                case 2:
                    opcionJuego = 0;
                    break;
                case 3:
                    opcionJuego = 5;
                    break;
            }
        } while (opcionJuego != 5);
    }

    /*Juego
    Ahorcado
     */
    private static void jugarAhorcado() {
        String palabra;
        int longitudDePalabra;
        int intentos = 0;
        int aciertos = 0;
        final int OPORTUNIDADES = 6;//Oportunidades maximos para adivinar dependiente de los dibujos
        System.out.println("Ingrese un palabra (sin que el jugador lo vea)");
        palabra = scanner.next();
        longitudDePalabra = palabra.length();
        String casillas[];//arreglo que mostrara la palabra conforme se vayan adivinado las letras
        casillas = new String[longitudDePalabra];
        for (int i = 0; i < longitudDePalabra; i++) {
            casillas[i] = "_";//Las letras no adivinadas se identificaran con guion bajo
        }
        do {
            System.out.println("intentos: " + intentos + "/" + OPORTUNIDADES);
            String letra;
            System.out.println(dibujarAhorcado(intentos));//Llama al metodo para mostrar las figuras del Ahorcado
            for (int j = 0; j < longitudDePalabra; j++) {
                System.out.print(casillas[j] + " ");
            }
            System.out.println("Ingrese una Letra o Adivine la Palabra");
            letra = scanner.next();
            if (verificarPalabraAdivinada(palabra, letra)) {//Metodo que para la adivinacion de toda la palabra
                aciertos = longitudDePalabra;
            } else {
                boolean encontrado = false;
                String buscador[] = new String[longitudDePalabra];
                for (int i = 0; i < longitudDePalabra; i++) {
                    buscador[i] = palabra.substring(i, i + 1);
                    if (verificarLetraAdivinada(buscador[i], letra)) {//Llama el metodo que verifica la letra que el jugador ingresa
                        encontrado = true;
                        System.out.println("correcto");
                        if ("_".equals(casillas[i])) {
                            casillas[i] = buscador[i];
                            aciertos++;
                        }
                    }
                }
                if (encontrado == false) {//En caso de que la adivinacion es incorrecto
                    intentos++;
                    System.out.println("Incorrecto");
                }
            }
        } while (intentos < OPORTUNIDADES && aciertos < longitudDePalabra);
        if (aciertos == longitudDePalabra) {//Se el jugador gano
            System.out.println("Felicidades Has Ganado");

        } else {//Si el jugador perdio
            System.out.println(dibujarAhorcado(intentos));
            System.out.println("Perdiste");
            System.out.println("La Palabra Era: " + palabra);

        }
        System.out.println("Presione Enter Para Continuar");
        String Esperar = scanner.nextLine();
        String Esperar1 = scanner.nextLine();
    }

    //metodo que verifica si el jugador ingresa exactamente la palabra que debe adivinar
    private static boolean verificarPalabraAdivinada(String palabra, String palabraAdivinada) {
        boolean adivinacion = false;
        if (palabra.equals(palabraAdivinada)) {
            adivinacion = true;
        }
        return adivinacion;
    }

    //Verificacion de la letra ingresada por el jugador
    private static boolean verificarLetraAdivinada(String letra, String letraAdivinada) {
        boolean letraEncontrada = false;
        if (letra.equals(letraAdivinada)) {
            letraEncontrada = true;
        }
        return letraEncontrada;
    }
    //Metodo que imprime los dibujos del ahoracado deppendiendo de los intentos

    private static String dibujarAhorcado(int intentos) {
        String dibujo = null;
        switch (intentos) {
            case 0:
                dibujo = "____\n"
                        + "│   │\n"
                        + "│   \n"
                        + "│   \n"
                        + "│";
                break;
            case 1:
                dibujo = "____\n"
                        + "│   │\n"
                        + "│   O\n"
                        + "│   \n"
                        + "│   ";
                break;
            case 2:
                dibujo = "____\n"
                        + "│   │\n"
                        + "│   O\n"
                        + "│   |\n"
                        + "│   ";
                break;
            case 3:
                dibujo = "____\n"
                        + "│   │\n"
                        + "│   O\n"
                        + "│  /|\n"
                        + "│";
                break;
            case 4:
                dibujo = "____\n"
                        + "│   │\n"
                        + "│   O\n"
                        + "│  /|\\\n"
                        + "│";
                break;
            case 5:
                dibujo = "____\n"
                        + "│   │\n"
                        + "│   O\n"
                        + "│  /|\\\n"
                        + "│  /";
                break;

            case 6:
                dibujo = "____\n"
                        + "│   │\n"
                        + "│   O\n"
                        + "│  /|\\\n"
                        + "│  / \\";
                break;

        }
        return dibujo;
    }

    /*JUEGO
   BASKETBALL*/
    private static void jugarBasketball() {
        String nombreJugador1;
        int puntosJugador1 = 0;
        String nombreJugador2;
        int puntosJugador2 = 0;
        int numRondas;
        System.out.println("Jugador1 ingrese su nombre:");//Ingreso de los jugadores
        nombreJugador1 = scanner.next();
        System.out.println("Jugador2 ingrese su nombre");
        nombreJugador2 = scanner.next();
        System.out.println("Cuantas rondas desea jugar?");//Los jugadores ingresan el numero de rondas
        numRondas = scanner.nextInt();
        int orden = (int) (Math.random() * 2) + 1;//el random provee la aleatoridad de los turnos
        String jugadorTirando = null;
        String jugadorDefendiendo = null;
        for (int i = 0; i < 2 * numRondas; i++) {
            System.out.println(nombreJugador1 + ": " + puntosJugador1 + "    " + nombreJugador2 + ": " + puntosJugador2);//Por cada turno se muesta el marcador
            switch (orden) {
                case 1://jugador1 primero
                    jugadorTirando = nombreJugador1;
                    jugadorDefendiendo = nombreJugador2;
                    orden = 2;
                    break;
                case 2://jugador2 priemro
                    jugadorTirando = nombreJugador2;
                    jugadorDefendiendo = nombreJugador1;
                    orden = 1;
                    break;
            }
            System.out.println(jugadorTirando + " es tu turno de tirar");
            System.out.println("[1] Salto Largo");
            System.out.println("[2] Salto Corto");
            int opcionTiro = scanner.nextInt();
            int defensa = generarPosibilidadDefensa(jugadorDefendiendo);//Llama el metodo para que el jugador 2 pueda defender
            int puntosDelTiro = generarPuntosDeTiro(opcionTiro, defensa, jugadorTirando);//llama el metodo para verificar si el jugador anota teniendo como paramametro la posibilidad de defensa
            String Esperar = scanner.nextLine();
            if (jugadorTirando.equals(nombreJugador1)) {//if para asignar los puntos del turno al jugador adecuado
                puntosJugador1 = puntosJugador1 + puntosDelTiro;
            } else {
                puntosJugador2 = puntosJugador2 + puntosDelTiro;
            }
        }//al terminar las rondas se muestra el ganador
        System.out.println(nombreJugador1 + ": " + puntosJugador1 + "    " + nombreJugador2 + ": " + puntosJugador2);
        if (puntosJugador1 > puntosJugador2) {
            System.out.println(nombreJugador1 + " Felicidades Ganaste");
        } else if (puntosJugador2 > puntosJugador1) {
            System.out.println(nombreJugador2 + " Felicidades Ganaste");
        } else {
            System.out.println("Quedaron empatados");
        }
        String Esperar = scanner.nextLine();

    }

    /* Este metodo sirve para determinar si la defensa elejida
   por el defensor se vuelve falta o no, regresando un porcentaje de defensa,
   si se comete la falta la posibilidad de defensa sera 100 y sino sera el porcentaje del defensa elejido*/
    private static int generarPosibilidadDefensa(String nombreJugadorDefendiendo) {
        int posibilidadDefensa = 0;
        final int DEFENSA_CUERPO = 15;
        final int FALTA_DEFENSA_CUERPO = 35;
        final int DEFENSA_FUERTE = 30;
        final int FALTA_DEFENSA_FUERTE = 65;
        System.out.println(nombreJugadorDefendiendo + " te toca Defender");
        System.out.println("[1] Defensa Cuerpo o Cuerpo");
        System.out.println("[2] Defensa Fuerte");
        int opcionDefensa = scanner.nextInt();
        int num = (int) (Math.random() * 100) + 1; //Variable que sirve para calcular la posibilidad de falta
        switch (opcionDefensa) {
            case 1:
                if (num <= FALTA_DEFENSA_CUERPO) {
                    posibilidadDefensa = 100;   //Falta para defensa cuerpo a cuerpo
                } else {
                    posibilidadDefensa = DEFENSA_CUERPO; //Si la falta no existe el metodo regresara la posibilidad de defensa cuerpo a cuerpo
                }
                break;
            case 2:
                if (num <= FALTA_DEFENSA_FUERTE) {
                    posibilidadDefensa = 100;   //Falta para defensa fuerte
                } else {
                    posibilidadDefensa = DEFENSA_FUERTE;  //Si la falta no existe el metodo regresara la posibilidad de defensa fuerte
                }
                break;
        }
        return posibilidadDefensa;
    }

    /*Ya teniendo la posibilidad de defensa elejido por el jugador defendiendo se manda como parametro la opcion de tiro que elijio
    el jugador tirando para ya poder determinar si dicho jugador anota puntos o no*/
    private static int generarPuntosDeTiro(int opcionTiro, int posibilidadDefensa, String nombre) {
        int puntosDeTiro = 0;
        final int SALTO_LARGO = 65;
        final int PUNTOS_SALTO_LARGO = 3;
        final int SALTO_CORTO = 80;
        final int PUNTOS_SALTO_CORTO = 2;
        final int TIRO_LIBRE = 90;
        final int PUNTOS_TIRO_LIBRE = 2;
        int num = (int) (Math.random() * 100) + 1;//num sera una variable que servira de mucho para las posibilidades de anotacion
        if (posibilidadDefensa == 100) {//En caso de una falta
            System.out.println("Falta Realizada!!!");
            System.out.println(nombre + " Enter para tirar");
            String Esperar = scanner.nextLine();
            String Esperar1 = scanner.nextLine();
            if (num <= TIRO_LIBRE) {//para cuando el jugador atacando deba tirar un tiro libre
                System.out.println(nombre + " anotaste el tiro libre +" + PUNTOS_TIRO_LIBRE + " puntos");
                puntosDeTiro =PUNTOS_TIRO_LIBRE;
            } else {
                System.out.println(nombre + " fallaste el tiro libre");
            }
        } else {
            switch (opcionTiro) {//Si la defensa no provoca una falta el programa se dirija a este switch dependiendo de la opcion de tiro
                case 1:
                    if (num <= (SALTO_LARGO - posibilidadDefensa)) {//Salto largo
                        System.out.println(nombre + " anotaste " + PUNTOS_SALTO_LARGO + " puntos");
                        puntosDeTiro =PUNTOS_SALTO_LARGO;
                    } else {
                        System.out.println(nombre + " fallaste el tiro");
                    }
                    break;
                case 2:
                    if (num <= (SALTO_CORTO - posibilidadDefensa)) {//Salto Corto
                        System.out.println(nombre + " anotaste " + PUNTOS_SALTO_CORTO + " puntos");
                        puntosDeTiro =PUNTOS_SALTO_CORTO;
                    } else {
                        System.out.println(nombre + " fallaste el tiro");
                    }
                    break;
            }
            String Esperar = scanner.nextLine();
        }

        return puntosDeTiro;//Este metodo devuelve los puntos que se anotaron en ese turno
    }

    /* JUEGO
        DE
      CARTAS */
    private static void jugarCartas() {
        int dinero = 0;
        int opcionCarta;
        int[] cartas = new int[3];
        System.out.println("Ingrese la Cantidad de Dinero con el que va jugar");
        dinero = scanner.nextInt();
        do {
            System.out.println("Dinero Actual: $" + dinero);//Por cada turno se muestra la cantidad de dinero actual
            System.out.println("[1] Repartir");
            System.out.println("[2] Retirar");
            opcionCarta = scanner.nextInt();
            if (opcionCarta == 1) {
                int apuesta = 0;
                //Do para que las primeras cartas no tengan el mismo valor, para que las posibilidades no sean minimas
                do {
                    cartas[0] = generarCarta();
                    cartas[1] = generarCarta();
                } while (cartas[0] == cartas[1]);
//Mostracion de las primeras dos cartas
                System.out.println(generarLetraDeCarta(cartas[0]) + generarSimboloDeCarta() + "  " + generarLetraDeCarta(cartas[1]) + generarSimboloDeCarta());
                System.out.println("Cuanto Deseas Apostar");
                System.out.println("(La carta siguiente debe encontrar entre el valor de estas dos cartas) ");
                apuesta = scanner.nextInt();
                do {
                    if (apuesta > dinero) {//en caso de que la apuesta sea mayor al dinero actual del jugador
                        System.out.println("No Cuentas Con Ese Dinero, Ingrese otra Cantidad");
                        apuesta = scanner.nextInt();
                    }
                } while (apuesta > dinero);
                if (apuesta != 0) {//si la apuesta es igual a 0 ya no se muestra la tercera carta
                    cartas[2] = generarCarta();
                    System.out.println(generarLetraDeCarta(cartas[2]) + generarSimboloDeCarta());
                    if (compararCartas(cartas[0], cartas[1], cartas[2])) {//llama el metodo para comparar las tres cartas
                        System.out.println("Ganaste");//si la comparacion es verdader
                        dinero = dinero + apuesta;
                        System.out.println("+" + apuesta);
                    } else {//si la comparacion es falso
                        System.out.println("Perdiste");
                        dinero = dinero - apuesta;
                        System.out.println("-" + apuesta);
                    }
                    String Esperar = scanner.nextLine();
                    String Esperar1 = scanner.nextLine();
                }
            }
        } while (dinero > 0 && opcionCarta == 1);
        if (dinero == 0) {//en caso de que el juego termine porque el apostador ya no tiene dinero
            System.out.println("PERDISTE TODO TU DINERO");
        }
    }
    //Metodo que generar valores de cartas

    private static int generarCarta() {
        int numeroDeCarta = (int) (Math.random() * 13) + 1;
        return numeroDeCarta;
    }
    //Metodo para los valores que son letras (A,J,Q,K)

    private static String generarLetraDeCarta(int valorDeCarta) {
        String letra = null;
        switch (valorDeCarta) {
            case 1:
                letra = "A";
                break;
            case 11:
                letra = "J";
                break;
            case 12:
                letra = "Q";
                break;
            case 13:
                letra = "K";
                break;
            default:
                letra = String.valueOf(valorDeCarta);
        }
        return letra;
    }
    //Metodo que genera simbolos alzar

    private static String generarSimboloDeCarta() {
        String simbolo = null;
        switch ((int) (Math.random() * 4) + 1) {
            case 1:
                simbolo = "♠";
                break;
            case 2:
                simbolo = "♦";
                break;
            case 3:
                simbolo = "♣";
                break;
            case 4:
                simbolo = "♥";
                break;
        }
        return simbolo;
    }
    //Tenido las tres cartas de parametro, este metodo las compara y devuelve un boolean idicando si el jugador gano o no

    private static boolean compararCartas(int carta1, int carta2, int carta3) {
        boolean bandera = false;
        if (carta1 <= carta3 && carta3 <= carta2 || carta2 <= carta3 && carta3 <= carta1 ) {
            bandera = true;
        }
        return bandera;
    }

    /*TORRES
     DE
     HANOI*/
    private static void jugarHanoi() {
        int espacios[] = new int[3];
        int cantidadDeMovimientos = 0;
        System.out.println("Ingrese la cantidad de Discos Que Desea ");
        int numeroDiscos = scanner.nextInt();
        int torres[][] = new int[3][numeroDiscos];      //matriz en la que la primera dimension son las 3 torres y la otra dimension representa las capacidades que tendra cada torre
        for (int i = 0; i < numeroDiscos; i++) {        //fori para que empezar el juego con todos los discos en la primera torre
            torres[0][i] = numeroDiscos - i;
        }
        espacios[0] = numeroDiscos;//al empezar solo un espacio estara ocupado
        espacios[1] = 0;
        espacios[2] = 0;
        while (espacios[1] != numeroDiscos && espacios[2] != numeroDiscos) {//se mantendra jugando hasta el espacio 1 o 2 esten llenos
            System.out.println("cantidad de movimientos: " + cantidadDeMovimientos);
            dibujarTorresConDiscos(espacios, torres);   //llama el metodo para dibujar las torres en cada turno
            System.out.println("");
            System.out.println("");
            //Movimientos
            System.out.println("Ingrese el Numero De torre que deseas sacar el disco");
            int torreInicial = scanner.nextInt();   //el jugador debe elejir dos torres para relizar su movimiento
            System.out.println("Ingrese la torre de Destino");
            int torreFinal = scanner.nextInt();
            torreInicial--; //se le resta 1 a cada variable porque los arreglos empiezan con 0
            torreFinal--;
            if (verificarMovimientoValido(torreInicial, torreFinal, espacios, torres)) {//llama el metodo que devuelve un true si el movimeinto es valido
                cantidadDeMovimientos++;
                torres[torreFinal][espacios[torreFinal]] = torres[torreInicial][espacios[torreInicial] - 1];//movimeinto del disco
                espacios[torreInicial] = espacios[torreInicial] - 1;
                espacios[torreFinal] = espacios[torreFinal] + 1;
            } else {    //en caso de que el movimiento es invalido
                System.out.println("Movimiento Invalido");
                String Esperar = scanner.nextLine();
                String Esperar1 = scanner.nextLine();
            }
        }
        dibujarTorresConDiscos(espacios, torres);
        System.out.println(" ");
//Al momento de ganar se imprime la cantidad de movimientos que el jugador hizo
        System.out.println("Felicidades");
        System.out.println("cantidad total de movimientos:" + cantidadDeMovimientos);
        String Esperar = scanner.nextLine();
        String Esperar1 = scanner.nextLine();
    }
    //Metodo que imprime los discos teniendo como parametro la cantidad de discos

    private static void dibujarTorresConDiscos(int espacios[], int torres[][]) {
        for (int i = 0; i < 3; i++) {
            System.out.println("");
            System.out.println("    TORRE " + (i + 1));
            if (espacios[i] == 0) {
                System.out.println("");
            } else {
                for (int j = espacios[i] - 1; j > -1; j--) {
                    System.out.println("");
                    for (int k = 0; k < torres[i][j]; k++) {//este fori hace que no existan limites de discos para el jugador
                        System.out.print("▄▄");
                    }
                }
            }
        }

    }
    //Metodo que devuelve un true si el movimiento que jugador desea realizar es valido

    private static boolean verificarMovimientoValido(int torreInicial, int torreFinal, int espacio[], int torre[][]) {
        boolean valido = true;
        if (torreInicial < 0 || torreInicial > 2 || torreFinal < 0 || torreFinal > 2) { //Esta condicion verifica que el numero de torre sea valido
            valido = false;
        } else if (espacio[torreInicial] == 0) {//Condicion que verifica que exista al menos un disco en la torre
            valido = false;
        } else if (espacio[torreFinal] != 0) {
            if (torre[torreFinal][espacio[torreFinal] - 1] < torre[torreInicial][espacio[torreInicial] - 1]) { //Verificacion de que el disco de la torre final sea mayor al del inicial
                valido = false;
            }
        }
        return valido;
    }
}
