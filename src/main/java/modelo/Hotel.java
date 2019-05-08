package modelo;

public class Hotel extends Alojamiento {
	
	private int numEstrellas;
	
	protected double[] precioBase;
	protected double[] pvpTotalHab;

	public int getNumEstrellas() {
		return numEstrellas;
	}

	public void setNumEstrellas(int estrellas) {
		this.numEstrellas = estrellas;
	}

	public double[] getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase() {
		if(habitaciones != null) {
			precioBase = new double[habitaciones.length];
			for(int i=0;i<precioBase.length;i++) 
				precioBase[i] = habitaciones[i].getM2() * pvpM2;
		}
	}

	public double[] getPvpTotalHab() {
		return pvpTotalHab;
	}

	public void setPvpTotalHab() {
		if(habitaciones != null) {
			pvpTotalHab = new double[habitaciones.length];
			for(int i=0;i<pvpTotalHab.length;i++) {
				//pvpTotalHab[i] = ;
			}	
			pvpTotal = pvpTotalHab[0];
			for(double d:pvpTotalHab) 
				if(pvpTotal>d)
					pvpTotal = d;
		}
	}

}
