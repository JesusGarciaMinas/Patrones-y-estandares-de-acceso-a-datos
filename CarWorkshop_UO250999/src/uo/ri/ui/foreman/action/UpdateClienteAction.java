package uo.ri.ui.foreman.action;

import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.business.ForemanService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServicesFactory;

/**
 * Clase que lee por pantalla el id de un cliente con sus nuevos datos a
 * actualizar
 * 
 * @author UO250999
 *
 */
public class UpdateClienteAction implements Action {

	@Override
	public void execute() throws BusinessException {
		Long id = Console.readLong("Id del cliente");
		String nombre = Console.readString("Nombre");
		String apellidos = Console.readString("Apellidos");

		actualizarCliente(id, nombre, apellidos);

		println(id + " " + nombre + " " + apellidos);
	}

	private void actualizarCliente(Long id, String nombre, String apellidos) {
		ForemanService asi = ServicesFactory.getForemanService();
		asi.updateCliente(id, nombre, apellidos);
	}

	private void println(String mecanico) {
		Console.printf("Cliente actualizado: %s\n", mecanico);
	}
}