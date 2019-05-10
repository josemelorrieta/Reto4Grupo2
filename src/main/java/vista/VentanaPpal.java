package vista;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;

import vista.panelBorder.PanelBotones;
import vista.panelBorder.PanelCenter;
import vista.panelBorder.PanelTitulo;

public class VentanaPpal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BorderLayout border;
	public PanelTitulo pTitulo;
	public PanelCenter pCenter;
	public PanelBotones pBotones;
	public CondicionesLegales pCondiciones;

	/**
	 * Create the frame.
	 */
	public VentanaPpal() {	
		setParametros();
		instanciarObjetos();
	}
	
	private void setParametros() {
		border = new BorderLayout(0,0);
		getContentPane().setLayout(border);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		//setPreferredSize(new Dimension(800,600));
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("BIDAI-ON (developed by JYJApps)");
		setVisible(true);
	}
	
	private void instanciarObjetos() {
		pTitulo = new PanelTitulo();
		getContentPane().add(pTitulo, BorderLayout.NORTH);
		
		pCenter = new PanelCenter();
		pCenter.pBuscar.cbxBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(pCenter, BorderLayout.CENTER);
		
		pBotones = new PanelBotones();
		getContentPane().add(pBotones, BorderLayout.SOUTH);
		
		pCondiciones = new CondicionesLegales();
		pCondiciones.setVisible(false);
	}
}
