package uo.ri.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import uo.ri.conf.Conf;
import uo.ri.persistence.MediosPagoGateway;

/**
 * Clase que conecta con la base de datos con el objetivo de hacer
 * modificaciones sobre la tabla TMediosPago
 */
public class MediosPagoGatewayImpl implements MediosPagoGateway {
	private Connection c;

	/**
	 * Se crea la conexión con la base de datos
	 * 
	 * @param c,
	 *            la conexión de la base de datos
	 */
	@Override
	public void setConnection(Connection c) throws SQLException {
		this.c = c;
	}

	/**
	 * Al crear un cliente se le asignará un medio de pago de tipo metálico por
	 * defecto
	 * 
	 * @param id,
	 *            el id del cliente
	 */
	@Override
	public void saveClienteTipo(Long id) throws SQLException {
		PreparedStatement pst = c.prepareStatement(Conf.get("SQL_INSERT_MEDIO_DE_PAGO"));
		pst.setString(1, "TMetalico");
		pst.setLong(2, id);
		pst.executeUpdate();
	}

	/**
	 * En caso de poder borrar un cliente (Si no tiene vehículos registrados) se
	 * borrarán sus medios de pago
	 * 
	 * @param id,
	 *            el id del cliente
	 */
	@Override
	public void delete(Long id) throws SQLException {
		PreparedStatement pst = c.prepareStatement(Conf.get("SQL_DELETE_MEDIO_DE_PAGO"));
		pst.setLong(1, id);
		pst.setString(2, "TMetalico");
		pst.executeUpdate();
	}

	/**
	 * Método que genera bonos por cada 3 averías. Se hace un map con id y averías
	 * facturadas (y sin bono) de un cliente. Se generan los bonos y se pasan las
	 * averías a un estado donde no se podrán generar nuevos bonos con estas.
	 */
	@Override
	public void generaBonos() throws SQLException {
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		PreparedStatement pst = c.prepareStatement(Conf.get("SQL_AVERIAS_FACTURADAS"));
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			map.put(rs.getLong(2), rs.getInt(1));
		}
		pst = c.prepareStatement(Conf.get("SQL_CODIGO_BONO"));
		rs = pst.executeQuery();
		String bono = "";
		int numBono = 0;
		while (rs.next()) {
			bono = rs.getString(1);
			numBono = Integer.parseInt(bono.substring(1, bono.length() - 1));
			numBono += 10;
			bono = "B" + numBono;
		}
		for (Map.Entry<Long, Integer> m : map.entrySet()) {
			pst = c.prepareStatement(Conf.get("SQL_GENERA_BONO"));
			pst.setString(1, "TBonos");
			pst.setLong(2, m.getKey());
			pst.setDouble(3, 20);
			pst.setString(4, bono);
			numBono += 10;
			bono = "B" + numBono;
			for (int i = 0; i < (m.getValue() / 3); i++)
				pst.executeUpdate();

			pst = c.prepareStatement(Conf.get("SQL_ID_AVERIAS_SIN_USAR"));
			pst.setLong(1, m.getKey());
			rs = pst.executeQuery();
			int bonos = m.getValue() / 3;
			while (rs.next() || bonos == 0) {
				PreparedStatement pst2 = c.prepareStatement(Conf.get("SQL_AVERIA_USADA"));
				pst2.setLong(1, rs.getLong(1));
				pst2.executeUpdate();
				bonos--;
			}
		}
	}
}