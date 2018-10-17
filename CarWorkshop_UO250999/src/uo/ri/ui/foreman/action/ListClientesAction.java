package uo.ri.ui.foreman.action;

import java.util.List;
import java.util.Map;

import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.business.ForemanService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServicesFactory;

/**
 * Clase que lista todos los clientes de la base de datos
 * 
 * @author UO250999
 *
 */
public class ListClientesAction implements Action {

	@Override
	public void execute() throws BusinessException {
		List<Map<String, Object>> lista = listaClientes();

		Console.println("\nListado de clientes\n");
		for (Map<String, Object> l : lista) {
			Console.printf("\t%d %s %s\n", l.get("id"), l.get("dni"), l.get("nombre"), l.get("apellidos"));
		}
	}

	private List<Map<String, Object>> listaClientes() {
		ForemanService asi = ServicesFactory.getForemanService();
		return asi.findAllClientes();
	}
}