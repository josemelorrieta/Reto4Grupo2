package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class CondicionesLegales extends JFrame {

	private static final long serialVersionUID = 1L;

	public JButton btnCerrar;
	public JScrollPane scroll;

	final String texto = "1. DATOS IDENTIFICATIVOS\r\n" + 
			"En cumplimiento con el deber de información recogido en artículo 10 de la Ley 34/2002, de 11 de julio, de Servicios de la Sociedad de la Información y del Comercio Electrónico, a continuación se reflejan los siguientes datos: la empresa titular de dominio web es RRRRR (en adelante NNNNN), con domicilio a estos efectos en DDDDD número de C.I.F.: CCCCC inscrita en el MMMMM. Correo electrónico de contacto: EEEEE del sitio web.\r\n" + 
			"\r\n" + 
			" \r\n" + 
			"\r\n" + 
			"2. USUARIOS\r\n" + 
			"El acceso y/o uso de este portal de NNNNN atribuye la condición de USUARIO, que acepta, desde dicho acceso y/o uso, las Condiciones Generales de Uso aquí reflejadas. Las citadas Condiciones serán de aplicación independientemente de las Condiciones Generales de Contratación que en su caso resulten de obligado cumplimiento.\r\n" + 
			"\r\n" + 
			" \r\n" + 
			"\r\n" + 
			"3. USO DEL PORTAL\r\n" + 
			"WWWWW proporciona el acceso a multitud de informaciones, servicios, programas o datos (en adelante, «los contenidos») en Internet pertenecientes a NNNNN o a sus licenciantes a los que el USUARIO pueda tener acceso. El USUARIO asume la responsabilidad del uso del portal. Dicha responsabilidad se extiende al registro que fuese necesario para acceder a determinados servicios o contenidos.\r\n" + 
			"En dicho registro el USUARIO será responsable de aportar información veraz y lícita. Como consecuencia de este registro, al USUARIO se le puede proporcionar una contraseña de la que será responsable,\r\n" + 
			"comprometiéndose a hacer un uso diligente y confidencial de la misma. El USUARIO se compromete a hacer un uso adecuado de los contenidos y servicios (como por ejemplo servicios de chat, foros de discusión o grupos de noticias) que Nombre de la empresa creadora del sitio web ofrece a través de su portal y con carácter enunciativo pero no limitativo, a no emplearlos para (i) incurrir en actividades ilícitas, ilegales o contrarias a la buena fe y al orden público; (ii) difundir contenidos o propaganda de carácter racista, xenófobo, pornográfico-ilegal, de apología del terrorismo o atentatorio contra los derechos humanos; (iii) provocar daños en los sistemas físicos y lógicos de Nombre de la empresa creadora del sitio web , de sus proveedores o de terceras personas, introducir o difundir en la red virus informáticos o cualesquiera otros sistemas físicos o lógicos que sean susceptibles de provocar los daños anteriormente mencionados; (iv) intentar acceder y, en su caso, utilizar las cuentas de correo electrónico de otros usuarios y modificaro manipular sus mensajes. Nombre de la empresa creadora del sitio web se reserva el derecho de retirar todos aquellos comentarios y aportaciones que vulneren el respeto a la dignidad de la persona, que sean discriminatorios, xenófobos, racistas, pornográficos, que atenten contra la juventud o la infancia, el orden o la seguridad pública o que, a su juicio, no resultaran adecuados para su publicación. En cualquier caso, NNNNN no será responsable de las opiniones vertidas por los usuarios a través de los foros, chats, u otras herramientas de participación.\r\n" + 
			"\r\n" + 
			" \r\n" + 
			"\r\n" + 
			"4. PROTECCIÓN DE DATOS\r\n" + 
			"NNNNN cumple con las directrices de la Ley Orgánica 15/1999 de 13 de diciembre de Protección de Datos de Carácter Personal, el Real Decreto 1720/2007 de 21 de diciembre por el que se aprueba el Reglamento de desarrollo de la Ley Orgánica y demás normativa vigente en cada momento, y vela por garantizar un correcto uso y tratamiento de los datos personales del usuario. Para ello, junto a cada formulario de recabo de datos de carácter personal, en los servicios que el usuario pueda solicitar a KKKKK, hará saber al usuario de la existencia y aceptación de las condiciones particulares del tratamiento de sus datos en cada caso, informándole de la responsabilidad del fichero creado, la dirección del responsable, la posibilidad de ejercer sus derechos de acceso, rectificación, cancelación u oposición, la finalidad del tratamiento y las comunicaciones de datos a terceros en su caso.\r\n" + 
			"\r\n" + 
			"Asimismo, NNNNN informa que da cumplimiento a la Ley 34/2002 de 11 de julio, de Servicios de la Sociedad de la Información y el Comercio Electrónico y le solicitará su consentimiento al tratamiento de su correo electrónico con fines comerciales en cada momento.\r\n" + 
			"\r\n" + 
			" \r\n" + 
			"\r\n" + 
			"5. PROPIEDAD INTELECTUAL E INDUSTRIAL\r\n" + 
			"NNNNN por sí o como cesionaria, es titular de todos los derechos de propiedad intelectual e industrial desu página web, así como de los elementos contenidos en la misma (a título enunciativo, imágenes, sonido, audio, vídeo, software o textos; marcas o logotipos, combinaciones de colores, estructura y diseño, selección de materiales usados, programas de ordenador necesarios para su funcionamiento, acceso y uso, etc.), titularidad de NNNNN o bien de sus licenciantes.\r\n" + 
			"\r\n" + 
			"Todos los derechos reservados. En virtud de lo dispuesto en los artículos 8 y 32.1, párrafo segundo, de la Ley de Propiedad Intelectual, quedan expresamente prohibidas la reproducción, la distribución y la comunicación pública, incluida su modalidad de puesta a disposición, de la totalidad o parte de los contenidos de esta página web, con fines comerciales, en cualquier soporte y por cualquier medio técnico, sin la autorización de NNNNN. El USUARIO se compromete a respetar los derechos de Propiedad Intelectual e Industrial titularidad de NNNNN. Podrá visualizar los elementos del portal e incluso imprimirlos, copiarlos y almacenarlos en el disco duro de su ordenador o en cualquier otro soporte físico siempre y cuando sea, única y exclusivamente, para su uso personal y privado. El USUARIO deberá abstenerse de suprimir, alterar, eludir o manipular cualquier dispositivo de protección o sistema de seguridad que estuviera instalado en el las páginas de NNNNN.\r\n" + 
			"\r\n" + 
			" \r\n" + 
			"\r\n" + 
			"6. EXCLUSION DE GARANTIAS Y RESPONSABILIDAD\r\n" + 
			"NNNNN no se hace responsable, en ningún caso, de los daños y perjuicios de cualquier naturaleza que pudieran ocasionar, a título enunciativo: errores u omisiones en los contenidos, falta de disponibilidad del portal o la transmisión de virus o programas maliciosos o lesivos en los contenidos, a pesar de haber adoptado todas las medidas tecnológicas necesarias para evitarlo.\r\n" + 
			"\r\n" + 
			" \r\n" + 
			"\r\n" + 
			"7. MODIFICACIONES\r\n" + 
			"NNNNN se reserva el derecho de efectuar sin previo aviso las modificaciones que considere oportunas en su portal, pudiendocambiar, suprimir o añadir tanto los contenidos y servicios que se presten a través de la misma como la forma en la que éstos aparezcan presentados o localizados en su portal.\r\n" + 
			"\r\n" + 
			" \r\n" + 
			"\r\n" + 
			"8. ENLACES\r\n" + 
			"En el caso de que en WWWWW se dispusiesen enlaces o hipervínculos hacía otros sitios de Internet, NNNNN no ejercerá ningún tipo de control sobre dichos sitios y contenidos. En ningún caso\r\n" + 
			"NNNNN asumirá responsabilidad alguna por los contenidos de algún enlace perteneciente a un sitio web ajeno, ni garantizará la disponibilidad técnica, calidad, fiabilidad, exactitud, amplitud, veracidad, validez y\r\n" + 
			"constitucionalidad de cualquier material o información contenida en ninguno de dichos hipervínculos u otros sitios de Internet.\r\n" + 
			"\r\n" + 
			"Igualmente la inclusión de estas conexiones externas no implicará ningún tipo de asociación, fusión o participación con las entidades conectadas.\r\n" + 
			"\r\n" + 
			" \r\n" + 
			"\r\n" + 
			"9. DERECHO DE EXCLUSIÓN\r\n" + 
			"NNNNN se reserva el derecho a denegar o retirar el acceso a portal y/o los servicios ofrecidos sin necesidad de preaviso, a instancia propia o de un tercero, a aquellos usuarios que incumplan las presentes Condiciones Generales de Uso.\r\n" + 
			"\r\n" + 
			" \r\n" + 
			"\r\n" + 
			"10.GENERALIDADES\r\n" + 
			"NNNNN perseguirá el incumplimiento de las presentes condiciones así como cualquier utilización indebida de su portal ejerciendo todas las acciones civiles y penales que le puedan corresponder en derecho.\r\n" + 
			"\r\n" + 
			" \r\n" + 
			"\r\n" + 
			"11.MODIFICACIÓN DE LAS PRESENTES CONDICIONES Y DURACIÓN\r\n" + 
			"NNNNN podrá modificar en cualquier momento las condiciones aquí determinadas, siendo debidamente publicadas como aquí aparecen.\r\n" + 
			"\r\n" + 
			"La vigencia de las citadas condiciones irá en función de su exposición y estarán vigentes hasta debidamente publicadas. que sean modificadas por otras.\r\n" + 
			"\r\n" + 
			" \r\n" + 
			"\r\n" + 
			"12. LEGISLACIÓN APLICABLE Y JURISDICCIÓN\r\n" + 
			"La relación entre NNNNN y el USUARIO se regirá por la normativa española vigente y cualquier controversia se someterá a los Juzgados y tribunales de la ciudad de QQQQQ.";
	/**
	 * Create the panel.
	 */
	public CondicionesLegales() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CondicionesLegales.class.getResource("/imagenes/general/logo.png")));
		getContentPane().setLayout(null);
		setSize(695,587);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("BIDAI-ON - Condiciones legales");
		
		JLabel lblTitulo = new JLabel("Condiciones Legales");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTitulo.setBounds(23, 11, 402, 47);
		lblTitulo.setForeground(new Color(0,109,214));
		getContentPane().add(lblTitulo);
		
		JTextArea txtAreaCondiciones = new JTextArea();
		txtAreaCondiciones.setFont(new Font("Monospaced", Font.PLAIN, 14));
		txtAreaCondiciones.setLineWrap(true);
		txtAreaCondiciones.setWrapStyleWord(true);
		txtAreaCondiciones.setEditable(false);
		txtAreaCondiciones.setText(texto);
//		txtAreaCondiciones.setBounds(23, 53, 644, 420);
		getContentPane().add(txtAreaCondiciones);
		
		scroll = new JScrollPane(txtAreaCondiciones);
		scroll.setLocation(23, 53);
		scroll.setSize(644, 420);
		getContentPane().add(scroll);
		
		btnCerrar = new JButton("CERRAR");
		btnCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCerrar.setIcon(new ImageIcon(CondicionesLegales.class.getResource("/imagenes/general/boton140.png")));
		btnCerrar.setForeground(Color.WHITE);
		btnCerrar.setFocusPainted(false);
		btnCerrar.setMargin(new Insets(0, 0, 0, 0));
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setBorderPainted(false);
		btnCerrar.setOpaque(false);
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCerrar.setBounds(290, 500, 140, 40);
		btnCerrar.setHorizontalTextPosition(JButton.CENTER);
		btnCerrar.setVerticalTextPosition(JButton.CENTER);
		getContentPane().add(btnCerrar);

	}
}
