package vista.panelCard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAcompaniante extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel lblNombre, lblApellido, lblDni, lblValiNombre, lblValiApellido, lblValiDni;
	public JTextField txtNombre, txtApellido, txtDni;
	public JButton btnAniadir;
	public DefaultListModel<String> modeloAcompaniante = new DefaultListModel<String>();
	public JList<String> listAcompaniante;
	private Font tahomaFuente;
	public ImageIcon iconoOn, iconoOff;
	private Color colorRojo = new Color(240, 128, 128);

	/**
	 * Create the panel.
	 */
	public PanelAcompaniante() {
		setParametros();
		instanciarObjetos();
	}

	private void setParametros() {
		setPreferredSize(new Dimension(853, 647));
		setLayout(null);
	}

	private void instanciarObjetos() {
		tahomaFuente = new Font("Tahoma", Font.PLAIN, 18);

		lblNombre = new JLabel("Apellido:");
		lblNombre.setBounds(252, 147, 123, 20);
		add(lblNombre);
		
		lblApellido = new JLabel("Nombre:");
		lblApellido.setBounds(252, 109, 123, 20);
		add(lblApellido);

		txtNombre = new JTextField();
		txtNombre.setBounds(397, 106, 207, 27);
		add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setBounds(397, 144, 207, 27);
		add(txtApellido);
		txtApellido.setColumns(10);

		lblDni = new JLabel("Dni:");
		lblDni.setBounds(252, 196, 123, 20);
		add(lblDni);

		txtDni = new JTextField();
		txtDni.setBounds(397, 193, 207, 27);
		txtDni.setColumns(10);
		add(txtDni);

		lblValiNombre = new JLabel("* Este campo solo admite letras");
		lblValiNombre.setBounds(625, 109, 215, 14);
		add(lblValiNombre);

		lblValiApellido = new JLabel("* Este campo solo admite letras");
		lblValiApellido.setBounds(625, 147, 215, 14);
		add(lblValiApellido);

		lblValiDni = new JLabel("* El DNI esta compuesto por 8 numeros y una letra");
		lblValiDni.setBounds(625, 196, 270, 14);
		add(lblValiDni);
		
		btnAniadir = new JButton("Añadir");
		btnAniadir.setBounds(414, 243, 89, 23);
		add(btnAniadir);
		
		listAcompaniante = new JList<String>(modeloAcompaniante);
		listAcompaniante.setBounds(42, 84, 173, 199);
		add(listAcompaniante);

		JLabel[] arrayLabel = { lblNombre, lblApellido, lblDni };
		JLabel[] arrayLabelVali = { lblValiNombre, lblValiApellido, lblValiDni };

		for (JLabel label : arrayLabel) {
			label.setFont(tahomaFuente);
		}

		for (JLabel label : arrayLabelVali) {
			label.setVisible(false);
			label.setForeground(colorRojo);
		}
	}
}
