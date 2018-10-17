package uo.ri.persistence;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Interfaz con los métodos que se codificarán en MediosPagoGatewayImpl
 * 
 * @author UO250999
 *
 */
public interface MediosPagoGateway {
	void setConnection(Connection c) throws SQLException;

	void saveClienteTipo(Long id) throws SQLException;

	void delete(Long id) throws SQLException;

	void generaBonos() throws SQLException;
}