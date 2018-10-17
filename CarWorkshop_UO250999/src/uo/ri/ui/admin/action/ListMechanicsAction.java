package uo.ri.ui.admin.action;

import uo.ri.business.AdminService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServicesFactory;

import java.util.List;
import java.util.Map;

import alb.util.console.Console;
import alb.util.menu.Action;

/**
 * Clase que imprime por pantalla una lista con todos los mecánicos de la base
 * de datos
 * 
 * @author UO250999
 *
 */
public class ListMechanicsAction implements Action {

	@Override
	public void execute() throws BusinessException {
		List<Map<String, Object>> lista = listaMecanicos();

		Console.println("\nListado de mecánicos\n");
		for (Map<String, Object> l : lista) {
			Console.printf("\t%d %s %s\n", l.get("id"), l.get("nombre"), l.get("apellidos"));
		}
	}

	private List<Map<String, Object>> listaMecanicos() {
		AdminService asi = ServicesFactory.getAdminService();
		return asi.findAllMechanics();
	}
}