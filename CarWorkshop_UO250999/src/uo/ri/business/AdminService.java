package uo.ri.business;

import java.util.List;
import java.util.Map;

/**
 * Interfaz que contiene los métodos que utiliza el adminstrador de la base de
 * datos
 * 
 * @author UO250999
 *
 */
public interface AdminService {
	void newMechanic(String nombre, String apellidos);

	void deleteMechanic(Long id);

	void updateMechanic(Long id, String nombre, String apellidos);

	List<Map<String, Object>> findAllMechanics();

	Map<String, Object> findByIdMechanic(Long id);

	void generarBonos();
}