package vista.panelCard;

import java.awt.Dimension;
import java.awt.Font;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import util.FuncionesGenerales;

public class PanelLogin extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel lblContrasenia, lblDni;
	public JTextField txtDni;
	public JPasswordField pwdContra;
	public JButton contraOn0,btnRegistro;

	private Font tahomaFuente;
	public ImageIcon iconoOn, iconoOff;

	/**
	 * Create the panel.
	 */
	public PanelLogin() {
		setParametros();
		instanciarObjetos();
	}

	private void setParametros() {
		setPreferredSize(new Dimension(853, 647));
		setLayout(null);
	}

	private void instanciarObjetos() {
		tahomaFuente = new Font("Tahoma", Font.PLAIN, 18);

		contraOn0 = new JButton("");
		contraOn0.setBounds(521, 265, 32, 27);
		contraOn0.setVisible(true);
		setLayout(null);
		add(contraOn0);

		iconoOn = FuncionesGenerales.resizeIcono(contraOn0.getWidth(), contraOn0.getHeight(), new File(PanelPago.class.getResource("/imagenes/registro/contraOn.png").getPath()));
		iconoOff = FuncionesGenerales.resizeIcono(contraOn0.getWidth(), contraOn0.getHeight(), new File(PanelPago.class.getResource("/imagenes/registro/contraOff.png").getPath()));

		contraOn0.setIcon(iconoOn);

		pwdContra = new JPasswordField();
		pwdContra.setBounds(346, 265, 176, 27);
		add(pwdContra);

		lblContrasenia = new JLabel("Contraseña:");
		lblContrasenia.setBounds(213, 272, 123, 20);
		add(lblContrasenia);

		lblDni = new JLabel("Dni:");
		lblDni.setBounds(213, 125, 123, 20);
		add(lblDni);

		txtDni = new JTextField();
		txtDni.setBounds(346, 122, 207, 27);
		txtDni.setColumns(10);
		add(txtDni);
		
		btnRegistro = new JButton("Registro");
		btnRegistro.setBounds(670, 50, 89, 23);
		add(btnRegistro);

		JLabel[] arrayLabel = { lblContrasenia, lblDni };

		for (JLabel label : arrayLabel) {
			label.setFont(tahomaFuente);
		}
	}
}
