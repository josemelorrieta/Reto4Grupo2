package vista.panelCard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

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
	private JLabel lblAadirAcompaantes;
	private JLabel lblListadoDeAcompaantes;

	/**
	 * Create the panel.
	 */
	public PanelAcompaniante() {
		setBackground(Color.WHITE);
		setParametros();
		instanciarObjetos();
	}

	private void setParametros() {
		setPreferredSize(new Dimension(1024, 588));
		setLayout(null);
	}

	private void instanciarObjetos() {
		tahomaFuente = new Font("Tahoma", Font.PLAIN, 18);

		lblNombre = new JLabel("Apellido:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(252, 147, 123, 20);
		add(lblNombre);
		
		lblApellido = new JLabel("Nombre:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(252, 109, 123, 20);
		add(lblApellido);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setBounds(397, 106, 207, 27);
		add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtApellido.setBounds(397, 144, 207, 27);
		add(txtApellido);
		txtApellido.setColumns(10);

		lblDni = new JLabel("Dni:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(252, 196, 123, 20);
		add(lblDni);

		txtDni = new JTextField();
		txtDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		
		btnAniadir = new JButton("AÑADIR");
		btnAniadir.setForeground(Color.WHITE);
		btnAniadir.setIcon(new ImageIcon(PanelAcompaniante.class.getResource("/imagenes/general/boton140.png")));
		btnAniadir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAniadir.setBounds(426, 243, 140, 40);
		btnAniadir.setFocusPainted(false);
		btnAniadir.setMargin(new Insets(0, 0, 0, 0));
		btnAniadir.setContentAreaFilled(false);
		btnAniadir.setBorderPainted(false);
		btnAniadir.setOpaque(false);
		btnAniadir.setHorizontalTextPosition(JButton.CENTER);
		btnAniadir.setVerticalTextPosition(JButton.CENTER);
		add(btnAniadir);
		
		listAcompaniante = new JList<String>(modeloAcompaniante);
		listAcompaniante.setBorder(new LineBorder(new Color(0, 103, 219)));
		listAcompaniante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listAcompaniante.setBounds(267, 360, 444, 168);
		add(listAcompaniante);
		
		lblAadirAcompaantes = new JLabel("Añadir acompañantes");
		lblAadirAcompaantes.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirAcompaantes.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAadirAcompaantes.setBounds(10, 23, 1004, 40);
		lblAadirAcompaantes.setForeground(new Color(0,103,219));
		add(lblAadirAcompaantes);
		
		lblListadoDeAcompaantes = new JLabel("Listado de acompañantes");
		lblListadoDeAcompaantes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListadoDeAcompaantes.setBounds(267, 324, 299, 27);
		add(lblListadoDeAcompaantes);

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
