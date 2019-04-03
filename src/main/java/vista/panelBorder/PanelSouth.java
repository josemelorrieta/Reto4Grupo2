package vista.panelBorder;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class PanelSouth extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PanelSouth() {
		setParametros();
		instanciarObjetos();
	}
	
	private void setParametros() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		setPreferredSize(new Dimension(790, 90));
	}
	
	private void instanciarObjetos() {
		
	}
}
