package uo.ri.business;

import java.util.List;
import java.util.Map;

import uo.ri.common.BusinessException;

/**
 * Interfaz que contiene los métodos que utilizará el jefe de taller
 * 
 * @author UO250999
 *
 */
public interface ForemanService {
	void newCliente(String dni, String nombre, String apellidos, String direccionPostal, int telefono, String correo,
			Long recomendadoPor) throws BusinessException;

	void deleteCliente(Long id) throws BusinessException;

	void updateCliente(Long id, String nombre, String apellidos);

	List<Map<String, Object>> findAllClientes();

	List<Map<String, Object>> findRecomendadosCliente(Long id);

	Map<String, Object> detallesCliente(Long id);
}