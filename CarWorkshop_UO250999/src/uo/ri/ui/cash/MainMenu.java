package uo.ri.ui.cash;

import alb.util.menu.BaseMenu;
import uo.ri.ui.cash.action.*;

public class MainMenu extends BaseMenu {

	public MainMenu() {
		menuOptions = new Object[][] { 
			{ "Caja de Taller", null },
			{ "Facturar reparaciones", 				FacturarReparacionesAction.class },
		};
	}

	public static void main(String[] args) {
		new MainMenu().execute();
	}
}