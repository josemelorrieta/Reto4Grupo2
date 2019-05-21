package controlador;

import java.util.Vector;

import modelo.Dormitorio;
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
			boolean metido=false;
			for (Dormitorio dormi : columna) {
				if (dormi.isDisponible()) {
					vis.pCenter.pSelHab.modelResHab.addElement(dormi);
					metido=true;
					break;
				} else
					continue;
			}
			if(!metido) vis.pCenter.pSelHab.modelResHab.addElement(dormitoriosModelo[i]);
			i++;
		}
	}
}
