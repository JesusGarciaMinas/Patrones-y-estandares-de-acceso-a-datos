package uo.ri.business;

import java.util.List;
import java.util.Map;

import uo.ri.common.BusinessException;

/**
 * Interfaz que contiene el método para generar facturas
 * 
 * @author UO250999
 *
 */
public interface CashService {
	Map<String, Object> createInvoiceFor(List<Long> lista) throws BusinessException;
}