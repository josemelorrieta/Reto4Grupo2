package vista.panelBorder;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import vista.panelCard.PanelInfBotones;

public class PanelSouth extends JPanel {

	public PanelInfBotones pBotones = new PanelInfBotones();
	
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
		add(pBotones);
	}
}
