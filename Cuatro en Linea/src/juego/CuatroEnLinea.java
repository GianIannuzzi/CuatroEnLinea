package juego;

/**
 * Juego Cuatro en Lí­nea
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
	 * 		 Todo el tablero está vacío.
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
	 * post: devuelve la cantidad máxima de fichas que se pueden apilar en el tablero.
	 */
	public int contarFilas() {
		return tablero.length;
	}

	/**
	 * post: devuelve la cantidad máxima de fichas que se pueden alinear en el tablero.
	 */
	public int contarColumnas() {
		return tablero[0].length;
	}

	/**
	 * pre : fila está en el intervalo [1, contarFilas()],
	 * 		 columnas está en el intervalo [1, contarColumnas()].
	 * post: indica qué ocupa el casillero en la posición dada por fila y columna.
	 * 
	 * @param fila
	 * @param columna
	 */
	public Casillero obtenerCasillero(int fila, int columna) {
		return tablero[fila - 1][columna - 1];
	}
	
	/**
	 * pre : el juego no terminó, columna está en el intervalo [1, contarColumnas()]
	 * 		 y aún queda un Casillero.VACIO en la columna indicada. 
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
	 * post: indica si el juego terminó porque uno de los jugadores
	 * 		 ganó o no existen casilleros vacíos.
	 */
	public boolean termino() {
		boolean partidaTerminada = false;
		if((comprobarSiCasillerosEstanLlenos() == true)) {
			partidaTerminada = true;
		}
		return partidaTerminada;
	}

	/**
	 * post: indica si el juego terminó y tiene un ganador.
	 */
	public boolean hayGanador() {
		for(int i = 0; i < tablero.length; i++) {
			for(int j = 0; j < tablero[i].length; j++) {
		
			}
		}
		return false;
	}

	/**
	 * pre : el juego terminó.
	 * post: devuelve el nombre del jugador que ganó el juego.
	 */
	public String obtenerGanador() {
		
		return null;
	}
}
