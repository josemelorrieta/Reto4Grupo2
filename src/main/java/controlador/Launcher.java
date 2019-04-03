package controlador;

import vista.VentanaPpal;

public class Launcher {

	public static void main(String[] args) {
		VentanaPpal vista = new VentanaPpal();
		Controlador controlador = new Controlador(vista);
	
	}

}
