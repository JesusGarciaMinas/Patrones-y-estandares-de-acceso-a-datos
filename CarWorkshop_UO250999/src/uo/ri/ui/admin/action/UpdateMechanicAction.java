package uo.ri.ui.admin.action;

import uo.ri.business.AdminService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServicesFactory;
import alb.util.console.Console;
import alb.util.menu.Action;

/**
 * Clase que lee por pantalla el id del mecánico a actualizar sus datos
 * 
 * @author UO250999
 *
 */
public class UpdateMechanicAction implements Action {

	@Override
	public void execute() throws BusinessException {
		Long id = Console.readLong("Id del mecánico");
		String nombre = Console.readString("Nombre");
		String apellidos = Console.readString("Apellidos");

		actualizarMecanico(id, nombre, apellidos);

		println(id + " " + nombre + " " + apellidos);
	}

	private void actualizarMecanico(Long id, String nombre, String apellidos) {
		AdminService asi = ServicesFactory.getAdminService();
		asi.updateMechanic(id, nombre, apellidos);
	}

	private void println(String mecanico) {
		Console.printf("Mecánico actualizado: %s\n", mecanico);
	}
}