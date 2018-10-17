package uo.ri.business.impl.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import alb.util.jdbc.Jdbc;
import uo.ri.conf.PersistenceFactory;
import uo.ri.persistence.MecanicosGateway;

/**
 * Clase que elimina un mecánico de la base de datos
 * 
 * @author UO250999
 *
 */
public class DeleteMechanic {
	private Long idMecanico;

	/**
	 * Constructor de la clase
	 * 
	 * @param id,
	 *            el id del mecánico a eliminar
	 */
	public DeleteMechanic(Long id) {
		idMecanico = id;
	}

	public void execute() {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = Jdbc.getConnection();
			MecanicosGateway mgi = PersistenceFactory.getMecanicoGateway();
			mgi.setConnection(c);
			mgi.delete(idMecanico);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(rs, pst, c);
		}
	}
}