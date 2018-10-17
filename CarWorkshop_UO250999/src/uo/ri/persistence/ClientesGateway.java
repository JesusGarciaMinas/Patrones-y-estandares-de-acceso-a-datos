package uo.ri.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import uo.ri.common.BusinessException;

/**
 * Interfaz que contiene la signatura de los métodos que se implementarán en
 * ClientesGatewayImpl
 * 
 * @author UO250999
 *
 */
public interface ClientesGateway {
	void setConnection(Connection c) throws SQLException;

	List<Map<String, Object>> findRecomendados(Long id) throws SQLException;

	Map<String, Object> detallesCliente(Long id) throws SQLException;

	List<Map<String, Object>> findAll() throws SQLException;

	void update(Long id, String nombre, String apellidos) throws SQLException;

	void save(String dni, String nombre, String apellidos, String direccionPostal, int telefono, String correo,
			Long recomendadopor) throws SQLException, BusinessException;

	void delete(Long id) throws SQLException, BusinessException;
}