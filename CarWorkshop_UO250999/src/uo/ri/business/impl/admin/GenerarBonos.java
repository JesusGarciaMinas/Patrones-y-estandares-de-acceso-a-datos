package uo.ri.business.impl.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import alb.util.jdbc.Jdbc;
import uo.ri.conf.PersistenceFactory;
import uo.ri.persistence.MediosPagoGateway;

/**
 * Clase que genera los bonos por averías de clientes de la base de datos
 * 
 * @author UO250999
 *
 */
public class GenerarBonos {

	public void execute() {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = Jdbc.getConnection();
			MediosPagoGateway mgi = PersistenceFactory.getMediosPagoGateway();
			mgi.setConnection(c);
			mgi.generaBonos();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(rs, pst, c);
		}
	}
}
