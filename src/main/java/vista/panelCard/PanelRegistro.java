package vista.panelCard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

import modelo.Sexo;
import util.FuncionesGenerales;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class PanelRegistro extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel lblNombre, lblApellido, lblFechaNacimiento, lblSexo, lblContrasenia, lblRepetirContrasenia, lblDni,lblValiNombre,lblValiApellido,lblValiDni,lblValiContra,lblValiContraCoinciden, lblCondiciones;
	public JTextField txtNombre, txtApellido, txtDni;
	public JDateChooser calenNacimiento;
	public JComboBox<Sexo> comboBoxSexo;
	public DefaultComboBoxModel<Sexo> modeloSexo;
	public JSpinnerDateEditor spnDateEditorNacimiento;
	public JPasswordField pwdContra, pwdRepContra;
	public JButton contraOn0, contraOn1;
	public JCheckBox chckbxCondiciones;

	private Font tahomaFuente;
	public ImageIcon iconoOn, iconoOff;
	private Color colorRojo=new Color(240, 128, 128);
	private JLabel lblRegistro;

	/**
	 * Create the panel.
	 */
	public PanelRegistro() {
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
		contraOn0.setBounds(583, 350, 32, 27);
		contraOn0.setVisible(true);
		setLayout(null);
		add(contraOn0);

		contraOn1 = new JButton("");
		contraOn1.setBounds(583, 398, 32, 27);
		contraOn1.setVisible(true);
		add(contraOn1);

		iconoOn = FuncionesGenerales.resizeIcono(contraOn0.getWidth(), contraOn0.getHeight(), new File(PanelPago.class.getResource("/imagenes/registro/contraOn.png").getPath()));
		iconoOff = FuncionesGenerales.resizeIcono(contraOn0.getWidth(), contraOn0.getHeight(), new File(PanelPago.class.getResource("/imagenes/registro/contraOff.png").getPath()));

		contraOn0.setIcon(iconoOn);
		contraOn1.setIcon(iconoOn);

		pwdContra = new JPasswordField();
		pwdContra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pwdContra.setBounds(408, 350, 176, 27);
		add(pwdContra);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(188, 126, 123, 20);
		add(lblNombre);

		pwdRepContra = new JPasswordField();
		pwdRepContra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pwdRepContra.setBounds(408, 398, 176, 27);
		add(pwdRepContra);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setBounds(408, 123, 207, 27);
		add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtApellido.setBounds(408, 168, 207, 27);
		add(txtApellido);
		txtApellido.setColumns(10);

		spnDateEditorNacimiento = new JSpinnerDateEditor();
		spnDateEditorNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		((JSpinner.DefaultEditor) spnDateEditorNacimiento.getEditor()).getTextField().setEditable(false);

		calenNacimiento = new JDateChooser(null, null, null, spnDateEditorNacimiento);
		calenNacimiento.setBounds(408, 260, 207, 27);
		calenNacimiento.setDateFormatString("dd-MM-yyyy");
		add(calenNacimiento);

		modeloSexo = new DefaultComboBoxModel<>(Sexo.values());

		comboBoxSexo = new JComboBox<Sexo>();
		comboBoxSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxSexo.setModel(modeloSexo);
		comboBoxSexo.setBounds(408, 308, 207, 27);
		add(comboBoxSexo);

		lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(188, 171, 123, 20);
		add(lblApellido);

		lblFechaNacimiento = new JLabel("Fecha nacimiento:");
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaNacimiento.setBounds(188, 266, 210, 20);
		add(lblFechaNacimiento);

		lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSexo.setBounds(188, 311, 123, 20);
		add(lblSexo);

		lblContrasenia = new JLabel("Contraseña:");
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasenia.setBounds(188, 356, 123, 20);
		add(lblContrasenia);

		lblRepetirContrasenia = new JLabel("Repetir contraseña:");
		lblRepetirContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRepetirContrasenia.setBounds(188, 401, 210, 20);
		add(lblRepetirContrasenia);

		lblDni = new JLabel("Dni:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(188, 221, 123, 20);
		add(lblDni);

		txtDni = new JTextField();
		txtDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDni.setBounds(408, 218, 207, 27);
		txtDni.setColumns(10);
		add(txtDni);
		
		lblValiNombre = new JLabel("* Este campo solo admite letras");
		lblValiNombre.setBounds(636, 131, 215, 14);
		add(lblValiNombre);
		
		lblValiApellido = new JLabel("* Este campo solo admite letras");
		lblValiApellido.setBounds(636, 176, 215, 14);
		add(lblValiApellido);
		
		lblValiDni = new JLabel("* El DNI esta compuesto por 8 numeros y una letra");
		lblValiDni.setBounds(636, 226, 270, 14);
		add(lblValiDni);
		
		lblValiContra = new JLabel("<html>* La contraseña debe tener 8 caracteres de longuitud</br> con minimo una letra mayuscula, minuscula y un numero</html>");
		lblValiContra.setBounds(636, 348, 310, 48);
		add(lblValiContra);
		
		lblValiContraCoinciden = new JLabel("* Las contraseñas no coinciden");
		lblValiContraCoinciden.setBounds(636, 403, 249, 20);
		add(lblValiContraCoinciden);
		
		chckbxCondiciones = new JCheckBox("  Acepto las");
		chckbxCondiciones.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxCondiciones.setBounds(408, 469, 100, 23);
		add(chckbxCondiciones);
		
		lblCondiciones = new JLabel("Condiciones Legales");
		lblCondiciones.setForeground(new Color(0,103,219));
		lblCondiciones.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblCondiciones.setHorizontalAlignment(SwingConstants.LEFT);
		lblCondiciones.setBounds(507, 469, 150, 23);
		add(lblCondiciones);
		
		lblRegistro = new JLabel("Registro");
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblRegistro.setBounds(10, 24, 1004, 48);
		lblRegistro.setForeground(new Color(0,103,219));
		add(lblRegistro);

		JLabel[] arrayLabel = { lblNombre, lblApellido, lblFechaNacimiento, lblSexo, lblContrasenia, lblRepetirContrasenia, lblDni };
		JLabel[] arrayLabelVali= {lblValiNombre,lblValiApellido,lblValiDni,lblValiContra,lblValiContraCoinciden};

		for (JLabel label : arrayLabel) {
			label.setFont(tahomaFuente);
		}
		
		for(JLabel label: arrayLabelVali) {
			label.setVisible(false);
			label.setForeground(colorRojo);
		}
	}
}
