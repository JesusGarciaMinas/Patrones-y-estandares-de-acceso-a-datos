package uo.ri.business.impl.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import alb.util.jdbc.Jdbc;
import uo.ri.conf.PersistenceFactory;
import uo.ri.persistence.MecanicosGateway;

/**
 * Clse que introduce un mecánico en la base de datos
 * 
 * @author UO250999
 *
 */
public class AddMechanic {
	private String nombre;
	private String apellidos;

	/**
	 * Datos del mecánico a introducir
	 * 
	 * @param nombre,
	 *            el nombre del mecánico
	 * @param apellidos,
	 *            los apellidos del mecánico
	 */
	public AddMechanic(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public void execute() {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = Jdbc.getConnection();
			MecanicosGateway mgi = PersistenceFactory.getMecanicoGateway();
			mgi.setConnection(c);
			mgi.save(nombre, apellidos);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(rs, pst, c);
		}
	}
}