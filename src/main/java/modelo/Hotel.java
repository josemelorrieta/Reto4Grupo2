package modelo;

import java.util.Vector;

/**
 * Clase Hotel extiende Alojamiento con el numero de estrellas y una matriz de habitaciones
 *
 */
public class Hotel extends Alojamiento {
	private int numEstrellas;
	private Vector<Vector<Dormitorio>> matrix = new Vector<Vector<Dormitorio>>();

	/**
	 * Metodo que devuelve la matriz de dormitorios del hotel
	 * @return matrix
	 */
	public Vector<Vector<Dormitorio>> getMatrix() {
		return matrix;
	}

	/**
	 * Metodo que cambia la matriz de dormitorios del hotel
	 * @param matrix
	 */
	public void setMatrix(Vector<Vector<Dormitorio>> matrix) {
		this.matrix = matrix;
	}

	/**
	 * Metodo que devuelve el numero de estrellas del hotel
	 * @return numEstrellas
	 */
	public int getNumEstrellas() {
		return numEstrellas;
	}

	/**
	 * Metodo que cambia el numero de estrellas del hotel
	 * @param estrellas
	 */
	public void setNumEstrellas(int estrellas) {
		this.numEstrellas = estrellas;
	}

}
