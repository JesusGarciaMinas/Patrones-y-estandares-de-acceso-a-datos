package uo.ri.business.impl.foreman;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import alb.util.jdbc.Jdbc;
import uo.ri.conf.PersistenceFactory;
import uo.ri.persistence.ClientesGateway;

/**
 * Clase que muestra todos los datos de un cliente en la base de datos
 * 
 * @author UO250999
 *
 */
public class DetallesCliente {
	private Long id;

	public DetallesCliente(Long id) {
		this.id = id;
	}

	public Map<String, Object> execute() {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Map<String, Object> map;
		try {
			c = Jdbc.getConnection();
			ClientesGateway mgi = PersistenceFactory.getClienteGateway();
			mgi.setConnection(c);
			map = mgi.detallesCliente(id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(rs, pst, c);
		}
		return map;
	}
}
