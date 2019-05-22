package modelo;

/**
 * Clase Apartamento que extiende casa con el atributo adicional piso
 *
 */
public class Apartamento extends Casa{
	private int piso;

	/**
	 * Metodo que devuelve el piso del apartamento
	 * @return piso
	 */
	public int getPiso() {
		return piso;
	}

	/**
	 * Metodo que cambia el piso del alojamiento
	 * @param piso nuevo piso para la casa
	 */
	public void setPiso(int piso) {
		this.piso = piso;
	}
}
