package vista.panelCard;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import modelo.Dormitorio;

public class PanelSelHabitacion extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JLabel lblTitulo;
	public DefaultListModel<Dormitorio> modelResHab;
	public JList<Dormitorio> resultHab;
	public JScrollPane scroll;

	public PanelSelHabitacion() {
		setPanelParametros();
		instanciarObjetos();
	}

	private void setPanelParametros() {
		setPreferredSize(new Dimension(800, 400));
		setLayout(null);
	}

	private void instanciarObjetos() {
		lblTitulo = new JLabel("Datos del alojamiento");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitulo.setBounds(43, 32, 116, 14);
		add(lblTitulo);

		modelResHab = new DefaultListModel<Dormitorio>();

		resultHab = new JList<Dormitorio>(modelResHab);
		resultHab.setBackground(SystemColor.control);
		resultHab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		resultHab.setCellRenderer(new RendererHabitacion());

		scroll = new JScrollPane(resultHab);
		scroll.setLocation(100, 60);
		scroll.setSize(520, 320);
		add(scroll);
	}

	public void setResultHab(Vector<Vector<Dormitorio>> dormitorios, Dormitorio[] dormitoriosModelo) {
		modelResHab.clear();
		int i = 0;
		for (Vector<Dormitorio> columna : dormitorios) {
			if (columna == null) {
				modelResHab.addElement(dormitoriosModelo[i]);
				i++;
				continue;
			}
			for (Dormitorio dormi : columna) {
				if (dormi.isDisponible()) {
					modelResHab.addElement(dormi);
					break;
				} else
					continue;
			}
			i++;
		}
	}
}
