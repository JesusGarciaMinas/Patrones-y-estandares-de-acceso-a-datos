package uo.ri.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

/**
 * Interfaz que contiene los métodos que se implementarán para manejar facturas
 * 
 * @author UO250999
 *
 */
public interface FacturasGateway {
	void setConnection(Connection c) throws SQLException;

	Long save(Map<String, Object> map) throws SQLException;

	void update(Map<String, Object> map) throws SQLException;
}