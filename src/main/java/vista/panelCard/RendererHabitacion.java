package vista.panelCard;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import modelo.Habitacion;

public class RendererHabitacion extends JPanel implements ListCellRenderer<Habitacion>{

	/**
	 * Create the panel.
	 */
	public RendererHabitacion() {
		setParametros();
		instanciarObjetos();
	}

	private void setParametros() {
		
		
	}

	private void instanciarObjetos() {
		
		
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Habitacion> arg0, Habitacion arg1, int arg2,
			boolean arg3, boolean arg4) {
		
		return null;
	}

}
