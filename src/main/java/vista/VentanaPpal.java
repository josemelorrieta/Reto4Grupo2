package vista;

import javax.swing.JFrame;

import vista.panelBorder.PanelCenter;
import vista.panelBorder.PanelNorth;
import vista.panelBorder.PanelSouth;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Font;

public class VentanaPpal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BorderLayout border;
	public PanelNorth pNorth;
	public PanelCenter pCenter;
	public PanelSouth pSouth;

	/**
	 * Create the frame.
	 */
	public VentanaPpal() {	
		setParametros();
		instanciarObjetos();
		pack();
	}

	private void setParametros() {
		border = new BorderLayout(0,0);
		getContentPane().setLayout(border);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(800,600));
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("BIDAI-ON (developed by JYJApps)");
		setVisible(true);
	}
	
	private void instanciarObjetos() {
		pNorth = new PanelNorth();
		getContentPane().add(pNorth, BorderLayout.NORTH);
		
		pCenter = new PanelCenter();
		pCenter.pBuscar.cbxBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(pCenter, BorderLayout.CENTER);
		
		pSouth = new PanelSouth();
		getContentPane().add(pSouth, BorderLayout.SOUTH);
	}
}
