package vista.panelCard;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import modelo.Hotel;
import javax.swing.ListSelectionModel;
import java.awt.SystemColor;

public class PanelResBusqueda extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public JLabel lblLocBusq;
	public DefaultListModel<Hotel> modelResBusq = new DefaultListModel<Hotel>();
	public JList<Hotel> resultBusq;
	public JScrollPane scroll;
	
	public PanelResBusqueda() {
		setParametros();
		instanciarObjetos();
	}
	
	private void setParametros() {
		setPreferredSize(new Dimension(800, 400));
		setLayout(null);
	}
	
	private void instanciarObjetos() {	
		lblLocBusq = new JLabel("Resultados para Bilbao");
		lblLocBusq.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLocBusq.setBounds(100, 30, 360, 26);
		add(lblLocBusq);
		
		resultBusq = new JList<Hotel>(modelResBusq);
		resultBusq.setBackground(SystemColor.control);
		resultBusq.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		resultBusq.setCellRenderer(new ItemResBusqueda());
		
		scroll = new JScrollPane(resultBusq);
		scroll.setLocation(100, 60);
		scroll.setSize(520, 320);
		add(scroll);
	}	
	
	public void setResultBusqueda(Hotel[] hoteles) {
		modelResBusq.clear();
		for(Hotel hotel:hoteles) {
			modelResBusq.addElement(hotel);
		}
		lblLocBusq.setText("Resultados para " + hoteles[0].getDireccion().getLocalidad());
	}
}
