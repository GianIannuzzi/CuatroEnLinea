package juego;

/**
 * Juego Cuatro en L�nea
 * 
 * Reglas:
 * 
 * 		...
 *
 */
public class CuatroEnLinea {
	
	private Casillero[][] tablero;
	private String nombreRojo;
	private String nombreAmarillo;
	
	private Casillero jugadorActual;
	

	/**
	 * pre : 'filas' y 'columnas' son mayores o iguales a 4.
	 * post: empieza el juego entre el jugador que tiene fichas rojas, identificado como 
	 * 		 'jugadorRojo' y el jugador que tiene fichas amarillas, identificado como
	 * 		 'jugadorAmarillo'. 
	 * 		 Todo el tablero est� vac�o.
	 * 
	 * @param filas : cantidad de filas que tiene el tablero.
	 * @param columnas : cantidad de columnas que tiene el tablero.
	 * @param jugadorRojo : nombre del jugador con fichas rojas.
	 * @param jugadorAmarillo : nombre del jugador con fichas amarillas.
	 */
	public CuatroEnLinea(int filas, int columnas, String jugadorRojo, String jugadorAmarillo) {
		tablero = new Casillero[filas][columnas];
		for(int i = 0; i < tablero.length; i++) {
			for(int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = Casillero.VACIO;
			}
		}
		jugadorActual = Casillero.ROJO;
		nombreRojo = jugadorRojo;
		nombreAmarillo = jugadorAmarillo;
	}
	
	private void cambioDeJugador() {
		if(jugadorActual == Casillero.ROJO) {
			jugadorActual = Casillero.AMARILLO;
		} else {
			jugadorActual = Casillero.ROJO;
		}
	}
	
	private boolean comprobarSiCasillerosEstanLlenos() {
		boolean casillerosLlenos = true;
		for(int i = 0; i < tablero.length; i++) {
			for(int j = 0; j < tablero[i].length; j++) {
				if(tablero[i][j] == Casillero.VACIO) {
					casillerosLlenos = false;
				}
			}
		}
		return casillerosLlenos;
	}
	

	/**
	 * post: devuelve la cantidad m�xima de fichas que se pueden apilar en el tablero.
	 */
	public int contarFilas() {
		return tablero.length;
	}

	/**
	 * post: devuelve la cantidad m�xima de fichas que se pueden alinear en el tablero.
	 */
	public int contarColumnas() {
		return tablero[0].length;
	}

	/**
	 * pre : fila est� en el intervalo [1, contarFilas()],
	 * 		 columnas est� en el intervalo [1, contarColumnas()].
	 * post: indica qu� ocupa el casillero en la posici�n dada por fila y columna.
	 * 
	 * @param fila
	 * @param columna
	 */
	public Casillero obtenerCasillero(int fila, int columna) {
		return tablero[fila - 1][columna - 1];
	}
	
	/**
	 * pre : el juego no termin�, columna est� en el intervalo [1, contarColumnas()]
	 * 		 y a�n queda un Casillero.VACIO en la columna indicada. 
	 * post: deja caer una ficha en la columna indicada.
	 * 
	 * @param columna
	 */
	public void soltarFicha(int columna) {
		boolean finDeLaJugada = false;
		for(int i = tablero.length - 1; (i >= 0) && (finDeLaJugada == false); i--) {
			if(tablero[i][columna - 1] == Casillero.VACIO) {
				tablero[i][columna - 1] = jugadorActual;
				finDeLaJugada = true;
				cambioDeJugador();
			}
		}
	}
	
	/**
	 * post: indica si el juego termin� porque uno de los jugadores
	 * 		 gan� o no existen casilleros vac�os.
	 */
	public boolean termino() {
		boolean partidaTerminada = false;
		if((comprobarSiCasillerosEstanLlenos() == true)) {
			partidaTerminada = true;
		}
		return partidaTerminada;
	}

	/**
	 * post: indica si el juego termin� y tiene un ganador.
	 */
	public boolean hayGanador() {
		for(int i = 0; i < tablero.length; i++) {
			for(int j = 0; j < tablero[i].length; j++) {
		
			}
		}
		return false;
	}

	/**
	 * pre : el juego termin�.
	 * post: devuelve el nombre del jugador que gan� el juego.
	 */
	public String obtenerGanador() {
		
		return null;
	}
}
