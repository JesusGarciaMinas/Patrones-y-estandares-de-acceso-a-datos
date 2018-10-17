package uo.ri.ui.foreman.action;

import java.util.Map;

import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.business.ForemanService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServicesFactory;

/**
 * Clase que muestra por pantalla todos los datos de un cliente en concreto
 * 
 * @author UO250999
 *
 */
public class DetallesClienteAction implements Action {

	@Override
	public void execute() throws BusinessException {
		Long id = Console.readLong("id cliente");
		Map<String, Object> map = listaClienteDetallesPorId(id);

		Console.println("\nDetalles de cliente por id\n");
		Console.printf("\t%d %s %s\n", map.get("id"), map.get("dni"), map.get("nombre"), map.get("apellidos"),
				map.get("direccionPostal"), map.get("telefono"), map.get("correo"), map.get("recomendadopor"));
	}

	private Map<String, Object> listaClienteDetallesPorId(Long id) {
		ForemanService asi = ServicesFactory.getForemanService();
		return asi.detallesCliente(id);
	}
}