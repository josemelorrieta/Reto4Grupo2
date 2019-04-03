package vista.panelBorder;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import vista.panelCard.PanelBuscar;

public class PanelCenter extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CardLayout card;
	public int currentIndex;
	public PanelBuscar pBuscar;
	
	public PanelCenter() {
		setParametros();
		instanciarObjetos();
		currentIndex = 1;
	}

	private void setParametros() {
		card = new CardLayout();
		setLayout(card);
		setPreferredSize(new Dimension(600,400));
	}

	private void instanciarObjetos() {
		pBuscar = new PanelBuscar();
		add(pBuscar, "1");	
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
