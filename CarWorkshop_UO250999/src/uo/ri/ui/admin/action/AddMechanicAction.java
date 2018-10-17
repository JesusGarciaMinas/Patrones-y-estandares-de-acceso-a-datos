package uo.ri.ui.admin.action;

import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.business.AdminService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServicesFactory;

/**
 * Clase que lee el nombre y apellidos del mecánico a introducir en la base de
 * datos
 * 
 * @author UO250999
 *
 */
public class AddMechanicAction implements Action {

	@Override
	public void execute() throws BusinessException {
		String nombre = Console.readString("Nombre");
		String apellidos = Console.readString("Apellidos");

		crearMecanico(nombre, apellidos);

		println(nombre + " " + apellidos);
	}

	private void crearMecanico(String nombre, String apellidos) throws BusinessException {
		AdminService asi = ServicesFactory.getAdminService();
		asi.newMechanic(nombre, apellidos);
	}

	private void println(String mecanico) {
		Console.printf("Nuevo mecánico añadido: %s\n", mecanico);
	}
}