package uo.ri.ui.admin.action;

import java.util.Map;

import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.business.AdminService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServicesFactory;

/**
 * Clase que muestra un mecánico con su nombre y apellidos según su id
 * 
 * @author UO250999
 *
 */
public class ListByIdMechanicAction implements Action {

	@Override
	public void execute() throws BusinessException {
		Long id = Console.readLong("id mecánico");
		Map<String, Object> map = listaMecanicosPorId(id);

		Console.println("\nListado de mecánicos por id\n");
		Console.printf("\t%d %s %s\n", map.get("id"), map.get("nombre"), map.get("apellidos"));
	}

	private Map<String, Object> listaMecanicosPorId(Long id) {
		AdminService asi = ServicesFactory.getAdminService();
		return asi.findByIdMechanic(id);
	}
}