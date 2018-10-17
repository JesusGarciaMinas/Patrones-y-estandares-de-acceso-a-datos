package uo.ri.business.impl.foreman;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import alb.util.jdbc.Jdbc;
import uo.ri.conf.PersistenceFactory;
import uo.ri.persistence.ClientesGateway;

/**
 * Clase que muestra a aquellos clientes que han sido recomendados por el id
 * introducido
 * 
 * @author UO250999
 *
 */
public class FindRecomendadosCliente {
	private Long id;

	public FindRecomendadosCliente(Long id) {
		this.id = id;
	}

	public List<Map<String, Object>> execute() {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Map<String, Object>> lista;
		try {
			c = Jdbc.getConnection();
			ClientesGateway mgi = PersistenceFactory.getClienteGateway();
			mgi.setConnection(c);
			lista = mgi.findRecomendados(id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(rs, pst, c);
		}
		return lista;
	}
}
