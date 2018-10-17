package uo.ri.ui.admin.action;

import uo.ri.business.AdminService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServicesFactory;
import alb.util.console.Console;
import alb.util.menu.Action;

/**
 * Clase que escribe por teclado el id del mecánico a eliminar de la base de
 * datos
 * 
 * @author UO250999
 *
 */
public class DeleteMechanicAction implements Action {

	@Override
	public void execute() throws BusinessException {
		Long idMecanico = Console.readLong("Id de mecánico");

		eliminarMecanico(idMecanico);

		println(String.valueOf(idMecanico));
	}

	private void eliminarMecanico(Long idMecanico) {
		AdminService asi = ServicesFactory.getAdminService();
		asi.deleteMechanic(idMecanico);
	}

	private void println(String id) {
		Console.printf("Se ha eliminado el mecánico: %s\n", id);
	}
}