package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import modelo.Modelo;
import vista.VentanaPpal;

/**
 * Controlador para el panel Reserva
 *
 */
public class ControladorPanelResumenReserva {

	private VentanaPpal vis;
	private Modelo mod;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
	NumberFormat moneda = NumberFormat.getCurrencyInstance();
	
	/**
	 * Constructor para el controlador
	 * @param mod Modelo donde se guarda la informacion
	 * @param vis Vista la cual edita
	 */
	public ControladorPanelResumenReserva (VentanaPpal vis, Modelo mod) {
		this.vis = vis;
		this.mod = mod;
		initListeners();
	}

	/**
	 * Inicializador para listeners
	 */
	private void initListeners() {
		vis.pCenter.pResumenRes.btnCodProm.addActionListener(new ListenerCodProm());
		vis.pCenter.pResumenRes.lblCondiciones.addMouseListener(new ListenerMouse());
	}
	
	/**
	 * Actualiza el panel de resumen de la reserva con la informacion del modelo
	 */
	public void actualizarResumenReserva () {
		vis.pCenter.pResumenRes.txtAlojamiento.setText(mod.reserva.getAlojReservado().getNombre() + " (" + mod.reserva.getAlojReservado().getDireccion().getLocalidad() + ")");
		if(mod.reserva.getDormitorioReservado() != null)
			vis.pCenter.pResumenRes.txtNHab.setText(String.valueOf(mod.reserva.getDormitorioReservado().getIdHab()));
		else
			vis.pCenter.pResumenRes.txtNHab.setText("");
		vis.pCenter.pResumenRes.txtFecEntrada.setText(sdf.format(mod.reserva.getFechaEntrada()));
		vis.pCenter.pResumenRes.txtFecSalida.setText(sdf.format(mod.reserva.getFechaSalida()));
		vis.pCenter.pResumenRes.txtPrecioBase.setText(moneda.format(mod.desglosePrecio.getpBaseAloj()));
		vis.pCenter.pResumenRes.txtEquip.setText(moneda.format(mod.desglosePrecio.getpEquipamiento()));
		vis.pCenter.pResumenRes.txtExtras.setText(moneda.format(mod.desglosePrecio.getPrecioExtras()));
		vis.pCenter.pResumenRes.txtDescuento.setText(moneda.format(0));
		vis.pCenter.pResumenRes.txtTotal.setText(moneda.format(mod.desglosePrecio.getTotal()));
		vis.pCenter.pResumenRes.txtTemporada.setText(mod.desglosePrecio.getTemporada());
		vis.pCenter.pResumenRes.textFestivos.setText(String.valueOf(mod.desglosePrecio.getNumFestivos()));
		vis.pCenter.pResumenRes.textNoches.setText(String.valueOf(mod.desglosePrecio.getNoches()));
		vis.pCenter.pResumenRes.txtCodProm.setText("");
	}
	
	/**
	 * Listener para los elementos relacionados con el codigo promocional
	 *
	 */
	private class ListenerCodProm implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!vis.pCenter.pResumenRes.txtCodProm.getText().equals("")) {
				if (mod.mRegiLog.comprobarCodigoPromocional(vis.pCenter.pResumenRes.txtCodProm.getText(), mod.clienteRegis.getDni(), mod.reserva.getAlojReservado())) {
					JOptionPane.showMessageDialog(vis.pCenter, "Código promocional válido", "INFO", JOptionPane.INFORMATION_MESSAGE);
					mod.desglosePrecio.setCodPromocional(true);
					mod.reserva.setCodPromocional(vis.pCenter.pResumenRes.txtCodProm.getText());
					vis.pCenter.pResumenRes.txtDescuento.setText(moneda.format(mod.desglosePrecio.getTotal() * 0.2));
				} else {
					JOptionPane.showMessageDialog(vis.pCenter, "El código promocional introducido no es válido", "¡Atención!", JOptionPane.WARNING_MESSAGE);
					mod.desglosePrecio.setCodPromocional(false);
					vis.pCenter.pResumenRes.txtDescuento.setText(moneda.format(0));
				}
			} else {
				mod.desglosePrecio.setCodPromocional(false);
				mod.reserva.setCodPromocional("");
				vis.pCenter.pResumenRes.txtDescuento.setText(moneda.format(0));
			}
			vis.pCenter.pResumenRes.txtTotal.setText(moneda.format(mod.desglosePrecio.getTotal()));
		}		
	}
	
	/**
	 * Listener para las condiciones de servicio
	 *
	 */
	private class ListenerMouse implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			vis.pCondiciones.setVisible(true);
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			
		}
	}
	
}
