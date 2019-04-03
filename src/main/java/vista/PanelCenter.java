package vista;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import vista.panelCenter.PanelBuscar;

public class PanelCenter extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CardLayout layout;
	
	public PanelBuscar pBuscar;
	
	public PanelCenter() {
		setParametros();
		instanciarObjetos();
	}

	private void setParametros() {
		layout = new CardLayout();
		setLayout(layout);
		setPreferredSize(new Dimension(600,400));
	}

	private void instanciarObjetos() {
		pBuscar = new PanelBuscar();
		add(pBuscar,"1");
		
	}
}
