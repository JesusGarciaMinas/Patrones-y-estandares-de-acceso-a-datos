package uo.ri.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uo.ri.common.BusinessException;
import uo.ri.conf.Conf;
import uo.ri.persistence.ClientesGateway;
import uo.ri.persistence.MediosPagoGateway;

public class ClientesGatewayImpl implements ClientesGateway {

	private Connection c;

	/**
	 * Conexión a la base de datos
	 */
	@Override
	public void setConnection(Connection c) throws SQLException {
		this.c = c;
	}

	/**
	 * Busca todos los clientes que han sido recomendados por la misma persona con
	 * id específico
	 * 
	 * @param id,
	 *            el id de la persona que ha recomendado a todas estas personas
	 */
	@Override
	public List<Map<String, Object>> findRecomendados(Long id) throws SQLException {
		List<Map<String, Object>> lista = new ArrayList<Map<String, Object>>();
		PreparedStatement pst = c.prepareStatement(Conf.get("SQL_FIND_CLIENTES_RECOMENDADOS"));
		pst.setLong(1, id);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", rs.getString(1));
			map.put("dni", rs.getString(2));
			map.put("nombre", rs.getString(3));
			map.put("apellidos", rs.getString(4));
			lista.add(map);
		}
		return lista;
	}

	/**
	 * Busca todos los clientes que aparecen en la aplicación.
	 */
	@Override
	public List<Map<String, Object>> findAll() throws SQLException {
		List<Map<String, Object>> lista = new ArrayList<Map<String, Object>>();
		PreparedStatement pst = c.prepareStatement(Conf.get("SQL_FIND_ALL_CLIENTES"));
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", rs.getString(1));
			map.put("dni", rs.getString(2));
			map.put("nombre", rs.getString(3));
			map.put("apellidos", rs.getString(4));
			lista.add(map);
		}
		return lista;
	}

	/**
	 * Método que actualiza los datos básicos (En este caso nombre y apellidos) de
	 * un cliente en el sistema.
	 */
	@Override
	public void update(Long id, String nombre, String apellidos) throws SQLException {
		PreparedStatement pst = c.prepareStatement(Conf.get("SQL_UPDATE_CLIENTE"));
		pst.setString(1, nombre);
		pst.setString(2, apellidos);
		pst.setLong(3, id);
		pst.executeUpdate();
	}

	/**
	 * Método que almacena un cliente en la base de datos. En caso de no haber sido
	 * recomendado por nadie, este campo se rellenará con un 0. En el otro caso, se
	 * comprobará si el cliente existe y ha pagado alguna factura.
	 * 
	 * @throws BusinessException
	 */
	@Override
	public void save(String dni, String nombre, String apellidos, String direccionPostal, int telefono, String correo,
			Long recomendadoPor) throws SQLException, BusinessException {
		if (!facturasCliente(recomendadoPor) && recomendadoPor != 0) {
			throw new BusinessException("El cliente que te ha recomendado no existe y/o no tiene facturas pagadas");
		}
		Long id = null;
		PreparedStatement pst = c.prepareStatement(Conf.get("SQL_INSERT_CLIENTE"));
		pst.setString(1, dni);
		pst.setString(2, nombre);
		pst.setString(3, apellidos);
		pst.setString(4, direccionPostal);
		pst.setInt(5, telefono);
		pst.setString(6, correo);
		pst.setLong(7, recomendadoPor);
		pst.executeUpdate();

		pst = c.prepareStatement(Conf.get("SQL_FIND_ID_CLIENTE"));
		pst.setString(1, dni);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			id = rs.getLong(1);
		}
		MediosPagoGateway mpgi = new MediosPagoGatewayImpl();
		mpgi.setConnection(c);
		mpgi.saveClienteTipo(id);
	}

	private boolean facturasCliente(Long id) throws SQLException {
		PreparedStatement pst = c.prepareStatement(Conf.get("SQL_FACTURAS_PAGADAS"));
		pst.setLong(1, id);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			if (rs.getString(1).equals("ABONADA")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Método que borra un cliente de la base de datos. Para ello, se busca el
	 * número de clientes que tiene registrados. Si tiene alguno, la operación se
	 * cancela. En el otro caso, se borra su medio de pago de tipo metálico y el
	 * cliente.
	 */
	@Override
	public void delete(Long id) throws SQLException, BusinessException {
		PreparedStatement pst = c.prepareStatement(Conf.get("SQL_NUM_VEHICULOS_CLIENTE"));
		pst.setLong(1, id);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			if (rs.getInt(1) > 0) {
				throw new BusinessException("No se puede eliminar un cliente con vehículos registrados en el sistema");
			} else {
				MediosPagoGateway mpgi = new MediosPagoGatewayImpl();
				mpgi.setConnection(c);
				mpgi.delete(id);
				pst = c.prepareStatement(Conf.get("SQL_DELETE_CLIENTE"));
				pst.setLong(1, id);
				pst.executeUpdate();
			}
		}
	}

	/**
	 * Método que muestra por pantalla todos los datos de un cliente en la
	 * aplicación. En caso de que no haya sido recomendado por nadie, aparecerá un 0
	 * en dicho campo.
	 */
	@Override
	public Map<String, Object> detallesCliente(Long id) throws SQLException {
		Map<String, Object> map = new HashMap<String, Object>();
		PreparedStatement pst = c.prepareStatement(Conf.get("SQL_ALL_DETALLES_CLIENTE"));
		pst.setLong(1, id);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			map.put("id", rs.getString(1));
			map.put("dni", rs.getString(2));
			map.put("nombre", rs.getString(3));
			map.put("apellidos", rs.getString(4));
			map.put("direccionPostal", rs.getInt(5));
			map.put("telefono", rs.getInt(6));
			map.put("correo", rs.getString(7));
			map.put("recomendadopor", rs.getLong(8));
		}
		return map;
	}
}