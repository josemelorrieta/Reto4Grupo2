package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vista.panelCenter.PanelBuscar;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.BorderLayout;

public class VentanaPpal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BorderLayout layout;
	public PanelNorth pNorth;
	public PanelCenter pCenter;
	public PanelSouth pSouth;

	/**
	 * Create the frame.
	 */
	public VentanaPpal() {
		setParametros();
		instanciarObjetos();
	}

	private void setParametros() {
		layout = new BorderLayout(0,0);
		setLayout(layout);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(800,600));
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void instanciarObjetos() {
		pNorth = new PanelNorth();
		add(pNorth, BorderLayout.NORTH);
		
		pCenter = new PanelCenter();
		add(pCenter, BorderLayout.CENTER);
		
		pSouth = new PanelSouth();
		add(pSouth, BorderLayout.SOUTH);
	}
}
