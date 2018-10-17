package uo.ri.ui.admin.action;

import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.business.AdminService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServicesFactory;

/**
 * Clase que llama al generador de bonos por cada 3 averías
 * 
 * @author UO250999
 *
 */
public class GenerarBonosAveriaAction implements Action {

	@Override
	public void execute() throws BusinessException {

		generarBonos();

		println("Se han generado los bonos por 3 averías");
	}

	private void generarBonos() {
		AdminService asi = ServicesFactory.getAdminService();
		asi.generarBonos();
	}

	private void println(String mensaje) {
		Console.printf(mensaje);
	}
}