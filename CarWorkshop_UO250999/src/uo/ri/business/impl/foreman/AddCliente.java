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
 * Clase que añade un cliente en la base de datos
 * 
 * @author UO250999
 *
 */
public class AddCliente {
	private String dni;
	private String nombre;
	private String apellidos;
	private String direccionPostal;
	private int telefono;
	private String correo;
	private Long recomendadopor;

	public AddCliente(String dni, String nombre, String apellidos, String direccionPostal, int telefono, String correo,
			Long recomendadopor) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccionPostal = direccionPostal;
		this.telefono = telefono;
		this.correo = correo;
		this.recomendadopor = recomendadopor;
	}

	public void execute() throws BusinessException {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = Jdbc.getConnection();
			ClientesGateway mgi = PersistenceFactory.getClienteGateway();
			mgi.setConnection(c);
			mgi.save(dni, nombre, apellidos, direccionPostal, telefono, correo, recomendadopor);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(rs, pst, c);
		}
	}
}
