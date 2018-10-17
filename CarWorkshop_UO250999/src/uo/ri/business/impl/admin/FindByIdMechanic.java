package uo.ri.business.impl.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import alb.util.jdbc.Jdbc;
import uo.ri.conf.PersistenceFactory;
import uo.ri.persistence.MecanicosGateway;

/**
 * Clase que encuentra los datos de un mecánico segun su id
 * 
 * @author UO250999
 *
 */
public class FindByIdMechanic {
	private Long id;

	public FindByIdMechanic(Long id) {
		this.id = id;
	}

	public Map<String, Object> execute() {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Map<String, Object> map;
		try {
			c = Jdbc.getConnection();
			MecanicosGateway mgi = PersistenceFactory.getMecanicoGateway();
			mgi.setConnection(c);
			map = mgi.findById(id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(rs, pst, c);
		}
		return map;
	}
}
