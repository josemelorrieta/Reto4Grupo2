package controlador;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import modelo.Hotel;
import modelo.Modelo;
import vista.panelCard.PanelResumenPago;

public class ControladorPanelResumenPago {

	private Modelo mod;
	private PanelResumenPago vis;
	private SimpleDateFormat sdf;
	private DecimalFormat df;
	
	public ControladorPanelResumenPago(Modelo mod, PanelResumenPago vis) {
		this.mod = mod;
		this.vis = vis;
		sdf = new SimpleDateFormat("dd-MM-YYYY");
		df = new DecimalFormat("#.00 €");
	}
	
	public void insertarDatos() {		
		vis.txtAlojamiento.setText(mod.aloj1.getNombre());
		if(mod.aloj1 instanceof Hotel) {
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
		vis.txtPrecio.setText(df.format(mod.reserva.getPrecio()));
		
		vis.txtDni.setText(mod.clienteRegis.getDni());
		vis.txtNombre.setText(mod.clienteRegis.getNombre());
		vis.txtApellidos.setText(mod.clienteRegis.getApellidos());
	}
}
