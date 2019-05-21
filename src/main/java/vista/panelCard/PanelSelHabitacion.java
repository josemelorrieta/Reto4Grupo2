package vista.panelCard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import modelo.Dormitorio;

public class PanelSelHabitacion extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public JLabel lblTitulo;
	public DefaultListModel<Dormitorio> modelResHab = new DefaultListModel<Dormitorio>();
	public JList<Dormitorio> resultHab;
	public JScrollPane scroll;

	
	public PanelSelHabitacion() {
		setParametros();
		instanciarObjetos();
	}
	
	private void setParametros() {
		setPreferredSize(new Dimension(1024,588));
		setLayout(null);
	}
	
	private void instanciarObjetos() {	
		lblTitulo = new JLabel("Seleccionarel tipo de habitación");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitulo.setBounds(40, 26, 869, 26);
		add(lblTitulo);
		
		resultHab = new JList<Dormitorio>(modelResHab);
		resultHab.setBackground(Color.WHITE);
		resultHab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		resultHab.setCellRenderer(new RendererHabitacion());
		
		scroll = new JScrollPane(resultHab);
		scroll.setLocation(40, 80);
		scroll.setSize(590, 480);
		scroll.getVerticalScrollBar().setUnitIncrement(8);
		add(scroll);	
	}
}
