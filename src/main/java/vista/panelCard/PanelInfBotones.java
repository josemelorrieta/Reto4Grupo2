package vista.panelCard;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelInfBotones extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public JButton btnSiguiente, btnVolver;

	public PanelInfBotones() {
		setParametros();
		instanciarObjetos();
	}
			
	private void setParametros() {
		setPreferredSize(new Dimension(800, 110));
		setVisible(false);
	}
	
	private void instanciarObjetos() {
		setLayout(null);

	
	}
}
