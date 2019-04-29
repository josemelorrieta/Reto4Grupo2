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
	 * Declaracion de atributos
	 */
	private static final long serialVersionUID = 1L;
	public JButton btn500, btn200, btn100, btn50, btn20, btn10, btn5, btn2, btn1, btn050, btn020, btn010, btn005, btn002, btn001;
	public JButton[] arrayBtn = new JButton[15];
	public JLabel lblEuro1, lblEuro2, lblEuro3, lblAPagar, lblPagado, lblDineroMetido;
	public JTextField textAPagar, textPagado, textVueltas;
	public JList<String> listaCambio;
	public DefaultListModel<String> modeloCambio;

	/**
	 * Constructor del panel
	 */
	public PanelPago() {
		setParametros();
		instanciarObjetos();
	}

	private void setParametros() {
		setPreferredSize(new Dimension(853, 647));
		setLayout(null);
	}

	private void instanciarObjetos() {
		lblDineroMetido = new JLabel("Dinero metido:");
		lblDineroMetido.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblDineroMetido.setBounds(312, 39, 169, 35);
		add(lblDineroMetido);

		textPagado = new JTextField();
		textPagado.setHorizontalAlignment(SwingConstants.CENTER);
		textPagado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textPagado.setBounds(320, 85, 104, 42);
		add(textPagado);
		textPagado.setColumns(10);

		lblPagado = new JLabel("Vueltas:");
		lblPagado.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblPagado.setBounds(581, 39, 112, 35);
		add(lblPagado);

		textVueltas = new JTextField();
		textVueltas.setHorizontalAlignment(SwingConstants.CENTER);
		textVueltas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textVueltas.setBounds(581, 85, 104, 42);
		add(textVueltas);
		textVueltas.setColumns(10);

		btn5 = new JButton("5");
		btn5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn5.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/pago/5euros.jpg")));
		btn5.setFont(btn5.getFont().deriveFont(0f));
		btn5.setBounds(84, 340, 59, 35);
		add(btn5);

		btn2 = new JButton("2");
		btn2.setBackground(new Color(193, 240, 240));
		btn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn2.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/pago/2euros.png")));
		btn2.setFont(btn2.getFont().deriveFont(0f));
		btn2.setBounds(312, 150, 45, 45);
		add(btn2);

		btn10 = new JButton("10");
		btn10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn10.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/pago/10euros.jpg")));
		btn10.setFont(btn10.getFont().deriveFont(0f));
		btn10.setBounds(128, 280, 59, 35);
		add(btn10);

		btn200 = new JButton("200");
		btn200.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn200.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/pago/200euros.jpg")));
		btn200.setFont(btn200.getFont().deriveFont(0f));
		btn200.setBounds(128, 160, 59, 35);
		add(btn200);

		btn20 = new JButton("20");
		btn20.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn20.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/pago/20euros.jpg")));
		btn20.setFont(btn20.getFont().deriveFont(0f));
		btn20.setBounds(40, 280, 59, 35);
		add(btn20);

		btn500 = new JButton("500");
		btn500.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn500.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/pago/500euros.jpg")));
		btn500.setFont(btn500.getFont().deriveFont(0f));
		btn500.setBounds(40, 160, 59, 35);
		add(btn500);

		btn100 = new JButton("100");
		btn100.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn100.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/pago/100euros.jpg")));
		btn100.setFont(btn100.getFont().deriveFont(0f));
		btn100.setBounds(40, 220, 59, 35);
		add(btn100);

		btn50 = new JButton("50");
		btn50.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn50.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/pago/50euros.jpg")));
		btn50.setFont(btn50.getFont().deriveFont(0f));
		btn50.setBounds(128, 220, 59, 35);
		add(btn50);

		btn1 = new JButton("1");
		btn1.setBackground(new Color(193, 240, 240));
		btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn1.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/pago/1euro.png")));
		btn1.setFont(btn1.getFont().deriveFont(0f));
		btn1.setBounds(390, 150, 45, 45);
		add(btn1);

		btn050 = new JButton("0.50");
		btn050.setBackground(new Color(193, 240, 240));
		btn050.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn050.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/pago/50centimos.png")));
		btn050.setFont(btn050.getFont().deriveFont(0f));
		btn050.setBounds(312, 215, 45, 45);
		add(btn050);

		btn020 = new JButton("0.20");
		btn020.setBackground(new Color(193, 240, 240));
		btn020.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn020.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/pago/20centimos.png")));
		btn020.setFont(btn020.getFont().deriveFont(0f));
		btn020.setBounds(390, 215, 45, 45);
		add(btn020);

		btn010 = new JButton("0.10");
		btn010.setBackground(new Color(193, 240, 240));
		btn010.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn010.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/pago/10centimos.png")));
		btn010.setFont(btn010.getFont().deriveFont(0f));
		btn010.setBounds(312, 280, 45, 45);
		add(btn010);

		btn005 = new JButton("0.05");
		btn005.setBackground(new Color(193, 240, 240));
		btn005.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn005.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/pago/5centimos.png")));
		btn005.setFont(btn005.getFont().deriveFont(0f));
		btn005.setBounds(390, 280, 45, 45);
		add(btn005);

		btn002 = new JButton("0.02");
		btn002.setBackground(new Color(193, 240, 240));
		btn002.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn002.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/pago/2centimos.png")));
		btn002.setFont(btn002.getFont().deriveFont(0f));
		btn002.setBounds(312, 345, 45, 45);
		add(btn002);

		btn001 = new JButton("0.01");
		btn001.setBackground(new Color(193, 240, 240));
		btn001.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn001.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/pago/1centimo.png")));
		btn001.setFont(btn001.getFont().deriveFont(0f));
		btn001.setBounds(390, 345, 45, 45);
		add(btn001);
		
		arrayBtn[0]=btn500;
		arrayBtn[1]=btn200;
		arrayBtn[2]=btn100;
		arrayBtn[3]=btn50;
		arrayBtn[4]=btn20;
		arrayBtn[5]=btn10;
		arrayBtn[6]=btn5;
		arrayBtn[7]=btn2;
		arrayBtn[8]=btn1;
		arrayBtn[9]=btn050;
		arrayBtn[10]=btn020;
		arrayBtn[11]=btn010;
		arrayBtn[12]=btn005;
		arrayBtn[13]=btn002;
		arrayBtn[14]=btn001;
		
		for(JButton boton:arrayBtn) {
			boton.setOpaque(false);
			boton.setContentAreaFilled(false);
			boton.setBorderPainted(false);
			boton.setFocusPainted(false);
		}
		
		
		lblEuro1 = new JLabel("\u20AC");
		lblEuro1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblEuro1.setBounds(695, 88, 29, 35);
		add(lblEuro1);

		lblEuro2 = new JLabel("\u20AC");
		lblEuro2.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblEuro2.setBounds(434, 88, 29, 35);
		add(lblEuro2);

		lblEuro3 = new JLabel("\u20AC");
		lblEuro3.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblEuro3.setBounds(166, 88, 29, 35);
		add(lblEuro3);

		lblAPagar = new JLabel("A pagar:");
		lblAPagar.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblAPagar.setBounds(52, 39, 98, 35);
		add(lblAPagar);

		textAPagar = new JTextField();
		textAPagar.setHorizontalAlignment(SwingConstants.CENTER);
		textAPagar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textAPagar.setBounds(52, 85, 104, 42);
		add(textAPagar);
		textAPagar.setColumns(10);

		modeloCambio = new DefaultListModel<String>();

		listaCambio = new JList<String>(modeloCambio);
		listaCambio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		listaCambio.setBounds(524, 158, 254, 256);
		add(listaCambio);

		textPagado.setText("0.00");
		textAPagar.setText("0.00");
		textVueltas.setText("--------");
		
		textPagado.setEditable(false);
		textAPagar.setEditable(false);
		textVueltas.setEditable(false);

	}
}
