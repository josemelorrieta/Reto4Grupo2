package vista.panelCard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import util.FuncionesGenerales;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class PanelLogin extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel lblContrasenia, lblDni,lblValiDni;
	public JTextField txtDni;
	public JPasswordField pwdContra;
	public JButton contraOn0,btnRegistro;

	private Font tahomaFuente;
	public ImageIcon iconoOn, iconoOff;
	private JLabel lblLogin;
	private JLabel lblSiNoTiene;

	/**
	 * Create the panel.
	 */
	public PanelLogin() {
		setBorder(new CompoundBorder(null, new EmptyBorder(0, 5, 0, 0)));
		setParametros();
		instanciarObjetos();
	}

	private void setParametros() {
		setPreferredSize(new Dimension(1024, 588));
		setLayout(null);
	}

	private void instanciarObjetos() {
		tahomaFuente = new Font("Tahoma", Font.PLAIN, 18);

		contraOn0 = new JButton("");
		contraOn0.setBounds(605, 303, 32, 27);
		contraOn0.setVisible(true);
		setLayout(null);
		add(contraOn0);

		iconoOn = FuncionesGenerales.resizeIcono(contraOn0.getWidth(), contraOn0.getHeight(), new File(PanelPago.class.getResource("/imagenes/registro/contraOn.png").getPath()));
		iconoOff = FuncionesGenerales.resizeIcono(contraOn0.getWidth(), contraOn0.getHeight(), new File(PanelPago.class.getResource("/imagenes/registro/contraOff.png").getPath()));

		contraOn0.setIcon(iconoOn);

		pwdContra = new JPasswordField();
		pwdContra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pwdContra.setBounds(387, 303, 218, 27);
		pwdContra.setBorder (new CompoundBorder(new LineBorder(new Color(128,128,128), 1), new EmptyBorder(0, 5, 0, 0)));
		add(pwdContra);

		lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasenia.setBounds(387, 272, 250, 20);
		lblContrasenia.setForeground(new Color(0,103,219));
		add(lblContrasenia);

		lblDni = new JLabel("D.N.I.");
		lblDni.setHorizontalAlignment(SwingConstants.CENTER);
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(387, 129, 250, 20);
		lblDni.setForeground(new Color(0,103,219));
		add(lblDni);

		txtDni = new JTextField();
		txtDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDni.setBounds(387, 157, 250, 27);
		txtDni.setColumns(10);
		txtDni.setBorder (new CompoundBorder(new LineBorder(new Color(128,128,128), 1), new EmptyBorder(0, 5, 0, 0)));
		add(txtDni);
		
		btnRegistro = new JButton("REGISTRO");
		btnRegistro.setIcon(new ImageIcon(PanelLogin.class.getResource("/imagenes/general/boton140.png")));
		btnRegistro.setForeground(Color.WHITE);
		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistro.setBounds(441, 453, 140, 40);
		btnRegistro.setFocusPainted(false);
		btnRegistro.setMargin(new Insets(0, 0, 0, 0));
		btnRegistro.setContentAreaFilled(false);
		btnRegistro.setBorderPainted(false);
		btnRegistro.setOpaque(false);
		btnRegistro.setHorizontalTextPosition(JButton.CENTER);
		btnRegistro.setVerticalTextPosition(JButton.CENTER);
		add(btnRegistro);
		
		lblValiDni = new JLabel("* El DNI esta compuesto por 8 numeros y una letra");
		lblValiDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValiDni.setBounds(387, 195, 343, 27);
		add(lblValiDni);
		
		lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLogin.setBounds(10, 23, 1004, 40);
		lblLogin.setForeground(new Color(0,103,219));
		add(lblLogin);
		
		lblSiNoTiene = new JLabel("Si no tiene un usuario debe registrarse");
		lblSiNoTiene.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiNoTiene.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSiNoTiene.setBounds(362, 403, 300, 39);
		add(lblSiNoTiene);
		
		lblValiDni.setVisible(false);

		JLabel[] arrayLabel = { lblContrasenia, lblDni };

		for (JLabel label : arrayLabel) {
			label.setFont(tahomaFuente);
		}
	}
}
