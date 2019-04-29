package modelo;

import java.awt.Color;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.google.gson.Gson;
import com.toedter.calendar.JDateChooser;

import BaseDatos.ConsultaBD;
import vista.panelCard.PanelLogin;
import vista.panelCard.PanelRegistro;

public class MetodosPanelRegistroYLogin {
	private ConsultaBD bd;
	private Gson gson = new Gson();
	private Modelo mod;

	/**
	 * Array de booleanos que se utiliza para validar la informacion introducida por
	 * el cliente, se usa para no volver a comprobar los datos mediante sus metodos
	 * designados
	 */
	public boolean[] comprobacionRegistro = { false, false, false, false, false };
	public boolean comprobacionLogin = false;

	public MetodosPanelRegistroYLogin(Modelo mod, ConsultaBD bd) {
		this.bd=bd;
		this.mod=mod;
	}
	

	/**
	 * Comprueba que todos los datos introducidos sean correctos
	 * 
	 * @return true si esta todo bien
	 */
	public boolean comprobarDatos() {
		for (boolean estado : comprobacionRegistro) {
			if (!estado)
				return false;
		}
		return true;
	}

	/**
	 * Devuelve el array de booleanos y el booleano del login a su estado original
	 */
	public void resetComprobacion() {
		for (boolean estado : comprobacionRegistro) {
			estado = false;
		}
		comprobacionLogin = false;
	}

	/**
	 * Limpia el panel de registro
	 * 
	 * @param panel Panel registro
	 */
	public void limpiar(PanelRegistro panel) {
		Color colorPass = new JPasswordField().getBackground();
		Color colorTxt = new JTextField().getBackground();
		resetComprobacion();
		visibilidadContrasenia(panel, true);
		panel.txtNombre.setText(null);
		panel.txtNombre.setBackground(colorTxt);

		panel.txtApellido.setText(null);
		panel.txtApellido.setBackground(colorTxt);

		panel.txtDni.setText(null);
		panel.txtDni.setBackground(colorTxt);

		limitarFechaNacimiento(panel.calenNacimiento);

		panel.comboBoxSexo.setSelectedIndex(0);

		panel.pwdContra.setText(null);
		panel.pwdContra.setBackground(colorPass);

		panel.pwdRepContra.setText(null);
		panel.pwdRepContra.setBackground(colorPass);

		panel.lblValiNombre.setVisible(false);
		panel.lblValiApellido.setVisible(false);
		panel.lblValiDni.setVisible(false);
		panel.lblValiContra.setVisible(false);
		panel.lblValiContraCoinciden.setVisible(false);
	}

	/**
	 * Limpia el panel de login
	 * @param panel Panel login
	 */
	public void limpiar(PanelLogin panel) {
		Color colorPass = new JPasswordField().getBackground();
		Color colorTxt = new JTextField().getBackground();
		resetComprobacion();
		visibilidadContrasenia(panel, true);

		panel.txtDni.setText(null);
		panel.txtDni.setBackground(colorTxt);

		panel.pwdContra.setText(null);
		panel.pwdContra.setBackground(colorPass);
	}

	/**
	 * Cambia la visibilidad del campo contrasenia en el panel registro
	 * 
	 * @param panel panel donde se encuentran los textfield
	 * @param reset booleano, poner true si se quiere dejar en el estado original
	 */
	public void visibilidadContrasenia(PanelRegistro panel, boolean reset) {
		if (!panel.pwdContra.echoCharIsSet() || reset) {
			char echo = new JPasswordField().getEchoChar();
			panel.pwdContra.setEchoChar(echo);
			panel.pwdRepContra.setEchoChar(echo);
			panel.contraOn0.setIcon(panel.iconoOn);
			panel.contraOn1.setIcon(panel.iconoOn);
		} else {
			panel.pwdContra.setEchoChar('\0');
			panel.pwdRepContra.setEchoChar('\0');
			panel.contraOn0.setIcon(panel.iconoOff);
			panel.contraOn1.setIcon(panel.iconoOff);
		}
	}

	/**
	 * Cambia la visibilidad del campo contrasenia en el panel login
	 * 
	 * @param panel panel donde se encuentran los textfield
	 * @param reset booleano, poner true si se quiere dejar en el estado original
	 */
	public void visibilidadContrasenia(PanelLogin panel, boolean reset) {
		if (!panel.pwdContra.echoCharIsSet() || reset) {
			char echo = new JPasswordField().getEchoChar();
			panel.pwdContra.setEchoChar(echo);
			panel.contraOn0.setIcon(panel.iconoOn);
		} else {
			panel.pwdContra.setEchoChar('\0');
			panel.contraOn0.setIcon(panel.iconoOff);
		}
	}

