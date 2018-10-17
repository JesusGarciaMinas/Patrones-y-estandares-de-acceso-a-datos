package uo.ri.ui.foreman;

import alb.util.menu.BaseMenu;

/**
 * Clase menu de Jefe de taller con todas las clases a las que puede acceder
 * este
 * 
 * @author UO250999
 *
 */
public class MainMenu extends BaseMenu {

	public MainMenu() {
		menuOptions = new Object[][] { { "Jefe de Taller", null }, { "Gestión de clientes", ClientesMenu.class }, };
	}

	public static void main(String[] args) {
		new MainMenu().execute();
	}
}