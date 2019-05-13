package modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import util.FuncionesGenerales;

public class DesglosePrecio {
	private double pBaseAloj;
	private double pEquipamiento;

	private int noches;

	private double pBaseFestivos;
	private int numFestivos;
	private double totalExtraFestivos;
	private String temporada;
	private boolean codPromocional;

	// wifi etc
	private double precioExtras;

	private double total;

	// public double

	public DesglosePrecio() {

	}

	public DesglosePrecio(Alojamiento aloj, Date fechanEnt, Date fechaSal, Dormitorio dormHotel, Calendar[] festivos) {
		Calendar fechaEntrada = Calendar.getInstance();
		Calendar fechaSalida = Calendar.getInstance();

		fechaEntrada.setTime(fechanEnt);
		fechaSalida.setTime(fechaSal);

		if (fechaEntrada.get(Calendar.MONTH) > Calendar.MAY && fechaEntrada.get(Calendar.MONTH) < Calendar.OCTOBER) {
			this.pBaseAloj = aloj.getPrecioTAlta();
			this.setTemporada("Alta");
		} else {
			this.pBaseAloj = aloj.getPrecioTBaja();
			this.setTemporada("Baja");
		}

		if (aloj instanceof Hotel && dormHotel != null) {
			this.pEquipamiento = dormHotel.calcularPrecio(aloj.pvpM2);
		} else if (aloj instanceof Casa || aloj instanceof Apartamento) {
			this.pEquipamiento = aloj.precioDormitorios() + aloj.precioNoDormitorios();
		} else {
			pEquipamiento = 0;
		}

		this.noches = Math.abs((int) FuncionesGenerales.diferenciaEntreFechas(fechanEnt, fechaSal, TimeUnit.DAYS));

		this.pBaseFestivos = aloj.getPrecioTFest();
		this.numFestivos = NumFestivosEntreFechas(fechaEntrada, fechaSalida, festivos);
		this.totalExtraFestivos = pBaseFestivos * numFestivos;

		this.precioExtras = 0;

		calcularTotal();
		
		this.setCodPromocional(false);
	}

	public int NumFestivosEntreFechas(Calendar fecha1, Calendar fecha2, Calendar[] festivos) {
		int num = 0;
		for (Calendar festivo : festivos) {
			if (festivo.before(fecha2) && festivo.after(fecha1)) {
				num++;
			}
		}
		return num;
	}

	public double getpBaseAloj() {
		return pBaseAloj;
	}

	public void setpBaseAloj(double pBaseAloj) {
		this.pBaseAloj = pBaseAloj;
	}

	public double getpEquipamiento() {
		return pEquipamiento;
	}

	public void setpEquipamiento(double pEquipamiento) {
		this.pEquipamiento = pEquipamiento;
	}

	public int getNoches() {
		return noches;
	}

	public void setNoches(int noches) {
		this.noches = noches;
	}

	public double getpBaseFestivos() {
		return pBaseFestivos;
	}

	public void setpBaseFestivos(double pBaseFestivos) {
		this.pBaseFestivos = pBaseFestivos;
	}

	public int getNumFestivos() {
		return numFestivos;
	}

	public void setNumFestivos(int numFestivos) {
		this.numFestivos = numFestivos;
	}

	public double getTotalExtraFestivos() {
		return totalExtraFestivos;
	}

	public void setTotalExtraFestivos(double totalExtraFestivos) {
		this.totalExtraFestivos = totalExtraFestivos;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public double getPrecioExtras() {
		return precioExtras;
	}

	public void setPrecioExtras(double precioExtras) {
		this.precioExtras = precioExtras;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public boolean isCodPromocional() {
		return codPromocional;
	}

	public void setCodPromocional(boolean codPromocional) {
		this.codPromocional = codPromocional;
		calcularTotal();
	}
	
	private void calcularTotal() {
		if (codPromocional) {
			this.total = ((this.pBaseAloj + this.pEquipamiento + this.precioExtras) * this.noches + this.totalExtraFestivos) * 0.8;
		} else {
			this.total = ((this.pBaseAloj + this.pEquipamiento + this.precioExtras) * this.noches + this.totalExtraFestivos);
		}
	}

}
