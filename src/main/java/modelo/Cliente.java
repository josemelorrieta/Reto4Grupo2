package modelo;

import java.util.Date;

public class Cliente {
	private String dni;
	private String nombre;
	private String apellidos;
	private Date fechaNac;
	private Sexo sexo;
	private String password;
	
	public Cliente() {
	}
	
	public Cliente(String nombre) {
		this.nombre = nombre;
	}

	public Cliente(String dni, String nombre, String apellidos, Date fechaNac, Sexo sexo, String password) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNac = fechaNac;
		this.sexo = sexo;
		this.password = password;
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
