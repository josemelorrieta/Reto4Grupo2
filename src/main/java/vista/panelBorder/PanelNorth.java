package vista.panelBorder;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import vista.panelCard.PanelTitulo;

public class PanelNorth extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelNorth() {
		setParametros();
		instanciarObjetos();
	}
	
	private void setParametros() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		setPreferredSize(new Dimension(800, 90));
	}
	
	private void instanciarObjetos() {
		PanelTitulo pTitulo = new PanelTitulo();
		add(pTitulo);
	}
}
