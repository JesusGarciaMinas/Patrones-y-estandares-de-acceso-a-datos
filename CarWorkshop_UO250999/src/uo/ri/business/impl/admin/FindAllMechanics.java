package uo.ri.business.impl.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import alb.util.jdbc.Jdbc;
import uo.ri.conf.PersistenceFactory;
import uo.ri.persistence.MecanicosGateway;

/**
 * Clase que muestra una lista entera de los mecánicos de la base de datos
 * 
 * @author UO250999
 *
 */
public class FindAllMechanics {

	public List<Map<String, Object>> execute() {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Map<String, Object>> lista;
		try {

			c = Jdbc.getConnection();
			MecanicosGateway mgi = PersistenceFactory.getMecanicoGateway();
			mgi.setConnection(c);
			lista = mgi.findAll();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(rs, pst, c);
		}
		return lista;
	}
}