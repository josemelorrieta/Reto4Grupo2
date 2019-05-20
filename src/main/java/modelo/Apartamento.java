package modelo;

/**
 * Clase Apartamento que extiende casa con el atribudo adicional pisp
 *
 */
public class Apartamento extends Casa{
	private int piso;

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}
}
