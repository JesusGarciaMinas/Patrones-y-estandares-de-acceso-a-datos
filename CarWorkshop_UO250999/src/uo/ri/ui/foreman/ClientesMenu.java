package uo.ri.ui.foreman;

import alb.util.menu.BaseMenu;
import uo.ri.ui.foreman.action.AddClienteAction;
import uo.ri.ui.foreman.action.DeleteClienteAction;
import uo.ri.ui.foreman.action.DetallesClienteAction;
import uo.ri.ui.foreman.action.ListClientesAction;
import uo.ri.ui.foreman.action.ListClientesRecomendadosAction;
import uo.ri.ui.foreman.action.UpdateClienteAction;

/**
 * Todas las opciones que tiene el jefe del taller respecto a la gestión de
 * clientes en el menu
 * 
 * @author UO250999
 *
 */
public class ClientesMenu extends BaseMenu {

	public ClientesMenu() {
		menuOptions = new Object[][] { { "Jefe de Taller > Gestión de Clientes", null },

				{ "Añadir cliente", AddClienteAction.class },
				{ "Modificar datos de cliente", UpdateClienteAction.class },
				{ "Eliminar cliente", DeleteClienteAction.class },
				{ "Listar clientes", ListClientesAction.class },
				{ "Ver detalles de un cliente", DetallesClienteAction.class },
				{ "Listar por recomendación", ListClientesRecomendadosAction.class }, };
	}
}