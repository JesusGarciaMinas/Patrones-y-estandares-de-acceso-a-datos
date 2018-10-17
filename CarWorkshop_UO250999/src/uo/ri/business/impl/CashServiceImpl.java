package uo.ri.business.impl;

import java.util.List;
import java.util.Map;

import uo.ri.business.CashService;
import uo.ri.business.impl.cash.CreateInvoICEFor;
import uo.ri.common.BusinessException;

/**
 * Clase con llamadas a las clases que gestionan facturas y averías
 * 
 * @author UO250999
 *
 */
public class CashServiceImpl implements CashService {

	@Override
	public Map<String, Object> createInvoiceFor(List<Long> lista) throws BusinessException {
		CreateInvoICEFor ci = new CreateInvoICEFor(lista);
		Map<String, Object> map = ci.execute();
		return map;
	}
}