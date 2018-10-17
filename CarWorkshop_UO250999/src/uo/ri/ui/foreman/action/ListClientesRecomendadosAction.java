package uo.ri.ui.foreman.action;

import java.util.List;
import java.util.Map;

import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.business.ForemanService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServicesFactory;

/**
 * Clase que muestra por pantalla la lista de clientes de la base datos que han
 * sido recomendados por la misma persona
 * 
 * @author UO250999
 *
 */
public class ListClientesRecomendadosAction implements Action {

	@Override
	public void execute() throws BusinessException {
		Long id = Console.readLong();
		List<Map<String, Object>> lista = listaClientes(id);

		Console.println("\nListado de clientes por recomendación\n");
		for (Map<String, Object> l : lista) {
			Console.printf("\t%d %s %s\n", l.get("id"), l.get("dni"), l.get("nombre"), l.get("apellidos"));
		}
	}

	private List<Map<String, Object>> listaClientes(Long id) {
		ForemanService asi = ServicesFactory.getForemanService();
		return asi.findRecomendadosCliente(id);
	}
}