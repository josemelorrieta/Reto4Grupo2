package modelo;

public class Casa extends Alojamiento{
	protected Habitacion[] habitaciones;
	protected int numBanios;
	protected int m2;
	
	public Casa() {
		
	}
	
	public Casa(int id, String nombre, Direccion direccion, double precioA, double precioB, double precioF, String imagen, boolean disponible) {
		super(id, nombre, direccion, precioA, precioB, precioF, imagen, disponible);
	}
	
	public Casa(int id, String nombre, Direccion direccion, double precioA, double precioB, double precioF, String imagen, boolean disponible, Habitacion[] habitaciones, int numBanios, int m2) {
		super(id, nombre, direccion, precioA, precioB, precioF, imagen, disponible);
		this.habitaciones = habitaciones;
		setNumBanios();
		setM2();
	}

	public Habitacion[] getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(Habitacion[] habitaciones) {
		this.habitaciones = habitaciones;
	}	

	public int getNumBanios() {
		return numBanios;
	}

	public void setNumBanios() {
		for(Habitacion habitacion:habitaciones) {
			if(habitacion.tipoHabitacion==TipoHabitacion.BANIO)
				numBanios++;
		}
	}

	public int getM2() {
		return m2;
	}
	
	public int numCamas() {
		int cont=0;
		for(Habitacion hab:this.habitaciones) {
			if(hab.tipoHabitacion==TipoHabitacion.DORMITORIO) {
				for(Mobiliario mobi: ((Dormitorio) hab).getMobiliario()) {
					if(mobi instanceof Cama) {
						cont+=1;
					}
				}
			}
		}
		return cont;
	}

	public void setM2() {
		for(Habitacion habitacion:habitaciones) 
			m2 += habitacion.getM2();
	}
	
}
