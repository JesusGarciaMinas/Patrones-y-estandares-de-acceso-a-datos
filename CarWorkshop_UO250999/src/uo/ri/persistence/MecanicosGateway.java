package uo.ri.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Interfaz con todos los métodos para manejar mecánicos en la base de datos
 * 
 * @author UO250999
 *
 */
public interface MecanicosGateway {
	void setConnection(Connection c) throws SQLException;

	Map<String, Object> findById(Long l) throws SQLException;

	List<Map<String, Object>> findAll() throws SQLException;

	void update(Long id, String nombre, String apellidos) throws SQLException;

	void save(String nombre, String apellidos) throws SQLException;

	void delete(Long id) throws SQLException;
}