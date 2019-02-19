Inicio LibreriaJuegos
	var opcionJuego
	Mientras opcionJuego!=5 Hacer
		Escribir 'BIENVENIDO'
		Escribir 'Elija un Juego'
		Escribir '[1] Ahorcado'
		Escribir '[2] Basketball'
		Escribir '[3] Juego de Cartas'
		Escribir '[4] Hanoi'
		Escribir '[5] Salir '
		Leer opcionJuego
		Segun opcionJuego  Hacer
			1:
				Escribir 'AHORCADO'
				JuegoAhorcado()
			2:
				Escribir 'BASKETBALL'
				JugarBasketball()
			3:
				Escribir 'JUEGO DE CARTAS'
				JugarCartas()
			4:
				Escribir 'HANOI'
				JugarHanoi()
			5:
				Escribir 'Regrese Pronto'
			De Otro Modo:
				Escribir 'Porfavor ingrese un numero del 1-5'
		FinSegun
	FinMientras
Fin

				// Ahorcado
Funcion JuegoAhorcado()
	texto  palabra
	var  longitudPalabra
	var  intentos=0
	aciertos  0
	oportunidades  6
	Escribir 'ingrese la palabra: (sin que el jugador lo vea,3-10 letras)'
	Leer palabra
	longitudPalabra = Longitud(palabra)
	Dimension casillas[longitudPalabra]
	Para i<-1 Hasta longitudPalabra Hacer
		casillas[i] = '_'
	FinPara
	Repetir
		Escribir 'intentos: ',intentos,'/',oportunidades
		texto = letra
		Para i<-1 Hasta longitudPalabra Hacer
			Escribir casillas[i],' ' Sin Saltar
		FinPara
		Escribir 'Ingrese una letra'
		Leer letra
		encontrando <- Falso
		Para i<-1 Hasta longitudPalabra Hacer
			buscador <- Subcadena(palabra,i,i)
			Si verificarPalabraAdivinada(palabra,letra) Entonces
				aciertos <- longitudPalabra
			SiNo
				Si verificarLetraAdivinada(buscador,letra) Entonces
					encontrando <- verdadero
					Si casillas[i]='_' Entonces
						casillas[i] <- buscador
						aciertos <- aciertos+1
					FinSi
				FinSi
			FinSi
		FinPara
		Si  NO encontrando Entonces
			intentos <- intentos+1
			Escribir 'Letra no encontrada.'
		FinSi
	Hasta Que intentos>=oportunidades O aciertos=longitudPalabra
	Si aciertos=longitudPalabra Entonces
		Escribir palabra
		Escribir 'Felicidades, has ganado'
	SiNo
		Escribir 'La palabra era',palabra
		Escribir 'Has perdido.'
	FinSi
	Esperar Tecla
FinFuncion

Funcion bandera = verificarPalabraAdivinada(palabra,palabraAdivinada)
	bandera = Falso
	Si palabra=palabraAdivinada Entonces
		bandera = verdadero
	FinSi
FinFuncion

Funcion bandera = verificarLetraAdivinada(letra,letraAdivinada)
	bandera = Falso
	Si letra=letraAdivinada Entonces
		bandera = verdadero
	FinSi
FinFuncion

				// juego de basketball
Funcion JugarBasketball()
	texto = nombreJugador1
	var = puntosJugador1=0
	texto = nombreJugador2
	var = puntosJugador2=0
	var = numDeRondas=0
	Escribir 'Jugador1 ingrese su nombre'
	Leer nombreJugador1
	Escribir 'Jugador2 ingrese su nombre'
	Leer nombreJugador2
	Escribir 'cuantas rondas desea jugar?'
	Leer numDeRondas
	var <- orden<-azar(2)+1
	orden <- azar(2)+1
	var <- jugadorTirando
	var <- jugadorDefendiendo
	Para i<-0 Hasta 2*numDeRondas Hacer
		Borrar Pantalla
		Escribir nombreJugador1,': ',puntosJugador1,'     ',nombreJugador2,':',puntosJugador2
		Segun orden  Hacer
			1:
				jugadorTirando <- nombreJugador1
				jugadorDefendiendo <- nombreJugador2
				orden <- 2
			2:
				jugadorTirando <- nombreJugador2
				jugadorDefendiendo <- nombreJugador1
				orden <- 1
		FinSegun
		Escribir jugadorTirando,' es tu turno de tirar'
		Escribir '[1] Salto Largo'
		Escribir '[2] Salto Corto'
		Leer opciontiro
		x <- DefensaBasket(jugadorDefendiendo)
		puntosDelTiro <- TiroBasket(opciontiro,x,jugadorTirando)
		Esperar Tecla
		Si jugadorTirando=nombreJugador1 Entonces
			puntosJugador1 <- puntosJugador1+puntosDelTiro
		SiNo
			puntosJugador2 <- puntosJugador2+puntosDelTiro
		FinSi
	FinPara
	Escribir nombreJugador1,': ',puntosJugador1,'     ',nombreJugador2,':',puntosJugador2
	Si puntosJugador1>puntosJugador2 Entonces
		Escribir nombreJugador1,' Felicidades ganaste'
	SiNo
		Si puntosJugador2>puntosJugador1 Entonces
			Escribir nombreJugador2,' Felicidades ganaste'
		SiNo
			Escribir 'quedaron empatados'
		FinSi
	FinSi
	Esperar Tecla
