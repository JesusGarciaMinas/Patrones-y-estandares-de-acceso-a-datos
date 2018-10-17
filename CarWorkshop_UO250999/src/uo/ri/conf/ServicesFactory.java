package uo.ri.conf;

import uo.ri.business.AdminService;
import uo.ri.business.CashService;
import uo.ri.business.ForemanService;
import uo.ri.business.impl.AdminServiceImpl;
import uo.ri.business.impl.CashServiceImpl;
import uo.ri.business.impl.ForemanServiceImpl;

/**
 * Patrón de tipo factoría que permite llegar a todas las clases de tipo service
 * 
 * @author UO250999
 *
 */
public class ServicesFactory {

	public static AdminService getAdminService() {
		return new AdminServiceImpl();
	}

	public static CashService getCashService() {
		return new CashServiceImpl();
	}

	public static ForemanService getForemanService() {
		return new ForemanServiceImpl();
	}
}