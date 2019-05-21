package modelo;

/**
 * Clase Global
 * Clase auxiliar para recoger uno o mas (hasta 3) datos de la base de datos con los Json
 *
 */
public class Global {
	private Object auxiliar;
	private Object auxiliar2;
	private Object auxiliar3;

	/**
	 * Metodo que devuelve el primer objeto auxiliar
	 * @return auxiliar
	 */
	public Object getAuxiliar() {
		return auxiliar;
	}

	/**
	 * Metodo que cambia el primer objeto auxiliar
	 * @param auxiliar
	 */
	public void setAuxiliar(Object auxiliar) {
		this.auxiliar = auxiliar;
	}
	
	/**
	 * Metodo que devuelve el segundo objeto auxiliar
	 * @return auxiliar2
	 */
	public Object getAuxiliar2() {
		return auxiliar2;
	}

	/**
	 * Metodo que cambia el segundo objeto auxiliar
	 * @param auxiliar2
	 */
	public void setAuxiliar2(Object auxiliar) {
		this.auxiliar2 = auxiliar;
	}
	
	/**
	 * Metodo que devuelve el tercer objeto auxiliar
	 * @return auxiliar3
	 */
	public Object getAuxiliar3() {
		return auxiliar3;
	}

	/**
	 * Metodo que cambia el tercer objeto auxiliar
	 * @param auxiliar3
	 */
	public void setAuxiliar3(Object auxiliar) {
		this.auxiliar3 = auxiliar;
	}
	
}
