package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import modelo.Alojamiento;
import modelo.Casa;
import modelo.Dormitorio;
import modelo.Hotel;
import modelo.Modelo;
import util.FuncionesGenerales;
import vista.VentanaPpal;
import vista.panelCard.PanelResBusqueda;

/**
 * Controlador para el panel buscar
 *
 */
public class ControladorPanelBuscar {

	private VentanaPpal vis;
	private Controlador controlador;
	private Modelo mod;
	DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
	Calendar calendar = Calendar.getInstance();
	Date hoy = calendar.getTime();

	/**
	 * Constructor para el controlador
	 * 
	 * @param vis  Vista la cual edita
	 * @param cont Controlador principal en caso de que necesite acceder a algun
	 *             otro metodo
	 * @param mod  Modelo donde se guarda la informacion
	 */
	public ControladorPanelBuscar(VentanaPpal vis, Controlador cont, Modelo mod) {
		this.vis = vis;
		this.controlador = cont;
		this.mod = mod;
		cargarLocalidades();
		fechaHoy();
		cambioFechaEnt(hoy);
		vis.pBotones.setBotonesVisible(false);
		initListeners();
	}

	/**
	 * Inicializador para los listeners del panel
	 */
	private void initListeners() {
		vis.pCenter.pBuscar.btnBuscar.addActionListener(new ListenerBotones());
		vis.pCenter.pBuscar.calenEntrada.addPropertyChangeListener(new ListenerFechaEnt());
	}

