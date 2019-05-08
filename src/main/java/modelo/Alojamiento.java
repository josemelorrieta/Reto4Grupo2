package modelo;

public class Alojamiento {
	protected int id;
	protected String nombre;
	protected Direccion direccion;
	protected double pvpTAlta;
	protected double pvpTBaja;
	protected double pvpRecFestivo;
	protected double pvpM2;
	protected String imagen;
	protected Habitacion[] habitaciones;
	
	protected double pvpTotal;
	protected boolean disponible;
	protected int numCamas;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public double getPvpTAlta() {
		return pvpTAlta;
	}

	public void setPvpTAlta(double pvpTAlta) {
		this.pvpTAlta = pvpTAlta;
	}

	public double getPvpTBaja() {
		return pvpTBaja;
	}

	public void setPvpTBaja(double pvpTBaja) {
		this.pvpTBaja = pvpTBaja;
	}

	public double getPvpRecFestivo() {
		return pvpRecFestivo;
	}

	public void setPvpRecFestivo(double pvpRecFestivo) {
		this.pvpRecFestivo = pvpRecFestivo;
	}

	public double getPvpM2() {
		return pvpM2;
	}

	public void setPvpM2(double pvpM2) {
		this.pvpM2 = pvpM2;
	}

	public double getPvpTotal() {
		return pvpTotal;
	}

	public void setPvpTotal() {
		// setPvp en base a dias * (temp + pvpBase + pvpMob + festivo??)
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public Habitacion[] getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(Habitacion[] habitaciones) {
		this.habitaciones = habitaciones;
	}
	
	public int getNumCamas() {
		return numCamas;
	}
	
	public void setNumCamas() {
		if (habitaciones != null)
			for (Habitacion hab : habitaciones) 
				if (hab.tipoHab == TipoHabitacion.DORMITORIO) 
					if (hab.getMobiliario() != null) 
						for (Mobiliario mob : hab.getMobiliario()) 
							if (mob instanceof Cama) 
								numCamas++;
	}

}