FinFuncion

Funcion puntosDeTiro  TiroBasket(numTiro,posibilidadDeDefensa,nombreDelJugador)
	puntosDeTiro = 0
	SALTOLARGO = 65
	PUNTOSSALTOLARGO = 3
	SALTOCORTO = 80
	PUNTOSSALTOCORTO = 2
	TIROLIBRE = 90
	PUNTOSTIROLIBRE = 2
	num <- azar(100)+1
	Si posibilidadDeDefensa=100 Entonces
		Escribir 'falta realizada'
		Escribir nombreDelJugador,' Enter para tirar Falta'
		Esperar Tecla
		Si num<=TIROLIBRE Entonces
			Escribir nombreDelJugador,' anotaste el tiro libre +2'
			puntosDeTiro <- PUNTOSTIROLIBRE
		SiNo
			Escribir nombreDelJugador,' fallaste el tiro libre'
			puntosDeTiro <- 0
		FinSi
	SiNo
		Segun numTiro  Hacer
			1:
				Si num<=(SALTOLARGO-posibilidadDeDefensa) Entonces
					Escribir nombreDelJugador,' anotaste 3 puntos'
					puntosDeTiro <- PUNTOSSALTOLARGO
				SiNo
					Escribir nombreDelJugador,' fallaste el tiro'
					puntosDeTiro <- 0
				FinSi
			2:
				Si num<=(SALTOCORTO-posibilidadDeDefensa) Entonces
					Escribir nombreDelJugador,' anotaste 2 puntos'
					puntosDeTiro <- PUNTOSSALTOCORTO
				SiNo
					Escribir nombreDelJugador,' fallaste el tiro'
					puntosDeTiro <- 0
				FinSi
		FinSegun
	FinSi
FinFuncion

Funcion posibilidadDefensa <- DefensaBasket(nombreJugadorDefendiendo)
	DEFCUERPO = 15
	FALTADEFCUERPO = 35
	DEFFUERTE = 30
	FALTADEFFUERTE = 65
	Escribir nombreJugadorDefendiendo,' te toca defender'
	Escribir '[1] Defensa Cuerpo a Cuerpo'
	Escribir '[2] Defensa Fuerte'
	Leer opcionDefensa
	// variable que sirve para calcular la posibilidad de falta
	num <- azar(100)+1
	Segun opcionDefensa  Hacer
		1:
			Si num<=FALTADEFCUERPO Entonces
				posibilidadDefensa <- 100
			SiNo
				posibilidadDefensa <- DEFCUERPO
			FinSi
		2:
			Si num<=FALTADEFFUERTE Entonces
				posibilidadDefensa <- 100
			SiNo
				posibilidadDefensa <- DEFFUERTE
			FinSi
	FinSegun
FinFuncion

			
			// Funcion para jugar cartas
Funcion JugarCartas()
	var dinero
	var opcionCartas
	var cartas[3]
	Escribir 'Ingrese la cantidad de dinero con el que va jugar'
	Leer dinero
	Repetir
		Escribir 'Dinero Actual: ',dinero
		Escribir '[1] Repatir'
		Escribir '[2] Retirar'
		Leer opcionCartas
		Si opcionCartas=1 Entonces
			var <- apuesta=0
			Repetir
				cartas[1] <- PedirCarta
				cartas[2] <- PedirCarta
			Hasta Que cartas[1]!=cartas[2]
			Escribir PedirLetradeCarta(cartas[1]),' ',PedirLetradeCarta(cartas[2])
			Escribir 'Cuanto Deseas Apostar? '
			Escribir '(La carta siguiente debe encontrar entre el valor de estas dos cartas)'
			Leer apuesta
			Repetir
				Si apuesta>dinero Entonces
					Escribir 'no cuentas con ese dinero Ingrese otra cantidad'
					Leer apuesta
				FinSi
			Hasta Que apuesta<=dinero
			cartas[3] <- PedirCarta
			Escribir PedirLetradeCarta(cartas[3])
			Si CompararCartas(cartas[1],cartas[2],cartas[3]) Entonces
				Escribir 'Felicidades Ganaste'
				dinero <- dinero+apuesta
				Escribir '+',(apuesta)
			SiNo
				Escribir 'Perdiste'
				dinero <- dinero-apuesta
				Escribir '-',apuesta
			FinSi
			Esperar Tecla
		FinSi
	Hasta Que opcionCartas=2 O dinero=0
	Si dinero=0 Entonces
		Escribir 'Perdiste todo tu dinero'
		Esperar Tecla
	FinSi
