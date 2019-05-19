package vista;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;

import vista.panelBorder.PanelBotones;
import vista.panelBorder.PanelCenter;
import vista.panelBorder.PanelTitulo;
import java.awt.Color;
import java.awt.Toolkit;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPpal.class.getResource("/imagenes/general/logo.png")));
		getContentPane().setBackground(Color.WHITE);	
		setParametros();
		instanciarObjetos();
	}
	
	private void setParametros() {
		border = new BorderLayout(0,0);
		getContentPane().setLayout(border);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024,768);
		//setPreferredSize(new Dimension(800,600));
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("BIDAI-ON (developed by JYJApps)");
		setVisible(true);
	}
	
	private void instanciarObjetos() {
		pTitulo = new PanelTitulo();
		pTitulo.setBackground(Color.WHITE);
		getContentPane().add(pTitulo, BorderLayout.NORTH);
		
		pCenter = new PanelCenter();
		pCenter.pResumenPago.setBackground(Color.WHITE);
		pCenter.pPago.setBackground(Color.WHITE);
		pCenter.pAcompaniante.setBackground(Color.WHITE);
		pCenter.pResumenRes.setBackground(Color.WHITE);
		pCenter.pRegistro.setBackground(Color.WHITE);
		pCenter.pLogin.setBackground(Color.WHITE);
		pCenter.pSelServ.setBackground(Color.WHITE);
		pCenter.pSelHab.setBackground(Color.WHITE);
		pCenter.pResBusq.setBackground(Color.WHITE);
		pCenter.pBuscar.setBackground(Color.WHITE);
		pCenter.setBackground(Color.WHITE);
		pCenter.pBuscar.cbxBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(pCenter, BorderLayout.CENTER);
		
		pBotones = new PanelBotones();
		pBotones.setBackground(Color.WHITE);
		getContentPane().add(pBotones, BorderLayout.SOUTH);
		
		pCondiciones = new CondicionesLegales();
		pCondiciones.setVisible(false);
	}
}