	/**
	 * Carga las localidades desde la base de datos en un checkbox
	 */
	public void cargarLocalidades() {
		String[] localidades = mod.mBuscar.buscarLocalidades();
		if (localidades != null) {
			for (String localidad : localidades)
				vis.pCenter.pBuscar.cbxBuscar.addItem(localidad);
		} else {
			JOptionPane.showMessageDialog(vis, "Error en la Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
			vis.dispose();
		}
	}

	/**
	 * Limita las fechas del calendario al dia de hoy para el calendario de entrada
	 * y maniana para el calendario de salida
	 */
	public void fechaHoy() {
		mod.reserva.setFechaReserva(hoy);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		Date manana = calendar.getTime();
		try {
			vis.pCenter.pBuscar.calenEntrada.setSelectableDateRange(hoy, formato.parse("01-01-2100"));
			vis.pCenter.pBuscar.calenSalida.setSelectableDateRange(manana, formato.parse("01-01-2100"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		vis.pCenter.pBuscar.calenEntrada.setDate(hoy);
		vis.pCenter.pBuscar.calenSalida.setDate(manana);
	}

	/**
	 * Actualiza el limite de fechas del segundo calendario en funcion de la fecha
	 * por parametro
	 * 
	 * @param fechaEntrada fecha desde la cual se limita el rango del calendario
	 */
	public void cambioFechaEnt(Date fechaEntrada) {
		calendar.setTime(fechaEntrada);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		Date manana = calendar.getTime();

		if (fechaEntrada.compareTo(vis.pCenter.pBuscar.calenSalida.getDate()) >= 0) {
			vis.pCenter.pBuscar.calenSalida.setDate(manana);
		}
		try {
			vis.pCenter.pBuscar.calenSalida.setSelectableDateRange(manana, formato.parse("01-01-2100"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Listeners para los botones del panel
	 *
	 */
	private class ListenerBotones implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			mod.reserva.setFechaEntrada(vis.pCenter.pBuscar.calenEntrada.getDate());
			mod.reserva.setFechaSalida(vis.pCenter.pBuscar.calenSalida.getDate());
			mod.mBuscar.cargarAlojamientos(vis.pCenter.pBuscar.cbxBuscar.getSelectedItem().toString());
			setResultBusqueda(mod.hotelesBusqueda, vis.pCenter.pResBusq, mod.tiposDorm);
			setResultBusqueda(mod.casasBusqueda, vis.pCenter.pResBusq);
			setResultBusqueda(mod.apartBusqueda, vis.pCenter.pResBusq);
			ordenarAlojamientos();
			vis.pCenter.pResBusq.resultBusq.ensureIndexIsVisible(0);
			vis.pBotones.setBotonesVisible(true);
			vis.pCenter.nextPanel();
		}
	}

	/**
	 * Listeners para el calendario
	 *
	 */
	private class ListenerFechaEnt implements PropertyChangeListener {
		@Override
		public void propertyChange(PropertyChangeEvent e) {
			Date fechaEntrada = vis.pCenter.pBuscar.calenEntrada.getDate();
			cambioFechaEnt(fechaEntrada);
		}

	}

	/**
	 * Carga los hoteles en el modelo del Jlist y aniade las camas a su array de
	 * mobiliario
	 * 
	 * @param hoteles   array de hoteles que carga
	 * @param panel     panel en cual carga los hoteles
	 * @param tiposDorm array de dormitorios modelo para cargar las camas en los
	 *                  dormitorios de los hoteles
	 */
	public void setResultBusqueda(Hotel[] hoteles, PanelResBusqueda panel, Dormitorio[] tiposDorm) {
		panel.modelResBusq.clear();
		for (Hotel hotel : hoteles) {
			for (int i = 0; i < hotel.getMatrix().size(); i++) {
				if (hotel.getMatrix().get(i) == null)
					continue;
				for (int f = 0; f < hotel.getMatrix().get(i).size(); f++) {
					hotel.getMatrix().get(i).get(f).setMobiliario(FuncionesGenerales.concatenate(hotel.getMatrix().get(i).get(f).getMobiliario(), tiposDorm[i].getMobiliario()));
				}
			}
			panel.modelResBusq.addElement(hotel);
		}
		panel.lblLocBusq.setText("Resultados para " + hoteles[0].getDireccion().getLocalidad());
	}

	/**
	 * Carga las casas/apartamentos en el modelo del Jlist
	 * 
	 * @param casas array de alojamientos que carga en model
	 * @param panel panel en el cual carga la informacion
	 */
	public void setResultBusqueda(Casa[] casas, PanelResBusqueda panel) {
		for (Casa casa : casas) {
			panel.modelResBusq.addElement(casa);
		}
		panel.lblLocBusq.setText("Destino: " + casas[0].getDireccion().getLocalidad() + "      Entrada: " + formato.format(mod.reserva.getFechaEntrada()) + "      Salida: " + formato.format(mod.reserva.getFechaSalida()));
	}

	/**
	 * Recoge informacion del modelo de la jlist y lo carga en un array
	 * @param modelResBusq modelo de un jlist con la informacion de los alojamientos
	 * @return alojamientos[]
	 */
	public Alojamiento[] cargarArrayConAlojamientos(DefaultListModel<Alojamiento> modelResBusq) {
		// Cargar jlist en array
		int tam = modelResBusq.size();
		Alojamiento[] aloj = new Alojamiento[tam];
		for (int i = 0; i < tam; i++) {
			aloj[i] = modelResBusq.get(i);
		}
		return aloj;
	}
	
	/**
	 * Ordena los alojamientos y los mete al modelo
	 */
	public void ordenarAlojamientos() {
		Alojamiento[] arrayAloj = cargarArrayConAlojamientos(vis.pCenter.pResBusq.modelResBusq);
		int[] popularidad = mod.mBuscar.arrayNumeroReservas(arrayAloj);
		arrayAloj = mod.mBuscar.ordenarPorPopularidadYAlfabeticamente(arrayAloj, popularidad);
		vis.pCenter.pResBusq.modelResBusq.clear();
		for (Alojamiento aloj : arrayAloj) {
			vis.pCenter.pResBusq.modelResBusq.add(vis.pCenter.pResBusq.modelResBusq.size(), aloj);
		}
	}
}
