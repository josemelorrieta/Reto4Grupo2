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

public class PanelRegistro extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel lblNombre, lblApellido, lblFechaNacimiento, lblSexo, lblContrasenia, lblRepetirContrasenia, lblDni,lblValiNombre,lblValiApellido,lblValiDni,lblValiContra,lblValiContraCoinciden;
	public JTextField txtNombre, txtApellido, txtDni;
	public JDateChooser calenNacimiento;
	public JComboBox<Sexo> comboBoxSexo;
	public DefaultComboBoxModel<Sexo> modeloSexo;
	public JSpinnerDateEditor spnDateEditorNacimiento;
	public JPasswordField pwdContra, pwdRepContra;
	public JButton contraOn0, contraOn1;

	private Font tahomaFuente;
	public ImageIcon iconoOn, iconoOff;
	private Color colorRojo=new Color(240, 128, 128);

	/**
	 * Create the panel.
	 */
	public PanelRegistro() {
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
		contraOn0.setBounds(449, 265, 32, 27);
		contraOn0.setVisible(true);
		setLayout(null);
		add(contraOn0);

		contraOn1 = new JButton("");
		contraOn1.setBounds(449, 319, 32, 27);
		contraOn1.setVisible(true);
		add(contraOn1);

		iconoOn = FuncionesGenerales.resizeIcono(contraOn0.getWidth(), contraOn0.getHeight(), new File(PanelPago.class.getResource("/imagenes/registro/contraOn.png").getPath()));
		iconoOff = FuncionesGenerales.resizeIcono(contraOn0.getWidth(), contraOn0.getHeight(), new File(PanelPago.class.getResource("/imagenes/registro/contraOff.png").getPath()));

		contraOn0.setIcon(iconoOn);
		contraOn1.setIcon(iconoOn);

		pwdContra = new JPasswordField();
		pwdContra.setBounds(274, 265, 176, 27);
		add(pwdContra);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(54, 42, 123, 20);
		add(lblNombre);

		pwdRepContra = new JPasswordField();
		pwdRepContra.setBounds(274, 319, 176, 27);
		add(pwdRepContra);

		txtNombre = new JTextField();
		txtNombre.setBounds(274, 39, 207, 27);
		add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setBounds(274, 77, 207, 27);
		add(txtApellido);
		txtApellido.setColumns(10);

		spnDateEditorNacimiento = new JSpinnerDateEditor();
		((JSpinner.DefaultEditor) spnDateEditorNacimiento.getEditor()).getTextField().setEditable(false);

		calenNacimiento = new JDateChooser(null, null, null, spnDateEditorNacimiento);
		calenNacimiento.setBounds(274, 175, 207, 27);
		calenNacimiento.setDateFormatString("dd-MM-yyyy");
		add(calenNacimiento);

		modeloSexo = new DefaultComboBoxModel<>(Sexo.values());

		comboBoxSexo = new JComboBox<Sexo>();
		comboBoxSexo.setModel(modeloSexo);
		comboBoxSexo.setBounds(274, 227, 207, 27);
		add(comboBoxSexo);

		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(54, 85, 123, 20);
		add(lblApellido);

		lblFechaNacimiento = new JLabel("Fecha nacimiento:");
		lblFechaNacimiento.setBounds(54, 175, 210, 20);
		add(lblFechaNacimiento);

		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(54, 220, 123, 20);
		add(lblSexo);

		lblContrasenia = new JLabel("Contraseña:");
		lblContrasenia.setBounds(54, 264, 123, 20);
		add(lblContrasenia);

		lblRepetirContrasenia = new JLabel("Repetir contraseña:");
		lblRepetirContrasenia.setBounds(54, 322, 210, 20);
		add(lblRepetirContrasenia);

		lblDni = new JLabel("Dni:");
		lblDni.setBounds(54, 129, 123, 20);
		add(lblDni);

		txtDni = new JTextField();
		txtDni.setBounds(274, 126, 207, 27);
		txtDni.setColumns(10);
		add(txtDni);
		
		lblValiNombre = new JLabel("* Este campo solo admite letras");
		lblValiNombre.setBounds(502, 42, 215, 14);
		add(lblValiNombre);
		
		lblValiApellido = new JLabel("* Este campo solo admite letras");
		lblValiApellido.setBounds(502, 80, 215, 14);
		add(lblValiApellido);
		
		lblValiDni = new JLabel("* El DNI esta compuesto por 8 numeros y una letra");
		lblValiDni.setBounds(502, 129, 270, 14);
		add(lblValiDni);
		
		lblValiContra = new JLabel("<html>* La contraseña debe tener 8 caracteres de longuitud</br> con minimo una letra mayuscula, minuscula y un numero</html>");
		lblValiContra.setBounds(502, 253, 310, 59);
		add(lblValiContra);
		
		lblValiContraCoinciden = new JLabel("* Las contraseñas no coinciden");
		lblValiContraCoinciden.setBounds(502, 323, 249, 20);
		add(lblValiContraCoinciden);

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
