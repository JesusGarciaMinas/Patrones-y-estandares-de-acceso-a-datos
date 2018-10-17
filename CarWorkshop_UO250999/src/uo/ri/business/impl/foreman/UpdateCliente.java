package uo.ri.business.impl.foreman;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import alb.util.jdbc.Jdbc;
import uo.ri.conf.PersistenceFactory;
import uo.ri.persistence.ClientesGateway;

/**
 * Clase que actualiza los datos de un cliente
 * 
 * @author UO250999
 *
 */
public class UpdateCliente {
	private Long id;
	private String nombre;
	private String apellidos;

	public UpdateCliente(Long id, String nombre, String apellidos) {
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
			ClientesGateway mgi = PersistenceFactory.getClienteGateway();
			mgi.setConnection(c);
			mgi.update(id, nombre, apellidos);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(rs, pst, c);
		}
	}
}
