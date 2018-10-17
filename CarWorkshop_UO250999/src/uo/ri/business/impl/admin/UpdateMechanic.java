package uo.ri.business.impl.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import alb.util.jdbc.Jdbc;
import uo.ri.conf.PersistenceFactory;
import uo.ri.persistence.MecanicosGateway;

/**
 * Clase que actualiza los datos de un mecánico
 * 
 * @author UO250999
 *
 */
public class UpdateMechanic {
	private Long id;
	private String nombre;
	private String apellidos;

	/**
	 * Constructor con los datos a actualizar
	 * 
	 * @param id,
	 *            el id para encontrar al mecánico
	 * @param nombre,
	 *            nuevo nombre
	 * @param apellidos,
	 *            nuevo apellido
	 */
	public UpdateMechanic(Long id, String nombre, String apellidos) {
		super();
		this.id = id;
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
			mgi.update(id, nombre, apellidos);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(rs, pst, c);
		}
	}
}