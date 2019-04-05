package vista.panelCard;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import modelo.Hotel;

public class PanelResBusqueda extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public JLabel lblResBusq, lblLocBusq;
	public DefaultListModel<Hotel> modelResBusq = new DefaultListModel<Hotel>();
	public JList<Hotel> resultBusq;
	
	public PanelResBusqueda() {
		setParametros();
		instanciarObjetos();
	}
	
	private void setParametros() {
		setPreferredSize(new Dimension(800, 400));
		setLayout(null);
		
		lblResBusq = new JLabel("Resultados para ");
		lblResBusq.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblResBusq.setBounds(100, 30, 135, 26);
		add(lblResBusq);
		
		lblLocBusq = new JLabel("Bilbao");
		lblLocBusq.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLocBusq.setBounds(230, 30, 360, 26);
		add(lblLocBusq);
		
		resultBusq = new JList<Hotel>(modelResBusq);
		resultBusq.setBounds(100, 60, 600, 320);
		resultBusq.setCellRenderer(new ItemResBusqueda());
		add(new JScrollPane(resultBusq));
	}
	
	private void instanciarObjetos() {
		
		
	}	
}
