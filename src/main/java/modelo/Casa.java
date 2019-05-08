package modelo;

import java.util.Calendar;

public class Casa extends Alojamiento {

	protected int numBanios;
	protected int m2;
	protected double precioBase;

	public int getNumBanios() {
		return numBanios;
	}

	public void setNumBanios() {
		if(habitaciones != null) {
			for (Habitacion habitacion : habitaciones) 
				if (habitacion.tipoHab == TipoHabitacion.BANIO)
					numBanios++;	
		}
	}

	public int getM2() {
		return m2;
	}

	public void setM2() {
		if(habitaciones != null) {
			for (Habitacion habitacion : habitaciones)
				m2 += habitacion.getM2();
		}
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase() {
		precioBase = m2 * pvpM2;
	}

	/**
	 * Calcula el precio base de la casa
	 * 
	 * @param festivos array de fechas festivas
	 * @return el precio base de la casa, se le debe sumar el precio individual de
	 *         cada habitacion reservada, tiene en cuenta las habitaciones que no
	 *         sean dormitorios
	 */
	public double calcularPrecioBaseCasa(Calendar[] festivos) {
		Calendar fechaAct = Calendar.getInstance();
		double precio = 0, precioTemp = 0;

		if (fechaAct.get(Calendar.MONTH) > Calendar.MAY && fechaAct.get(Calendar.MONTH) < Calendar.OCTOBER) 
			precioTemp = this.pvpTAlta;
		else
			precioTemp = this.pvpTBaja;
		
		precio += precioTemp;

		for (Calendar fest : festivos) {
			if (fechaAct.equals(fest)) 
				precio += precioTemp * 1.75;
		}
		
		return precio;
	}


}
