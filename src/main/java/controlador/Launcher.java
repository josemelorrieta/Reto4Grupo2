package controlador;

import modelo.Modelo;
import vista.VentanaPpal;

public class Launcher {

	public static void main(String[] args) {
		VentanaPpal vista = new VentanaPpal();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(vista, modelo);

		/**
		Calendar fecha1=Calendar.getInstance();
		fecha1.setTime(new Date());
		Calendar fecha2=Calendar.getInstance();
		fecha2.set(2019,5,15);
		DesglosePrecio prueba=new DesglosePrecio();
		System.out.println(prueba.NumFestivosEntreFechas(fecha1, fecha2, modelo.festivos));
		prueba festivos
		 **/
	}

}
