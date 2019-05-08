package modelo;

public class Habitacion {
	
	protected int idHab;
	protected int m2;
	protected TipoHabitacion tipoHab;
	protected Mobiliario[] mobiliario;
	
	protected boolean disponible;
	protected double pvpTotalMobiliario;
	
	public int getIdHab() {
		return idHab;
	}

	public void setIdHab(int idHab) {
		this.idHab = idHab;
	}

	public int getM2() {
		return m2;
	}
	
	public void setM2(int m2) {
		this.m2 = m2;
	}

	public TipoHabitacion getTipoHab() {
		return tipoHab;
	}
	
	public void setTipoHab(TipoHabitacion tipoHab) {
		this.tipoHab = tipoHab;
	}
	
	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public Mobiliario[] getMobiliario() {
		return mobiliario;
	}

	public void setMobiliario(Mobiliario[] mobiliario) {
		this.mobiliario = mobiliario;
	}

	public double getPvpTotalMobiliario() {
		return pvpTotalMobiliario;
	}

	public void setPvpTotalMobiliario() {
		if(mobiliario != null) {
			for(Mobiliario mob:mobiliario) 
				pvpTotalMobiliario += mob.getPvpMob();
		}
	}
	
}
