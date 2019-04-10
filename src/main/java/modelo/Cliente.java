package modelo;

import java.sql.Date;

public class Cliente {
	private String dni;
	private String nombre;
	private String apellidos;
	private Date fechaNac;
	private Sexo sexo;

	
	public Cliente() {
	}
	
	public Cliente(String nombre) {
		this.nombre = nombre;
	}

	public Cliente(String dni, String nombre, String apellidos, Date fechaNac, Sexo sexo) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNac = fechaNac;
		this.sexo = sexo;
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
	
	public Object[] toArray() {
		Object[] objetos= {dni,nombre,apellidos,fechaNac,sexo.toString()};
		return objetos;
	}
}
