package uo.ri.business.impl.foreman;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import alb.util.jdbc.Jdbc;
import uo.ri.common.BusinessException;
import uo.ri.conf.PersistenceFactory;
import uo.ri.persistence.ClientesGateway;

/**
 * Clase que elimina un cliente de la base de datos
 * 
 * @author UO250999
 *
 */
public class DeleteCliente {
	private Long id;

	public DeleteCliente(Long id) {
		this.id = id;
	}

	public void execute() throws BusinessException {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = Jdbc.getConnection();
			ClientesGateway mgi = PersistenceFactory.getClienteGateway();
			mgi.setConnection(c);
			mgi.delete(id);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(rs, pst, c);
		}
	}
}
