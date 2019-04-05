package vista.panelCard;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelPago extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton btn500, btn200, btn100, btn50, btn20, btn10, btn5, btn2, btn1, btn050, btn020, btn010, btn005, btn002, btn001;
	public JButton[] arrayBtn = {btn500, btn200, btn100, btn50, btn20, btn10, btn5, btn2, btn1, btn050, btn020, btn010, btn005, btn002, btn001};
	public JLabel lblEuro1, lblEuro2, lblEuro3, lblAPagar, lblPagado, lblDineroMetido;
	public JTextField textAPagar, textPagado, textVueltas;
	public JList<String> listaCambio;
	public DefaultListModel<String> modeloCambio;

	
	public PanelPago() {
		setParametros();
		instanciarObjetos();
	}
	
	public void setParametros() {
		setLayout(null);
		setPreferredSize(new Dimension(590, 390));
	}
	
	public void instanciarObjetos() {
		lblDineroMetido = new JLabel("Dinero metido:");
		lblDineroMetido.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblDineroMetido.setBounds(309, 75, 169, 35);
		add(lblDineroMetido);

		textPagado = new JTextField();
		textPagado.setHorizontalAlignment(SwingConstants.CENTER);
		textPagado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textPagado.setBounds(309, 110, 130, 41);
		add(textPagado);
		textPagado.setColumns(10);

		lblPagado = new JLabel("Vueltas:");
		lblPagado.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblPagado.setBounds(581, 75, 112, 35);
		add(lblPagado);

		textVueltas = new JTextField();
		textVueltas.setHorizontalAlignment(SwingConstants.CENTER);
		textVueltas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textVueltas.setBounds(581, 110, 104, 41);
		add(textVueltas);

		textVueltas.setBounds(581, 108, 104, 41);
		add(textVueltas);
		textVueltas.setColumns(10);

		btn5 = new JButton("5");
		btn5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn5.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/5euros.jpg")));
		btn5.setFont(btn5.getFont().deriveFont(0f));
		btn5.setBounds(84, 423, 59, 35);
		add(btn5);

		btn2 = new JButton("2");
		btn2.setBackground(new Color(193, 240, 240));
		btn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn2.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/2euros.png")));
		btn2.setFont(btn2.getFont().deriveFont(0f));
		btn2.setBounds(296, 197, 59, 54);
		add(btn2);

		btn10 = new JButton("10");
		btn10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn10.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/10euros.jpg")));
		btn10.setFont(btn10.getFont().deriveFont(0f));
		btn10.setBounds(128, 360, 59, 35);
		add(btn10);

		btn200 = new JButton("200");
		btn200.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn200.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/200euros.jpg")));
		btn200.setFont(btn200.getFont().deriveFont(0f));
		btn200.setBounds(128, 207, 59, 35);
		add(btn200);

		btn20 = new JButton("20");
		btn20.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn20.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/20euros.jpg")));
		btn20.setFont(btn20.getFont().deriveFont(0f));
		btn20.setBounds(40, 360, 59, 35);
		add(btn20);

		btn500 = new JButton("500");
		btn500.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn500.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/500euros.jpg")));
		btn500.setFont(btn500.getFont().deriveFont(0f));
		btn500.setBounds(40, 207, 59, 35);
		add(btn500);

		btn100 = new JButton("100");
		btn100.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn100.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/100euros.jpg")));
		btn100.setFont(btn100.getFont().deriveFont(0f));
		btn100.setBounds(40, 279, 59, 35);
		add(btn100);

		btn50 = new JButton("50");
		btn50.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn50.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/50euros.jpg")));
		btn50.setFont(btn50.getFont().deriveFont(0f));
		btn50.setBounds(128, 279, 59, 35);
		add(btn50);

		btn1 = new JButton("1");
		btn1.setBackground(new Color(193, 240, 240));
		btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn1.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/1euro.png")));
		btn1.setFont(btn1.getFont().deriveFont(0f));
		btn1.setBounds(374, 197, 59, 54);
		add(btn1);

		btn050 = new JButton("0.50");
		btn050.setBackground(new Color(193, 240, 240));
		btn050.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn050.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/50centimos.png")));
		btn050.setFont(btn050.getFont().deriveFont(0f));
		btn050.setBounds(296, 279, 59, 54);
		add(btn050);

		btn020 = new JButton("0.20");
		btn020.setBackground(new Color(193, 240, 240));
		btn020.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn020.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/20centimos.png")));
		btn020.setFont(btn020.getFont().deriveFont(0f));
		btn020.setBounds(374, 279, 59, 54);
		add(btn020);

		btn010 = new JButton("0.10");
		btn010.setBackground(new Color(193, 240, 240));
		btn010.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn010.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/10centimos.png")));
		btn010.setFont(btn010.getFont().deriveFont(0f));
		btn010.setBounds(296, 360, 59, 54);
		add(btn010);

		btn005 = new JButton("0.05");
		btn005.setBackground(new Color(193, 240, 240));
		btn005.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn005.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/5centimos.png")));
		btn005.setFont(btn005.getFont().deriveFont(0f));
		btn005.setBounds(374, 360, 59, 54);
		add(btn005);

		btn002 = new JButton("0.02");
		btn002.setBackground(new Color(193, 240, 240));
		btn002.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn002.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/2centimos.png")));
		btn002.setFont(btn002.getFont().deriveFont(0f));
		btn002.setBounds(296, 439, 59, 54);
		add(btn002);

		btn001 = new JButton("0.01");
		btn001.setBackground(new Color(193, 240, 240));
		btn001.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn001.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/1centimo.png")));
		btn001.setFont(btn001.getFont().deriveFont(0f));
		btn001.setBounds(374, 439, 59, 54);
		add(btn001);

		lblEuro1 = new JLabel("\u20AC");
		lblEuro1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblEuro1.setBounds(695, 121, 43, 35);
		add(lblEuro1);

		lblEuro2 = new JLabel("\u20AC");
		lblEuro2.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblEuro2.setBounds(449, 121, 29, 35);
		add(lblEuro2);

		lblEuro3 = new JLabel("\u20AC");
		lblEuro3.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblEuro3.setBounds(166, 121, 29, 35);
		add(lblEuro3);

		lblAPagar = new JLabel("A pagar:");
		lblAPagar.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));

		lblAPagar.setBounds(52, 80, 98, 25);
		add(lblAPagar);

		lblAPagar.setBounds(52, 75, 98, 25);
		add(lblAPagar);

		textAPagar = new JTextField();
		textAPagar.setHorizontalAlignment(SwingConstants.CENTER);
		textAPagar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textAPagar.setBounds(52, 109, 104, 42);
		add(textAPagar);
		textAPagar.setColumns(10);

		modeloCambio = new DefaultListModel<String>();

		listaCambio = new JList<String>(modeloCambio);
		listaCambio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		listaCambio.setBounds(524, 185, 254, 308);
		add(listaCambio);

		textPagado.setText("0.00");
		textAPagar.setText("0.00");
		textVueltas.setText("--------");
	}

	/**
	 * Limpia el panel reseteando todos los elementos a valores por defecto seleccionados por el programador
	 */
	public void limpiar() {
		textPagado.setText("0.00");
		textAPagar.setText("0.00");
		textVueltas.setText("--------");
		modeloCambio.clear();
		ActDesBotones(true);
	}

	/**
	 * Activa o desactiva su array de botones al estado que se le pasa por
	 * parametros
	 * 
	 * @param estado El estado que se quiere tener para el array de botones (true =
	 *               activado y false = desactivado)
	 */
	public void ActDesBotones(boolean estado) {
		for (int i = 0; i < this.arrayBtn.length; i++) {
			this.arrayBtn[i].setEnabled(estado);
		}
	}
}
