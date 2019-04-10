package vista.panelBorder;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import vista.panelCard.PanelBuscar;
import vista.panelCard.PanelResBusqueda;
import vista.panelCard.PanelPago;
import vista.panelCard.PanelRegistro;

public class PanelCenter extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CardLayout card;
	public int currentIndex;
	public PanelBuscar pBuscar;
	public PanelResBusqueda pResBusq;
	public PanelPago pPago;
	public PanelRegistro pRegistro;
	
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
		
		pPago = new PanelPago();
		add(pPago,"3");
		
		pRegistro=new PanelRegistro();
		add(pRegistro,"4");
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
