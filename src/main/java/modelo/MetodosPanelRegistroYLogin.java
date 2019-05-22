package modelo;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeUtility;
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
	private final static String keyBuffer = "bidaion4";

	/**
	 * Array de booleanos que se utiliza para validar la informacion introducida por
	 * el cliente, se usa para no volver a comprobar los datos mediante sus metodos
	 * designados
	 */
	public boolean[] comprobacionRegistro = { false, false, false, false, false, false };
	public boolean[] comprobarAcompaniante = { false, false, false };
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
	public boolean comprobarDatos(boolean[] array) {
		for (boolean estado : array) {
			if (!estado)
				return false;
		}
		return true;
	}

	/**
	 * Devuelve el array de booleanos y el booleano del login a su estado original
	 */
	public void resetComprobacion() {
		for (int i = 0; i < comprobacionRegistro.length; i++)
			comprobacionRegistro[i] = false;
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
	 * @param panel Donde estan los datos
	 * @return objeto cliente
	 */
	public Cliente crearCliente(PanelRegistro panel) {
		String pass = "";
		String dni = "";
		String nombre = "";
		String apellido = "";
		try {
			pass = encripta(panel.pwdContra.getPassword().toString());
			nombre = encripta(panel.txtNombre.getText());
			dni = encripta(panel.txtDni.getText());
			apellido = encripta(panel.txtApellido.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Cliente(dni, nombre, apellido, panel.calenNacimiento.getDate(), (Sexo) panel.comboBoxSexo.getSelectedItem(), pass);
	}

	/**
	 * Logea al usuario en la aplicacion
	 * 
	 * @param panel panel de donde provienen los datos
	 * @return Cliente si los datos introducidos son correctos o null si la
	 *         contraseña es correcta o si no hay ningun usuario con ese dni
	 */
	public Cliente login(PanelLogin panel) {
		String dni = "";
		String contraIntroducida = "";
		try {
			dni = encripta(panel.txtDni.getText());
			contraIntroducida = encripta(new String(panel.pwdContra.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}

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

	/**
	 * Registra un cliente si no esta registrado en la base de datos
	 * 
	 * @param panel panel donde se encuentra la informacion del cliente
	 * @return Cliente
	 */
	public Cliente registro(PanelRegistro panel) {
		String dni = "";
		try {
			dni = encripta(panel.txtDni.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String json = bd.consultarToGson("select `dni` from cliente where `dni`='" + dni + "'");
		if (json.equals("")) {
			return crearCliente(panel);
		} else {
			JOptionPane.showMessageDialog(null, "Este usuario ya esta registrado", null, JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	/**
	 * Funcion para comprobar si el dni indicado por parametro esta en la base de
	 * datos
	 * 
	 * @param dni dni de usuario
	 * @return false si el usuario NO esta registrado, true si ya esta registrado
	 */
	public boolean comprobarRegistradoClienteExtra(String dni) {
		String json = bd.consultarToGson("select `dni` from clienteextra where `dni`='" + dni + "'");
		if (json.equals("")) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Funcion para registrar a un cliente extra en la base de datos
	 * @param cliente que se quiere registrar
	 * @return true si ha sido registrado correctamente, false si no ha hecho nada
	 */
	public boolean registrarClienteExtra(Cliente cliente) {
		if (!comprobarRegistradoClienteExtra(cliente.getDni())) {
			bd.insertGenerico(cliente.toArrayClienteExtra(), "clienteextra");
			return true;
		}
		return false;
	}

	/**
	 * Funcion para borrar un cliente extra de la base de datos
	 * @param dni del cliente que se quiere borrar
	 * @return true si ha sido borrado correctamente, false si no ha hecho nada
	 */
	public boolean borrarClienteExtra(String dni) {
		if (comprobarRegistradoClienteExtra(dni)) {
			if (!comprobarReservasPrevias(dni)) {
				String[] condicion = {"`dni` = '"+dni+"'"};
				bd.deleteGenerico("clienteextra", condicion);
				return true;
			}
		}
		return false;
	}

	/**
	 * Funcion para comprobar si el dni del cliente introducido ha sido cliente extra alguna vez
	 * @param dni de cliente
	 * @return true si ha sido cliente extra anteriormente, false en caso contrario
	 */
	public boolean comprobarReservasPrevias(String dni) {
		try {
			dni = encripta(dni);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String json = bd.consultarToGson("select `dni` from rsvcliextra where `dni`='" + dni + "'");
		if (json.equals("")) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Codifica un array de bytes en base64
	 * 
	 * @param b array de bytes a codificar
	 * @return array de bytes en base64
	 * @throws Exception
	 */
	public byte[] encode(byte[] b) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		OutputStream b64os = MimeUtility.encode(baos, "base64");
		b64os.write(b);
		b64os.close();

		return baos.toByteArray();
	}

	/**
	 * Decodifica un array desde base64
	 * 
	 * @param b array de bytes a decodificar
	 * @return array de bytes decodificado
	 * @throws Exception
	 */
	public byte[] decode(byte[] b) throws Exception {
		ByteArrayInputStream bais = new ByteArrayInputStream(b);
		InputStream b64is = MimeUtility.decode(bais, "base64");
		byte[] tmp = new byte[b.length];
		int n = b64is.read(tmp);
		byte[] res = new byte[n];
		System.arraycopy(tmp, 0, res, 0, n);

		return res;
	}

	/**
	 * Pasa la semilla para encriptar los datos como clave secreta
	 * 
	 * @return la semilla convertida en clave secreta
	 */
	private SecretKeySpec getKey() {
		SecretKeySpec key = new SecretKeySpec(keyBuffer.getBytes(), "DES");

		return key;
	}

	/**
	 * Desencripta una cadena por medio de una semilla
	 * 
	 * @param s Cadena a desencriptar
	 * @return Cadena desencriptada
	 * @throws Exception
	 */
	public String desencripta(String s) throws Exception {
		String s1 = null;
		if (s.indexOf("{DES}") != -1) {
			String s2 = s.substring("{DES}".length());
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(2, getKey());
			byte abyte0[] = cipher.doFinal(decode(s2.getBytes()));
			s1 = new String(abyte0);
		} else {
			s1 = s;
		}

		return s1;
	}

	/**
	 * Encripta una cadena por medio de una semilla
	 * 
	 * @param s Cadena a encriptar
	 * @return Cadena encriptada
	 * @throws Exception
	 */
	public String encripta(String s) throws Exception {
		byte abyte0[];
		SecureRandom securerandom = new SecureRandom();
		securerandom.nextBytes(keyBuffer.getBytes());
		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		cipher.init(1, getKey());
		abyte0 = encode(cipher.doFinal(s.getBytes())); // antes

		return "{DES}" + new String(abyte0);
	}

	/**
	 * Pone limite a la fecha de nacimiento
	 * 
	 * @param calen
	 */
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
	 * @param pass jpasswordfield de contrasenia
	 * @param aviso label que muestra mensaje de error
	 * @return true si la contrasenia es valida, false en caso contrario
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
	 * @param campoTexto campo de texto
	 * @param aviso jlabel con mensaje
	 * @return true si el texto cumple los requisitos, false en caso contrario
	 */
	public boolean validarSoloLetras(JTextField campoTexto, JLabel aviso) {
		if (!(campoTexto.getText().matches("^[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$"))) {
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
	public boolean comprobarCodigoPromocional(String codigo, String dni, Alojamiento aloj, String tablaAux) {
		if (codigo.length() == 5) {
			Gson gson = new Gson();
			String json;
			String tabla = FuncionesGenerales.tipoAloj(aloj);
			if (tabla.equalsIgnoreCase("hab"))
				tabla = "Hot";
			if (dni != null && aloj != null) {
				json = bd.consultarToGson("SELECT `idCod` 'auxiliar' FROM `cod" + tabla.toLowerCase() + "` WHERE `dni` ='" + dni + "' AND `id" + tabla + "` ='" + aloj.getId() + "'");
				Global[] codigoBD = gson.fromJson(json, Global[].class);
				if (json.equals("")) {
					return false;
				} else if (((String) codigoBD[0].getAuxiliar()).equals(codigo)) {
					return true;
				} else
					return false;
			} else {
				json = bd.consultarToGson("SELECT `idCod` 'auxiliar' FROM `cod" + tablaAux.toLowerCase() + "` WHERE `idCod` ='" + codigo + "'");
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
			String codigoProm = String.copyValueOf(generarCodigoAleatorio(5));
			String tipoAloj = FuncionesGenerales.tipoAloj(aloj);
			if(tipoAloj.equals("Hab"))
				tipoAloj = "hot";
			if (comprobarCodigoPromocional(codigoProm, null, null, tipoAloj)) {
				Object[] preparedItems = { codigoProm, aloj.getId(), dni };
				bd.insertGenerico(preparedItems, "cod" + tipoAloj.toLowerCase());
				return codigoProm;
			}/*else {
				JOptionPane.showMessageDialog(null, "Error al insertar codigo en la BD", "Error", JOptionPane.ERROR_MESSAGE);
				return null;
			}*/
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
