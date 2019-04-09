package vista.panelCard;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

import modelo.Sexo;

import javax.swing.JComboBox;

public class PanelRegistro extends JPanel {
	JLabel lblApellido,lblFechaNacimiento,lblSexo,lblContrasenia,lblRepetirContrasenia;
	JTextField txtNombre,txtApellido;
	JDateChooser calenNacimiento;
	JComboBox<Sexo> comboBoxSexo;
	JSpinnerDateEditor spnDateEditorNacimiento;

	JPasswordField pwdContra,pwdRepContra;
	/**
	 * Create the panel.
	 */
	public PanelRegistro() {
		setParametros();
		instanciarObjetos();
	}

	public void setParametros() {
		setLayout(null);
		setPreferredSize(new Dimension(853, 647));
		
		pwdContra = new JPasswordField();
		pwdContra.setBounds(249, 424, 233, 58);
		add(pwdContra);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(67, 79, 123, 20);
		add(lblNombre);
		
		pwdRepContra = new JPasswordField();
		pwdRepContra.setBounds(249, 493, 221, 64);
		add(pwdRepContra);
		
		txtNombre = new JTextField();
		txtNombre.setText("Nombr");
		txtNombre.setBounds(291, 105, 86, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setText("Apellido");
		txtApellido.setBounds(291, 168, 86, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		
		spnDateEditorNacimiento = new JSpinnerDateEditor();
		((JSpinner.DefaultEditor) spnDateEditorNacimiento.getEditor()).getTextField().setEditable(false);
		
		calenNacimiento = new JDateChooser(null, null, null, spnDateEditorNacimiento);
		calenNacimiento.setDateFormatString("dd-MM-yyyy");
		calenNacimiento.setBounds(275, 251, 137, 27);
		add(calenNacimiento);
		
		comboBoxSexo = new JComboBox<Sexo>();
		comboBoxSexo.setBounds(249, 312, 199, 74);
		add(comboBoxSexo);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(71, 171, 119, 35);
		add(lblApellido);
		
		lblFechaNacimiento = new JLabel("Fecha nacimiento:");
		lblFechaNacimiento.setBounds(71, 254, 119, 35);
		add(lblFechaNacimiento);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(67, 327, 119, 35);
		add(lblSexo);
		
		lblContrasenia = new JLabel("Contraseña:");
		lblContrasenia.setBounds(53, 446, 119, 35);
		add(lblContrasenia);
		
		lblRepetirContrasenia = new JLabel("Repetir contraseña:");
		lblRepetirContrasenia.setBounds(53, 491, 119, 35);
		add(lblRepetirContrasenia);
		
		
		JLabel[] arrayLabel= {lblApellido,lblFechaNacimiento,lblSexo,lblContrasenia,lblRepetirContrasenia};
		for(JLabel label:arrayLabel) {
			
		}
	}

	private void instanciarObjetos() {

	}
}