	/**
	 * Crea un objeto cliente a partid de los datos en el panel
	 * 
	 * @param panel Donde estan los daots
	 * @return objeto cliente
	 */
	public Cliente crearCliente(PanelRegistro panel) {
		return new Cliente(panel.txtDni.getText(), panel.txtNombre.getText(), panel.txtApellido.getText(), panel.calenNacimiento.getDate(), (Sexo) panel.comboBoxSexo.getSelectedItem(), panel.pwdContra.getPassword().toString());
	}

	/**
	 * Logea al usuario en la aplicacion
	 * 
	 * @param panel panel de donde provienen los datos
	 * @return Cliente si los datos introducidos son correctos o null si la
	 *         contraseña es correcta o si no hay ningun usuario con ese dni
	 */
	public Cliente login(PanelLogin panel) {
		String dni = panel.txtDni.getText();
		char[] contraIntroducida = panel.pwdContra.getPassword();

		String json = bd.consultarToGson("select `dni`,`nombre`,`apellidos` 'apellido',`fechaNac`,`sexo`,`password` 'contrasenia' from cliente where `dni`='" + dni + "'");
		gson = new Gson();
		if (!json.equals("")) {
			//Object[] aux= gson.fromJson(json, Object[].class);
			//aux.toString();
			
			Cliente[] cliente = gson.fromJson(json, Cliente[].class);
			if (cliente[0].getPassword().equals(contraIntroducida.toString())) {
				return cliente[0];
			} else {
				JOptionPane.showMessageDialog(null, "Contraseña incorrecta, vuelva a intertarlo", null, JOptionPane.ERROR_MESSAGE);
				return null;
			}
			
		}
		JOptionPane.showMessageDialog(null, "No hay ningun usuario con ese nombre, porfavor registrese", null, JOptionPane.ERROR_MESSAGE);
		return null;
	}

	/**
	 * Encriptacion de contrasenia en MD5
	 * 
	 * @param contrasenia contrasenia que se quiere encriptar
	 * @return string de la contrasenia encriptada
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

	public void limitarFechaNacimiento(JDateChooser calen) {
		Date fechaLimite = new Date();
		calen.setDate(fechaLimite);
		calen.setMaxSelectableDate(fechaLimite);
	}

	/**
	 * Comprueba que las contrasenias coinciden
	 * 
	 * @param pass1
	 * @param pass2
	 * @return
	 */
	public boolean constraseniaCoincide(JPasswordField pass1, JPasswordField pass2, JLabel aviso) {
		char[] contra1 = pass1.getPassword();
		char[] contra2 = pass2.getPassword();
		boolean condicion = contra1.length == contra2.length;
		if (!condicion) {
			aviso.setVisible(true);
			pass1.setBackground(new Color(240, 128, 128));
			pass2.setBackground(new Color(240, 128, 128));
			return false;
		} else if (condicion) {
			for (int i = 0; i < contra1.length; i++) {
				if (!(contra1[i] == contra2[i])) {
					aviso.setVisible(true);
					pass1.setBackground(new Color(240, 128, 128));
					pass2.setBackground(new Color(240, 128, 128));
					return false;
				}
			}
		}
		aviso.setVisible(false);
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
	public boolean seguridadContrasenia(JPasswordField pass, JLabel aviso) {
		// Regex para validar contraseña, por orden: Una letra minuscula, una letra
		// mayuscula, un numero y minimo 8 caracteres de longitud

		Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");
		String contraString = new String(pass.getPassword());
		Matcher m = p.matcher(contraString);
		if (m.matches()) {
			pass.setBackground(new JPasswordField().getBackground());
			aviso.setVisible(false);
			return true;
		} else {
			pass.setBackground(new Color(240, 128, 128));
			aviso.setVisible(true);
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
	public boolean validarDNI(JTextField DNI, JLabel aviso) {
		if (!(DNI.getText().matches("^[0-9]{7,8}['T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E|T]$"))) {
			aviso.setVisible(true);
			DNI.setBackground(new Color(240, 128, 128));
			return false;
		} else {
			aviso.setVisible(false);
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
	public boolean validarSoloLetras(JTextField campoTexto, JLabel aviso) {
		if (!(campoTexto.getText().matches("^[a-zA-Z]+$"))) {
			aviso.setVisible(true);
			campoTexto.setBackground(new Color(240, 128, 128));
			return false;
		} else {
			aviso.setVisible(false);
			campoTexto.setBackground(new JTextField().getBackground());
			return true;
		}
	}
}
