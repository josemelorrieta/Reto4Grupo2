package vista.panelCard;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.BevelBorder;

import modelo.Habitacion;
import javax.swing.JLabel;

public class RendererHabitacion extends JPanel implements ListCellRenderer<Habitacion>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel lblNewLabel;
	
	
	public RendererHabitacion() {
		
		lblNewLabel = new JLabel("New label");
		add(lblNewLabel);
		setParametros();
		instanciarObjetos();
	}

	private void setParametros() {
		setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setPreferredSize(new Dimension(500,111));
		setLayout(null);
	}

	private void instanciarObjetos() {
		
		
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Habitacion> lista, Habitacion habitacion, int index,
			boolean isSelected, boolean cellHasFocus) {
		
		
		
		
		
		
		
		
		
		if (isSelected) {
		    setBackground(lista.getSelectionBackground());
		    setForeground(lista.getSelectionForeground());
		} else {
		    setBackground(lista.getBackground());
		    setForeground(lista.getForeground());
		}
		return this;
	}
	
}
