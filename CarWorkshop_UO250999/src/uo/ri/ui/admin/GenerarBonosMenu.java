package uo.ri.ui.admin;

import alb.util.menu.BaseMenu;
import uo.ri.ui.admin.action.GenerarBonosAveriaAction;

/**
 * Clase que utiliza el administrador para generar nuevos bonos cada cierto
 * tiempo
 * 
 * @author UO250999
 *
 */
public class GenerarBonosMenu extends BaseMenu {

	public GenerarBonosMenu() {
		menuOptions = new Object[][] { 
			{ "Administrador > Generación de bonos", null },
			
				{ "Generar bonos automáticamente", GenerarBonosAveriaAction.class },
			};
	}
}