package uo.ri.ui.foreman.action;

import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.business.ForemanService;
import uo.ri.common.BusinessException;
import uo.ri.conf.ServicesFactory;

/**
 * Clase que lee por pantalla todos los datos para añadir un cliente en la base
 * de datos
 * 
 * @author UO250999
 *
 */
public class AddClienteAction implements Action {

	@Override
	public void execute() throws BusinessException {
		String dni = Console.readString("Nombre");
		String nombre = Console.readString("Nombre");
		String apellidos = Console.readString("Apellidos");
		String direccionPostal = Console.readString("Dirección postal");
		int telefono = Console.readInt("Dirección postal");
		String correo = Console.readString("correo");
		Long recomendadopor = Console.readLong("Recomendación (En caso de que no exista, poner 0");

		crearCliente(dni, nombre, apellidos, direccionPostal, telefono, correo, recomendadopor);

		println(nombre + " " + apellidos);
	}

	private void crearCliente(String dni, String nombre, String apellidos, String direccionPostal, int telefono,
			String correo, Long recomendadopor) throws BusinessException {
		ForemanService asi = ServicesFactory.getForemanService();
		asi.newCliente(dni, nombre, apellidos, direccionPostal, telefono, correo, recomendadopor);
	}

	private void println(String cliente) {
		Console.printf("Nuevo cliente añadido: %s\n", cliente);
	}
}