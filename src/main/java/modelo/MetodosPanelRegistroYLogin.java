package modelo;

import java.awt.Color;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.toedter.calendar.JDateChooser;

import BaseDatos.ConsultaBD;
import util.FuncionesGenerales;
import vista.panelCard.PanelLogin;
import vista.panelCard.PanelRegistro;

public class MetodosPanelRegistroYLogin {
	private ConsultaBD bd;
	private GsonBuilder gson;
	private Gson gson1;
	private Modelo mod;

	/**
	 * Array de booleanos que se utiliza para validar la informacion introducida por
	 * el cliente, se usa para no volver a comprobar los datos mediante sus metodos
	 * designados
	 */
	public boolean[] comprobacionRegistro = { false, false, false, false, false, false };
	public boolean comprobacionLogin = false;

	public MetodosPanelRegistroYLogin(Modelo mod, ConsultaBD bd) {
		this.bd = bd;
		this.mod = mod;
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
		
		panel.chckbxCondiciones.setSelected(false);
	}

	/**
	 * Limpia el panel de login
	 * 
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

		panel.lblValiDni.setVisible(false);
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
		return new Cliente(encriptar(panel.txtDni.getText().toCharArray()), encriptar(panel.txtNombre.getText().toCharArray()), encriptar(panel.txtApellido.getText().toCharArray()), panel.calenNacimiento.getDate(), (Sexo) panel.comboBoxSexo.getSelectedItem(), encriptar(panel.pwdContra.getPassword()));
	}

	/**
	 * Logea al usuario en la aplicacion
	 * 
	 * @param panel panel de donde provienen los datos
	 * @return Cliente si los datos introducidos son correctos o null si la
	 *         contraseña es correcta o si no hay ningun usuario con ese dni
	 */
	public Cliente login(PanelLogin panel) {
		String dni = encriptar(panel.txtDni.getText().toCharArray());
		String contraIntroducida = encriptar(panel.pwdContra.getPassword());

		String json = bd.consultarToGson("select `dni`,`nombre`,`apellidos` 'apellidos',`fechaNac`,`sexo`,`password` from cliente where `dni`='" + dni + "'");
		gson = new GsonBuilder();
		gson.setDateFormat("yyyy-MM-dd");
		gson1 = gson.create();
		if (!json.equals("")) {
			Cliente[] cliente = gson1.fromJson(json, Cliente[].class);
			if (cliente[0].getPassword().equals(contraIntroducida)) {
				return cliente[0];
			} else {
				JOptionPane.showMessageDialog(null, "Contraseña incorrecta, vuelva a intertarlo", null, JOptionPane.ERROR_MESSAGE);
				return null;
			}
		}
		JOptionPane.showMessageDialog(null, "No hay ningun usuario con ese nombre, porfavor registrese", null, JOptionPane.ERROR_MESSAGE);
		return null;
	}

	public Cliente registro(PanelRegistro panel) {
		String json = bd.consultarToGson("select `dni` from cliente where `dni`='" + encriptar(panel.txtDni.getText().toCharArray()) + "'");
		if (json.equals("")) {
			return crearCliente(panel);
		} else {
			JOptionPane.showMessageDialog(null, "Este usuario ya esta registrado", null, JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	/**
	 * Encriptacion de datos en MD5
	 * 
	 * @param cadena Cadena de datos que se quiere encriptar
	 * @return String de los datos encriptados
	 */
	public String encriptar(char[] cadena) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			String contraEnc = new String(cadena);
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
		pass2.setBackground(new JPasswordField().getBackground());
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
		if (!(DNI.getText().matches("^[0-9]{7,8}['T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E]$"))) {
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

	/**
	 * Comprueba si el codigo introducido por parametro existe en la bbdd y si
	 * corresponde al usuario y alojamiento seleccionado, si dni y alojamiento son
	 * null, comprueba que ese codigo exista en la base de datos
	 * 
	 * @param codigo codigo promocional
	 * @param dni    dni del usuario (sin encriptar)
	 * @param aloj   (objeto hijo de aloj)
	 * @return
	 */
	public boolean comprobarCodigoPromocional(String codigo, String dni, Alojamiento aloj) {
		if (codigo.length() == 5) {
			Gson gson = new Gson();
			String json;
			String tabla = FuncionesGenerales.tipoAloj(aloj);
			if (dni != null && aloj != null) {
				json = bd.consultarToGson("SELECT `idCod` 'auxiliar' FROM `cod" + tabla.toLowerCase() + "` WHERE `dni` ='" + encriptar(dni.toCharArray()) + "' AND `id" + tabla + "` ='" + aloj.getId() + "'");
				Global[] codigoBD = gson.fromJson(json, Global[].class);
				if (((String) codigoBD[0].getAuxiliar()).equalsIgnoreCase(codigo)) {
					return true;
				} else
					return false;
			} else {
				json = bd.consultarToGson("SELECT `idCod` 'auxiliar' FROM `cod" + tabla.toLowerCase() + "` WHERE `idCod` ='" + codigo + "'");
				if (json.equals(""))
					return true;
				else
					return false;
			}
		} else
			return false;
	}

	/**
	 * Genera un char array de la longitud especificada
	 * 
	 * @param longitud longitud del array a crear
	 * @return el array con valores aleatorios
	 */
	public char[] generarCodigoAleatorio(int longitud) {
		final String stringValores = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		final char[] charArrValores = stringValores.toCharArray();

		char[] stringAleatorio = new char[longitud];
		for (int i = 0; i < stringAleatorio.length; i++) {
			int random = (int) (Math.random() * charArrValores.length);
			stringAleatorio[i] = charArrValores[random];
		}
		return stringAleatorio;
	}

	/**
	 * Genera e inserta en la bbdd un codigo promocional no repetido
	 * 
	 * @param aloj
	 * @param dni
	 * @return
	 */
	public String generarCodigoPromocional(Alojamiento aloj, String dni) {
		while (true) {
			String codigoProm = generarCodigoAleatorio(5).toString();
			String tipoAloj = FuncionesGenerales.tipoAloj(aloj);

			if (comprobarCodigoPromocional(codigoProm, null, null)) {
				Object[] preparedItems = { codigoProm, aloj.getId(), dni };
				bd.insertGenerico(preparedItems, "cod" + tipoAloj.toLowerCase());
				return codigoProm;
			}
		}
	}

	/**
	 * Borra el codigo especificado de la base de datos del tipo de alojamiento que
	 * le llega por parametro
	 * 
	 * @param codigo codigo promocional
	 * @param aloj   de que tipo de alojamiento debe borrar la tabla
	 * @return true en caso de delete ejecutado correctamente
	 */
	public boolean borrarCodigoPromocional(String codigo, Alojamiento aloj) {
		String tipo = FuncionesGenerales.tipoAloj(aloj);
		String[] condiciones = { "`idCod` = '" + codigo + "'" };
		return bd.deleteGenerico("cod" + tipo.toLowerCase(), condiciones);
	}
}
