package controlador;

import modelo.Modelo;
import vista.VentanaPpal;

public class Launcher {

	public static void main(String[] args) {
		VentanaPpal vista = new VentanaPpal();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(vista, modelo);
		
		/** Test de insert generico
		ConsultaBD bdTest=new ConsultaBD();
		Cliente clienteTest=new Cliente("124", "ASDASDSD", "ASDASDASD", new Date(), Sexo.Hombre,"TEST");
		bdTest.insertGenerico(clienteTest.toArray(), "cliente");
		**/
	}

}
