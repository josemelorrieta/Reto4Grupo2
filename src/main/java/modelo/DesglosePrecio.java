package modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import util.FuncionesGenerales;

public class DesglosePrecio {
	private double pBaseAloj;
	private double pNoDormitorio;
	private double pDormitorio;

	private int noches;

	private double pBaseFestivos;
	private int numFestivos;
	private double totalExtraFestivos;

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
		} else {
			this.pBaseAloj = aloj.getPrecioTBaja();
		}

		if (aloj instanceof Hotel && dormHotel != null) {
			this.pDormitorio = dormHotel.getPrecio();
			this.pNoDormitorio = 0;
		} else if (aloj instanceof Casa || aloj instanceof Apartamento) {
			this.pDormitorio = aloj.precioDormitorios();
			this.pNoDormitorio = aloj.precioNoDormitorios();
		} else {
			this.pDormitorio = 0;
			this.pNoDormitorio = 0;
		}

		this.noches = (int) FuncionesGenerales.diferenciaEntreFechas(fechanEnt, fechaSal, TimeUnit.DAYS);
		
		this.pBaseFestivos = aloj.getPrecioTFest();
		this.numFestivos = NumFestivosEntreFechas(fechaEntrada, fechaSalida, festivos);
		this.totalExtraFestivos=pBaseFestivos*numFestivos;
		
		this.precioExtras = 0;
		
		this.total=(this.pBaseAloj+this.pNoDormitorio+this.pDormitorio+this.precioExtras)*this.noches+this.totalExtraFestivos;
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

	public double getpHabNoDormitorio() {
		return pNoDormitorio;
	}

	public void setpHabNoDormitorio(double pHabNoDormitorio) {
		this.pNoDormitorio = pHabNoDormitorio;
	}

	public double getCosteDormitorio() {
		return pDormitorio;
	}

	public void setCosteDormitorio(double costeDormitorio) {
		this.pDormitorio = costeDormitorio;
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
}
