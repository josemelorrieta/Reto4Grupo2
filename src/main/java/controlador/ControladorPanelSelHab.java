package controlador;

import java.util.Vector;

import modelo.Dormitorio;
import modelo.Modelo;
import vista.VentanaPpal;

public class ControladorPanelSelHab {
	private VentanaPpal vis;
	
	public ControladorPanelSelHab(VentanaPpal vis) {
		this.vis = vis;
	}
	
	public void setResultHab(Vector<Vector<Dormitorio>> dormitorios, Dormitorio[] dormitoriosModelo) {
		vis.pCenter.pSelHab.modelResHab.clear();
		int i = 0;
		for (Vector<Dormitorio> columna : dormitorios) {
			if (columna == null) {
				vis.pCenter.pSelHab.modelResHab.addElement(dormitoriosModelo[i]);
				i++;
				continue;
			}
			for (Dormitorio dormi : columna) {
				if (dormi.isDisponible()) {
					vis.pCenter.pSelHab.modelResHab.addElement(dormi);
					break;
				} else
					continue;
			}
			i++;
		}
	}
}
