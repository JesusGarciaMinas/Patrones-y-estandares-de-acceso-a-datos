package uo.ri.ui.foreman.action;

import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.business.ForemanService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServicesFactory;

/**
 * Clase que elimina un cliente según el id introducido por teclado
 * 
 * @author UO250999
 *
 */
public class DeleteClienteAction implements Action {

	@Override
	public void execute() throws BusinessException {
		Long id = Console.readLong("Id del cliente");
		eliminarCliente(id);
		println(String.valueOf(id));
	}

	private void eliminarCliente(Long id) throws BusinessException {
		ForemanService asi = ServicesFactory.getForemanService();
		asi.deleteCliente(id);
	}

	private void println(String id) {
		Console.printf("Se ha eliminado el cliente: %s\n", id);
	}
}