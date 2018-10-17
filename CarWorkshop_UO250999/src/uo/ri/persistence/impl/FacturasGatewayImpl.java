package uo.ri.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import uo.ri.conf.Conf;
import uo.ri.persistence.FacturasGateway;

public class FacturasGatewayImpl implements FacturasGateway {

	private Connection c;

	/**
	 * Conexión a la base de datos
	 */
	@Override
	public void setConnection(Connection c) throws SQLException {
		this.c = c;
	}

	/**
	 * Se actualiza el importe de la avería
	 */
	@Override
	public void update(Map<String, Object> map) throws SQLException {
		PreparedStatement pst = c.prepareStatement(Conf.get("SQL_UPDATE_IMPORTE_AVERIA"));
		pst.setDouble(1, (double) map.get("totalAveria"));
		pst.setLong(2, (long) map.get("idAveria"));
		pst.executeUpdate();
	}

	/**
	 * Se actualiza el estado de la avería
	 */
	@Override
	public Long save(Map<String, Object> map) throws SQLException {
		PreparedStatement pst = c.prepareStatement(Conf.get("SQL_ACTUALIZAR_ESTADO_AVERIA"));
		pst.setString(1, (String) map.get("status"));
		pst.setLong(2, (long) map.get("idAveria"));
		pst.executeUpdate();
		return (long) map.get("idAveria");
	}
}