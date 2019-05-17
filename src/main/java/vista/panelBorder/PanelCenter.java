package vista.panelBorder;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import vista.panelCard.PanelAcompaniante;
import vista.panelCard.PanelBuscar;
import vista.panelCard.PanelLogin;
import vista.panelCard.PanelPago;
import vista.panelCard.PanelRegistro;
import vista.panelCard.PanelResBusqueda;
import vista.panelCard.PanelResumenPago;
import vista.panelCard.PanelResumenReserva;
import vista.panelCard.PanelSelHabitacion;
import vista.panelCard.PanelServicios;

public class PanelCenter extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CardLayout card;
	public int currentIndex;
	
	public PanelBuscar pBuscar;
	public PanelResBusqueda pResBusq;
	public PanelSelHabitacion pSelHab;
	public PanelServicios pSelServ;
	public PanelResumenReserva pResumenRes;
	public PanelRegistro pRegistro;
	public PanelPago pPago;
	public PanelLogin pLogin;
	public PanelResumenPago pResumenPago;
	public PanelAcompaniante pAcompaniante;
	
	
	public PanelCenter() {
		setParametros();
		instanciarObjetos();
		currentIndex = 1;
	}

	private void setParametros() {
		card = new CardLayout();
		setLayout(card);
		setPreferredSize(new Dimension(800,400));
	}

	private void instanciarObjetos() {
		pBuscar = new PanelBuscar();
		add(pBuscar, "1");

		pResBusq = new PanelResBusqueda();
		add(pResBusq, "2");
		
		pSelHab = new PanelSelHabitacion();
		add(pSelHab, "3");

		pSelServ = new PanelServicios();
		add(pSelServ, "4");
		
		pLogin= new PanelLogin();
		add(pLogin,"5");
		
		pRegistro=new PanelRegistro();
		add(pRegistro,"6");
	
		pResumenRes = new PanelResumenReserva();
		add(pResumenRes, "7");
		
		pAcompaniante= new PanelAcompaniante();
		add(pAcompaniante,"8");
		
		pPago = new PanelPago();
		add(pPago,"9");
		
		pResumenPago = new PanelResumenPago();
		add(pResumenPago, "10");		
	}
	
	public void prevPanel() {
		card.previous(this);
		currentIndex--;
	}
	
	public void nextPanel() {
		card.next(this);
		currentIndex++;
	}
	
	public void firstPanel() {
		card.first(this);
		currentIndex = 1;
	}
	
	public void changePanel(String index) {
		card.show(this, index);
		currentIndex = Integer.parseInt(index);
	}
}