FinFuncion

// Funcion para pedir carta para el juego de cartas
Funcion numeroCarta <- PedirCarta
	numeroCarta <- azar(13)+1
FinFuncion

// Funcion para las cartas que son letras para el juego de cartas
Funcion LetradeCarta <- PedirLetradeCarta (numerodeCarta)
	Segun numerodeCarta  Hacer
		1:
			LetradeCarta <- 'A'
		11:
			LetradeCarta <- 'J'
		12:
			LetradeCarta <- 'Q'
		13:
			LetradeCarta <- 'K'
		De Otro Modo:
			LetradeCarta <- numerodeCarta
	FinSegun
FinFuncion

Funcion bandera <- CompararCartas(carta1,carta2,carta3)
	bandera <- Falso
	Si (carta1<=carta3 Y carta3<=carta2) O (carta2<=carta3 Y carta3<=carta1) Entonces
		bandera <- verdadero
	FinSi
FinFuncion



			// Juego de las torres de hanoi
Funcion JugarHanoi()
	var espacios[3]
	Escribir 'Ingrese la cantidad de discos que desea'
	Leer numeroDiscos
	var = cantidadMovimientos
	Dimension torres[3,numeroDiscos]
	Para i<-1 Hasta numeroDiscos Hacer
		torres[1,i]<-numeroDiscos+1-i
	FinPara
	espacios[1] = numeroDiscos
	espacios[2] = 0
	espacios[3] = 0
	Mientras espacios[2]<>numeroDiscos Y espacios[3]<>numeroDiscos Hacer
		Para i<-1 Hasta 3 Hacer
			Escribir ''
			Escribir '               Torre ',i
			Si espacios[i]=0 Entonces
				Escribir ''
			SiNo
				Para j<-espacios[i] Hasta 1 Con Paso -1 Hacer // recorrer los discos de la torre, de arriba hacia abajo
					Escribir ''
					DibujarDiscos(torres[i,j])
				FinPara
			FinSi
		FinPara
		Escribir ''
		Escribir ''
		Escribir ''
		// Movimiento
		var = torreInicial
		var = torreFinal
		Escribir 'Ingrese el Numero De torre que deseas sacar el disco'
		Leer torreInicial
		Escribir 'Ingrese la torre de Destino'
		Leer torreFinal
		Si VerificarMovimientoValido(torreInicial,torreFinal,espacios[],torres[][]) Entonces
			cant_movs = cant_movs+1
			espacios[torreFinal] = espacios[torreFinal]+1
			torres[torreFinal,espacios[torreFinal]]=torres[torreInicial,espacios[torreInicial]]
			espacios[torreInicial] = espacios[torreInicial]-1
		SiNo
			Escribir 'Movimiento Invalido'
		FinSi
	FinMientras
	Escribir 'Cantidad Total De Movimientos:',cantidadMovimientos
FinFuncion

Funcion DibujarDiscos(tamanoDisco)
	Para k<-1 Hasta tamanoDisco Hacer
		Escribir '00' Sin Saltar
	FinPara
FinFuncion

Funcion bandera = VerificarMovimientoValido(inicial,destino,espacio,torre)
	bandera <- verdadero
	Si inicial<1 O inicial>3 O destino<1 O destino>3 Entonces
		bandera <- Falso
	SiNo
	    Si espacio[inicial]=0 Entonces 
	        bandera=Falso
	    Sino
		Si espacio[destino]<>0 Entonces // controlar que la torre dos no tenga discos o tenga solo discos mas grandes
			Si torre[destino][espacio[destino]]<torre[inicial][espacio[inicial]] Entonces
				bandera <- Falso
			FinSi
		FinSi
	     FinSi
	 FinSi
FinFuncion

