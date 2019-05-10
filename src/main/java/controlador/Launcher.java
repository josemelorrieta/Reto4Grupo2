package controlador;

import modelo.Modelo;
import vista.VentanaPpal;

public class Launcher {

	public static void main(String[] args) {
		VentanaPpal vista = new VentanaPpal();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(vista, modelo);

	}

}
