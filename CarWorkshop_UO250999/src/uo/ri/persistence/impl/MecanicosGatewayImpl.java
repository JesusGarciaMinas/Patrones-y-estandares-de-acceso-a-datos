package uo.ri.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uo.ri.conf.Conf;
import uo.ri.persistence.MecanicosGateway;

public class MecanicosGatewayImpl implements MecanicosGateway {

	private Connection c;

	/**
	 * Conexión a la base de datos
	 */
	@Override
	public void setConnection(Connection c) throws SQLException {
		this.c = c;
	}

	/**
	 * Se busca un mecánico según su id
	 */
	@Override
	public Map<String, Object> findById(Long l) throws SQLException {
		PreparedStatement pst = c.prepareStatement(Conf.get("SQL_FIND_BY_ID"));
		pst.setLong(1, l);
		ResultSet rs = pst.executeQuery();
		Map<String, Object> map = new HashMap<String, Object>();
		;
		while (rs.next()) {
			map.put("id", rs.getString(1));
			map.put("nombre", rs.getString(2));
			map.put("apellidos", rs.getString(3));
		}
		return map;
	}

	/**
	 * Se muestra una lista con todos los mecánicos
	 */
	@Override
	public List<Map<String, Object>> findAll() throws SQLException {
		List<Map<String, Object>> lista = new ArrayList<Map<String, Object>>();
		PreparedStatement pst = c.prepareStatement(Conf.get("SQL_FIND_ALL_MECHANICS"));
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", rs.getString(1));
			map.put("nombre", rs.getString(2));
			map.put("apellidos", rs.getString(3));
			lista.add(map);
		}
		return lista;
	}

	/**
	 * Se actualizan los datos básicos de un mecánico
	 */
	@Override
	public void update(Long id, String nombre, String apellidos) throws SQLException {
		PreparedStatement pst = c.prepareStatement(Conf.get("SQL_UPDATE_MECHANIC"));
		pst.setString(1, nombre);
		pst.setString(2, apellidos);
		pst.setLong(3, id);
		pst.executeUpdate();
	}

	/**
	 * Se añade un nuevo mecánico
	 */
	@Override
	public void save(String nombre, String apellidos) throws SQLException {
		PreparedStatement pst = c.prepareStatement(Conf.get("SQL_INSERT_MECHANIC"));
		pst.setString(1, nombre);
		pst.setString(2, apellidos);
		pst.executeUpdate();
	}

	/**
	 * Se elimina un mecánico
	 */
	@Override
	public void delete(Long id) throws SQLException {
		PreparedStatement pst = c.prepareStatement(Conf.get("SQL_DELETE_MECHANIC"));
		pst.setLong(1, id);
		pst.executeUpdate();
	}
}