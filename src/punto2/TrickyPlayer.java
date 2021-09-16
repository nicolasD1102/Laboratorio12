/*
 * Programa: Punto 2 del Laboratorio 12
 * Autor: Miguel Nicolas Diaz Vargas
 * Fecha: Agosto 10 de 2021
 */

package punto2;

public class TrickyPlayer {

	// creacion de variables de instancia
	private String nickname1 = "";
	private String nickname2 = "";
	private int puntaje1 = 0;
	private int puntaje2 = 0;
	private int ganador = 0;
	int matrix[][];

	// creacion de metodo constructor
	TrickyPlayer(String nickname1, String nickname2) {
		this.nickname1 = nickname1;
		this.nickname2 = nickname2;
		matrix = new int[3][3];
		reiniciarJuego();
	}

	// metodo para reinicia posiciones de la matriz
	void reiniciarJuego() {
		matrix[0][0] = 0;
		matrix[0][1] = 0;
		matrix[0][2] = 0;
		matrix[1][0] = 0;
		matrix[1][1] = 0;
		matrix[1][2] = 0;
		matrix[2][0] = 0;
		matrix[2][1] = 0;
		matrix[2][2] = 0;
	}

	// metodo para determinar si hay algun ganador
	int ganador(int jugador, int posicionx, int posiciony) {

		// coloca la posicion elegida
		matrix[posicionx][posiciony] = jugador;

		// condicionesp para que gane el jugador 1
		if ((matrix[0][0] == 1 && matrix[1][1] == 1 && matrix[2][2] == 1)
				|| (matrix[0][2] == 1 && matrix[1][1] == 1 && matrix[2][0] == 1)
				|| (matrix[0][0] == 1 && matrix[1][0] == 1 && matrix[2][0] == 1)
				|| (matrix[0][1] == 1 && matrix[1][1] == 1 && matrix[2][1] == 1)
				|| (matrix[0][2] == 1 && matrix[1][2] == 1 && matrix[2][2] == 1)
				|| (matrix[0][0] == 1 && matrix[0][1] == 1 && matrix[0][2] == 1)
				|| (matrix[1][0] == 1 && matrix[1][1] == 1 && matrix[1][2] == 1)
				|| (matrix[2][0] == 1 && matrix[2][1] == 1 && matrix[2][2] == 1)) {
			ganador = 1; // determinacion de ganador
			puntaje1 = puntaje1 + 1; // contador de puntje
			reiniciarJuego(); // metodo para reiniciar juego si hay ganador
			return 1;
		// condicionesp para que gane el jugador 1
		} else if ((matrix[0][0] == 2 && matrix[1][1] == 2 && matrix[2][2] == 2)
				|| (matrix[0][2] == 2 && matrix[1][1] == 2 && matrix[2][0] == 2)
				|| (matrix[0][0] == 2 && matrix[1][0] == 2 && matrix[2][0] == 2)
				|| (matrix[0][1] == 2 && matrix[1][1] == 2 && matrix[2][1] == 2)
				|| (matrix[0][2] == 2 && matrix[1][2] == 2 && matrix[2][2] == 2)
				|| (matrix[0][0] == 2 && matrix[0][1] == 2 && matrix[0][2] == 2)
				|| (matrix[1][0] == 2 && matrix[1][1] == 2 && matrix[1][2] == 2)
				|| (matrix[2][0] == 2 && matrix[2][1] == 2 && matrix[2][2] == 2)) {
			ganador = 2; // determinacion de ganador
			puntaje2 = puntaje2 + 1; // contador de puntje
			reiniciarJuego(); // metodo para reiniciar juego si hay ganador
			return 1;
		// para reiniciar juego si no hay ganador
		} else if ((matrix[0][0] != 0 && matrix[0][1] != 0 && matrix[0][2] != 0 && matrix[1][0] != 0
				&& matrix[1][1] != 0 && matrix[1][2] != 0 && matrix[2][0] != 0 && matrix[2][1] != 0
				&& matrix[2][2] != 0)) {
			
			return 0;
		// si no hay ganador y todavia hay espacio para jugar
		} else {
			return 3;
		}

	}

	// creacion de metodos getters y setters
	public String getNickname1() {
		return nickname1;
	}

	public void setNickname1(String nickname1) {
		this.nickname1 = nickname1;
	}

	public String getNickname2() {
		return nickname2;
	}

	public void setNickname2(String nickname2) {
		this.nickname2 = nickname2;
	}

	public int getPuntaje1() {
		return puntaje1;
	}

	public void setPuntaje1(int puntaje1) {
		this.puntaje1 = puntaje1;
	}

	public int getPuntaje2() {
		return puntaje2;
	}

	public void setPuntaje2(int puntaje2) {
		this.puntaje2 = puntaje2;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public int getGanador() {
		return ganador;
	}

	public void setGanador(int ganador) {
		this.ganador = ganador;
	}

}
