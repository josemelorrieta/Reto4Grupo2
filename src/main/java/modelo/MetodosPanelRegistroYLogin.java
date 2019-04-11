package modelo;

import java.awt.Color;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import vista.panelCard.PanelRegistro;

public class MetodosPanelRegistroYLogin {

	/**
	 * Array de booleanos que se utiliza para validar la informacion introducida por
	 * el cliente, se usa para no volver a comprobar los datos mediante sus metodos
	 * designados
	 */
	public boolean[] comprobacion = { false, false, false, false, false, false };

	/**
	 * Comprueba que todos los datos introducidos sean correctos
	 * 
	 * @return true si esta todo bien
	 */
	public boolean comprobarDatos() {
		for (boolean estado : comprobacion) {
			if (!estado)
				return false;
		}
		return true;
	}

	/**
	 * Devuelve el array de booleanos a su estado original
	 */
	public void resetComprobacion() {
		for (boolean estado : comprobacion) {
			estado = false;
		}
	}

	public Cliente crearCliente(PanelRegistro panel) {
		return new Cliente(panel.txtDni.getText(), panel.txtNombre.getText(), panel.txtApellido.getText(), panel.calenNacimiento.getDate(), (Sexo) panel.comboBoxSexo.getSelectedItem(), panel.pwdContra.getPassword().toString());
	}

	/**
	 * Metodo para la incripatcion de la contraseña
	 * 
	 * @return
	 */
	public String encriptarContra(char[] contrasenia) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			String contraEnc = new String(contrasenia);
			byte[] hashInBytes = md.digest(contraEnc.getBytes(StandardCharsets.UTF_8));
			StringBuilder sb = new StringBuilder();
			for (byte b : hashInBytes) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Comprueba que la fecha sea anterior a hoy
	 * 
	 * @param fecha
	 * @return
	 */
	public boolean validarFecha(Date fecha) {
		if (!fecha.before(Calendar.getInstance().getTime())) {
			JOptionPane.showMessageDialog(null, "La fecha introducida es invalida", "Campo fecha", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else
			return true;
	}

	/**
	 * 
	 * @param pass1
	 * @param pass2
	 * @return
	 */
	public boolean constraseniaCoincide(JPasswordField pass1, JPasswordField pass2) {
		char[] contra1 = pass1.getPassword();
		char[] contra2 = pass2.getPassword();
		if (contra1.length == contra2.length) {
			for (int i = 0; i < contra1.length; i++) {
				if (!(contra1[i] == contra2[i])) {
					JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Campo contraseña", JOptionPane.ERROR_MESSAGE);
					pass1.setBackground(new Color(240, 128, 128));
					pass2.setBackground(new Color(240, 128, 128));
					return false;
				}
			}
		}
		pass1.setBackground(new JPasswordField().getBackground());
		pass1.setBackground(new JPasswordField().getBackground());
		return true;
	}

	/**
	 * Comprueba que has introducido la contraseña segun los criterios requeridos
	 * (letra mayus,letra minus, numero y almenos 8 caracteres)
	 * 
	 * @param contrasenia que se valida
	 * @return
	 */
	public boolean seguridadContrasenia(char[] contra) {
		// Regex para validar contraseña, por orden: Una letra minuscula, una letra
		// mayuscula, un numero y minimo 8 caracteres de longitud

		Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");
		String contraString = new String(contra);
		Matcher m = p.matcher(contraString);
		if (m.matches())
			return true;
		else {
			JOptionPane.showMessageDialog(null, "Introduce una letra minuscula, una mayuscula, un numero y al menos 8 caracteres", "Contraseña poco segura", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	/**
	 * Comprueba que el DNI cumple con los parametros de un DNI (8 numeros y una
	 * letra)
	 * 
	 * @param DNI
	 * @return
	 */
	public boolean validarDNI(JTextField DNI) {
		if (!(DNI.getText().matches("^[0-9]{7,8}['T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E|T]$"))) {
			JOptionPane.showMessageDialog(null, "El DNI introducido es invalido", "Error", JOptionPane.ERROR_MESSAGE);
			DNI.setBackground(new Color(240, 128, 128));
			return false;
		} else {
			DNI.setBackground(new JTextField().getBackground());
			return true;
		}
	}

	/**
	 * Comprueba que has metido letras en el campo de texto
	 * 
	 * @param vis
	 * @return
	 */
	public boolean validarSoloLetras(JTextField campoTexto) {
		if (!(campoTexto.getText().matches("^[a-zA-Z]+$"))) {
			JOptionPane.showMessageDialog(null, "Este campo solo admite letras", "Error", JOptionPane.ERROR_MESSAGE);
			campoTexto.setBackground(new Color(240, 128, 128));
			return false;
		} else {
			campoTexto.setBackground(new JTextField().getBackground());
			return true;
		}
	}
}
