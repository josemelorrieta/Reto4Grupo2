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
	
	/**
	 * Metodo que devuelve el nombre del cliente
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que cambia el nombre del cliente
	 * @param nombre nuevo nombre para el cliente
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo que devuelve el DNI del cliente
	 * @return dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Metodo que cambia el DNI del cliente
	 * @param dni nuevo dni para el cliente
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Metodo que devuelve los apellidos del cliente
	 * @return apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Metodo que cambia los apellidos del cliente
	 * @param apellidos nuevos apellidos para el cliente
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Metodo que devuelve la fecha de nacimiento del cliente
	 * @return fechaNac
	 */
	public Date getFechaNac() {
		return fechaNac;
	}

	/**
	 * Metodo que cambia la fecha de nacimiento del cliente
	 * @param fechaNac nueva fecha de nacimiento para el cliente
	 */
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	/**
	 * Metodo que devuelve el sexo del cliente
	 * @return sexo
	 */
	public Sexo getSexo() {
		return sexo;
	}

	/**
	 * Metodo que cambia el sexo del cliente
	 * @param sexo nuevo sexo para el cliente
	 */
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	/**
	 * Metodo que devuelve la contrasenia del cliente
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Metodo que cambia la contrasenia del cliente
	 * @param password nueva contrasenia para el cliente
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
