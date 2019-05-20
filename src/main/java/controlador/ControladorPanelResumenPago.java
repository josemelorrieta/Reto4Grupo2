package controlador;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import modelo.Hotel;
import modelo.Modelo;
import vista.panelCard.PanelResumenPago;

/**
 * Controlador del panel resumen pago
 *
 */
public class ControladorPanelResumenPago {

	private Modelo mod;
	private PanelResumenPago vis;
	private SimpleDateFormat sdf;
	private DecimalFormat df;
	
	/**
	 * Constructor para el controlador
	 * @param mod Modelo donde se guarda la informacion
	 * @param vis Vista la cual edita
	 */
	public ControladorPanelResumenPago(Modelo mod, PanelResumenPago vis) {
		this.mod = mod;
		this.vis = vis;
		sdf = new SimpleDateFormat("dd-MM-YYYY");
		df = new DecimalFormat("#.00 €");
	}
	
	/**
	 * Mete los datos del desglose del modelo a varios textField de la vista
	 */
	public void insertarDatos() {		
		vis.txtAlojamiento.setText(mod.reserva.getAlojReservado().getNombre());
		if(mod.reserva.getAlojReservado() instanceof Hotel) {
			vis.lblNHab.setVisible(true);
			vis.txtNHab.setVisible(true);
			vis.txtNHab.setText(String.valueOf(mod.reserva.getDormitorioReservado().getIdHab()));
		}else {
			vis.lblNHab.setVisible(false);
			vis.txtNHab.setVisible(false);
		}	
		vis.txtFecReserva.setText(sdf.format(mod.reserva.getFechaReserva()));
		vis.txtFecEntrada.setText(sdf.format(mod.reserva.getFechaEntrada()));
		vis.txtFecSalida.setText(sdf.format(mod.reserva.getFechaSalida()));
		vis.txtPrecio.setText(df.format(mod.reserva.getDesglose().getTotal()));
		
		String dni="";
		String nombre = "";
		String apellidos = "";
		
		try {
			dni = mod.mRegiLog.desencripta(mod.clienteRegis.getDni());
			nombre = mod.mRegiLog.desencripta(mod.clienteRegis.getNombre());
			apellidos = mod.mRegiLog.desencripta(mod.clienteRegis.getApellidos());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		vis.txtDni.setText(dni);
		vis.txtNombre.setText(nombre);
		vis.txtApellidos.setText(apellidos);
	}
}
