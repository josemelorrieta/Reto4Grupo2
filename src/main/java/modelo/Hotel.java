package modelo;

import java.util.Vector;

public class Hotel extends Alojamiento {
	private int numEstrellas;
	private Vector<Vector<Dormitorio>> matrix = new Vector<Vector<Dormitorio>>();

	public Vector<Vector<Dormitorio>> getMatrix() {
		return matrix;
	}


	public void setMatrix(Vector<Vector<Dormitorio>> matrix) {
		this.matrix = matrix;
	}

	public int getNumEstrellas() {
		return numEstrellas;
	}

	public void setNumEstrellas(int estrellas) {
		this.numEstrellas = estrellas;
	}

}
