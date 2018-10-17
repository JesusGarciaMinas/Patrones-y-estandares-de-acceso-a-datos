package uo.ri.ui.cash.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import uo.ri.business.CashService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServicesFactory;
import alb.util.console.Console;
import alb.util.menu.Action;

/**
 * Clase llamada por el menu de facturas que realiza las llamadas a las clases
 * que se encargan de gestionar las facturas de la base de datos
 * 
 * @author UO250999
 *
 */
public class FacturarReparacionesAction implements Action {

	@Override
	public void execute() throws BusinessException {
		List<Long> idsAveria = new ArrayList<Long>();
		do {
			Long id = Console.readLong("ID de averia");
			idsAveria.add(id);
		} while (masAverias());

		Map<String, Object> map = crearInvoiceFor(idsAveria);

		mostrarFactura((Long) map.get("numeroFactura"), (Date) map.get("fechaFactura"),
				(Double) map.get("totalFactura"), (Double) map.get("iva"), (Double) map.get("importe"));
	}

	private Map<String, Object> crearInvoiceFor(List<Long> idsAveria) throws BusinessException {
		CashService csi = ServicesFactory.getCashService();
		return csi.createInvoiceFor(idsAveria);
	}

	private void mostrarFactura(long numeroFactura, Date fechaFactura, double totalFactura, double iva,
			double totalConIva) {

		Console.printf("Factura nº: %d\n", numeroFactura);
		Console.printf("\tFecha: %1$td/%1$tm/%1$tY\n", fechaFactura);
		Console.printf("\tTotal: %.2f €\n", totalFactura);
		Console.printf("\tIva: %.1f %% \n", iva);
		Console.printf("\tTotal con IVA: %.2f €\n", totalConIva);
	}

	private boolean masAverias() {
		return Console.readString("¿Añadir más averias? (s/n) ").equalsIgnoreCase("s");
	}
}