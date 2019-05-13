package controlador;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import modelo.Modelo;
import vista.VentanaPpal;

public class ControladorPanelResumenReserva {

	private VentanaPpal vis;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
	NumberFormat moneda = NumberFormat.getCurrencyInstance();
	
	public ControladorPanelResumenReserva (VentanaPpal vis) {
		this.vis = vis;
	}
	
	public void actualizarResumenReserva (Modelo mod) {
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
		vis.pCenter.pResumenRes.txtTotal.setText(moneda.format(mod.desglosePrecio.getTotal()));
		vis.pCenter.pResumenRes.txtTemporada.setText(mod.desglosePrecio.getTemporada());
		vis.pCenter.pResumenRes.textFestivos.setText(String.valueOf(mod.desglosePrecio.getNumFestivos()));
		vis.pCenter.pResumenRes.textNoches.setText(String.valueOf(mod.desglosePrecio.getNoches()));
		vis.pCenter.pResumenRes.txtCodProm.setText("");
	}
}
