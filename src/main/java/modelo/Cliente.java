package modelo;

import java.util.Date;

/**
 * Clase Cliente donde se guarda toda la informacion del cliente
 *
 */
public class Cliente {
	private String dni;
	private String nombre;
	private String apellidos;
	private Date fechaNac;
	private Sexo sexo;
	private String password;

	/**
	 * Constructor vacio
	 */
	public Cliente() {
	}

	/**
	 * Crea un cliente vacio solo con el nombre
	 * @param nombre string
	 */
	public Cliente(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Cliente con los parametros basico de dni nombre y apellidos
	 * @param dni string
	 * @param nombre string 
	 * @param apellidos string
	 */
	public Cliente(String dni, String nombre, String apellidos) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	/**
	 * Cliente con todos los parametros
	 * @param dni string
	 * @param nombre string
	 * @param apellidos string
	 * @param fechaNac string
	 * @param sexo string
	 * @param password string
	 */
	public Cliente(String dni, String nombre, String apellidos, Date fechaNac, Sexo sexo, String password) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNac = fechaNac;
		this.sexo = sexo;
		this.password = password;
	}


	/**
	 * Mete todos los datos del cliente en un array de objetos
	 * @return array de Object
	 */
	public Object[] toArray() {
		Object[] objetos = { dni, nombre, apellidos, fechaNac, new Date(), sexo.toString(), password };
		return objetos;
	}
	
	/**
	 * Mete los datos basico necesarios para el cliente extra en un array de objetos, usar en el parametro del insert generico
	 * @return array de Object
	 */
	public Object[] toArrayClienteExtra() {
		Object[] objetos = { dni, nombre, apellidos};
		return objetos;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
