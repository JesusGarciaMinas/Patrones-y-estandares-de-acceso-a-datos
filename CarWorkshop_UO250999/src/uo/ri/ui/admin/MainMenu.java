package uo.ri.ui.admin;

import alb.util.menu.BaseMenu;

/**
 * Menu principal del administrador de la base de datos
 * 
 * @author UO250999
 *
 */
public class MainMenu extends BaseMenu {

	public MainMenu() {
		menuOptions = new Object[][] { { "Administrador", null }, 
			
			{ "Gestión de mecánicos", 		 MecanicosMenu.class },
			{ "Generar bonos por 3 averías", GenerarBonosMenu.class }, 
		};
	}

	public static void main(String[] args) {
		new MainMenu().execute();
	}
}